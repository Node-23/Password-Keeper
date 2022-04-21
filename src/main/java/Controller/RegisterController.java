package Controller;

import Model.User;
import Service.FIleIO;
import Service.Popups;

import javax.swing.*;

public class RegisterController {
    private static final String emptyFieldErrorMessage = "All fields must be filled";
    private static final String passwordNotMatchErrorMessage = "Passwords not match";
    private static final String successMessage = "User created";

        //TODO: Encrypt data with md5
        //TODO: Save file in the SO

    public static boolean RegisterUser(String name, String password, String confirmPassword){
        if(!ValidateUserData(name, password, confirmPassword)) return false;
        User user = new User(name, password);
        FIleIO.AddUserDataInConfig(user.getUsername(), user.getPassword());
        return true;
    }

    protected static boolean ValidateUserData(String name, String password, String confirmPassword){
        if(name.isBlank() || password.isEmpty() || confirmPassword.isEmpty()) {
            Popups.ShowPopup(emptyFieldErrorMessage, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!password.equals(confirmPassword)){
            Popups.ShowPopup(passwordNotMatchErrorMessage, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Popups.ShowPopup(successMessage, JOptionPane.PLAIN_MESSAGE);
        return true;
    }
}
