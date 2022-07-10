package Service.DataBase;

import Model.User;

import javax.swing.*;

import static Service.ConfigurationStrings.dataSeparator;
import static Service.DataBase.DBGenericFunctions.*;

public class DBUserCRUD {

    public static void CreateUserTable(){
        CreateTable(DBQueries.UserTableQuery, "Users");
    }

    public static boolean AddUser(String username, String password){
        return AddInTable(DBQueries.UserInsertionQuery(username, password));
    }

    public static long GetUserId(String userName){
        String query = DBQueries.GetUserQuery(userName);
       return GetById(query);
    }

    public static User GetUserByName(String userName){
        String query = DBQueries.GetUserQuery(userName);
        String data = DBGenericFunctions.GetObject(query);
        if(data == null) return null;
        return StringDataToUser(data);
    }

    public static boolean EditUser(String userName, String newUserName, String newPassword){
        String query = DBQueries.EditUserQuery(userName, newUserName, newPassword);
        int rowsAffected = DBGenericFunctions.EditInTable(query);
        return DBRowsAffected(userName, rowsAffected);
    }

    public static boolean DeleteUser(String userName){
        String query = DBQueries.DeleteUserQuery(userName);
        int rowsAffected = DBGenericFunctions.DeleteInTable(query);
        return DBRowsAffected(userName, rowsAffected);
    }

    private static boolean DBRowsAffected(String userName, int rowsQuantity) {
        switch (rowsQuantity){
            case 0:
                JOptionPane.showMessageDialog(null, "The user " + userName + " was not found!", "User not found",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            case -1:
                return false;
            default:
                return true;
        }
    }

    private static User StringDataToUser(String data){
        String[] userData = data.split(dataSeparator);
        long id = Long.parseLong(userData[0]);
        String name = userData[1];
        String password = userData[2];
        return new User(id, name, password);
    }
}
