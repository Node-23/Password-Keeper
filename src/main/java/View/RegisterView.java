package View;

import Controller.RegisterController;
import Service.ConfigurationStrings;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class RegisterView extends JFrame{

    public static void ShowRegisterView() {
        RegisterView frame = new RegisterView();
        frame.setTitle("Register User");
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

        registerBt.setBackground(Color.decode(ConfigurationStrings.registerButtonColor));
        registerBt.setForeground(Color.WHITE);

        cancelBt.setBackground(Color.decode(ConfigurationStrings.cancelButtonColor));
        cancelBt.setForeground(Color.white);

        registerBt.addActionListener(v->{
            boolean success = RegisterController.RegisterUser(
                    usernameField.getText().trim(),
                    String.valueOf(passwordField.getPassword()),
                    String.valueOf(confirmPasswordField.getPassword())
            );
            if(success){
                usernameField.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
            }
        });

        cancelBt.addActionListener(v->{
            frame.dispose();
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
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
