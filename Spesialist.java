class Spesialist extends Lege implements Godkjenningsfritak {
    String kontrollkode;
    //lager insitansvariabel for å skille mellom leger og spesialister
    int klasse = 1;

    public Spesialist(String navn, String kontrollkode) {
        
        super(navn);
        this.kontrollkode = kontrollkode;
    }

    @Override
    public String hentKontrollkode() {

        return kontrollkode;
        
    }

    @Override
    public String toString() {
        return "Informasjon om Legen: Navn: " + navn + " Kontrollkode: " + kontrollkode ;
    }
    
    
}
