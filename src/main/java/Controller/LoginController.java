package Controller;

import Model.User;
import Service.FIleIO;
import java.util.ArrayList;

public class LoginController {

    public static boolean ValidateLogin(User user){
        ArrayList<String> data = FIleIO.GetUsersData();
        return data.stream().anyMatch(d -> d.split("-")[0].equals(user.getUsername()) && d.split("-")[1].equals(user.getPassword()));
    }
}
