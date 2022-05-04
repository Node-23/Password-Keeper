package Service;

import Model.Password;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class FIleIO {
    private static final String mainFolderPath = System.getProperty("user.home") +
            File.separator +
            "password_keeper" +
            File.separator;
    private static final String configData = "Config.txt";
    private static final String userPasswordsFileName = "data.txt";

    private static void SaveFile(String data, String filePath, String fileName){
        CreateFolderIfNeeded(filePath);
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(filePath + File.separator + fileName);
            byte[] strToBytes = data.getBytes();
            outputStream.write(strToBytes);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error writing the file");
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Unexpected error");
        }
    }

    private static String ReadFile(String fileName){
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            StringBuilder data = new StringBuilder();
            while (reader.hasNextLine()) {
                data.append(reader.nextLine()).append(ConfigurationStrings.itemsDataSeparator);
            }
            reader.close();
            return data.toString();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
            return null;
        }
    }

    private static void CreateFolderIfNeeded(String folderName){
        File folder = new File(folderName);
        if(!folder.exists()){
            if(!folder.mkdirs()){
                System.out.println("Error creating folder");
            }
        }
    }

    public static void CreateMainFolder(){
        File mainFolder = new File(mainFolderPath);
        if (mainFolder.exists()) return;
        if(!mainFolder.mkdirs()){
            System.out.println("Error creating main folder");
        }
    }

    public static void CreateAppConfig(){
        File configFile = new File(mainFolderPath + configData);
        if (configFile.exists()) return;
        String data = "";
        SaveFile(data, mainFolderPath, configData);
        //File configFile = new File(configData);
    }

    public static void AddUserDataInConfig(String username, String password){
        String data = ReadFile(mainFolderPath + configData);
        data += username + ConfigurationStrings.itemsSeparator + password;
        SaveFile(data, mainFolderPath, configData);
    }

    public static ArrayList<String> GetUsersData(){
        String[] data = Objects.requireNonNull(ReadFile(mainFolderPath + configData)).split(ConfigurationStrings.itemsDataSeparator);
        return new ArrayList<>(Arrays.asList(data));
    }

    public static void AddUserPassword(String username, Password pass){
        String userFolder = mainFolderPath + username;
        CreateFolderIfNeeded(userFolder);
        String data = ReadFile(userFolder + File.separator +"data.txt");
        if(data == null) {
            data = "";
        }
        data += pass.getFrom() + ConfigurationStrings.itemsSeparator + pass.getUsername() + ConfigurationStrings.itemsSeparator + pass.getPassword();
        SaveFile(data, userFolder, userPasswordsFileName);
    }

    public static void EditUserPassword(String username, String data){
        String userFolder = mainFolderPath + username;
        SaveFile(data, userFolder, userPasswordsFileName);
    }

    public static void RemoveUserPassword(String username, ArrayList<Password> userData){
        String userFolder = mainFolderPath + username;
        StringBuilder stringData = new StringBuilder();
        for (Password data: userData) {
            stringData.append(data.toString()).append(ConfigurationStrings.itemsDataSeparator);
        }
        SaveFile(stringData.toString(), userFolder, userPasswordsFileName);
    }

    public static ArrayList<Password> GetUserPasswords(String username){
        String stringFile = ReadFile(mainFolderPath + username + File.separator + userPasswordsFileName);
        if(stringFile == null) return null;

        String[] stringData = stringFile.split(ConfigurationStrings.itemsDataSeparator);
        ArrayList<Password> data = new ArrayList<>();
        Arrays.stream(stringData).forEach(sd -> {
            Password pass = new Password(sd.split(ConfigurationStrings.itemsSeparator)[0],
                    sd.split(ConfigurationStrings.itemsSeparator)[1],
                    sd.split(ConfigurationStrings.itemsSeparator)[2]);
            data.add(pass);
        });
        return data;
    }

}
