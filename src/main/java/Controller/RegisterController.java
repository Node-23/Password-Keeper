package Controller;

import Model.User;
import Service.FIleIO;
import Service.Messages;
import Service.Popups;

import javax.swing.*;
import java.util.ArrayList;

public class RegisterController {
    private static final int minimumFieldLength = 6;
    public static boolean RegisterUser(String userName, String password, String confirmPassword){
        String validateMessage = ValidUser(userName, password, confirmPassword);
        if(!validateMessage.equals(Messages.loginSuccessMessage)){
            Popups.ShowPopup(validateMessage, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        User user = new User(userName, password);
        FIleIO.AddUserDataInConfig(user.getUsername(), user.getPassword());
        Popups.ShowPopup(validateMessage, JOptionPane.PLAIN_MESSAGE);
        return true;
    }

    protected static String ValidUser(String userName, String password, String confirmPassword){
        if(userName.length() < minimumFieldLength || password.length() < minimumFieldLength || confirmPassword.length() < minimumFieldLength){
            return Messages.fieldLengthErrorMessage;
        }
        if(!password.equals(confirmPassword)){
            return Messages.passwordNotMatchErrorMessage;
        }
        if(UserAlreadyExists(userName)){
            return Messages.usernameAlreadyExistsErrorMessage;
        }
        return Messages.loginSuccessMessage;
    }

    private static boolean UserAlreadyExists(String userName){
        ArrayList<String> data = FIleIO.GetUsersData();
        return data.stream().anyMatch(d -> d.split("-")[0].equals(userName));
    }
}
