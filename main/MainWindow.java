package main;

import javax.swing.*;

import controller.MainWindowAction;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private static MainWindow mainWindow;
    public static JToolBar jToolBar;

    private JPanel jPanel;
    private JButton jButton_Caesar;
    private JButton jButton_PlayFair;
    private JButton jButton_Substitution;
    private JButton jButton_Transposition;
    private JButton jButton_Vegernere;

    private MainWindowAction ac;

    private MainWindow() {
        this.setTitle("Công cụ mã hóa HDB");
        setSize(1000, 700);
        setLayout(null);
        setLocation(300, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jToolBar = new JToolBar();
        jButton_Caesar = new JButton("Ceasar");
        jButton_PlayFair = new JButton("Play Fair");
        jButton_Substitution = new JButton("Substituton");
        jButton_Transposition = new JButton("Transposition");
        jButton_Vegernere = new JButton("Vegernere");

        jPanel = new JPanel();

        ac = new MainWindowAction(this);

        jButton_Caesar.addActionListener(ac);
        jButton_PlayFair.addActionListener(ac);
        jButton_Substitution.addActionListener(ac);
        jButton_Transposition.addActionListener(ac);
        jButton_Vegernere.addActionListener(ac);

        jButton_Caesar.setBackground(Color.lightGray);
        jButton_PlayFair.setBackground(Color.lightGray);
        jButton_Substitution.setBackground(Color.lightGray);
        jButton_Transposition.setBackground(Color.lightGray);
        jButton_Vegernere.setBackground(Color.lightGray);

        jToolBar.add(jButton_Caesar);
        jToolBar.add(jButton_PlayFair);
        jToolBar.add(jButton_Substitution);
        jToolBar.add(jButton_Transposition);
        jToolBar.add(jButton_Vegernere);
        this.setLayout(new BorderLayout());
        this.add(jToolBar, BorderLayout.NORTH);
        this.add(jPanel, BorderLayout.CENTER);
    }

    public static MainWindow getInstance() {
        if (mainWindow == null) {
            mainWindow = new MainWindow();
        }
        return mainWindow;
    }

    public void show(JPanel panel) {
        // setContentPane(panel);
        this.remove(jPanel);
        this.add(panel, BorderLayout.CENTER);
        this.jPanel = panel;
        setVisible(true);
    }

    public void setjButton_Caesar() {

        jButton_Caesar.setBackground(Color.GREEN);
        jButton_PlayFair.setBackground(Color.lightGray);
        jButton_Substitution.setBackground(Color.lightGray);
        jButton_Transposition.setBackground(Color.lightGray);
        jButton_Vegernere.setBackground(Color.lightGray);
    }

    public void setjButton_PlayFair() {
        jButton_Caesar.setBackground(Color.lightGray);
        jButton_PlayFair.setBackground(Color.GREEN);
        jButton_Substitution.setBackground(Color.lightGray);
        jButton_Transposition.setBackground(Color.lightGray);
        jButton_Vegernere.setBackground(Color.lightGray);
    }

    public void setjButton_Substitution() {
        jButton_Caesar.setBackground(Color.lightGray);
        jButton_PlayFair.setBackground(Color.lightGray);
        jButton_Substitution.setBackground(Color.GREEN);
        jButton_Transposition.setBackground(Color.lightGray);
        jButton_Vegernere.setBackground(Color.lightGray);
    }

    public void setjButton_Transposition() {
        jButton_Caesar.setBackground(Color.lightGray);
        jButton_PlayFair.setBackground(Color.lightGray);
        jButton_Substitution.setBackground(Color.lightGray);
        jButton_Transposition.setBackground(Color.GREEN);
        jButton_Vegernere.setBackground(Color.lightGray);
    }

    public void setjButton_Vegernere() {
        jButton_Caesar.setBackground(Color.lightGray);
        jButton_PlayFair.setBackground(Color.lightGray);
        jButton_Substitution.setBackground(Color.lightGray);
        jButton_Transposition.setBackground(Color.lightGray);
        jButton_Vegernere.setBackground(Color.GREEN);
    }

}
