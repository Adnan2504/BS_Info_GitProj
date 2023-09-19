import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Konto {
    private String kontoinhaber;
    private String bankleitzahl;
    private String kontonummer;
    private double ueberziehungsrahmen;
    private double kontofuehrungsgebuehren;
    private double kontostand;
    private String kontoart;

    public Konto(String kontoinhaber, String kontoart) {
        this.kontoinhaber = kontoinhaber;
        this.bankleitzahl = generateBankleitzahl();
        this.kontonummer = generateKontonummer();
        this.ueberziehungsrahmen = 0.0;
        this.kontofuehrungsgebuehren = 0.0;
        this.kontostand = 1000000.0;
        this.kontoart = kontoart;
    }

    private String generateBankleitzahl() {
        return String.format("%10d", new Random().nextInt(100000000));
    }

    private String generateKontonummer() {
        return String.format("%10d", new Random().nextInt(1000000000));
    }

    public void einzahlen(double betrag) {
        kontostand += betrag;
    }

    public void abheben(double betrag) {
        if (kontostand - betrag >= -ueberziehungsrahmen) {
            kontostand -= betrag;
        } else {
            System.out.println("Nicht genug Guthaben.");
        }
    }

    public void kontoauszug() {
        System.out.println("_________________________");
        System.out.println("Kontoinhaber: " + kontoinhaber);
        System.out.println("Kontonummer: " + kontonummer);
        System.out.println("Kontostand: " + kontostand);
        System.out.println("Kontoart: " + kontoart);
        System.out.println("\n");
        System.out.println("_________________________");
    }

    public String getKontonummer() {
        return kontonummer;
    }

    public void ueberweisen(Konto zielkonto, double betrag) {
        if (kontostand - betrag >= -ueberziehungsrahmen) {
            abheben(betrag);
            zielkonto.einzahlen(betrag);
            System.out.println("Überweisung erfolgreich.");
        } else {
            System.out.println("Nicht genug Guthaben für die Überweisung.");
        }
    }

    public String getKontoart() {
        return kontoart;
    }
}
