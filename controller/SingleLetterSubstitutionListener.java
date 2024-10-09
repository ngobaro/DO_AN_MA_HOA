package controller;

import java.awt.event.*;

import view.SingleLetterSubstitutionView;;

public class SingleLetterSubstitutionListener implements ActionListener {
    private SingleLetterSubstitutionView singleLetterSubstitutionView;

    public SingleLetterSubstitutionListener(SingleLetterSubstitutionView singleLetterSubstitutionView) {
        this.singleLetterSubstitutionView = singleLetterSubstitutionView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Random")) {
            singleLetterSubstitutionView.random();
        } else if (src.equals("Encryption")) {
            singleLetterSubstitutionView.encryption();
        } else if (src.equals("Decryption")) {
            singleLetterSubstitutionView.decryption();

        }
    }

}
