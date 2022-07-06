package Service.DataBase;

import static Service.DataBase.DBGenericFunctions.AddInTable;
import static Service.DataBase.DBGenericFunctions.CreateTable;

public class DBCRUD {
    public static void CreateUserTable(){
        CreateTable(DBQueries.UserTableQuery, "Users");
    }

    public static void CreatePasswordsTable(){
        CreateTable(DBQueries.PasswordTableQuery, "Passwords");
    }

    public static boolean AddUser(String username, String password){
        return AddInTable(DBQueries.UserInsertionQuery(username, password));
    }

    public static boolean AddPassword(long userId, String localPasswordIsFrom, String password){
        return AddInTable(DBQueries.PasswordInsertionQuery(userId, localPasswordIsFrom, password));
    }
}
