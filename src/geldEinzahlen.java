import javax.swing.*;
import java.util.List;

public class geldEinzahlen {
    public JPanel geldEinzahlenForm;
    public JTextField textField1;
    public JComboBox<String> comboBox1;

    public geldEinzahlen(List<Konto> konten) {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        comboBox1.setModel(comboBoxModel);
        MainForm a = new MainForm();

        for (Konto konto : konten) {
            String itemToAdd = konto.getKontoinhaber() + " " + konto.getKontonummer();
            comboBoxModel.addElement(itemToAdd);
        }
    }
}
