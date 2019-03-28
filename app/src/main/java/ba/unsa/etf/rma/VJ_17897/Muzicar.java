package ba.unsa.etf.rma.VJ_17897;

public class Muzicar {
    private String ime;
    private String prezime;
    private String zanr;
    private String webStranica;
    private String biografija;

    public Muzicar(String ime, String prezime, String zanr, String webStranica, String biografija) {
        this.ime = ime;
        this.prezime = prezime;
        this.zanr = zanr;
        this.webStranica = webStranica;
        this.biografija = biografija;
    }

    @Override
    public String toString()
    {
        return ime + " " + prezime + "\n" + zanr;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public String getWebStranica() {
        return webStranica;
    }

    public void setWebStranica(String webStranica) {
        this.webStranica = webStranica;
    }

    public String getBiografija() {
        return biografija;
    }

    public void setBiografija(String biografija) {
        this.biografija = biografija;
    }
}
