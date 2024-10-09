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
        if (src.equals("+")) { // nếu là nút cộng
            transpositionView.cong(); // thực hiện hành động cộng
        } else if (src.equals("-")) {// nếu là nút trừ
            transpositionView.tru();// thực hiện hành động trừ
        } else if (src.equals("Encryption")) {// nếu là nút Encryption
            transpositionView.encryption();// thực hiện hành động encryption
        } else if (src.equals("Decryption")) {// nếu là nút Encryption
            transpositionView.decryption();
        }
    }

}
