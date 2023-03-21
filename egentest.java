class egentest {

    public static void main(String[] args) throws UlovligUtskrift {
        Lege legen = new Lege("Temoor");
        Pasient pasienten = new Pasient("Farid", "010197");

        Narkotisk narko = new Narkotisk("fentanyl", 200, 150, 8);
        Vanedannende vane = new Vanedannende("paracet", 100, 500, 8);
        Vanlig vanlig = new Vanlig("Hostesaft" , 500, 25);

        Lege tor = new Lege("Tor");
        Spesialist line = new Spesialist("Line", "346092");

        tor.skrivPResept(vanlig, pasienten, 5);
        tor.skrivHvitResept(vanlig, pasienten, 0);

        System.out.println(tor.utskrevneResepter.toString());

        line.skrivBlaaResept(narko, pasienten, 2);
        tor.skrivBlaaResept(narko, pasienten, 2);
    }

    
}
