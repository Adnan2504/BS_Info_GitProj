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

        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        kontoartcomboBox.setModel(comboBoxModel);

        comboBoxModel.addElement("Spar");
        comboBoxModel.addElement("Kredit");
        comboBoxModel.addElement("Giro");
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
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for Kontostand.");
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
