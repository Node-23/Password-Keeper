import Service.DataBase.DataBaseConnection;
import Service.FIleIO;
import View.*;
import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        //Creates app main folder and creates config file in this folder
//        FIleIO.CreateMainFolder();
//        FIleIO.CreateAppConfig();
        Connection connection = DataBaseConnection.connect();
        LoginView.ShowLoginView();
    }
}
