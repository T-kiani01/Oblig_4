import java.util.Scanner;

class Hovedmeny {
    public static void main(String[] args) {

        Legesystem hoved = new Legesystem();
        try {
            hoved.lesFraFil("Legedata.txt");
        } catch (UlovligUtskrift e) {
        }

        System.out.println("Velkommen til dette legesystemet. Du blir naa presentert med en rekke valg! Tast inn NR paa det du onsker aa gjore!");
        menyen(hoved);

    }

    public static void menyen(Legesystem hoved) {
        int input;
        Scanner scan = new Scanner(System.in);
        System.out.println("1: Skrive ut valgfri oversikt av ulike elementer i systemet.");
        System.out.println("2: Opprett et nytt element og legg det til i systemet");
        System.out.println("3: Bruke en resept for en gitt pasient");
        System.out.println("4: Skriv ut diverse statistikk om systemet");
        System.out.println("5: Skrive alle data til ny fil");
        System.out.println("6: for aa avslutte programmet :(");

        input = scan.nextInt();
        if (input == 1) {
            hoved.skrivOversikt();
            menyen(hoved);
        } else if (input == 2) {
            try {
                hoved.leggTil();
            } catch (UlovligUtskrift e) {
            }

            menyen(hoved);
        } else if (input == 3) {
            hoved.brukresept();
            menyen(hoved);
        } else if (input == 4) {
            //hoved.skrivStatistikk();
            menyen(hoved);
        } else if (input == 5) {
            //hoved.skrivTilFil();
            menyen(hoved);
        } else if (input == 6) {
            System.out.println("Programmet avsluttes.");
            System.exit(0);
        } else {
            System.out.println("Ugyldig input. Prøv igjen.");
            menyen(hoved);
        }
    }
}

