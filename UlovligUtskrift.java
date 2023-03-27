class UlovligUtskrift extends Exception {
    
    UlovligUtskrift (Lege l, Legemiddel lm) 
    {
    System.out.println("Legen "+l.hentNavn()+" har ikke lov til aa skrive ut "+lm.hentNavn());
    }

    public UlovligUtskrift() {
    }
    
}