package Service;

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

    private static void SaveFile(String data, String filePath, String fileName){
        CreateFolderIfNeeded(filePath);
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(filePath + fileName);
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
                data.append(reader.nextLine()).append("\n");
            }
            reader.close();
            return data.toString();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
            e.printStackTrace();
        }
        return null;
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
        data += username + "-" + password;
        SaveFile(data, mainFolderPath, configData);
    }

    public static ArrayList<String> GetUsersData(){
        String[] data = Objects.requireNonNull(ReadFile(mainFolderPath + configData)).split("\n");
        return new ArrayList<>(Arrays.asList(data));
    }

}
