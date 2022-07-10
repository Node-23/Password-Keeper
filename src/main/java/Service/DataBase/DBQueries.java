package Service.DataBase;

public class DBQueries {
    protected static final String UserTableQuery = "CREATE TABLE IF NOT EXISTS users " +
            "(id SERIAL PRIMARY KEY     NOT NULL," +
            " user_name           varchar(60)    NOT NULL, " +
            " password            varchar(60) NOT NULL) ";

    protected static final String PasswordTableQuery = "CREATE TABLE IF NOT EXISTS passwords " +
            "(id SERIAL PRIMARY KEY     NOT NULL," +
            " user_id           Numeric(5)    NOT NULL, " +
            " local_password_is_from           varchar(60)    NOT NULL, " +
            " password            varchar(60) NOT NULL) ";

    protected static String GetUserQuery(String userName){
        return "SELECT * FROM users WHERE user_name = " + "'" + userName + "'" + ";";
    }

    protected static String DeleteUserQuery(String userName){
        return "DELETE FROM users WHERE user_name = " + "'" + userName + "'" + ";";
    }

    protected static String EditUserQuery(String userName, String newUserName, String newPassword){
        return "UPDATE users " +
        "SET user_name = " + "'" + newUserName + "', " +
        "password = '" + newPassword + "' " +
        "WHERE user_name = " + "'" + userName + "'" + ";";
    }


    protected static String UserInsertionQuery(String username, String password){
        return "INSERT INTO users(user_name,password) VALUES ('" + username + "', " + "'" + password + "');";
    }

    protected static String PasswordInsertionQuery(long userId, String localPasswordIsFrom, String password){
        return "INSERT INTO passwords(user_id, local_password_is_from, password) " + "VALUES (" + "'" + userId + "'" + ", " + "'" + localPasswordIsFrom + "'" + ", " + "'" + password + "'" + ");";
    }
}
