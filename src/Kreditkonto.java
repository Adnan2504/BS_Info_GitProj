public class Kreditkonto extends Kontoverwaltung {
    public Kreditkonto(String kontoinhaber, String bankleitzahl, String kontonummer, double ueberziehungsrahmen, double kontofuehrungsgebuehren) {
        super(kontoinhaber, bankleitzahl, kontonummer, ueberziehungsrahmen, kontofuehrungsgebuehren, "Kreditkonto");
    }

}
