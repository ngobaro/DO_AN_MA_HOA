package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainWindow;
import view.CeasarView;
import view.PlayFairView;
import view.SubstitutionView;
import view.TranspositionView;

/**
 * MainWindowAction
 * //
 */

public class MainWindowAction implements ActionListener {
    private MainWindow mainWindow;
    private CeasarView ceasarView;
    private PlayFairView playFairView;
    private SubstitutionView substitutionView;
    private TranspositionView transpositionView;

    public MainWindowAction(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

    }

    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if (button.equals("Ceasar")) {
            ceasarView = new CeasarView();
            mainWindow.show(ceasarView);
            mainWindow.setjButton_Caesar();
            System.out.println("doi panel cua Ceasar ");
        } else if (button.equals("Play Fair")) {
            playFairView = new PlayFairView();
            mainWindow.show(playFairView);
            mainWindow.setjButton_PlayFair();
            System.out.println("doi panle cua play fair");
        } else if (button.equals("Substituton")) {
            substitutionView = new SubstitutionView();
            mainWindow.show(substitutionView);
            mainWindow.setjButton_Substitution();
            System.out.println("doi panel cua Substituton");
            mainWindow.setjButton_Substitution();
        } else if (button.equals("Transposition")) {
            transpositionView = new TranspositionView();
            mainWindow.show(transpositionView);
            mainWindow.setjButton_Transposition();
            System.out.println("doi panel cua Transposition");
            mainWindow.setjButton_Transposition();
        } else if (button.equals("Vegernere")) {
            System.out.println("doi panel cua Vegernere");
            mainWindow.setjButton_Vegernere();
        }
    }

}
