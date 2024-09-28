package main;

import javax.swing.*;

import controller.MainWindowAction;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private static MainWindow mainWindow;
    private JToolBar jToolBar;
    private JButton jButton_Caesar;
    private JButton jButton_PlayFair;
    private JButton jButton_Substitution;
    private JButton jButton_Transposition;
    private JButton jButton_Vegernere;
    private MainWindowAction ac;

    private MainWindow() {
        setSize(800, 600);
        setLayout(null);
        setLocation(400, 140);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jToolBar = new JToolBar();
        jButton_Caesar = new JButton("Ceasar");
        jButton_PlayFair = new JButton("Play Fair");
        jButton_Substitution = new JButton("Substituton");
        jButton_Transposition = new JButton("Transposition");
        jButton_Vegernere = new JButton("Vegernere");

        ac = new MainWindowAction(this);

        jButton_Caesar.addActionListener(ac);
        jButton_PlayFair.addActionListener(ac);

        jToolBar.add(jButton_Caesar);
        jToolBar.add(jButton_PlayFair);
        jToolBar.add(jButton_Substitution);
        jToolBar.add(jButton_Transposition);
        jToolBar.add(jButton_Vegernere);
        this.setLayout(new BorderLayout());
        this.add(jToolBar, BorderLayout.NORTH);
    }

    public static MainWindow getInstance() {
        if (mainWindow == null) {
            mainWindow = new MainWindow();
        }
        return mainWindow;
    }

    public void show(JPanel panel) {
        // setContentPane(panel);
        this.add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

}
