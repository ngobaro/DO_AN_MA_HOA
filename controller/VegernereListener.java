package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.VegernereView;

public class VegernereListener implements ActionListener {
    private VegernereView vegernereView;

    public VegernereListener(VegernereView vegernereView) {
        this.vegernereView = vegernereView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Generate")) {
            vegernereView.createKey();
        } else if (src.equals("Encryption")) {
            vegernereView.createKey();
            vegernereView.encryption();
        } else if (src.equals("Decryption")) {
            vegernereView.createKey();
            vegernereView.decryption();
        }
    }

}
