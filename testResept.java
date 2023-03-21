public class testResept {
    public static void main(String[] args) {
     
        Legemiddel narkotisk = new Narkotisk("Fentanyl", 500, 1000, 4);
        Lege lege = new Lege("Ali Reza");

        Resept resepthvit = new HvitResept(narkotisk, lege, 2, 1);
        Resept reseptblaa = new BlaaResept(narkotisk, lege, 1, 100);
        HvitResept hvit = new HvitResept(narkotisk, lege, 1, 5);
        BlaaResept blaa = new BlaaResept(narkotisk, lege, 1, 5);
        MilResept militaer = new MilResept(narkotisk, lege, 4);
        PResept pr = new PResept(narkotisk, lege, 6, 3);

        //tester Resept
        if (resepthvit.hentReseptId() == 1) {
            System.out.println("Resept id er riktig");
        } else {
            System.out.println("Resept id er feil");
        }
        if (reseptblaa.hentReseptId() == 2) {
            System.out.println("Resept id oeker riktig");
        } else {
            System.out.println("Resept id oeker feil");
        }
        if (resepthvit.hentReseptLegemiddel() == narkotisk) {
            System.out.println("Resept legemiddel er riktig");
        } else {
            System.out.println("Resept legemiddel er feil");
        }
        if (resepthvit.hentlege() == lege) {
            System.out.println("Resept lege er riktig");
        } else {
             System.out.println("Resept lege er feil");
        }
        if (resepthvit.hentPasientId() == 2) {
            System.out.println("Resept pasientId er riktig");
        } else {
            System.out.println("Resept pasientId er feil");
        }
        if (resepthvit.hentReit() == 1) {
            System.out.println("Resept reit er riktig");
        } else {
            System.out.println("Resept reit er feil");
        }
        resepthvit.bruk();
        if (resepthvit.bruk() == true) {
            System.out.println("Resept bruk() er feil");
        } else {
            System.out.println("Resept bruk() er riktig");
        }

        //tester HvitResept
        if (hvit.farge().equals("Hvit")) {
            System.out.println("HvitResept farge() er riktig");
        } else {
            System.out.println("HvitResept farge() er feil");
        }
        if (hvit.prisAaBetale() == 500) {
            System.out.println("HvitResept prisAaBetale() er riktig");
        } else {
            System.out.println("HvitResept prisAaBetale() er feil");
        }

        //tester Militaerresept
        if (militaer.prisAaBetale() == 0)
        {
         System.out.println("riktig pris for militaer resept");   
        } else {
            System.out.println("feil pris for militaer resept");
        }

        //tester PResept
        if (pr.prisAaBetale() == 392)
        {
            System.out.println("riktig pris for pResept");
        } else {
            System.out.println("feil pris for presept");
        }

        //tester BlaaResept
        if (blaa.prisAaBetale() == 125) {
            System.out.println("BlaaResept prisAaBetale() fungerer riktig");
        } else {
            System.out.println("BlaaResept prisAaBetale() fungerer feil");
        }

    }
}
