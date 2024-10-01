package view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.MainWindow;

public class WelcomeView extends JPanel {
    private MainWindow mainWindow = MainWindow.getInstance();
    private JLabel jlLabel;

    public WelcomeView() {
        this.setLayout(new GridBagLayout());
        jlLabel = new JLabel("Welcome to Java");

        this.setLayout(new BorderLayout());
        this.add(MainWindow.jToolBar, BorderLayout.NORTH);
        this.add(jlLabel, BorderLayout.CENTER);
        this.add(jlLabel);
    }

    public void showWelcome() {
        mainWindow.show(this);
    }
}
