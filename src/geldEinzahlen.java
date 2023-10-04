import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class geldEinzahlen {
    public JPanel geldEinzahlenForm;
    public JComboBox comboBox1;
    private JButton cancelButton;
    private JButton einzahlenButton;
    private JComboBox geldEinzahlenComboBox;
    private JTextField geldEinzahlenAmoutn;

    public geldEinzahlen(List<Konto> konten) {

        for (Konto konto : konten) {
            String itemToAdd = konto.getKontoinhaber() + " " +  konto.getKontoart() +  " | " + konto.getKontonummer();
            geldEinzahlenComboBox.addItem(itemToAdd);
        }

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(geldEinzahlenForm);
                frame.dispose();
            }
        });

        einzahlenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedKontoItem = (String) geldEinzahlenComboBox.getSelectedItem();

                String[] parts = selectedKontoItem.split("\\|");
                String kontonummer = null;

                if (parts.length >= 2) {
                    kontonummer = parts[1].trim();
                    System.out.println(kontonummer);
                } else {
                    System.out.println("Das Extrahieren des Teils nach | ist nicht möglich.");
                }

                Konto selectedKonto = null;
                for (Konto konto : konten) {
                    if (konto.getKontonummer().equals(kontonummer)) {
                        selectedKonto = konto;
                        break;
                    }
                }

                if (selectedKonto != null) {
                    try {
                        double amount = Double.parseDouble(geldEinzahlenAmoutn.getText());
                        selectedKonto.einzahlen(amount);
                        JOptionPane.showMessageDialog(geldEinzahlenForm, "Einzahlung erfolgreich.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(geldEinzahlenForm, "Ungültige Eingabe. Bitte geben Sie eine gültige Zahl ein.");
                    }
                } else {
                    JOptionPane.showMessageDialog(geldEinzahlenForm, "Ausgewähltes Konto nicht gefunden.");
                }
            }
        });
    }
}
