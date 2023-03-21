import java.util.Iterator;

abstract class Lenkeliste <E> implements Liste <E> {

        //lager en klasse for Nodene som den lenkede listen består av.
        public class Node{
            //En node har en data-verdi, og en referanse til neste node.
            E data;
            Node neste;
        
            public Node(E data)
            {
                this.data = data;
                this.neste = null;
            }
        
        }
        
        //lager et nodeobjekt som settes til null i Lenkeliste konstrukør, dette bli starten på listen
        protected Node start;
        public int storrelse = 0;

    public Lenkeliste() 
    {
        this.start = null;
    }

    //fjerner det første elementet ved å sete start til neste node, og returnerer første node-data. 
    @Override
    public E fjern() {

        if (start!=null){
            
        E fjernetData = start.data;
        start = start.neste;
        storrelse--;

        return fjernetData;
        }

        throw new UgyldigListeindeks(storrelse);       
    }

    //hvis start ikke er null, returneres data-verdien til start
    @Override
    public E hent() {
        if(start == null) {
            return null;
        }
        return start.data;
    }

    //Legger til på siste plass av den lenkede listen. Hvis listen legges den til som start, hvis ikke finner vi der peker.neste er null, og legger inn på neste. 
    @Override
    public void leggTil(E x) {
        
        Node noden = new Node(x);
        if(start == null)
        {
            start = noden;
        } else {
            Node peker = start;
            while(peker.neste != null)
            {
                peker = peker.neste;
            }
            peker.neste = noden;
        }

        storrelse++;

    }

    @Override
    //opprinnelig hadde jeg den koden du ser her, men jeg innså at det er 
    //Lettere å bare ha en teller som øker og synker for legg til/fjern
    public int stoerrelse() {
        //int antall = 0;
        //Node peker = start;

        //while(peker!=null)
        //{
        //    antall++;
        //    peker = peker.neste;
        //}

        //return antall;

        return storrelse;

    }

    public String toString()
    {
        if(start == null)
        {
            return "[]";
        }

        String retur = "[ ";
        retur += start.data + ", ";
        Node peker = start;
        while(peker.neste != null)
        {
            peker = peker.neste;
            retur += peker.data + ", "; 
        }

        retur += "]";

        return retur;

    }

    public LenkelisteIterator Iterator() 
    {
        LenkelisteIterator l2 = new LenkelisteIterator();
        return l2;
    }


public class LenkelisteIterator implements Iterable <E>
{

    public LenkelisteIterator(){}

    
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public boolean hasNext() {
        
        return false;
    }

    public E next() {
        
        return null;
    }
    
}


}