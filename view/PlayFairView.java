
package view;

import java.awt.*;
import javax.swing.*;
import main.MainWindow;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * PlayFairView
 */
public class PlayFairView extends JPanel {
    private Font font;
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

    public PlayFairView() {
        BufferedImage backgroundImage;
        try {
            backgroundImage = ImageIO.read(getClass().getResource("/view/a.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Tạo một JPanel để chứa ảnh background
        jPanel_BackGround = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image scaledImage = backgroundImage.getScaledInstance(getWidth(),
                        getHeight(), Image.SCALE_SMOOTH);
                g.drawImage(scaledImage, 0, 0, null);
            }
        };
        jPanel_BackGround.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        jLabel_plain = new JLabel("Message");
        jLabel_cipher = new JLabel("Result");
        jLabel_key = new JLabel("Key");
        jLabel_generate_key = new JLabel("Generate Key");

        jTextArea_plain = new JTextArea(7, 40);
        jTextArea_cipher = new JTextArea(7, 40);

        key = new JTextField(26);
        jTextField_alphabet = new JTextField(26);

        jScrollPane_plain = new JScrollPane(jTextArea_plain);
        jScrollPane_cipher = new JScrollPane(jTextArea_cipher);

        jPanel_Text_plain = new JPanel(new GridLayout(1, 1, 5, 40));
        jPanel_Text_cipher = new JPanel(new GridLayout(1, 1, 5, 40));
        jPanel_jLabel_plain = new JPanel();
        jPanel_jLabel_plain.setOpaque(false);
        jPanel_jLabel_cipher = new JPanel();
        jPanel_jLabel_cipher.setOpaque(false);
        jPanel_left = new JPanel(new GridBagLayout());
        jPanel_left.setOpaque(false);
        jPanel_right = new JPanel(new GridBagLayout());
        jPanel_right.setOpaque(false);
        jPanel_above = new JPanel(new GridBagLayout());
        jPanel_above.setOpaque(false);
        jPanel_left.setOpaque(false);
        jPanel_Text_plain.add(jScrollPane_plain);
        jPanel_Text_cipher.add(jScrollPane_cipher);
        jPanel_jLabel_plain.add(jLabel_plain);
        jPanel_jLabel_cipher.add(jLabel_cipher);
        jPanel_jLabel_key = new JPanel();
        jPanel_jLabel_key.setOpaque(false);
        jPanel_jLabel_generate_key = new JPanel();
        jPanel_jLabel_generate_key.setOpaque(false);
        jPanel_jLabel_key.add(jLabel_key);
        jPanel_jLabel_generate_key.add(jLabel_generate_key);
        jPanel_below = new JPanel(new GridBagLayout());
        jPanel_below.setOpaque(false);
        jPanel_all = new JPanel(new GridBagLayout());
        jPanel_all.setOpaque(false);

        jButton_gennerate = new JButton("Generate");
        jButton_encryption = new JButton("encryption");
        jButton_decryption = new JButton("decryption");

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

        // jPanel_BackGround.add(jPanel_left);

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

        // ------------------------------------------------
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

        this.setLayout(new BorderLayout());
        // this.add(MainWindow.jToolBar, BorderLayout.NORTH);
        this.add(jPanel_BackGround, BorderLayout.CENTER);
    }

}