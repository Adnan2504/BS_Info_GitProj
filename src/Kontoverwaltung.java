import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kontoverwaltung {
    private List<Konto> konten = new ArrayList<>();

    public void kontoErstellen() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kontoinhaber: ");
        String kontoinhaber = scanner.nextLine();

        System.out.println("Wählen Sie die Kontoart:");
        System.out.println("1 - Girokonto");
        System.out.println("2 - Sparkonto");
        System.out.println("3 - Kreditkonto");

        int kontoartAuswahl = Integer.parseInt(scanner.nextLine());

        if (kontoartAuswahl < 1 || kontoartAuswahl > 3) {
            System.out.println("Ungültige Auswahl.");
            return;
        }

        String kontoart;
        if (kontoartAuswahl == 1) {
            kontoart = "Girokonto";
        } else if (kontoartAuswahl == 2) {
            kontoart = "Sparkonto";
        } else {
            kontoart = "Kreditkonto";
        }

        Konto neuesKonto = new Konto(kontoinhaber, kontoart);
        konten.add(neuesKonto);
        System.out.println("Konto erstellt.");
    }

    public void einzahlen(double betrag) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("Kontonummer: ");

        int index = 1;
        for (Konto konto : konten) {
            System.out.println(index + " - " + konto.getKontoart() + " (Kontonummer: " + konto.getKontonummer() + ")");
            index++;
        }

        String kontonummer = scanner.nextLine();

        for (Konto konto : konten) {
            konto.einzahlen(betrag);
            System.out.println("Einzahlung auf Konto " + konto.getKontonummer() + " erfolgreich.");
            return;

        }

        System.out.println("Kontonummer nicht gefunden.");
    }

    public void abheben(double betrag) {
        Scanner scanner = new Scanner(System.in);
        int index = 1;
        for (Konto konto : konten) {
            System.out.println(index + " - " + konto.getKontoart() + " (Kontonummer: " + konto.getKontonummer() + ")");
            index++;
        }
        String kontonummer = scanner.nextLine();

        for (Konto konto : konten) {
            konto.abheben(betrag);
            System.out.println("Abhebung von Konto " + konto.getKontonummer() + " erfolgreich.");
            return;

        }

        System.out.println("Kontonummer nicht gefunden.");
    }

    public void kontoauszug() {
        for (Konto konto : konten) {
            konto.kontoauszug();
        }
    }

    public void geldUeberweisen() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Von welchem Konto möchten Sie überweisen?");
        int index = 1;
        for (Konto konto : konten) {
            System.out.println(index + " - " + konto.getKontoart() + " (Kontonummer: " + konto.getKontonummer() + ")");
            index++;
        }
        int vonIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if (vonIndex < 0 || vonIndex >= konten.size()) {
            System.out.println("Ungültige Auswahl.");
            return;
        }

        System.out.println("Auf welches Konto möchten Sie überweisen?");
        int index2 = 1;
        for (Konto konto : konten) {
            System.out.println(index2 + " - " + konto.getKontoart() + " (Kontonummer: " + konto.getKontonummer() + ")");
            index2++;
        }
        int aufIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if (aufIndex < 0 || aufIndex >= konten.size()) {
            System.out.println("Ungültige Auswahl.");
            return;
        }

        System.out.print("Betrag: ");
        double betrag = Double.parseDouble(scanner.nextLine());

        Konto vonKonto = konten.get(vonIndex);
        Konto aufKonto = konten.get(aufIndex);

        vonKonto.ueberweisen(aufKonto, betrag);
    }
}