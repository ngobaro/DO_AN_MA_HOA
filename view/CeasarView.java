package view;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import main.MainWindow;

/**
 * CeasarView
 */
public class CeasarView extends JPanel {
    private JLabel jlLabel;
    MainWindow mainWindow = MainWindow.getInstance();

    public CeasarView() {
        this.setLayout(new GridBagLayout());
        jlLabel = new JLabel("Welcome to Ceasar");
        this.add(jlLabel);
    }

    public void showCeasear() {
        mainWindow.show(this);
    }

}