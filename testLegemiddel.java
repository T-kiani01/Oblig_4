class testLegemiddel{
public static void main(String[] args) {
    Narkotisk narkotisk = new Narkotisk("paracet", 20, 500, 7);
    Vanedannende vane = new Vanedannende("Medisin", 100, 200, 5);
    Vanlig vanlig = new Vanlig("her", 11, 1200);

    System.out.println(narkotisk.toString());

    if(testId(vanlig, 3))
    {
        System.out.println("forventet 3 og fikk 3, helt Riktig!");
    } else {
        System.out.println("forventet 3 og fikk " + vanlig.IDnr + ", Feil");
    }
    if(testId(vane, 2))
    {
        System.out.println("forventet 2 og fikk 2, helt Riktig!");
    } else {
        System.out.println("forventet 2 og fikk " + vane.IDnr + ", Feil");
    }
    if(testId(narkotisk, 1))
    {
        System.out.println("forventet 1 og fikk 1, helt Riktig!");
    } else {
        System.out.println("forventet 1 og fikk " + vanlig.IDnr + ", Feil");
    }
    if(testVirkestoff(vanlig, 1200))
    {
        System.out.println("forventet 1200 og fikk 1200, helt Riktig!");
    } else {
        System.out.println("forventet 1200 og fikk " + vanlig.virkestoff + ", Feil");
    }
    
    
}
    //metode for å teste id
    static boolean testId(Legemiddel legemiddel, int forventetId) 
    {
        return legemiddel.hentId() == forventetId;
    }
    //metode for å teste pris
    static boolean testPris(Legemiddel legemiddel, int forventetPris) {
        return legemiddel.hentPris() == forventetPris;
    }
    //metode for å teste virkestoff
    static boolean testVirkestoff(Legemiddel legemiddel, double forventetVirkestoff) {
        return legemiddel.hentVirkestoff() == forventetVirkestoff;
    }
 

}
