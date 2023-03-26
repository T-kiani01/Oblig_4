class PResept extends HvitResept{

    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientid, int reit) {
        super(legemiddel, utskrivendeLege, pasientid, reit);
    }
    

@Override
public int prisAaBetale() {
        int pris = legemiddel.hentPris();
        if (pris > 108) {
            return pris - 108;
        } else {
            return 0;
        }
    }


}
