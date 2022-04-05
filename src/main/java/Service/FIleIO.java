package Service;

import java.io.*;

public class FIleIO {
    private static final String mainFolderPath = System.getProperty("user.home") +
            File.separator +
            "password_keeper" +
            File.separator;
    private static final String configDataPath = mainFolderPath + "Config.txt";

    public static void SaveFile(String data, String filePath, String fileName){
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

    public static void ReadFile(String fileName){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(mainFolderPath + fileName));
            String currentLine = reader.readLine();
            System.out.println("READ: " + currentLine);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Error reading the file");
        }
    }

    private static void CreateFolderIfNeeded(String folderName){
        File mainFolder = new File(folderName);
        if(!mainFolder.exists()){
            //TODO: Throws an custom exception
            mainFolder.mkdirs();
        }
    }

//    private static void CreateAppConfig(){
//        CreateFolderIfNeeded(mainFolderPath);
//        String data = "";
//        SaveFile(data, mainFolderPath, "config");
//        //File configFile = new File(configData);
//    }

}
