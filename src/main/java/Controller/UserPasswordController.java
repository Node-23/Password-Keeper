package Controller;

import Model.Password;
import Service.FIleIO;
import Service.Messages;
import Service.Popups;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Locale;

public class UserPasswordController {

    public static boolean AddUserData(String username, Password pass){
        if(PasswordAlreadyExists(username, pass)){
            Popups.ShowPopup(Messages.dataAlreadyExistsErrorMessage, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        FIleIO.AddUserPassword(username, pass);
        Popups.ShowPopup(Messages.passwordCreatedMessage, JOptionPane.PLAIN_MESSAGE);
        return true;
    }

    public static boolean EditUserData(String username, Password pass, String data){
        if(PasswordAlreadyExists(username, pass)){
            Popups.ShowPopup(Messages.dataAlreadyExistsErrorMessage, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        FIleIO.EditUserPassword(username, data);
        Popups.ShowPopup(Messages.passwordEditedMessage, JOptionPane.PLAIN_MESSAGE);
        return true;
    }

    protected static boolean PasswordAlreadyExists(String username, Password password){
        ArrayList<Password> data = FIleIO.GetUserPasswords(username);
        if(data == null) return false;
        return data.stream().anyMatch(pass ->
                pass.getFrom().equalsIgnoreCase(password.getFrom()) &&
                pass.getUsername().equals(password.getUsername()) &&
                pass.getPassword().equals(password.getPassword())
        );
    }
}
