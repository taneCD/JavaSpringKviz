package KvizVezba.KvizDemo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping(path="api")
public class ControlerKviz {
    KvizMemorija memory;
    KvizService kvizService;
    @Autowired
    public ControlerKviz(KvizService kvizService) {
        this.kvizService = kvizService;
    }
    @GetMapping
    public List<Pitanje>getPitanja(){
        return kvizService.getPitanja();
    }

    @GetMapping(path = "test")
    public String test() {
        return "<h2>Dobro vece</h2>" +
                "<a href='/api/pitanje'>Click me</a>";
    }
    @GetMapping(path="pitanja")
    public Pitanje[]citanje() throws IOException {
        return pitanja();
    }
    public Pitanje[] pitanja() throws IOException {
        URL url = new URL("https://opentdb.com/api.php?amount=10");

// Open a connection(?) on the URL(??) and cast the response(???)
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

// Now it's "open", we can set the request method, headers etc.
        connection.setRequestProperty("accept", "application/json");

// This line makes the request
        InputStream responseStream = connection.getInputStream();

// Manually converting the response body InputStream to APOD using Jackson
        ObjectMapper mapper = new ObjectMapper();
        KvizResponse kr = mapper.readValue(responseStream, KvizResponse.class);

// Finally we have the response
        return kr.results;
    }
    @GetMapping(path="novikviz")
    public String pocniNoviKviz() throws IOException {
        var pit = pitanja();
        memory = new KvizMemorija();
        memory.setListaPitanja(pit);
        memory.setBrTacnihOdgovora(0);
        memory.setBrojac(0);

        return "<h1>Kviz je poceo</h1>" +
                "<a href='/api/pitanje'>Start</a>";
    }
    @GetMapping(path="pitanje")
    public String pitanje1(){
        return pitanje_html();
    }
    @GetMapping(path="pitanje/{odgovor}")
    public String pitanje2(@PathVariable("odgovor") String odgovor){
        var brojac = memory.getBrojac();
        brojac--;
        var pitanja = memory.getListaPitanja();
        if(brojac<pitanja.length) {
            var trenutnoPitanje = pitanja[brojac];
            if(trenutnoPitanje.correct_answer.equals(odgovor)){
                memory.setBrTacnihOdgovora(memory.getBrTacnihOdgovora()+1);
            }
        }
        System.out.println("Korisnik je odgovorio sa "+odgovor);
        return pitanje_html();
    }
    public String pitanje_html(){
        String html="";
        var brojac = memory.getBrojac();
        var pitanja = memory.getListaPitanja();
        if(brojac<pitanja.length){
            var trenutnoPitanje = pitanja[brojac];
            brojac++;
            memory.setBrojac(brojac);
            html="<h1>Pitanje broj "+brojac+":</h1>";
            html+="<p><div>" + trenutnoPitanje.question + "</div></p>";
            html+="<p><ol>";
            int brojanje=0;
            for(var el : trenutnoPitanje.incorrect_answers){
                brojanje++;
                html+="<li><a href='/api/pitanje/"+el+"'>"+el+"</a></li>";
            }
            brojanje++;
            html+="<li><a href='/api/pitanje/"+ trenutnoPitanje.correct_answer+"'>"+trenutnoPitanje.correct_answer+"</a></li>";
            html+="</ol></p>";

        } else{
            html="<h1>Kviz je gotov</h1>";
            html+="<p>Tacnih odgovora: "+memory.getBrTacnihOdgovora()+ " od " + memory.getListaPitanja().length +".</p>";
            html+="<a href='/api/novikviz'>***Novi kviz***</a>";
        }
        return html;
    }
}
