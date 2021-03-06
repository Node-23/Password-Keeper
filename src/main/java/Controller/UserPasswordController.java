package Controller;

import Model.Password;
import Service.FIleIO;
import Service.Messages;
import Service.Popups;

import javax.swing.*;
import java.util.ArrayList;

public class UserPasswordController {

    public static boolean AddUserData(String username, Password pass){
        if(PasswordAlreadyExists(username, pass)){
            Popups.ShowPopup(Messages.dataAlreadyExistsErrorMessage, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        //boolean result = DBQueries.AddPassword(userId, pass.getLocalPasswordIsFrom(), pass.getPassword());
        //if(result){
            FIleIO.AddUserPassword(username, pass);
            Popups.ShowPopup(Messages.passwordCreatedMessage, JOptionPane.PLAIN_MESSAGE);
            return true;
        //}
        //return false;
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
                pass.getLocalPasswordIsFrom().equalsIgnoreCase(password.getLocalPasswordIsFrom()) &&
                pass.getUsername().equals(password.getUsername()) &&
                pass.getPassword().equals(password.getPassword())
        );
    }
}
