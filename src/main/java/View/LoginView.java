package View;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame{

    public static void ShowLoginView() {
        LoginView frame = new LoginView();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setForeground(Color.gray);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

        JLabel usernameLabel = new JLabel("Username");
        JLabel passwordLabel = new JLabel("Password");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginBt = new JButton("Login");
        JButton registerBt = new JButton("Register");

        titleLabel.setBounds(120, 30, 400, 30);
        usernameLabel.setBounds(25, 70, 200, 30);
        passwordLabel.setBounds(25, 110, 200, 30);
        usernameField.setBounds(100, 70, 200, 30);
        passwordField.setBounds(100, 110, 200, 30);
        loginBt.setBounds(25, 160, 100, 30);
        registerBt.setBounds(200, 160, 100, 30);

        frame.add(titleLabel);
        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginBt);
        frame.add(registerBt);

        frame.setSize(350, 250);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
