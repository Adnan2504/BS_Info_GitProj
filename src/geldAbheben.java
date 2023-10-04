import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class geldAbheben {
    public JComboBox comboBox1;
    public JPanel geldAbhebenField;
    public JTextField textField1;
    private JButton cancelButton;
    private JButton abhebenButton;

    public geldAbheben(List<Konto> konten){


        for (Konto konto : konten) {
            String itemToAdd = konto.getKontoinhaber() + " " +  konto.getKontoart() +  " | " + konto.getKontonummer();
            comboBox1.addItem(itemToAdd);
        }

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(geldAbhebenField);
                frame.dispose();
            }
        });

        abhebenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedKontoItem = (String) comboBox1.getSelectedItem();
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
                    if ( konto.getKontonummer().equals(kontonummer)) {
                        selectedKonto = konto;
                        break;
                    }
                }

                if (selectedKonto != null) {
                    try {
                        double amount = Double.parseDouble(textField1.getText());
                        if (selectedKonto.abheben(amount)) {
                            JOptionPane.showMessageDialog(geldAbhebenField, "Abhebung erfolgreich.");
                        } else {
                            JOptionPane.showMessageDialog(geldAbhebenField, "Nicht genug Guthaben.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(geldAbhebenField, "Ungültige Eingabe. Bitte geben Sie eine gültige Zahl ein.");
                    }
                } else {
                    JOptionPane.showMessageDialog(geldAbhebenField, "Ausgewähltes Konto nicht gefunden.");
                }
            }
        });

    }
}
