import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Legesystem {

    public Indeksertliste pasienter;
    public Indeksertliste leger;
    public Indeksertliste legemidler;
    public Indeksertliste resepter;

    public Legesystem() {
        pasienter = new Indeksertliste<Pasient>();
        leger = new Indeksertliste<Lege>();
        legemidler = new Indeksertliste<Legemiddel>();
        resepter = new Indeksertliste<Resept>();
    }


   


                public void lesFraFil(String filnavn) {
                   
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
                                double pris = Double.parseDouble(legemiddelData[2]);
                                double virkestoff = Double.parseDouble(legemiddelData[3]);
                                if (type.equals("vanlig")) {
                                    Legemiddel legemiddel = new Vanlig(navn, pris, virkestoff);
                                    legemidler.leggTil(legemiddel);
                                }
                                else if (type.equals("narkotisk")) {
                                    int styrke = Integer.parseInt(ord[5]);
                                    Legemiddel legemiddel = new Narkotisk(navn, pris, virkestoff, styrke);
                                    legemidler.leggTil(legemiddel);
                                }
                                else if (type.equals("vanedannende")) {
                                    int styrke = Integer.parseInt(ord[5]);
                                    Legemiddel legemiddel = new Vanedannende(navn, pris, virkestoff, styrke);
                                    legemidler.leggTil(legemiddel);
                                }
                            
                            }
                        }
                        if (linje.equals("# Leger")) {
                            while (fil.hasNextLine()) {
                                linje = fil.nextLine();
                                if (linje.startsWith("#")) {
                                    break;
                                }
                                String[] LegeData = linje.split(",");
                                String navn = LegeData[0];
                                int KontrollID = Integer.parseInt(LegeData[1]);
                                if (KontrollID == 0)
                                {Lege lege = new Lege(navn);
                                    leger.leggTil(lege);}
                                else{
                                    Spesialist spesialist = new Spesialist(navn, KontrollID);
                                    leger.leggTil(spesialist);
                                }
                                
                                
                            }
                        }
                        if (linje.equals("# Resepter")) {
                            while (fil.hasNextLine()) {
                                linje = fil.nextLine();
                                if (linje.startsWith("#")) {
                                    break;
                                }
                                //(legemiddelNummer,legeNavn,pasientID,type,[reit])
                                String[] ReseptData = linje.split(",");
                                int legemiddelNummer = Integer.parseInt(ReseptData[0]);
                                String legeNavn = ReseptData[1];
                                String pasientID = ReseptData[2];
                                String type = ReseptData[3];
                                if (type.equals("blaa")) {
                                    int reit = Integer.parseInt(ReseptData[4]);
                                    Resept blaresept = new BlaaResepter(legemiddelNummer,legeNavn, pasientID, reit);
                                    resepter.leggTil(blaresept);
                                }
                                else if (type.equals("p")) {
                                    int reit = Integer.parseInt(ReseptData[4]);
                                    Resept presept = new BlaaResepter(legemiddelNummer,legeNavn, pasientID, reit);
                                    resepter.leggTil(presept);
                                }
                                else if (type.equals("militaer")) {
                                    Resept militaeresept = new BlaaResepter(legemiddelNummer,legeNavn, pasientIDS);
                                    resepter.leggTil(militaerresept);
                                }
                            
                            }
                        }

                        return leger;
                        return resepter;
                        return pasienter;
                        return legemidler;

                        
                        
                        }}


                