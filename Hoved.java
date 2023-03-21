public class Hoved {

    public static void main(String[] args) {
        Narkotisk narko = new Narkotisk("fentanyl", 200, 150, 8);
        Vanedannende vane = new Vanedannende("paracet", 100, 500, 8);
        Vanlig vanlig = new Vanlig("Hostesaft" , 500, 25);

        Lege tor = new Lege("Tor");
        Spesialist line = new Spesialist("Line", "346092");

        HvitResept hvitResept = new HvitResept(vanlig, tor, 1, 4);
        MilResept militaerresept = new MilResept(narko, line, 2);
        PResept pResept = new PResept(vanlig, tor, 3, 4);
        BlaaResept blaaResept = new BlaaResept(vane, line, 4, 10); 

        //skriver ut relevant informasjon om hvert legemiddel-objekt,
        System.out.println(narko.toString());
        System.out.println(vane.toString());
        System.out.println(vanlig.toString());

        System.out.println("");
        //Skriver ut info om hver lege
        System.out.println(tor.toString());
        System.out.println(line.toString());

        System.out.println("");
        //Skriver ut info om prisen på resept-legemidlene, for de ulike resept-typene
        System.out.println("original pris paa legemiddel: " + militaerresept.legemiddel.hentPris() + " Ny pris med militaer-avslag " + militaerresept.prisAaBetale());
        System.out.println("original pris paa legemiddel: " + pResept.legemiddel.hentPris() + " Ny pris med P-resept-avslag " + pResept.prisAaBetale());
        System.out.println("original pris paa legemiddel: " + blaaResept.legemiddel.hentPris() + " Ny pris med blaaresept-avslag " + blaaResept.prisAaBetale());

        


       






        
    }
    
}
