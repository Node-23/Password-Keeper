package View;

import Controller.UserPasswordController;
import Model.Password;
import Service.ConfigurationStrings;
import Service.Messages;
import Service.Popups;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserCreateOrEditPasswordView extends JFrame {
    private static JTextField fromTextField;
    private static JTextField usernameTextField;
    private static JPasswordField passwordTextField;
    private static JButton registerBt;
    private static UserCreateOrEditPasswordView frame;

    private static void ShowCreatePasswordView(String username) {
        frame = new UserCreateOrEditPasswordView();
        frame.setTitle("Create Password");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        JLabel titleLabel = new JLabel("Add Password");
        titleLabel.setForeground(Color.gray);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

        JLabel fromLabel = new JLabel("From");
        JLabel usernameLabel = new JLabel("Username");
        JLabel confirmPasswordLabel = new JLabel("Password");
        fromTextField = new JTextField();
        usernameTextField = new JTextField();
        passwordTextField = new JPasswordField();
        registerBt = new JButton("Add");
        JButton cancelBt = new JButton("Cancel");

        titleLabel.setBounds(120, 30, 400, 30);
        fromLabel.setBounds(25, 70, 200, 30);
        usernameLabel.setBounds(25, 110, 200, 30);
        confirmPasswordLabel.setBounds(25, 150, 200, 30);

        fromTextField.setBounds(100, 70, 200, 30);
        usernameTextField.setBounds(100, 110, 200, 30);
        passwordTextField.setBounds(100, 150, 200, 30);

        registerBt.setBounds(25, 200, 100, 30);
        cancelBt.setBounds(200, 200, 100, 30);

        registerBt.setBackground(Color.decode(ConfigurationStrings.registerButtonColor));
        registerBt.setForeground(Color.WHITE);

        cancelBt.setBackground(Color.decode(ConfigurationStrings.cancelButtonColor));
        cancelBt.setForeground(Color.white);

            registerBt.addActionListener(v -> {
                if(ValidateInputs(fromTextField.getText(), usernameTextField.getText(), String.valueOf(passwordTextField.getPassword()))){
                    return;
                }
                Password password = new Password(fromTextField.getText(), usernameTextField.getText(), String.valueOf(passwordTextField.getPassword()));
                if(UserPasswordController.AddUserData(username, password)){
                    frame.dispose();
                    HomeView.ResetFrame(username);
                }
        });

        cancelBt.addActionListener(v->{
            frame.dispose();
            HomeView.ResetFrame(username);
        });

        frame.add(titleLabel);
        frame.add(fromLabel);
        frame.add(fromTextField);
        frame.add(usernameLabel);
        frame.add(confirmPasswordLabel);
        frame.add(usernameTextField);
        frame.add(passwordTextField);
        frame.add(registerBt);
        frame.add(cancelBt);

        frame.setSize(350, 300);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void CreatePassword(String username){
        ShowCreatePasswordView(username);
    }

    public static void EditPassword(String username, ArrayList<Password> userData, Password password){
        ShowCreatePasswordView(username);
        fromTextField.setText(password.getLocalPasswordIsFrom());
        fromTextField.setEnabled(false);
        usernameTextField.setText(password.getUsername());
        passwordTextField.setText(password.getPassword());

        registerBt.setBackground(Color.decode("#f4c430"));
        registerBt.setText("Edit");
        for( ActionListener actionListener : registerBt.getActionListeners() ) {
            registerBt.removeActionListener(actionListener);
        }

        registerBt.addActionListener(v -> {
            if(ValidateInputs(fromTextField.getText(), usernameTextField.getText(), String.valueOf(passwordTextField.getPassword()))){
                return;
            }

            for (Password data: userData) {
                if(data.equals(password)){
                    data.setUsername(usernameTextField.getText());
                    data.setPassword(String.valueOf(passwordTextField.getPassword()));
                    if(UserPasswordController.EditUserData(username, data, UserDataToString(userData))){
                        frame.dispose();
                        HomeView.ResetFrame(username);
                    }
                }
            }
        });
    }

    private static boolean ValidateInputs(String from, String username, String password){
        if(from.isBlank() || username.isBlank() || password.isBlank()){
            Popups.ShowPopup(Messages.EmptyFieldErrorMessage, JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if(from.contains(" ") || username.contains(" ")|| password.contains(" ")){
            Popups.ShowPopup(Messages.UsernameOrPasswordSpaceCharacterErrorMessage, JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    private static String UserDataToString(ArrayList<Password> userData){
        StringBuilder userDataString = new StringBuilder();
        for (Password data: userData) {
            userDataString.append(data.toString()).append(ConfigurationStrings.itemsDataSeparator);
        }
        return userDataString.toString();
    }

}
