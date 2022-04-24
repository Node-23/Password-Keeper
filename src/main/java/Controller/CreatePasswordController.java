package Controller;

import Model.Password;
import Service.FIleIO;
import Service.Messages;
import Service.Popups;

import javax.swing.*;
import java.util.ArrayList;

public class CreatePasswordController {

    public static boolean AddUserData(String username, Password pass){
        if(PasswordAlreadyExists(username, pass)){
            Popups.ShowPopup(Messages.dataAlreadyExistsErrorMessage, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        FIleIO.AddUserPassword(username, pass);
        Popups.ShowPopup(Messages.passwordSuccessMessage, JOptionPane.PLAIN_MESSAGE);
        return true;
    }

    protected static boolean PasswordAlreadyExists(String username, Password password){
        ArrayList<Password> data = FIleIO.GetUserPasswords(username);
        if(data == null) return false;

        return data.stream().anyMatch(pass ->
                pass.getFrom().equals(password.getFrom()) &&
                pass.getUsername().equals(password.getUsername()) &&
                pass.getPassword().equals(password.getPassword())
        );
    }
}
