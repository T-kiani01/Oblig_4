public class Lege implements Comparable<Lege> {
    String navn;
    IndeksertListe<Resept> utskrevneResepter = new IndeksertListe<>();
    //lager en instansvariabel for å skille mellom leger og spesialister(D3)
    int klasse = 0;

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
        return navn;
    }

    @Override
    public int compareTo(Lege o) {
        int v = navn.compareTo(o.navn);
        return v;
    }

    public IndeksertListe<Resept> hentReseptListe()
    {
        return utskrevneResepter;
    }

    //Vi tar inn de respektive parameterne i hver metode, lager resepten, legger den til i legens liste av utskrevne, og returnerer resepten
    public HvitResept skrivHvitResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if(legemiddel instanceof Narkotisk)
        { throw new UlovligUtskrift();}

        HvitResept hvit = new HvitResept(legemiddel, this, pasient.pasientID, reit);
        utskrevneResepter.leggTil(hvit);
        return hvit;
    }
    
    public MilResept skrivMilResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift
    {
        
        if(legemiddel instanceof Narkotisk)
        { throw new UlovligUtskrift();}

        MilResept mil = new MilResept(legemiddel, this, pasient.pasientID);
        utskrevneResepter.leggTil(mil);
        return mil;
        
    }

    public PResept skrivPResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift 
    {
        
        if(legemiddel instanceof Narkotisk)
        { throw new UlovligUtskrift();}

        PResept p = new PResept(legemiddel, this, pasient.pasientID, reit);
        utskrevneResepter.leggTil(p);
        return p;
    }

    //Ingen har lov å skrive ut narkotiske resepter, utenom spesialister som skriver ut blåresept. 
    public BlaaResept skrivBlaaResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift
    {
        if(!(this instanceof Godkjenningsfritak) && legemiddel instanceof Narkotisk)
        { throw new UlovligUtskrift();}


        BlaaResept blaa = new BlaaResept(legemiddel, this, pasient.pasientID, reit);
        utskrevneResepter.leggTil(blaa);
        return blaa;
    }

public String hentKontrollkode (){
        return null;

    }


}
