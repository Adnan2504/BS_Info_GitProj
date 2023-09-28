import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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


    public KontoAnlegen() {

        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        kontoartcomboBox.setModel(comboBoxModel);

        comboBoxModel.addElement("Spar");
        comboBoxModel.addElement("Kredit");
        comboBoxModel.addElement("Giro");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = kontostandText.getText();
                Double kontoStand = Double.parseDouble(a);
                Konto konto = new Konto(kontoInhaberText.toString(), kontoartcomboBox.getSelectedItem().toString(), blzText.toString(), konotnummerText.toString(), zinsenText.toString(), kontoStand);
                MainForm mainform = new MainForm();
                mainform.konten.add(konto);
                mainform.displayKonten();
            }
        });
    }
}
