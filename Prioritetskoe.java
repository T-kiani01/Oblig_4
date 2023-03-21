class Prioritetskoe <E extends Comparable<E>> extends Lenkeliste <E> {

    public Prioritetskoe() {
    }


    @Override
    public void leggTil(E x) {
        Node ny = new Node(x);
    
        // hvis listen er tom settes vi inn noden som start
        if (storrelse == 0) {
            start = ny;
            storrelse++;
            return;
        }
    
        // hvis noden er mindre enn alt i listen(noe den er automatisk er om den er mindre enn start, settes den inn først)
        if (ny.data.compareTo(start.data) < 0) {
            ny.neste = start;
            start = ny;
            storrelse++;
            return;
        }
    
        Node peker = start;
    
        // vi itererer gjennom listen, og så lenge peker ikke peker på null, og den neste noden er mindre enn den nye, går vi videre. 
        while (peker.neste != null && peker.neste.data.compareTo(ny.data) < 0) {
            peker = peker.neste;
        }
    
        // når while loopen er brutt har vi funnet en node som er større enn den nye noden. 
        //da setter vi noden i mellom den større, og den som er før den, og øker størrelsen med 1. 
        ny.neste = peker.neste;
        peker.neste = ny;
        storrelse++;
    }
    
    

    
}
