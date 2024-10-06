package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.PlayFairView;

public class PlayFairListener implements ActionListener {
    private PlayFairView playFairView;

    public PlayFairListener(PlayFairView playFairView) {
        this.playFairView = playFairView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Generate")) {
            playFairView.createKey();
        } else if (src.equals("Encryption")) {
            playFairView.createKey();
            playFairView.encryption();
        } else if (src.equals("Decryption")) {
            playFairView.createKey();
            playFairView.decryption();
        }
    }

}
