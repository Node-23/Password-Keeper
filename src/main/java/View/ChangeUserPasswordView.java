package View;

import javax.swing.*;
import java.awt.*;

public class ChangeUserPasswordView extends JFrame {

    public static void ShowChangeUserPasswordView() {
        ChangeUserPasswordView frame = new ChangeUserPasswordView();
        frame.setTitle("Change User Password");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel titleLabel = new JLabel("Change Password");
        titleLabel.setForeground(Color.gray);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

        JLabel passwordLabel = new JLabel("Password");
        JLabel confirmPasswordLabel = new JLabel("Confirm psw");
        JPasswordField passwordField = new JPasswordField();
        JPasswordField confirmPasswordField = new JPasswordField();
        JButton registerBt = new JButton("Change");
        JButton cancelBt = new JButton("Cancel");

        titleLabel.setBounds(100, 30, 400, 30);
        passwordLabel.setBounds(25, 70, 200, 30);
        confirmPasswordLabel.setBounds(25, 110, 200, 30);

        passwordField.setBounds(100, 70, 200, 30);
        confirmPasswordField.setBounds(100, 110, 200, 30);

        registerBt.setBounds(25, 160, 100, 30);
        cancelBt.setBounds(200, 160, 100, 30);

        registerBt.setBackground(Color.decode("#008000"));
        registerBt.setForeground(Color.WHITE);

        cancelBt.setBackground(Color.decode("#e61919"));
        cancelBt.setForeground(Color.white);

        cancelBt.addActionListener(v->{
            frame.dispose();
            HomeView.ShowHomeView("test");
        });

        frame.add(titleLabel);
        frame.add(passwordLabel);
        frame.add(confirmPasswordLabel);
        frame.add(passwordField);
        frame.add(confirmPasswordField);
        frame.add(registerBt);
        frame.add(cancelBt);

        frame.setSize(350, 250);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
