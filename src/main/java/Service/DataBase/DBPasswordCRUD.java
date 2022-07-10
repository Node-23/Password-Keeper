package Service.DataBase;

import static Service.DataBase.DBGenericFunctions.AddInTable;
import static Service.DataBase.DBGenericFunctions.CreateTable;

public class DBPasswordCRUD {
    public static void CreatePasswordsTable(){
        CreateTable(DBQueries.PasswordTableQuery, "Passwords");
    }

    public static boolean AddPassword(long userId, String localPasswordIsFrom, String password){
        return AddInTable(DBQueries.PasswordInsertionQuery(userId, localPasswordIsFrom, password));
    }
}
