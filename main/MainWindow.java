package main;

import javax.swing.*;
import controller.MainWindowAction;
import java.awt.*;

public class MainWindow extends JFrame {

    // Khai báo các thuộc tính private
    // mainWindow là Jframe như cái khung chứa các panel là cái view muốn jFrame
    // muốn show
    private static MainWindow mainWindow;

    // toolbar để có thể chuyển các panel công cụ muốn mã hóa

    private JToolBar jToolBar;

    // panel và các nút
    private JPanel jPanel;
    private JButton jButton_Caesar;
    private JButton jButton_PlayFair;
    private JButton jButton_Substitution;
    private JButton jButton_Transposition;
    private JButton jButton_Vegernere;

    // hành động để tương tác
    private MainWindowAction ac;

    private MainWindow() {
        // đặt tên cho tựa đề
        this.setTitle("Công cụ mã hóa HDB");
        // chỉnh kích thước
        this.setSize(1000, 700);
        // cho khung Jfram xuất hiện tại vị trí trên màn hình
        this.setLocation(300, 50);
        // tắt khung sẽ dừng chương trình
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // khởi tạo toolbar và các button
        jToolBar = new JToolBar();
        jButton_Caesar = new JButton("Ceasar");
        jButton_PlayFair = new JButton("Play Fair");
        jButton_Substitution = new JButton("Substituton");
        jButton_Transposition = new JButton("Transposition");
        jButton_Vegernere = new JButton("Vegernere");

        // khởi tạo jpanel
        jPanel = new JPanel();

        // khởi tạo hành động cho JFrame
        ac = new MainWindowAction(this);

        // gán hành động khi người dùng tương tác vào
        jButton_Caesar.addActionListener(ac);
        jButton_PlayFair.addActionListener(ac);
        jButton_Substitution.addActionListener(ac);
        jButton_Transposition.addActionListener(ac);
        jButton_Vegernere.addActionListener(ac);

        // chỉnh màu cho các nút ấn
        jButton_Caesar.setBackground(Color.lightGray);
        jButton_PlayFair.setBackground(Color.lightGray);
        jButton_Substitution.setBackground(Color.lightGray);
        jButton_Transposition.setBackground(Color.lightGray);
        jButton_Vegernere.setBackground(Color.lightGray);

        // thêm các button vào thanh công cụ
        jToolBar.add(jButton_Caesar);
        jToolBar.add(jButton_PlayFair);
        jToolBar.add(jButton_Substitution);
        jToolBar.add(jButton_Transposition);
        jToolBar.add(jButton_Vegernere);
        // chỉnh layout theo kiểu đông tây nam bắc chính giữa
        this.setLayout(new BorderLayout());
        // bỏ thanh cụ ở phía bắc
        this.add(jToolBar, BorderLayout.NORTH);
        // bỏ pảel
        this.add(jPanel, BorderLayout.CENTER);
    }

    // khởi tạo MainWindow nếu chưa tạo thì tạo mới và có rồi thì gán trả lại
    public static MainWindow getInstance() {
        if (mainWindow == null) {
            mainWindow = new MainWindow();
        }
        return mainWindow;
    }

    // gán vị trí cho toolbbar và xóa panelview đang có thay bằng panel mới muốn
    // show
    public void show(JPanel panel) {
        this.remove(jPanel);
        this.add(panel, BorderLayout.CENTER);
        this.jPanel = panel;
        setVisible(true);
    }

    // nút nào được nhấn thì set lại màu cho nút đó
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
