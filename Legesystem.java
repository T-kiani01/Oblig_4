import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Legesystem {

    public IndeksertListe<Pasient> pasienter;
    public Prioritetskoe<Lege> leger;
    public IndeksertListe<Legemiddel> legemidler;
    public IndeksertListe<Resept> resepter;

    public Legesystem() {
        pasienter = new IndeksertListe<>();
        leger = new Prioritetskoe<>();
        legemidler = new IndeksertListe<>();
        resepter = new IndeksertListe<>();
    
    }

    public void lesFraFil(String filnavn) throws UlovligUtskrift {
        
        try {
            
            Scanner fil = new Scanner(new File(filnavn));
            String linje = fil.nextLine();
            
            // Les inn pasienter
            if (linje.startsWith("# Pasienter")) {
                
                while (fil.hasNextLine()) {
                    linje = fil.nextLine();
                    if (linje.startsWith("#")) {
                        break;
                    }
                    String[] pasientData = linje.split(",");
                    System.out.println(pasientData);
                    String navn = pasientData[0];
                    String fnr = pasientData[1];
                    Pasient pasient = new Pasient(navn, fnr);
                    pasienter.leggTil(pasient);
                }
            }

            // Les inn legemidler
            if (linje.startsWith("# Legemidler")) {
                while (fil.hasNextLine()) {
                    linje = fil.nextLine();
                    if (linje.startsWith("#")) {
                        break;
                    }
                    String[] legemiddelData = linje.split(",");
                    String navn = legemiddelData[0];
                    String type = legemiddelData[1];
                    int pris = Integer.parseInt(legemiddelData[2]);
                    double virkestoff = Double.parseDouble(legemiddelData[3]);
                    

                    if (type.equals("vanlig")) {
                        Legemiddel legemiddel = new Vanlig(navn, pris, virkestoff);
                        legemidler.leggTil(legemiddel);
                        
                    } else if (type.equals("narkotisk")) {
                        int styrke = Integer.parseInt(legemiddelData[4]);
                        Legemiddel legemiddel = new Narkotisk(navn, pris, virkestoff, styrke);
                        legemidler.leggTil(legemiddel);
                        
                    } else if (type.equals("vanedannende")) {
                        int styrke = Integer.parseInt(legemiddelData[4]);
                        Legemiddel legemiddel = new Vanedannende(navn, pris, virkestoff, styrke);
                        legemidler.leggTil(legemiddel);
                        
                    }
                }
            }

                        // Les inn leger
            if (linje.startsWith("# Leger")) {
                while (fil.hasNextLine()) {
                    linje = fil.nextLine();
                    if (linje.startsWith("#")) {
                        break;
                    }
                    String[] legeData = linje.split(",");
                    String navn = legeData[0];
                    String kontrollnr = legeData[1];
                    int kontrollIDsjekk = Integer.parseInt(legeData[1]);
                    if (kontrollIDsjekk == 0) {
                        Lege lege = new Lege(navn);
                        leger.leggTil(lege);
                    } else {
                        Spesialist spesialist = new Spesialist(navn, kontrollnr);
                        leger.leggTil(spesialist);
                    }
                }
            }

            // Les inn resepter
            if (linje.startsWith("# Resepter")) {
                // skip header line
                
                while (fil.hasNextLine()) {
                    linje = fil.nextLine();
                    if (linje.startsWith("#")) {
                        break;
                    }
                    //lager en liste av elementene på linjen
                    String[] reseptData = linje.split(",");
                    //for å opprette resept må vi først ha legen, legemiddelet, og pasienten. 
                    int legemiddelNummer = Integer.parseInt(reseptData[0]);
                    Lege legeNavn = null;
                    Pasient pasientObj = null;

                    //finner legen vår i listen med en for-løkke
                    for (Lege lege : leger) {
                        if (lege.hentNavn().equals(reseptData[1])) {
                            legeNavn = lege;
                            break;
                        } else {
                            legeNavn = new Lege(reseptData[1]);
                        }
                    }

                    //finner pasienten vår i pasient listen med en for løkke
                    for (Pasient pasient : pasienter) {
                        if (pasient.hentPasientID() == Integer.parseInt(reseptData[2])) {
                            pasientObj = pasient;
                            break;
                        }
                    }

                    //finner legemiddelet i listen vår med en for-løkke
                    Legemiddel legemiddel = null;
                    for (Legemiddel l : legemidler) {
                        if (l.hentId() == legemiddelNummer) {
                            legemiddel = l;
                            break;
                        }
                    }

                    String type = reseptData[3];
                    Resept resept = null;
                    if (type.startsWith("hvit")) {
                        int reit = Integer.parseInt(reseptData[4]);
                        resept = legeNavn.skrivHvitResept(legemiddel, pasientObj, reit);
                    } else if (type.startsWith("blaa")) {
                        int reit = Integer.parseInt(reseptData[4]);
                        resept = legeNavn.skrivBlaaResept(legemiddel, pasientObj, reit);
                    } else if (type.startsWith("militaer")) {
                        int reit = 3;
                        resept = legeNavn.skrivMilResept(legemiddel, pasientObj, reit);
                    } else if (type.startsWith("p")) {
                        int reit = Integer.parseInt(reseptData[4]);
                        resept = legeNavn.skrivPResept(legemiddel, pasientObj, reit);
                    }

                    if (resept != null) {
                        resepter.leggTil(resept);
                        pasientObj.leggTilResept(resept);
                    }
                }
            }
        }   catch (FileNotFoundException e) {
            System.out.println("Feil: Finner ikke filen");
            return;
        }
    }


    public void skrivOversikt()
    {   
        int inp;
        Scanner scan = new Scanner(System.in);
        System.out.println("Hva onsker du aa se hele oversikten for?(1-4)\n 1: Pasient \n 2: Leger \n 3: Legemidler\n 4: Resepter");
        inp = scan.nextInt();

        if(inp == 1){
        System.out.println("PASIENTENE i systemet er disse:");

        for(Pasient p : pasienter)
        {
            System.out.println(p);
            System.out.println("");
        }
        }

        else if(inp == 2){
        System.out.println("LEGENE(A-Z) i systemet er disse:");

        for(Lege l : leger)
        {
            System.out.println(l);
            System.out.println("");
        }
        }

        else if(inp == 3){
        System.out.println("Under er hvert LEGEMIDDEL i systemet");

        for(Legemiddel middel : legemidler)
        {
            System.out.println(middel);
            System.out.println("");
        }
        }

        else if (inp == 4) {
        System.out.println("her er alle RESEPTER i systemet");
        
        for(Resept r: resepter)
        {
            System.out.println(r);
            System.out.println("");
        }
    } else {
        System.out.println("Ugyldig input");
    }
    }

    public void brukresept()
    
    {
        int pasientnr;
        int reseptnr;
        Scanner scan = new Scanner(System.in);
        System.out.println("hvilken pasient onsker du aa se resepter for? (Tast NR)");
        for(int i = 0; i < pasienter.storrelse; i++)
        {
            System.out.println(i + ". " + pasienter.hent(i).navn);
            System.out.println("");
        }
        pasientnr = scan.nextInt();

        Pasient pasienten = pasienter.hent(pasientnr);
        System.out.println("Velg den resepten du ønsker å bruke(Tast NR)");
        for(int y = 0; y < pasienten.resepter.storrelse; y++)
        {
            System.out.println(y + ". " + pasienten.resepter.hent(y));
            System.out.println("");
        }
        reseptnr = scan.nextInt();
         if(pasienten.resepter.hent(reseptnr).bruk() == true){
        System.out.println("Du har brukt et reit av denne resepten, det er naa " + pasienten.resepter.hent(reseptnr).hentReit() + " Reit gjenvaerende." );
        } else {
            System.out.println("Kunne ikke bruke resept, (ingen gjenvaerende reit)."); 
            System.out.println("");
        }
    }

        public void leggTil() throws UlovligUtskrift
    {   
        System.out.println("Hva onsker du å legge til?(Tast 1-4)");
        System.out.println("1.Lege");
        System.out.println("2.Pasient");
        System.out.println("3.Resept");
        System.out.println("4.Legemiddel");
        Scanner scanner = new Scanner(System.in);
        int inp = scanner.nextInt();

        if(inp == 1)
        {leggTilLege();}
        else if(inp == 2)
        {leggTilPasient();}
        else if(inp == 3)
        {leggTilResept();}
        else if(inp == 4)
        {leggTilLegemiddel();}
        else 
        { System.out.println("Ugyldig inntasting");}

    }


    public void leggTilLege() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Navn på legen: ");
        String nylegenavn = scanner.nextLine();
        
        System.out.println("Er Legen en spesialist?(ja/nei)");
        String svar = scanner.nextLine();
        if (svar.equalsIgnoreCase("ja"))
        
        {
        System.out.println("Kontroll ID: ");
        String nykontrollID = scanner.nextLine();

        // Sjekker om legen allerede finnes
        for (Lege lege : leger) {
            if (lege.hentNavn().equals(nylegenavn) ) {
                System.out.println("Legen finnes allerede i systemet.");
                return;
            }
        }

        leger.leggTil(new Spesialist(nylegenavn, nykontrollID));
        System.out.println("Legen " + nylegenavn + " er lagt til i systemet.");}
        
        else if (svar.equalsIgnoreCase("nei"))
        {
        // Sjekker om legen allerede finnes
        for (Lege lege : leger) {
            if (lege.hentNavn().equals(nylegenavn)) {
                System.out.println("Legen finnes allerede i systemet.");
                return;
            }
        }

        leger.leggTil(new Lege(nylegenavn));
        System.out.println("Legen " + nylegenavn + " er lagt til i systemet.");
    } else {
        System.out.println("Ugyldig svar, kun JA eller NEI");
    }
}

    public void leggTilPasient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Navn på pasienten: ");
        String nypasientnavn = scanner.nextLine();
        System.out.print("Personnummer: ");
        String nypersonnummer = scanner.nextLine();

        // Sjekker om pasienten allerede finnes
        for (Pasient pasient : pasienter) {
            if (pasient.hentNavn().equals(nypasientnavn) && pasient.hentFødselsnummer().equals(nypersonnummer)) {
                System.out.println("Pasienten finnes allerede i systemet.");
                return;
            }
        }

        pasienter.leggTil(new Pasient(nypasientnavn, nypersonnummer));
        System.out.println("Pasienten " + nypasientnavn + " er lagt til i systemet.");
    }




    public void leggTilLegemiddel() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Navn på legemiddelet: ");
        String navn = scanner.nextLine();
        System.out.print("Pris: ");
        int pris = scanner.nextInt();
        System.out.print("Virkestoff: ");
        double virkestoff = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.println("Type (vanlig/vanedannende/narkotisk): ");
        String type = scanner.nextLine();

        if (type.equals("vanlig")) {
            legemidler.leggTil(new Vanlig(navn, pris, virkestoff));

        }
        else if (type.equals("vanedannende")) {
            System.out.print("Oppgi vanedannende styrke: ");
            int styrke = scanner.nextInt();
            legemidler.leggTil(new Vanedannende(navn, pris,virkestoff, styrke));
        }
        else if (type.equals("narkotisk")) {
            System.out.print("Oppgi narkotisk styrke: ");
            int styrke = scanner.nextInt();
            legemidler.leggTil(new Narkotisk(navn, pris,virkestoff, styrke));
        }
        else {
            System.out.println("Ugyldig legemiddeltype.");
        }
    }

        public void leggTilResept() {
            try {
            Scanner scanner = new Scanner(System.in);
            Lege valgtLege = null;
            Pasient valgtPasient= null;
            Legemiddel valgtLegemiddel = null;

            System.out.println("Hvilken Lege ønsker du å skrive ut en resepet fra");
            for(int i = 0; i < leger.storrelse;i++)
            {
                System.out.println(i + "." + leger.hent(i).navn);
            }
            int legenr = scanner.nextInt();
            if(legenr > leger.storrelse)
            {System.out.println("Ugyldig Lege");}
            else
            { valgtLege = leger.hent(legenr);}
            System.out.println("valgtLege: " + valgtLege);


            System.out.println("Hvilken pasient er resepten for?");
            for(int i = 0; i < pasienter.storrelse;i++)
            {
                System.out.println(i + "." + pasienter.hent(i).navn);
                System.out.println("");
            }
            int pasientnr = scanner.nextInt();
            if(pasientnr > pasienter.storrelse)
            {System.out.println("Ugyldig Pasient");}
            else
            {valgtPasient = pasienter.hent(pasientnr);}



            System.out.println("Hvilket Legemiddel skal resepten være for?");
            for(int i = 0; i < legemidler.storrelse;i++)
            {
                System.out.println(i + "." + legemidler.hent(i).navn);
                System.out.println("");
            }
            int legemidelnr = scanner.nextInt();
            scanner.nextLine(); 
            if(legemidelnr > legemidler.storrelse)
            {System.out.println("Ugyldig Legemiddel");}
            else
            {valgtLegemiddel = legemidler.hent(legemidelnr);}

            System.out.println("Oppgi antall reit på resepten");
            int nyreit = scanner.nextInt();
            scanner.nextLine(); 

            System.out.println("Oppgi resepttype (blaa, hvit, militaer eller p):");
            String resepttype = scanner.nextLine();

            if (resepttype.equals("hvit")) {

                resepter.leggTil(valgtLege.skrivHvitResept(valgtLegemiddel , valgtPasient, nyreit));
                System.out.println("Resepten har blitt lagt til!");
            } else if (resepttype.equals("blaa")) {
                
                resepter.leggTil(valgtLege.skrivBlaaResept(valgtLegemiddel , valgtPasient, nyreit));
                System.out.println("Resepten har blitt lagt til!");
            } else if (resepttype.equals("militaer")) {
                
                resepter.leggTil(valgtLege.skrivMilResept(valgtLegemiddel , valgtPasient, nyreit));
                System.out.println("Resepten har blitt lagt til!");
            } else if (resepttype.equals("p")) {
               
                resepter.leggTil(valgtLege.skrivPResept(valgtLegemiddel , valgtPasient, nyreit));
                System.out.println("Resepten har blitt lagt til!");
            }

            else
            {System.out.println("Ugyldig Resepttype");}
            
            } catch (UlovligUtskrift e) {
                
                System.out.println("Legen har ikke lov til aa skrive ut legemiddelet");

            }
        }
    }
    


    

    
        
        






