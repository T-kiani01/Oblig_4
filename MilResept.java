public class MilResept extends HvitResept {

    public MilResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientid) {
        super(legemiddel, utskrivendeLege, pasientid, 3);
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public int prisAaBetale()
    {
        return 0;
    }

}
