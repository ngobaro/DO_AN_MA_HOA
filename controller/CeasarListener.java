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
        String src = e.getActionCommand();
        if (src.equals("+")) {
            int value = Integer.parseInt(ceasarView.getjTextField_value().getText());
            ceasarView.getjTextField_value().setText(value + 1 + ""); // Tăng giá trị
            ceasarView.setKey(value);
        } else if (src.equals("-")) {
            int value = Integer.parseInt(ceasarView.getjTextField_value().getText());
            ceasarView.getjTextField_value().setText(value - 1 + ""); // Giảm giá trị
            ceasarView.setKey(value);
        } else if (src.equals("Encryption")) {
            int value = Integer.parseInt(ceasarView.getjTextField_value().getText());
            ceasarView.setKey(value);
            ceasarView.encryption();
        } else if (src.equals("Decrytion")) {
            int value = Integer.parseInt(ceasarView.getjTextField_value().getText());
            ceasarView.setKey(value);
            ceasarView.decryption();
        }
    }

}
