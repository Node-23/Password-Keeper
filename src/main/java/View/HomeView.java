package View;

import Model.Password;
import Service.ConfigurationStrings;
import Service.FIleIO;
import Service.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;

public class HomeView extends JFrame{

    private static final int fromXPosition = 10;
    private static final int usernameXPosition = 120;
    private static final int passwordXPosition = 365;
    private static final int columnsLabelTextSize = 15;
    private static final int passwordDataAdjustYPosition = 40;
    private static int passwordDataYPosition;
    private static ArrayList<Password> userData;
    private static HomeView frame;

    public static void ShowHomeView(String username) {
        passwordDataYPosition = 90;
        frame = new HomeView();
        frame.setTitle("Home");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Title label
        JLabel titleLabel = new JLabel("- PASSWORDS LIST -");
        titleLabel.setForeground(Color.gray);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

        //Columns label
        JLabel fromLabel = new JLabel("FROM");
        fromLabel.setFont(new Font(Font.DIALOG, Font.BOLD, columnsLabelTextSize));
        JLabel usernameLabel = new JLabel("USERNAME");
        usernameLabel.setFont(new Font(Font.DIALOG, Font.BOLD, columnsLabelTextSize));
        JLabel passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setFont(new Font(Font.DIALOG, Font.BOLD, columnsLabelTextSize));

        //MenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu userMenu = new JMenu("USER");
        JMenuItem helpMenu = new JMenu("HELP");
        menuBar.add(userMenu);
        menuBar.add(helpMenu);
        JMenuItem addPassword = new JMenuItem("Add password");
        JMenuItem changePassword = new JMenuItem("Change user password");
        JMenuItem logout = new JMenuItem("Logout");
        userMenu.add(addPassword);
        userMenu.add(changePassword);
        userMenu.add(logout);

        //Set objects coordinates
        titleLabel.setBounds(210, 15, 400, 30);
        fromLabel.setBounds(fromXPosition, 55, 200, 30);
        usernameLabel.setBounds(usernameXPosition, 55, 200, 30);
        passwordLabel.setBounds(passwordXPosition, 55, 200, 30);

        //Set Listeners
        logout.addActionListener(v -> {frame.dispose(); LoginView.ShowLoginView();});
        addPassword.addActionListener(v -> {frame.setEnabled(false); UserCreateOrEditPasswordView.CreatePassword(username);});

        frame.setJMenuBar(menuBar);
        frame.add(titleLabel);
        frame.add(fromLabel);
        frame.add(usernameLabel);
        frame.add(passwordLabel);

        GetAllUserPasswords(username, frame);

        frame.setSize(650, 600);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void setEachPasswordItems(HomeView frame, String userName, Password pass){
        //HERE WE WILL RECEIVE A PASSWORD OBJECT AND SET IT ON THE FRAME
        JLabel fromListLabel = new JLabel(pass.getLocalPasswordIsFrom());
        JLabel usernameListLabel = new JLabel(pass.getUsername());
        JLabel passwordListLabel = new JLabel(pass.getPassword());

        JLabel hidePasswordLabel = new JLabel(HidePasswordLabelText(pass.getPassword().length()));
        JButton editBt = new JButton("EDIT");
        JButton deleteBt = new JButton("DELETE");

        fromListLabel.setBounds(fromXPosition, passwordDataYPosition, 90, 30);
        usernameListLabel.setBounds(usernameXPosition, passwordDataYPosition, 200, 30);
        passwordListLabel.setBounds(passwordXPosition, passwordDataYPosition, 120, 30);
        hidePasswordLabel.setBounds(passwordXPosition, passwordDataYPosition, 120, 30);

        SetButtons(editBt, userName, pass, ConfigurationStrings.editButtonColor, 480, 60);
        SetButtons(deleteBt, userName, pass, ConfigurationStrings.deleteButtonColor, 550, 75);

        passwordListLabel.setVisible(false);
        hidePasswordLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent arg0) {
                hidePasswordLabel.setVisible(false);
                passwordListLabel.setVisible(true);
            }
            public void mouseExited(MouseEvent arg0) {

                int delay = 1000;
                Timer timer = new Timer( delay, e -> {
                    hidePasswordLabel.setVisible(true);
                    passwordListLabel.setVisible(false);
                } );
                timer.setRepeats( false );//make sure the timer only runs once
                timer.start();
            }
        });

        frame.add(fromListLabel);
        frame.add(usernameListLabel);
        frame.add(passwordListLabel);
        frame.add(hidePasswordLabel);
        frame.add(editBt);
        frame.add(deleteBt);
    }

    private static String HidePasswordLabelText(int length){
        return "■".repeat(Math.max(0, length));
    }

    private static void SetButtons(JButton button,String userName, Password pass ,String buttonColor, int buttonXPosition, int buttonWidth){
        button.setFont(new Font(Font.DIALOG, Font.BOLD, 10));
        button.setBackground(Color.decode(buttonColor));
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setBounds(buttonXPosition, passwordDataYPosition, buttonWidth, 30);

        if(Objects.equals(button.getText(), "EDIT")){
            button.addActionListener(v -> {
                frame.setEnabled(false);
                UserCreateOrEditPasswordView.EditPassword(userName, userData, pass);
            });
        }else{
            button.addActionListener(v -> {
                //0 - YES, 1- NO
                int response = JOptionPane.showConfirmDialog(null, Messages.ConfirmDeleteMessage,
                        "Delete password", JOptionPane.YES_NO_OPTION);
                if(response == 0){
                    userData.remove(pass);
                    FIleIO.RemoveUserPassword(userName, userData);
                    ResetFrame(userName);
                }
            });
        }
    }

    private static void GetAllUserPasswords(String username, HomeView frame){
        userData = FIleIO.GetUserPasswords(username);
        if(userData == null) return;
        userData.forEach(pass -> {
            setEachPasswordItems(frame, username, pass);
            passwordDataYPosition += passwordDataAdjustYPosition;
        });
    }

    public static void ResetFrame(String userName){
        frame.dispose();
        HomeView.ShowHomeView(userName);
    }
}
