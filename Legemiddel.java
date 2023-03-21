abstract class Legemiddel{

    public final int IDnr;
    public final String navn;
    int pris;
    public final double virkestoff;
    static int IDnummeret = 1;


    public Legemiddel(String navn, int pris, double virkestoff)
    {   //Id som øker med 1 for hver gang et nytt Legemiddelobjekt opprettes
        IDnr = IDnummeret;
        IDnummeret += 1;
        this.navn = navn; 
        this.pris = pris;
        this.virkestoff = virkestoff;

    }

    public int hentPris()
    {
        return pris;
    }

    public void settNyPris(int nypris)
    {
        pris = nypris;
    }

    public double hentVirkestoff()
    {
        return virkestoff;
    }

    public int hentId()
    {
        return IDnr;
    }

    public String toString() {
        return "Informasjon om Legemiddelet. ID: " + IDnr + ". Navn: " + navn + ". Pris: " + pris + " kr. Virkestoff: " + virkestoff + " mg.";
    }
    
}