public class Girokonto extends Kontoverwaltung {
    public Girokonto(String kontoinhaber, String bankleitzahl, String kontonummer, double ueberziehungsrahmen, double kontofuehrungsgebuehren) {
        super(kontoinhaber, bankleitzahl, kontonummer, ueberziehungsrahmen, kontofuehrungsgebuehren, "Girokonto");
    }

}
