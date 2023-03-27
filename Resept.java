abstract class Resept {
    Legemiddel legemiddel;
    Lege utskrivendeLege;
    int pasientid;
    int reit;
    int ID;
    static int IDnummer = 1;

    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientid, int reit)
    {
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientid = pasientid;
        this.reit = reit;
        ID = IDnummer;
        IDnummer++;
    }

    public int hentReseptId()
    {
        return ID; 
    }

    public Legemiddel hentReseptLegemiddel()
    {
        return legemiddel;
    }

    public Lege hentlege()
    {
        return utskrivendeLege;
    }

    public int hentPasientId()
    {
        return pasientid;
    }

    public int hentReit()
    {
        return reit;
    }

    public boolean bruk()
    {
        if (reit > 1)
        {
            reit -= 1;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString()
    {
    String legemiddelNavn = legemiddel.navn;
    return "ReseptID: " + ID + ". Legemiddelet er: " + legemiddelNavn + ". Utskrivende lege er: " + utskrivendeLege.navn + " og pasienten den skrives ut til har pasientID: " + pasientid + ". REIT: " + reit ;
    }

    abstract public String farge();
    abstract public int prisAaBetale();
    
}
