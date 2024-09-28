package view;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * PlayFairView
 */
public class PlayFairView extends JPanel {
    private JLabel jlLabel;

    public PlayFairView() {
        this.setLayout(new GridBagLayout());
        jlLabel = new JLabel("Welcome to Play Fair");
        this.add(jlLabel);
    }

}