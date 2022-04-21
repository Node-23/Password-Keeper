package Service;

import javax.swing.*;

public class Popups {

    public static void ShowPopup(String message, int messageType){
        //messageType = 0 -> Error message
        //messageType = 1 -> Plain message
        JOptionPane.showMessageDialog(
                null,
                message,
                "System Message",
                messageType
        );
    }
}
