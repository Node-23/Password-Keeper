import Service.DataBase.DBQueries;
import Service.DataBase.DataBaseConnection;
import Service.FIleIO;
import View.*;
import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        FIleIO.CreateMainFolder();
        FIleIO.CreateAppConfig();
        Connection connection = DataBaseConnection.connect();
        DBQueries.connection = connection;
        DBQueries.CreateUserTable();
        DBQueries.CreatePasswordsTable();
        LoginView.ShowLoginView();
    }
        //TODO: BUG: Container not storing DB data in volume
        //TODO: Remove file storage system
        //TODO: Add Password creation in DB
        //TODO: Implement delete and edit user in DB
        //TODO: Implement delete and edit password in DB
}
