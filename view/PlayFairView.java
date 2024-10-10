
package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.PlayFairListener;
import model.PlayFairModel;

import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * PlayFairView
 */
public class PlayFairView extends JPanel {

    // khai báo các thuộc tính
    private Font font;
    private PlayFairModel playFairModel;
    private GridBagConstraints gbc;

    private JTextArea jTextArea_plain;
    private JTextArea jTextArea_cipher;

    private JLabel jLabel_plain;
    private JLabel jLabel_cipher;
    private JLabel jLabel_key;
    private JLabel jLabel_generate_key;

    private JPanel jPanel_BackGround;
    private JPanel jPanel_Text_plain;
    private JPanel jPanel_Text_cipher;
    private JPanel jPanel_jLabel_plain;
    private JPanel jPanel_jLabel_cipher;
    private JPanel jPanel_jLabel_key;
    private JPanel jPanel_jLabel_generate_key;

    private JPanel jPanel_left;
    private JPanel jPanel_right;
    private JPanel jPanel_above;
    private JPanel jPanel_below;
    private JPanel jPanel_all;

    private JScrollPane jScrollPane_plain;
    private JScrollPane jScrollPane_cipher;

    private JTextField key;
    private JTextField jTextField_alphabet;

    private JButton jButton_gennerate;
    private JButton jButton_encryption;
    private JButton jButton_decryption;

    private ActionListener ac;

    // -------------------------------------------

    // khởi tạo panel PlayFairView
    public PlayFairView() {
        // tạo background
        BufferedImage backgroundImage;// backgroundImage để lưu lại hình ảnh
        try {
            backgroundImage = ImageIO.read(getClass().getResource("/view/PlayFairBackground.jpg"));// đọc hình ảnh và tệp

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
        // khởi tạo các thuộc tính đã khai báo
        ac = new PlayFairListener(this);
        playFairModel = new PlayFairModel();
        font = new Font("Arial", Font.BOLD, 15);
        jPanel_BackGround.setLayout(new GridBagLayout());// setlayout cho jPanel_BackGround
        gbc = new GridBagConstraints();
        jLabel_plain = new JLabel("Message");
        jLabel_cipher = new JLabel("Result");
        jLabel_key = new JLabel("Key");
        jLabel_generate_key = new JLabel("Generate Key");

        jTextArea_plain = new JTextArea(7, 40);
        jTextArea_plain.setFont(font);// set cỡ chữ
        jTextArea_cipher = new JTextArea(7, 40);
        jTextArea_cipher.setFont(font);// set cỡ chữ

        font = new Font("Arial", Font.BOLD, 25);
        key = new JTextField(16);
        key.setFont(font);// set cỡ chữ
        jTextField_alphabet = new JTextField(16);
        jTextField_alphabet.setFont(font);// set cỡ chữ

        jScrollPane_plain = new JScrollPane(jTextArea_plain);
        jScrollPane_cipher = new JScrollPane(jTextArea_cipher);

        jPanel_Text_plain = new JPanel(new GridLayout(1, 1, 5, 40));
        jPanel_Text_cipher = new JPanel(new GridLayout(1, 1, 5, 40));
        jPanel_jLabel_plain = new JPanel();

        jPanel_jLabel_cipher = new JPanel();
        jPanel_left = new JPanel(new GridBagLayout());
        jPanel_right = new JPanel(new GridBagLayout());
        jPanel_above = new JPanel(new GridBagLayout());

        jPanel_Text_plain.add(jScrollPane_plain);
        jPanel_Text_cipher.add(jScrollPane_cipher);
        jPanel_jLabel_plain.add(jLabel_plain);
        jPanel_jLabel_cipher.add(jLabel_cipher);
        jPanel_jLabel_key = new JPanel();
        jPanel_jLabel_generate_key = new JPanel();
        jPanel_jLabel_key.add(jLabel_key);
        jPanel_jLabel_generate_key.add(jLabel_generate_key);
        jPanel_below = new JPanel(new GridBagLayout());
        jPanel_all = new JPanel(new GridBagLayout());
        // -----------------------------------------------------

        // tắt nền cho jpanel
        jPanel_jLabel_plain.setOpaque(false);
        jPanel_jLabel_cipher.setOpaque(false);
        jPanel_left.setOpaque(false);
        jPanel_right.setOpaque(false);
        jPanel_above.setOpaque(false);
        jPanel_left.setOpaque(false);
        jPanel_jLabel_key.setOpaque(false);
        jPanel_jLabel_generate_key.setOpaque(false);
        jPanel_below.setOpaque(false);
        jPanel_all.setOpaque(false);

        // thêm hành động cho các button
        jButton_gennerate = new JButton("Generate");
        jButton_gennerate.addActionListener(ac);
        jButton_encryption = new JButton("Encryption");
        jButton_encryption.addActionListener(ac);
        jButton_decryption = new JButton("Decryption");
        jButton_decryption.addActionListener(ac);

        // chỉnh tọa độ canh giữa và đều cho các panel cho GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 20, 0, 20);
        jPanel_below.add(jButton_encryption, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        jPanel_below.add(jButton_decryption, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        jPanel_left.add(jPanel_Text_plain, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        jPanel_left.add(jPanel_Text_cipher, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        jPanel_left.add(jPanel_jLabel_plain, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        jPanel_left.add(jPanel_jLabel_cipher, gbc);

        // ----------------------------------
        gbc.gridx = 0;
        gbc.gridy = 1;
        jPanel_right.add(key, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        jPanel_right.add(jTextField_alphabet, gbc);
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        jPanel_right.add(jButton_gennerate, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        jPanel_right.add(jPanel_jLabel_key, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        jPanel_right.add(jPanel_jLabel_generate_key, gbc);

        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        jPanel_above.add(jPanel_left, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        jPanel_above.add(jPanel_right, gbc);

        gbc.insets = new Insets(10, 10, 60, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        jPanel_all.add(jPanel_above, gbc);
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        jPanel_all.add(jPanel_below, gbc);
        jPanel_BackGround.add(jPanel_all);
        // --------------------------------------------------------------

        // setlayout chính cho panel Ceasarview và jPanel tổng(jPanel_BackGround)
        this.setLayout(new BorderLayout());
        this.add(jPanel_BackGround, BorderLayout.CENTER);
    }

    public void createKey() { // hàm tạo key
        if(playFairModel.check(this.key.getText())) {
            playFairModel.setKey(this.key.getText());
            this.jTextField_alphabet.setText(playFairModel.generateKeyFromKey());// hiển thị key lên view
        }else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập key là chuỗi kí tự !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public void decryption() { // hàm thực hiện mã hóa để hiện lên view
        if(playFairModel.check(this.jTextArea_plain.getText())) {
            playFairModel.setPlainText(this.jTextArea_plain.getText());// lấy chuỗi từ view truyền về model
            playFairModel.decryption();// gọi hàm từ model
            this.jTextArea_cipher.setText(playFairModel.getCipherText());// lấy chuỗi đã mã hóa bên model hiển thị lên view
            playFairModel.resetCipherText();// gọi hàm từ model
        }else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập message là chuỗi kí tự !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public void encryption() {// hàm thực hiện mã hóa để hiện lên view
        if(playFairModel.check(this.jTextArea_plain.getText())) {
        playFairModel.setPlainText(this.jTextArea_plain.getText());// lấy chuỗi từ view truyền về model
        playFairModel.encryption();// gọi hàm từ model
        this.jTextArea_cipher.setText(playFairModel.getCipherText());// lấy chuỗi đã mã hóa bên model hiển thị lên view
        playFairModel.resetCipherText();// gọi hàm từ model
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng nhập message là chuỗi kí tự !", "Error", JOptionPane.ERROR_MESSAGE);   
        }
    }

}