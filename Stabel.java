class Stabel<E> extends Lenkeliste <E> {

    public Stabel() {}

    @Override
    public void leggTil(E x) {
        Node ny = new Node(x);
        ny.neste = start;
        start = ny;

        storrelse++;

    }
    

    
    
}
