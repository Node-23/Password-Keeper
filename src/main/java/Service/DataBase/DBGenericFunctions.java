package Service.DataBase;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import static Service.ConfigurationStrings.dataSeparator;

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

    protected static int EditInTable(String query){
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The Edition got wrong!", "Edit Object",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return -1;
        }
    }

    protected static int DeleteInTable(String query){
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The deletion got wrong!", "Delete Object",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return -1;
        }
    }

    public static String GetObject(String query){
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            StringBuilder sb = new StringBuilder();
            result.next();
            int columns = result.getMetaData().getColumnCount();
            for (int i = 0; i < columns; i++) {
                sb.append(result.getString(i + 1)).append(dataSeparator);
            }
            statement.close();
            return sb.toString();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The search got wrong!", "Get Object",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }

    public static long GetById(String query){
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            result.next();
            long id = result.getLong("id");
            statement.close();
            return id;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The search got wrong!", "Get Object ID",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return -1;
        }
    }
}
