package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainWindow;
import view.CeasarView;
import view.PlayFairView;
import view.SingleLetterSubstitutionView;
import view.TranspositionView;
import view.VeginereView;

/**
 * MainWindowAction
 * //
 */

public class MainWindowAction implements ActionListener {
    private MainWindow mainWindow;
    // khởi tạo các đối tượng view khi tương tác với button
    private CeasarView ceasarView;
    private PlayFairView playFairView;
    private SingleLetterSubstitutionView substitutionView;
    private TranspositionView transpositionView;
    private VeginereView vegernereView;

    // hàm khỏi tạo
    public MainWindowAction(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

    }

    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if (button.equals("Ceasar")) {
            // sử lí khi ấn nút Ceasar
            ceasarView = new CeasarView();
            mainWindow.show(ceasarView); // cửa sổ jframe chính sẽ đổi panel
            mainWindow.setjButton_Caesar();// đổi màu cho button đã chọn
        } else if (button.equals("Play Fair")) {
            // sử lí khi ấn nút play fair
            playFairView = new PlayFairView();
            mainWindow.show(playFairView);// cửa sổ jframe chính sẽ đổi panel
            mainWindow.setjButton_PlayFair();// đổi màu cho button đã chọn
        } else if (button.equals("SingleLetterSubstitution")) {
            // sử lí khi ấn nút Substituton
            substitutionView = new SingleLetterSubstitutionView();
            mainWindow.show(substitutionView);// cửa sổ jframe chính sẽ đổi panel
            mainWindow.setjButton_Substitution();// đổi màu cho button đã chọn
        } else if (button.equals("Transposition")) {
            // sử lí khi ấn nút Transposition
            transpositionView = new TranspositionView();
            mainWindow.show(transpositionView);
            mainWindow.setjButton_SingleLetterSubstitution();// cửa sổ jframe chính sẽ đổi panel
            mainWindow.setjButton_SingleLetterSubstitution();
            ;// đổi màu cho button đã chọn
        } else if (button.equals("Veginere")) {
            // sử lí khi ấn nút Vegernere
            vegernereView = new VeginereView();
            mainWindow.show(vegernereView);// cửa sổ jframe chính sẽ đổi panel
            mainWindow.setjButton_Vegernere();// đổi màu cho button đã chọn
        }
    }

}
