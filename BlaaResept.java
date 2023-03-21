class BlaaResept extends Resept {

    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String farge() {
        return "blaa";
    }

    @Override
    public int prisAaBetale() {
        int pris = legemiddel.hentPris();
        double prisen = pris * 0.25;
        int avrundetPris = (int) Math.round(prisen * 1.0);
        return avrundetPris;
    }


    
}
