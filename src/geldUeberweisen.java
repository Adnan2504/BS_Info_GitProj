import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class geldUeberweisen {
    public JPanel geldUeberweisenForm;
    private JButton cancelButton;
    private JButton ueberweisenButton;
    private JComboBox vonAccountComboBox;
    private JComboBox toAccountComboBox;
    private JTextField geldUeberweisenText;

    public geldUeberweisen(List<Konto> konten) {

        for (Konto konto : konten) {
            String itemToAdd = konto.getKontoinhaber() + " " + konto.getKontoart() + " | " + konto.getKontonummer();
            vonAccountComboBox.addItem(itemToAdd);
            toAccountComboBox.addItem(itemToAdd);
        }

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(geldUeberweisenForm);
                frame.dispose();
            }
        });

        ueberweisenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fromSelectedKontoItem = (String) vonAccountComboBox.getSelectedItem();
                String toSelectedKontoItem = (String) toAccountComboBox.getSelectedItem();

                String[] fromParts = fromSelectedKontoItem.split("\\|");
                String fromKontonummer = null;

                if (fromParts.length >= 2) {
                    fromKontonummer = fromParts[1].trim();
                    System.out.println(fromKontonummer);
                } else {
                    System.out.println("Das Extrahieren des Teils nach | ist nicht möglich.");
                }

                String[] toParts = toSelectedKontoItem.split("\\|");
                String toKontonummer = null;

                if (toParts.length >= 2) {
                    toKontonummer = toParts[1].trim();
                    System.out.println(toKontonummer);
                } else {
                    System.out.println("Das Extrahieren des Teils nach | ist nicht möglich.");
                }

                Konto fromKonto = null;
                Konto toKonto = null;

                for (Konto konto : konten) {
                    if (konto.getKontonummer().equals(fromKontonummer)) {
                        fromKonto = konto;
                    } else if (konto.getKontonummer().equals(toKontonummer)) {
                        toKonto = konto;
                    }

                    if (fromKonto != null && toKonto != null) {
                        break;
                    }
                }

                if (fromKonto != null && toKonto != null) {
                    try {
                        double amount = Double.parseDouble(geldUeberweisenText.getText());
                        if (amount > 0) {
                            fromKonto.ueberweisen(toKonto, amount);
                            JOptionPane.showMessageDialog(geldUeberweisenForm, "Überweisung erfolgreich.");
                        } else {
                            JOptionPane.showMessageDialog(geldUeberweisenForm, "Ungültiger Betrag. Bitte geben Sie einen positiven Betrag ein.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(geldUeberweisenForm, "Ungültige Eingabe. Bitte geben Sie eine gültige Zahl ein.");
                    }
                } else {
                    JOptionPane.showMessageDialog(geldUeberweisenForm, "Ausgewählte Konten nicht gefunden.");
                }
            }
        });
    }
}
