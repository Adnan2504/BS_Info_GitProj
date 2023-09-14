import java.util.ArrayList;

class Kontoverwaltung {
    private String kontoinhaber;
    private String bankleitzahl;
    private String kontonummer;
    private double ueberziehungsrahmen;
    private double kontofuehrungsgebuehren;
    protected double kontostand;
    private String kontoart;

    public Kontoverwaltung(String kontoinhaber, String bankleitzahl, String kontonummer, double ueberziehungsrahmen, double kontofuehrungsgebuehren, String kontoart) {
        this.kontoinhaber = kontoinhaber;
        this.bankleitzahl = bankleitzahl;
        this.kontonummer = kontonummer;
        this.ueberziehungsrahmen = ueberziehungsrahmen;
        this.kontofuehrungsgebuehren = kontofuehrungsgebuehren;
        this.kontostand = 0.0;
        this.kontoart = kontoart;
    }

    public void kontoErstellen() {
        this.kontoinhaber = "Adnan Bajric";
        this.bankleitzahl = "DWADWASDWA";
        this.kontonummer = "43324321432";
        this.ueberziehungsrahmen = 23.2;
        this.kontofuehrungsgebuehren = 11.23;
        this.kontostand = 19349.32;
        this.kontoart = "Girokonto";
    }

    public void einzahlen(double betrag) {
        if (betrag > 0) {
            kontostand += betrag;
            System.out.println("Einzahlung von " + betrag + " Euro erfolgreich. Neuer Kontostand: " + kontostand + " Euro");
            System.out.println("\n");
        } else {
            System.out.println("Ungültiger Einzahlungsbetrag.");
        }
    }

    public void abheben(double betrag) {
        if (betrag > 0) {
            if (kontostand - betrag >= -ueberziehungsrahmen) {
                kontostand -= betrag;
                System.out.println("Abhebung von " + betrag + " Euro erfolgreich. Neuer Kontostand: " + kontostand + " Euro");
                System.out.println("\n");
            } else {
                System.out.println("Kontostand reicht nicht aus.");
            }
        } else {
            System.out.println("Ungültiger Abhebungsbetrag.");
        }
    }

    public void kontoauszug() {
        System.out.println("Kontoinhaber: " + kontoinhaber);
        System.out.println("Bankleitzahl: " + bankleitzahl);
        System.out.println("Kontonummer: " + kontonummer);
        System.out.println("Kontostand: " + kontostand + " Euro");
        System.out.println("Kontoart: " + kontoart);
    }
}