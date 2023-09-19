import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        Kontoverwaltung kontoverwaltung = new Kontoverwaltung();

        while (true) {
            System.out.println("Welche Aktion möchten Sie durchführen?");
            System.out.println("1 - Konto anlegen");
            System.out.println("2 - Einzahlen");
            System.out.println("3 - Abheben");
            System.out.println("4 - Kontoauszug");
            System.out.println("5 - Geld zwischen Konten überweisen");
            System.out.println("0 - Programm beenden");
            System.out.println("\n");

            userInput = scanner.nextLine();

            switch (userInput) {
                case "0":
                    System.out.println("Programm wird beendet.");
                    return;
                case "1":
                    kontoverwaltung.kontoErstellen();
                    break;
                case "2":
                    System.out.print("Betrag einzahlen: ");
                    userInput = scanner.nextLine();
                    double inputEinzahlen = Double.parseDouble(userInput);
                    kontoverwaltung.einzahlen(inputEinzahlen);
                    break;
                case "3":
                    System.out.print("Betrag abheben: ");
                    userInput = scanner.nextLine();
                    double inputAbheben = Double.parseDouble(userInput);
                    kontoverwaltung.abheben(inputAbheben);
                    break;
                case "4":
                    kontoverwaltung.kontoauszug();
                    break;
                case "5":
                    kontoverwaltung.geldUeberweisen();
                    break;
                default:
                    System.out.println("Ungültige Eingabe. Bitte wählen Sie eine der verfügbaren Optionen.");
            }
        }
    }
}
