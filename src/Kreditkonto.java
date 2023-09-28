public class Kreditkonto extends Konto {
    public Kreditkonto(String kontoinhaber, String blz, String kontonummer, String kontofuehrungsgebuehren, double kontostan) {
        super(kontoinhaber, "Kreditkonto", blz, kontonummer, kontofuehrungsgebuehren,  kontostan);
    }
}
