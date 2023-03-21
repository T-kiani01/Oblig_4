public class Pasient{
    String navn;
    String fodselnummer;
    public int pasientID;
    static int nestePasientID = 0;
    Stabel <Resept> resepter;


    public Pasient (String navn, String fodselnummer){
        this.navn = navn;
        this.fodselnummer= fodselnummer;
        this.resepter = new Stabel<>();
        pasientID= nestePasientID;
        nestePasientID++;
    }

    public String hentNavn() {
        return navn;
    }

    public String hentFødselsnummer() {
        return fodselnummer;
    }

    public int hentPasientID() {
        return pasientID;
    }

    public void leggTilResept(Resept resept) {
        resepter.leggTil(resept);
    }

    public Lenkeliste<Resept> hentResepter() {
        return resepter;
    }


    


}

