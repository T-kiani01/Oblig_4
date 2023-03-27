public class Narkotisk extends Legemiddel {

    public final int styrke;

    Narkotisk(String navn, int pris, double virkestoff, int styrke) {
        super(navn, pris, virkestoff);
        this.styrke = styrke;
        //TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Narkotisk Legemiddel. ID: " + IDnr + ". Navn: " + navn + ". Pris: " + pris + " kr. Virkestoff: " + virkestoff + " mg. Styrke: " + styrke;
    }

    @Override
    public String type()
    {
        return "narkotisk";
    }

   

}
