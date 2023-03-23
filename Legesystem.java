import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Legesystem {

    public IndeksertListe pasienter;
    public IndeksertListe leger;
    public IndeksertListe legemidler;
    public IndeksertListe resepter;

    public Legesystem() {
        pasienter = new IndeksertListe<Pasient>();
        leger = new IndeksertListe<Lege>();
        legemidler = new IndeksertListe<Legemiddel>();
        resepter = new IndeksertListe<Resept>();
    }

    public void lesFraFil(String filnavn) {
        try {
            Scanner fil = new Scanner(new File(filnavn));
            String linje = fil.nextLine();

            // Les inn pasienter
            if (linje.equals("# Pasienter")) {
                while (fil.hasNextLine()) {
                    linje = fil.nextLine();
                    if (linje.startsWith("#")) {
                        break;
                    }
                    String[] pasientData = linje.split(",");
                    String navn = pasientData[0];
                    String fnr = pasientData[1];
                    Pasient pasient = new Pasient(navn, fnr);
                    pasienter.leggTil(pasient);
                }
            }

            // Les inn legemidler
            if (linje.equals("# Legemidler")) {
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
            if (linje.equals("# Leger")) {
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
            if (linje.equals("# Resepter")) {
                while (fil.hasNextLine()) {
                    linje = fil.nextLine();
                    if (linje.startsWith("#")) {
                        break;
                }
                String[] reseptData = linje.split(",");
                int legemiddelNummer = Integer.parseInt(reseptData[0]);

                //lager nytt legeobjekt
                Lege legeNavn = new Lege(reseptData[1]);
                

                int pasientID = Integer.parseInt(reseptData[2]);
                String type = reseptData[3];
                if (type.equals("blaa")) {
                    int reit = Integer.parseInt(reseptData[4]);
                    Resept blaaResept = new BlaaResept(null, legeNavn, pasientID, reit);
                    resepter.leggTil(blaaResept);
                } else if (type.equals("p")) {
                    int reit = Integer.parseInt(reseptData[4]);
                    Resept pResept = new PResept(null, legeNavn, pasientID, reit);
                    resepter.leggTil(pResept);
                } else if (type.equals("militaer")) {
                    Resept militaerResept = new MilResept(null, legeNavn, pasientID);
                    resepter.leggTil(militaerResept);
                }
            }
        }

        fil.close();
    } catch (FileNotFoundException e) {
        System.out.println("Finner ikke fil: " + filnavn);
    }
}
}

                    
                    
