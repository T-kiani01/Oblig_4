public class IndeksertListe <E> extends Lenkeliste<E> {

    public void leggTil (int pos, E x) 
    { 
        //sjekker om indeksen er gyldig
        if(0 > pos || pos > storrelse + 1)
        {
            throw new UgyldigListeindeks(pos);
        } else {

            //hvis gyldig indeks, lages noden
            Node noden = new Node(x);
            if(pos == 0)
            {   
                //hvis posisjon er 0, settes noden før start og blir nå startnoden, som for stabel klassen
                noden.neste = start;
                start = noden;
                storrelse++;
                return;
            }
            
            //hvis noden er større enn 0, itererer vi gjennom lenken til vi er en plass før pos. 
            //Så setter vi noden til å peke på plassen etter pos, og plassen som var på pos til å peke på noden
            //på denne måten har vi skapt plass for en node mellom disse, og gjort lenken større med 1
            Node peker = start;
            for(int i = 0; i < pos-1; i++)
            {
                peker = peker.neste;
            }
            noden.neste = peker.neste;
            peker.neste = noden;
            storrelse++;

        }
    }

   
    public void sett (int pos, E x) 
    {
        if (0<= pos && pos < storrelse)
        {   
            
            Node ny = new Node(x);
            Node peker = start;
            for(int i = 0; i < pos; i++)
            {
                peker = peker.neste;
            }

            //istedenfor å opprette et nytt objekt og sette det inn på plassen, sier vi bare at data verdien for den posisjon endres til "x", 
            //dette er den mest effektive måten å gjøre det på. 
            peker.data = ny.data;
            return;
        
        } else {

        throw new UgyldigListeindeks(pos);

        }

    }

    //Itererer gjennom til vi finner noden som er på pos, og returnerer dens data.
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

    public E fjern (int pos) 
    {
          if (0<= pos && pos < storrelse)
        {   
            E fjernetData;
            //hvis pos er den første noden, setter vi start til neste node
            if(pos==0)
            {   
                fjernetData = start.data;
                start = start.neste;
               
            }
            
            //hvis pos er siste node, setter vi nest siste node til å peke på null
            else if(pos == storrelse-1)
            {
                Node peker = start;
                for(int i = 0; i < pos-2; i++)
                {
                    peker = peker.neste;
                }
                fjernetData = peker.neste.data;
                peker.neste = null;
                

            //dette er i alle andre tilfeller, der vi fjerner en mellom-node og linker sammen nodene ved siden av. 
            } else {
            
                Node førPos = start;
                //etter for-løkka, peker "peker" på noden som er et hakk før noden på "pos"
                for(int i = 0; i < pos-1; i++)
                {
                    førPos = førPos.neste;
                }
                fjernetData = førPos.neste.data;
                Node etterPos = førPos.neste.neste;

                //noden før "pos" slutter å peke på noden som lå på pos, og peker nå på noden etter. 
                //i all praksis, vil den noden nå ikke lenger være med i lenken.
                førPos.neste = etterPos;
                
                }

                storrelse--;
                return fjernetData;

        } else {
            throw new UgyldigListeindeks(-1);
        }    
    }

    } 
