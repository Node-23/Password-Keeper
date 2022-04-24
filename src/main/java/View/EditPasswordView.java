package View;

import javax.swing.*;
import java.awt.*;

public class EditPasswordView extends JFrame {

    public static void ShowEditPasswordView() {
        EditPasswordView frame = new EditPasswordView();
        frame.setTitle("Edit Password");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel titleLabel = new JLabel("Edit Password");
        titleLabel.setForeground(Color.gray);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

        JLabel fromLabel = new JLabel("From");
        JLabel usernameLabel = new JLabel("Username");
        JLabel confirmPasswordLabel = new JLabel("Password");
        JTextField fromTextField = new JTextField();
        JTextField usernameTextfield = new JTextField();
        JPasswordField passwordTextField = new JPasswordField();
        JButton registerBt = new JButton("Edit");
        JButton cancelBt = new JButton("Cancel");

        titleLabel.setBounds(120, 30, 400, 30);
        fromLabel.setBounds(25, 70, 200, 30);
        usernameLabel.setBounds(25, 110, 200, 30);
        confirmPasswordLabel.setBounds(25, 150, 200, 30);

        fromTextField.setBounds(100, 70, 200, 30);
        usernameTextfield.setBounds(100, 110, 200, 30);
        passwordTextField.setBounds(100, 150, 200, 30);

        registerBt.setBounds(25, 200, 100, 30);
        cancelBt.setBounds(200, 200, 100, 30);

        registerBt.setBackground(Color.decode("#008000"));
        registerBt.setForeground(Color.WHITE);

        cancelBt.setBackground(Color.decode("#e61919"));
        cancelBt.setForeground(Color.white);

        cancelBt.addActionListener(v->{
            frame.setVisible(false);
            HomeView.ShowHomeView("test");
        });

        frame.add(titleLabel);
        frame.add(fromLabel);
        frame.add(fromTextField);
        frame.add(usernameLabel);
        frame.add(confirmPasswordLabel);
        frame.add(usernameTextfield);
        frame.add(passwordTextField);
        frame.add(registerBt);
        frame.add(cancelBt);

        frame.setSize(350, 300);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
