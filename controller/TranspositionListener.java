package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TranspositionView;

public class TranspositionListener implements ActionListener {
    private TranspositionView transpositionView;

    public TranspositionListener(TranspositionView transpositionView) {
        this.transpositionView = transpositionView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();// lấy chuỗi tên button
        if (src.equals("Encryption")) { // nếu là nút Decryption
            transpositionView.encryption();
        } else if (src.equals("Decryption")) {// nếu là nút Decryption
            transpositionView.decryption();
        }
    }

}
