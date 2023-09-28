import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainForm {
    private JButton kontoAnlegenButton;
    private JButton geldÜberweisenButton;
    private JButton kontoAuszugButton;
    private JButton einzahlenButton;
    private JPanel mainForm;
    private JButton abhebenButton;

    public List<Konto> konten = new ArrayList<>();


    public MainForm() {
        kontoAnlegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame kontoAnlegenFrame = new JFrame("konotAnlegenFrame");
                kontoAnlegenFrame.setContentPane(new KontoAnlegen().kontoAnlegen);
                kontoAnlegenFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                kontoAnlegenFrame.setVisible(true);
                kontoAnlegenFrame.pack();
            }
        });

        kontoAuszugButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    StringBuilder message = new StringBuilder("List of Konten:\n");
                    for (Konto konto : konten) {
                        message.append("Kontoinhaber: " + konto.kontoinhaber + "\n");
                        message.append("Kontonummer: " + konto.kontonummer + "\n");
                        message.append("Kontostand: " + konto.kontostand + "\n");
                        message.append("Kontoart: " + konto.kontoart + "\n");
                    }
                    JOptionPane.showMessageDialog(null, message, "List Output", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        einzahlenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame geldEinzahlenField = new JFrame("geldEinzahlenField");
                geldEinzahlenField.setContentPane(new geldEinzahlen().geldEinzahlenForm);
                geldEinzahlenField.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                geldEinzahlenField.setVisible(true);
                geldEinzahlenField.pack();
            }
        });
        abhebenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame geldAbhebenField = new JFrame("geldAbhebenField");
                geldAbhebenField.setContentPane(new geldAbheben().geldAbhebenField);
                geldAbhebenField.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                geldAbhebenField.setVisible(true);
                geldAbhebenField.pack();
            }
        });
    }

    public void displayKonten() {
        for (Konto konto : konten) {
            System.out.println("Kontoinhaber: " + konto.kontoinhaber);
            System.out.println("Kontonummer: " + konto.kontonummer);
            System.out.println("Kontostand: " + konto.kontostand);
            System.out.println("Kontoart: " + konto.kontoart);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new MainForm().mainForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}
