public interface Liste <E> extends iterable <E> {
    
    int stoerrelse ();
    void leggTil (E x);
    E hent ();
    E fjern ();
    
} 
