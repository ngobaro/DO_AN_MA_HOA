package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.PlainView;

import main.MainWindow;
import view.CeasarView;
import view.PlayFairView;

/**
 * MainWindowAction
 */
public class MainWindowAction implements ActionListener {
    private MainWindow mainWindow;
    private CeasarView ceasarView;
    private PlayFairView playFairView;

    public MainWindowAction(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

    }

    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if (button.equals("Ceasar")) {
            ceasarView = new CeasarView();
            mainWindow.show(ceasarView);
            System.out.println("doi panel cua Ceasar ");
        } else if (button.equals("Play Fair")) {
            playFairView = new PlayFairView();
            mainWindow.show(playFairView);
            System.out.println("doi panle cua play fair");
        } else if (button.equals("Substituton")) {
            System.out.print("bạn đã ấn click 3");
        } else if (button.equals("Transposition")) {
            System.out.print("bạn đã ấn click 4");
        } else if (button.equals("Vegernere")) {
            System.out.print("bạn đã ấn click 5");
        }
    }

}