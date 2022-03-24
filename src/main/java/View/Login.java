package View;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{

    static JLabel titleLabel;
    static JLabel usernameLabel;
    static JLabel passwordLabel;
    static JTextField usernameField;
    static JPasswordField passwordField;
    static JButton loginBt;
    static JButton registerBt;

    public static void LoginView() {
        Login frame = new Login();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        titleLabel = new JLabel("Login Form");
        titleLabel.setForeground(Color.gray);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginBt = new JButton("Login");
        registerBt = new JButton("Register");

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
