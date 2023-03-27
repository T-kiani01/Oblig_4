public class Vanedannende extends Legemiddel {

    public final int styrke;

    Vanedannende(String navn, int pris, double virkestoff, int styrke) {
        super(navn, pris, virkestoff);
        this.styrke = styrke;
        //TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Vanedannende Legemiddel. ID: " + IDnr + ". Navn: " + navn + ". Pris: " + pris + " kr. Virkestoff: " + virkestoff + " mg. Styrke: " + styrke;
    }

    public String type()
    {
        return "vanedannende";
    }
    
}   
