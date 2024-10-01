package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;

import controller.CeasarListener;
import controller.CeasarListener;
import main.MainWindow;
import model.CeasarModel;

/**
 * CeasarView
 */
public class CeasarView extends JPanel {
    private CeasarModel ceasarModel;

    private JTextArea jTextArea_plain;
    private JTextArea jTextArea_cipher;

    private JTextField jTextField_value;
    private JLabel jLabel_key;

    private JScrollPane jScrollPane_plain;
    private JScrollPane jScrollPane_cipher;
    private JPanel jPanel_key;
    private GridBagConstraints gbc;

    private JPanel jPanel_BackGround;
    private JPanel jPanel;

    JPanel jPanel_Button;

    private JButton jButton_1;
    private JButton jButton_2;
    private JButton jButton_Up;
    private JButton jButton_Down;

    private ActionListener ac;

    // private
    private Font font;

    public CeasarView() {
        BufferedImage backgroundImage;
        try {
            backgroundImage = ImageIO.read(getClass().getResource("/view/images.jpg"));
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

        ceasarModel = new CeasarModel();
        ac = new CeasarListener(this);
        font = new Font("Arial", Font.BOLD, 15);

        jTextField_value = new JTextField(ceasarModel.getKey() + "");
        jTextField_value.setHorizontalAlignment(JTextField.CENTER);

        jTextArea_plain = new JTextArea(7, 50);
        jTextArea_plain.setFont(font);
        jTextArea_cipher = new JTextArea(7, 50);
        jTextArea_cipher.setFont(font);

        jScrollPane_plain = new JScrollPane(jTextArea_plain);
        jScrollPane_cipher = new JScrollPane(jTextArea_cipher);
        jScrollPane_plain.setOpaque(false);
        jScrollPane_cipher.setOpaque(false);

        jButton_1 = new JButton("Encryption");
        jButton_1.addActionListener(ac);
        jButton_2 = new JButton("Decrytion");
        jButton_2.addActionListener(ac);
        jButton_Up = new JButton("+");
        jButton_Up.addActionListener(ac);
        jButton_Down = new JButton("-");
        jButton_Down.addActionListener(ac);

        jPanel_Button = new JPanel(new GridLayout(1, 3, 10, 200));
        jPanel_key = new JPanel(new GridLayout(1, 3));

        jPanel_key.add(jButton_Down);
        jPanel_key.add(jTextField_value);
        jPanel_key.add(jButton_Up);

        jPanel_Button.add(jButton_1);
        jPanel_Button.add(jButton_2);
        font = new Font("Arial", Font.BOLD, 45);
        jPanel_Button.setFont(font);

        jPanel_Button.setOpaque(false);

        jPanel = new JPanel(new GridLayout(2, 1, 15, 40));
        jPanel_BackGround.setLayout(new GridBagLayout());

        jPanel.add(jScrollPane_plain);
        jPanel.add(jScrollPane_cipher);

        jLabel_key = new JLabel("Key");

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 0, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        jPanel_BackGround.add(jPanel, gbc);
        gbc.insets = new Insets(0, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 2;
        jPanel_BackGround.add(jPanel_key, gbc);
        gbc.insets = new Insets(25, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 3;
        jPanel_BackGround.add(jPanel_Button, gbc);
        gbc.insets = new Insets(50, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 1;
        jPanel_BackGround.add(jLabel_key, gbc);

        jPanel.setOpaque(false);

        this.setLayout(new BorderLayout());
        this.add(MainWindow.jToolBar, BorderLayout.NORTH);
        this.add(jPanel_BackGround, BorderLayout.CENTER);
    }

    public void setKey(int key) {
        ceasarModel.setKey(key);
    }

    public JTextField getjTextField_value() {
        return jTextField_value;
    }

    public void setjTextField_value(JTextField jTextField_value) {
        this.jTextField_value = jTextField_value;
    }

}