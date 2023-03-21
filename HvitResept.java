public class HvitResept extends Resept {

    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
        
    }

    @Override
    public String farge() {
        return "Hvit";
    }

    @Override
    public int prisAaBetale() {

        //kanskje ikke slik denne metoden skal se ut, men det har ikke noe å si for den vil aldri bli kalt fra denne klassen.
        return legemiddel.pris;
    }

  
}
