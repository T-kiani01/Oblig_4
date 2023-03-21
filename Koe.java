class Koe <E> extends Lenkeliste <E> {

    public Koe() {
    }

    //D1: ingen metoder må endres på her, metodene i superklassen følger allerede kø prinsippet av "Sist inn, sist ut"
    //FIFO prinsippet fungerer kun fordi at vi ikke har en metode i superklassen eller i denne som tillater innsetting på arbitrære posisjoner. 
    //Hvis det var en slik metode(slik som indeksertListe), måtte vi ha over-ridet fjern() til å behandle elementene etter hvor lenge de hadde vært i listen. 
    //D2: Testkoe: Alt riktig!

}
