package View;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JFrame{

    public static void ShowHomeView() {
        HomeView frame = new HomeView();
        frame.setTitle("Home");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Title label
        JLabel titleLabel = new JLabel("Passwords");
        titleLabel.setForeground(Color.gray);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

        //Columns label
        JLabel fromLabel = new JLabel("From");
        JLabel usernameLabel = new JLabel("Username");
        JLabel passwordLabel = new JLabel("Password");
        JLabel actionsLabel = new JLabel("Actions");

        //MenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu userMenu = new JMenu("User");
        JMenuItem helpMenu = new JMenu("Help");
        menuBar.add(userMenu);
        menuBar.add(helpMenu);
        JMenuItem changePassword = new JMenuItem("Change password");
        JMenuItem logout = new JMenuItem("Logout");
        userMenu.add(changePassword);
        userMenu.add(logout);



        //Set objects coordinates
        titleLabel.setBounds(220, 15, 400, 30);
        fromLabel.setBounds(20, 55, 200, 30);
        usernameLabel.setBounds(150, 55, 200, 30);
        passwordLabel.setBounds(350, 55, 200, 30);
        actionsLabel.setBounds(500, 55, 200, 30);

        frame.setJMenuBar(menuBar);
        frame.add(titleLabel);
        frame.add(fromLabel);
        frame.add(usernameLabel);
        frame.add(passwordLabel);
        frame.add(actionsLabel);
        setPasswordItems(frame);

        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private static void setPasswordItems(HomeView frame){
        //HERE WE WILL RECIVE A PASSWORD OBJECT AND SET IT ON THE FRAME
        JLabel fromListLabel = new JLabel("Example");
        JLabel usernameListLabel = new JLabel("ThisIsAnExample@example.com");
        JLabel passwordListLabel = new JLabel("p@ssword");
        String[] actions = {"Select action", "Edit", "Delete"};
        JComboBox<String> actionsBox = new JComboBox<>(actions);

        fromListLabel.setBounds(10, 90, 90, 30);
        usernameListLabel.setBounds(120, 90, 200, 30);
        passwordListLabel.setBounds(340, 90, 120, 30);
        actionsBox.setBounds(480, 90, 100, 30);
        actionsBox.setSelectedIndex(0);
        //actionsBox.addActionListener((ActionListener) this);
        frame.add(fromListLabel);
        frame.add(usernameListLabel);
        frame.add(passwordListLabel);
        frame.add(actionsBox);
    }
}
