package KvizVezba.KvizDemo;

public class PitanjeBaza {
    int id;
    String Pitanje;
    String TacanOdgovor;
    String tekstNetacnogOdgovora;

    public PitanjeBaza(int id, String pitanje, String tacanOdgovor, String tekstNetacnogOdgovora) {
        this.id = id;
        Pitanje = pitanje;
        TacanOdgovor = tacanOdgovor;
        this.tekstNetacnogOdgovora = tekstNetacnogOdgovora;
    }

    public PitanjeBaza() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPitanje() {
        return Pitanje;
    }

    public void setPitanje(String pitanje) {
        Pitanje = pitanje;
    }

    public String getTacanOdgovor() {
        return TacanOdgovor;
    }

    public void setTacanOdgovor(String tacanOdgovor) {
        TacanOdgovor = tacanOdgovor;
    }

    public String getTekstNetacnogOdgovora() {
        return tekstNetacnogOdgovora;
    }
    public void setTekstNetacnogOdgovora(String tekstNetacnogOdgovora) {
        this.tekstNetacnogOdgovora = tekstNetacnogOdgovora;
    }
    @Override
    public String toString() {
        return "PitanjeBaza{" +
                "id=" + id +
                ", Pitanje='" + Pitanje + '\'' +
                ", TacanOdgovor='" + TacanOdgovor + '\'' +
                ", tekstNetacnogOdgovora='" + tekstNetacnogOdgovora + '\'' +
                '}';
    }
}
