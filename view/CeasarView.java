package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;

import controller.CeasarListener;
import model.CeasarModel;

/**
 * CeasarView
 */
public class CeasarView extends JPanel {
    // khai báo các thuộc tính
    private CeasarModel ceasarModel;

    private JTextArea jTextArea_plain;
    private JTextArea jTextArea_cipher;

    private JTextField jTextField_value;
    private JLabel jLabel_key;
    private JLabel jLabel_messenger;
    private JLabel jLabel_result;

    private JScrollPane jScrollPane_plain;
    private JScrollPane jScrollPane_cipher;
    private JPanel jPanel_key;
    private GridBagConstraints gbc;

    private JPanel jPanel_BackGround;
    private JPanel jPanel;
    private JPanel jPanel_messenger;
    private JPanel jPanel_result;
    private JPanel jPanel_Label_messenger;
    private JPanel jPanel_Label_result;
    private JPanel jPanel_Button;

    private JButton jButton_encryption;
    private JButton jButton_decryption;
    private JButton jButton_Up;
    private JButton jButton_Down;

    private ActionListener ac;
    private Font font;

    // khởi tạo panel CeasarView
    public CeasarView() {
        // tạo background
        BufferedImage backgroundImage;// backgroundImage để lưu lại hình ảnh
        try {
            backgroundImage = ImageIO.read(getClass().getResource("/view/a.jpg"));// đọc hình ảnh và tệp

        }
        // nếu đọc ảnh có lỗi thì ném ra IOException lúc này lỗi in ra và kết thúc
        // chương trình và return
        catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Tạo một JPanel để chứa ảnh background
        jPanel_BackGround = new JPanel() {
            @Override // ghi đè vẽ lại panel
            protected void paintComponent(Graphics g) { // vẽ lại dựa trên Graphics
                super.paintComponent(g);// đảm bảo rằng JPanel được vẽ đúng cách trước khi thêm nội dung tùy chỉnh
                Image scaledImage = backgroundImage.getScaledInstance(getWidth(),
                        getHeight(), Image.SCALE_SMOOTH);// làm cho phù hợp với kích thước hiện tại của panel
                g.drawImage(scaledImage, 0, 0, null); // bắt đầu vẽ ở vị trí (0;0)
            }
        };
        // khởi tạo ra các thuộc tính đã khai báo
        ceasarModel = new CeasarModel();
        ac = new CeasarListener(this);
        font = new Font("Arial", Font.BOLD, 15);

        jPanel = new JPanel(new GridLayout(1, 1, 15, 40));
        jPanel_messenger = new JPanel(new GridLayout(1, 1, 5, 40));
        jPanel_result = new JPanel(new GridLayout(1, 1, 5, 40));
        jPanel_Label_messenger = new JPanel();
        jPanel_Label_result = new JPanel();

        jPanel_BackGround.setLayout(new GridBagLayout());

        jTextField_value = new JTextField(ceasarModel.getKey() + "");
        jTextField_value.setHorizontalAlignment(JTextField.CENTER);

        jTextArea_plain = new JTextArea(7, 40);
        jTextArea_plain.setFont(font);
        jTextArea_cipher = new JTextArea(7, 40);
        jTextArea_cipher.setFont(font);

        jScrollPane_plain = new JScrollPane(jTextArea_plain);
        jScrollPane_cipher = new JScrollPane(jTextArea_cipher);
        jScrollPane_plain.setOpaque(false);
        jScrollPane_cipher.setOpaque(false);

        // thêm hành động lắng nghe cho nó
        jButton_encryption = new JButton("Encryption");
        jButton_encryption.addActionListener(ac);
        jButton_decryption = new JButton("Decryption");
        jButton_decryption.addActionListener(ac);
        jButton_Up = new JButton("+");
        jButton_Up.addActionListener(ac);
        jButton_Down = new JButton("-");
        jButton_Down.addActionListener(ac);
        // ---------------------------------------------------
        jLabel_messenger = new JLabel(" Message");
        jLabel_key = new JLabel("Key");
        jLabel_result = new JLabel(" Result");

        jPanel_Button = new JPanel(new GridLayout(1, 3, 10, 200));
        jPanel_key = new JPanel(new GridLayout(1, 3));
        // ----------------------------------------------------------------------------

        // gộp nút lên, xuống và jtextFied thành panel_key
        jPanel_key.add(jButton_Down);
        jPanel_key.add(jTextField_value);
        jPanel_key.add(jButton_Up);
        // gộp 2 button vào 1 panel
        jPanel_Button.add(jButton_encryption);
        jPanel_Button.add(jButton_decryption);
        // chỉnh kích cở cho nút
        font = new Font("Arial", Font.BOLD, 45);
        jPanel_Button.setFont(font);
        // tắt nền của panel
        jPanel_Button.setOpaque(false);

        // gộp chung jScrollPanel_plain lại vào 1 panel
        jPanel_messenger.add(jScrollPane_plain);
        jPanel_result.add(jScrollPane_cipher);
        // chinh lại font chữ
        font = new Font("Arial", Font.BOLD, 15);

        // gộp các chung các dong chữ và tắt nền panel chỉnh chữ
        jPanel_Label_messenger.add(jLabel_messenger);
        jPanel_Label_result.add(jLabel_result);
        jPanel_Label_messenger.setOpaque(false);
        jPanel_Label_result.setOpaque(false);
        jLabel_key.setFont(font);
        jLabel_messenger.setFont(font);
        jLabel_result.setFont(font);
        // -------------------------------------------------------

        // chỉnh tọa độ canh giữa và đều cho các panel cho GridBagConstraints
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 10, 0, 10);
        gbc.gridx = 0;
        gbc.gridy = 1;
        jPanel_BackGround.add(jPanel_messenger, gbc);

        gbc.insets = new Insets(0, 10, 0, 10);
        gbc.gridx = 0;
        gbc.gridy = 3;
        jPanel_BackGround.add(jPanel_result, gbc);
        gbc.insets = new Insets(50, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 4;
        jPanel_BackGround.add(jLabel_key, gbc);
        gbc.insets = new Insets(0, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 5;
        jPanel_BackGround.add(jPanel_key, gbc);
        gbc.insets = new Insets(25, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 6;
        jPanel_BackGround.add(jPanel_Button, gbc);

        gbc.insets = new Insets(5, 10, 0, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        jPanel_BackGround.add(jPanel_Label_messenger, gbc);

        gbc.insets = new Insets(5, 10, 0, 10);
        gbc.gridx = 0;
        gbc.gridy = 2;
        jPanel_BackGround.add(jPanel_Label_result, gbc);

        jPanel.setOpaque(false);// tắt nền của panel
        // --------------------------------------------------------------

        // setlayout chính cho panel Ceasarview và jPanel tổng(jPanel_BackGround)
        this.setLayout(new BorderLayout());
        this.add(jPanel_BackGround, BorderLayout.CENTER);
    }

    // hàm cập nhật key cho model

    public void encryption() {
        try {
            int value = Integer.parseInt(jTextField_value.getText());// lấy số trong jTextField_value vào value
            ceasarModel.setKey(value); // cập nhật lại key
            // lấy chữ trong jTextArea_plain vào PlainText của model
            this.ceasarModel.setPlainText(this.jTextArea_plain.getText());
            this.ceasarModel.encryption();// thuật toán mã hóa encryption trong model
            // lấy text CipherText hiển thị lên jTextArea_cipher
            this.jTextArea_cipher.setText(ceasarModel.getCipherText());
        } catch (Exception e) {
            // nếu gặp lỗi thì hiện thông báo lên
            JOptionPane.showMessageDialog(jPanel_BackGround, "vui lòng nhập key là số");
        }

    }

    public void decryption() {

        try {
            int value = Integer.parseInt(jTextField_value.getText());// lấy số trong jTextField_value vào value
            ceasarModel.setKey(value);// cập nhật lại key
            // lấy chữ trong jTextArea_plain vào PlainText của model
            this.ceasarModel.setPlainText(this.jTextArea_plain.getText());
            this.ceasarModel.decryption();// thuật toán giải mã encryption trong model
            // lấy text CipherText hiển thị lên jTextArea_cipher
            this.jTextArea_cipher.setText(ceasarModel.getCipherText());
        } catch (Exception e) {
            // nếu gặp lỗi thì hiện thông báo lên
            JOptionPane.showMessageDialog(this, "Vui lòng nhập key là số", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cong() {
        try {
            int value = Integer.parseInt(jTextField_value.getText());// lấy số trong jTextField_value vào value
            jTextField_value.setText(value + 1 + ""); // Tăng giá trị
            ceasarModel.setKey(value);// cập nhật lại key
        } catch (Exception e) {
            // nếu gặp lỗi thì hiện thông báo lên
            JOptionPane.showMessageDialog(this, "Vui lòng nhập key là số", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void tru() {
        try {
            int value = Integer.parseInt(jTextField_value.getText());// lấy số trong jTextField_value vào value
            jTextField_value.setText(value - 1 + ""); // Giảm giá trị
            ceasarModel.setKey(value);// cập nhật lại key
        } catch (Exception e) {
            // nếu gặp lỗi thì hiện thông báo lên
            JOptionPane.showMessageDialog(this, "Vui lòng nhập key là số", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}