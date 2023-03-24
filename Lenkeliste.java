import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class Lenkeliste<E> implements Liste<E>, Iterable<E> {

    protected class Node {
        E data;
        Node neste;

        public Node(E data) {
            this.data = data;
            this.neste = null;
        }
    }

    protected Node start;
    protected int storrelse;

    public Lenkeliste() {
        this.start = null;
        this.storrelse = 0;
    }

    @Override
    public int stoerrelse() {
        return storrelse;
    }

    @Override
    public void leggTil(E x) {
        Node nyNode = new Node(x);

        if (start == null) {
            start = nyNode;
        } else {
            Node p = start;
            while (p.neste != null) {
                p = p.neste;
            }
            p.neste = nyNode;
        }

        storrelse++;
    }

    @Override
    public E fjern() {
        if (start == null) {
            throw new UgyldigListeindeks(-1);
        }

        E fjernetData = start.data;
        start = start.neste;
        storrelse--;

        return fjernetData;
    }

    @Override
    public E hent() {
        if (start == null) {
            return null;
        }

        return start.data;
    }

    @Override
    public Iterator<E> iterator() {
        return new LenkelisteIterator();
    }

    private class LenkelisteIterator implements Iterator<E> {
        private Node current = start;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.neste;
            return data;
        }

    }

    public String toString() {
        if (start == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node p = start;
        while (p != null) {
            sb.append(p.data.toString());
            p = p.neste;
            if (p != null) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
