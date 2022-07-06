package Service.DataBase;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBQueries {

    public static Connection connection;
    public static void CreateUserTable(){
        try {
            Statement statement = connection.createStatement();
            String createBettorTable = "CREATE TABLE IF NOT EXISTS users " +
                    "(id SERIAL PRIMARY KEY     NOT NULL," +
                    " user_name           varchar(60)    NOT NULL, " +
                    " password            varchar(60) NOT NULL) ";
            statement.executeUpdate(createBettorTable);
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The creation of users table got wrong!", "Create Users table on DB",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void CreatePasswordsTable(){
        try {
            Statement statement = connection.createStatement();
            String createBettorTable = "CREATE TABLE IF NOT EXISTS passwords " +
                    "(id SERIAL PRIMARY KEY     NOT NULL," +
                    " user_id           Numeric(5)    NOT NULL, " +
                    " local_password_is_from           varchar(60)    NOT NULL, " +
                    " password            varchar(60) NOT NULL) ";
            statement.executeUpdate(createBettorTable);
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The creation of passwords table got wrong!", "Create Passwords table on DB",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static boolean AddUser(String username, String password){
        try {
            Statement statement = connection.createStatement();
            String addToTable = new StringBuilder().
                    append("INSERT INTO users(user_name,password) ").
                    append("VALUES (").
                    append("'").
                    append(username).
                    append("'").
                    append(", ").
                    append("'").
                    append(password).
                    append("'").
                    append(");").toString();
            statement.executeUpdate(addToTable);
            statement.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The insertion of user" + username + " got wrong!", "Insert user on DB",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }

    public static long GetUserId(String username){
        try {
            Statement statement = connection.createStatement();
            String addToTable = new StringBuilder().
                    append("SELECT id, user_name ").
                    append("FROM users ").
                    append("WHERE ").
                    append("user_name = ").
                    append("'").
                    append(username).
                    append("'").
                    append(";").toString();
            ResultSet result = statement.executeQuery(addToTable);
            result.next();
            long id = result.getLong("id");
            statement.close();
            return id;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The insertion of user" + username + " got wrong!", "Insert user on DB",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return -1;
        }
    }

    public static boolean AddPassword(long userId, String localPasswordIsFrom, String password){
        try {
            Statement statement = connection.createStatement();
            String addToTable = new StringBuilder().
                    append("INSERT INTO passwords(user_id, local_password_is_from, password) ").
                    append("VALUES (").
                    append("'").
                    append(userId).
                    append("'").
                    append(", ").
                    append("'").
                    append(localPasswordIsFrom).
                    append("'").
                    append(", ").
                    append("'").
                    append(password).
                    append("'").
                    append(");").toString();
            statement.executeUpdate(addToTable);
            statement.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The insertion of password got wrong!", "Insert password on DB",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }

}
