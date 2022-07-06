import Service.DataBase.DBCRUD;
import Service.DataBase.DBGenericFunctions;
import Service.DataBase.DataBaseConnection;
import Service.FIleIO;
import View.*;

public class App {
    public static void main(String[] args) {
        FIleIO.CreateMainFolder();
        FIleIO.CreateAppConfig();
        DBGenericFunctions.connection = DataBaseConnection.connect();
        DBCRUD.CreateUserTable();
        DBCRUD.CreatePasswordsTable();
        LoginView.ShowLoginView();
    }
        //TODO: Create userDB tests
        //TODO: BUG: Container not storing DB data in volume
        //TODO: Remove file storage system
        //TODO: Add Password creation in DB
        //TODO: Implement delete and edit user in DB
        //TODO: Implement delete and edit password in DB
}
