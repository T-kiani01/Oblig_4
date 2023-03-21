abstract class Resept {
    Legemiddel legemiddel;
    Lege utskrivendeLege;
    Pasient pasientId;
    int reit;
    int ID;
    static int IDnummer = 1;

    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient , int reit)
    {
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasient;
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

    public Pasient hentPasientId()
    {
        return pasientId;
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

    abstract public String farge();
    abstract public int prisAaBetale();
    
}
