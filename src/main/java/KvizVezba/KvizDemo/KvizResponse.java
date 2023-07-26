package KvizVezba.KvizDemo;

public class KvizResponse {
     int response_code;
     Pitanje[] results;

     public int getResponse_code() {
          return response_code;
     }

     public void setResponse_code(int response_code) {
          this.response_code = response_code;
     }

     public Pitanje[] getResults() {
          return results;
     }

     public void setResults(Pitanje[] results) {
          this.results = results;
     }
}
