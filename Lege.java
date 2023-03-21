public class Lege {
    String navn;

    public Lege(String navn)
    {
        this.navn = navn;
    }

    public String hentNavn()
    {
        return navn;
    }

    public void settNavn(String nvn)
    {
        navn = nvn;
    }

    public String toString() {
        return "Informasjon om Legen: Navn: " + navn;
    }
    
}
