package KvizVezba.KvizDemo;

public class KvizMemorija {
    public Pitanje[] listaPitanja;
    public int brTacnihOdgovora;
    int brojac;

    public Pitanje[] getListaPitanja() {
        return listaPitanja;
    }
    public void setListaPitanja(Pitanje[] listaPitanja) {
        this.listaPitanja = listaPitanja;
    }

    public int getBrTacnihOdgovora() {
        return brTacnihOdgovora;
    }

    public void setBrTacnihOdgovora(int brTacnihOdgovora) {
        this.brTacnihOdgovora = brTacnihOdgovora;
    }

    public int getBrojac() {
        return brojac;
    }

    public void setBrojac(int brojac) {
        this.brojac = brojac;
    }
}
