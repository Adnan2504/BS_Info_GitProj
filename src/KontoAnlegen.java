import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class KontoAnlegen {
    public JPanel kontoAnlegen;
    private JTextField kontoInhaberText;
    private JComboBox<String> kontoartcomboBox;
    private JButton saveButton;
    private JButton closeButton;
    private JTextField konotnummerText;
    private JTextField zinsenText;
    private JTextField kontostandText;
    private JLabel blzLabel;
    private JTextField blzText;


    public KontoAnlegen(List<Konto> konten) {

        kontoartcomboBox.addItem("Giro");
        kontoartcomboBox.addItem("Spar");
        kontoartcomboBox.addItem("Kredit");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String kontoInhaber = kontoInhaberText.getText();
                    String kontoArt = kontoartcomboBox.getSelectedItem().toString();
                    String blz = blzText.getText();
                    String kontonummer = konotnummerText.getText();
                    String zinsen = zinsenText.getText();
                    Double kontostand = Double.parseDouble(kontostandText.getText());

                    Konto konto = new Konto(kontoInhaber, kontoArt, blz, kontonummer, zinsen, kontostand);
                    MainForm mainform = new MainForm();
                    mainform.konten.add(konto);
                    mainform.displayKonten();
                    konten.add(konto);

                    System.out.println(konto);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ungültige Eingabe. Bitte geben Sie eine gültige Zahl für den Kontostand ein.");
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(kontoAnlegen);
                frame.dispose();
            }
        });
    }
}
