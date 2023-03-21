class egentest {

    public static void main(String[] args) {
        IndeksertListe indeks = new IndeksertListe<>();

        indeks.leggTil(27);
        indeks.leggTil(50);
        indeks.leggTil(104);

        
        System.out.println(indeks.toString());

        indeks.fjern(1);

        System.out.println(indeks.toString());

        indeks.leggTil(1, 54);

        System.out.println(indeks.toString());
    }

    
}
