class Stabel<E> extends Lenkeliste <E> {

    public Stabel() {}

    @Override
    public void leggTil(E x) {
        Node ny = new Node(x);
        ny.neste = start;
        start = ny;

        storrelse++;

    }

    public E hent (int pos) 
    { 

        if (0<= pos && pos <= storrelse)
        {
            Node peker = start;
            for(int i = 0; i < pos; i++)
            {
                peker = peker.neste;
            }
            return peker.data;

        } else {
            throw new UgyldigListeindeks(pos);
        }

    }
    

    
    
}
