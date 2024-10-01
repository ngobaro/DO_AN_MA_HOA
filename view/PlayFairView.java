package view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.MainWindow;

/**
 * PlayFairView
 */
public class PlayFairView extends JPanel {
    private JLabel jlLabel;
    private JLabel jlLabel2;

    public PlayFairView() {

        jlLabel = new JLabel("Welcome to ");
        jlLabel2 = new JLabel("Welcome  hiiiii");

        this.setLayout(new BorderLayout());

        this.add(MainWindow.jToolBar, BorderLayout.NORTH);
        this.add(jlLabel, BorderLayout.CENTER);
    }

}