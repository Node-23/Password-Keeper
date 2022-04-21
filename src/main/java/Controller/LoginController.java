package Controller;

import Model.User;
import Service.FIleIO;
import Service.Popups;

import javax.swing.*;
import java.util.ArrayList;

public class LoginController {
    private static final String loginErrorMessage = "Incorrect username or password";

    public static boolean ValidateLogin(User user){
        ArrayList<String> data = FIleIO.GetUsersData();
        boolean result = data.stream().anyMatch(d -> d.split("-")[0].equals(user.getUsername()) && d.split("-")[1].equals(user.getPassword()));
        if(!result) Popups.ShowPopup(loginErrorMessage, JOptionPane.ERROR_MESSAGE);
        return result;
    }
}
