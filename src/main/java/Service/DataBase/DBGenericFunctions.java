package Service.DataBase;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBGenericFunctions {
    public static Connection connection;

    protected static void CreateTable(String query, String tableName){
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The creation of" + tableName + "table got wrong!", "Create" + tableName + "table on DB",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    protected static boolean AddInTable(String query){
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Insertion got wrong!", "Insertion on DB",
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
}
