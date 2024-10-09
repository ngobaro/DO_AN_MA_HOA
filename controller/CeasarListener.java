package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CeasarView;

public class CeasarListener implements ActionListener {
    private CeasarView ceasarView;

    public CeasarListener(CeasarView ceasarView) {
        this.ceasarView = ceasarView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();// lấy chuỗi tên button
        if (src.equals("+")) { // nếu là nút cộng
            ceasarView.cong(); // thực hiện hành động cộng
        } else if (src.equals("-")) {// nếu là nút trừ
            ceasarView.tru();// thực hiện hành động trừ
        } else if (src.equals("Encryption")) {// nếu là nút Encryption
            ceasarView.encryption();// thực hiện hành động encryption
        } else if (src.equals("Decryption")) {// nếu là nút Encryption
            ceasarView.decryption();
        }
    }

}
