public class Sparkonto extends Konto {
    public Sparkonto(String kontoinhaber, String blz, String kontonummer, String kontofuehrungsgebuehren, double kontostan) {
        super(kontoinhaber, "Sparkonto", blz, kontonummer, kontofuehrungsgebuehren,  kontostan);
    }
}
