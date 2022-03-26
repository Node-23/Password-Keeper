package View;

import javax.swing.*;
import java.awt.*;

public class RegisterView {

    public static void ShowRegisterView() {
        LoginView frame = new LoginView();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel titleLabel = new JLabel("Register");
        titleLabel.setForeground(Color.gray);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

        JLabel usernameLabel = new JLabel("Username");
        JLabel passwordLabel = new JLabel("Password");
        JLabel confirmPasswordLabel = new JLabel("Confirm psw");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JPasswordField confirmPasswordField = new JPasswordField();
        JButton registerBt = new JButton("Register");
        JButton cancelBt = new JButton("Cancel");

        titleLabel.setBounds(130, 30, 400, 30);
        usernameLabel.setBounds(25, 70, 200, 30);
        passwordLabel.setBounds(25, 110, 200, 30);
        confirmPasswordLabel.setBounds(25, 150, 200, 30);

        usernameField.setBounds(100, 70, 200, 30);
        passwordField.setBounds(100, 110, 200, 30);
        confirmPasswordField.setBounds(100, 150, 200, 30);

        registerBt.setBounds(25, 200, 100, 30);
        cancelBt.setBounds(200, 200, 100, 30);

        registerBt.setBackground(Color.decode("#008000"));
        registerBt.setForeground(Color.WHITE);

        cancelBt.setBackground(Color.decode("#e61919"));
        cancelBt.setForeground(Color.white);

        cancelBt.addActionListener(v->{
            frame.setVisible(false);
            LoginView.ShowLoginView();
        });

        frame.add(titleLabel);
        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(confirmPasswordLabel);
        frame.add(passwordField);
        frame.add(confirmPasswordField);
        frame.add(registerBt);
        frame.add(cancelBt);

        frame.setSize(350, 300);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}