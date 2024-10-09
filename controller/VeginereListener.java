package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.VeginereView;

public class VeginereListener implements ActionListener {
    private VeginereView veginereView;

    public VeginereListener(VeginereView veginereView) {
        this.veginereView = veginereView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Generate")) {
            veginereView.createKey();
        } else if (src.equals("Encryption")) {
            veginereView.createKey();
            veginereView.encryption();
        } else if (src.equals("Decryption")) {
            veginereView.createKey();
            veginereView.decryption();
        }
    }

}
