public class Girokonto extends Konto {
    public Girokonto(String kontoinhaber,  String blz, String kontonummer, String kontofuehrungsgebuehren, double kontostan) {
        super(kontoinhaber, "Girokonto", blz, kontonummer, kontofuehrungsgebuehren,  kontostan);

    }
}
