package Controller;

import Model.User;
import Service.FIleIO;

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
        FIleIO.addUserDataInConfig(user.getUsername(), user.getPassword());
        return true;
    }

    protected static boolean ValidateUserData(String name, String password, String confirmPassword){
        if(name.isBlank() || password.isEmpty() || confirmPassword.isEmpty()) {
            RegisterMessage(emptyFieldErrorMessage, 0);
            return false;
        }
        if(!password.equals(confirmPassword)){
            RegisterMessage(passwordNotMatchErrorMessage, 0);
            return false;
        }
        RegisterMessage(successMessage, 1);
        return true;
    }
    private static void RegisterMessage(String message, int messageType){
        //messageType = 0 -> Error message
        //messageType = 1 -> Plain message
        JOptionPane.showMessageDialog(
                null,
                message,
                "Validation error",
                messageType
        );
    }
}
