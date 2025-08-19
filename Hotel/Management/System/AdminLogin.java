package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AdminLogin extends JFrame implements ActionListener {

    JTextField textField1;
    JPasswordField passwordField1;
    JButton b1,b2;

    AdminLogin() {
        //!Adding Labels
        //?Adding Label for Admin Username
        JLabel label1 = new JLabel("Username: ");
        label1.setBounds(40,47,100,30);
        label1.setFont(FontLoader.getLabelFont(16));
        label1.setForeground(Color.WHITE);
        add(label1);
        //?Adding Label for Admin Password
        JLabel label2 = new JLabel("Password: ");
        label2.setBounds(40,117,100,30);
        label2.setFont(FontLoader.getLabelFont(16));
        label2.setForeground(Color.WHITE);
        add(label2);

        //!Adding TextFields
        //?Adding TextField for Admin Username
        textField1 = new JTextField();
        textField1.setBounds(150,50,150,30);
        textField1.setForeground(Color.WHITE);
        textField1.setFont(FontLoader.getTextFont(15));
        textField1.setBackground(new Color(62, 66, 66));
        add(textField1);

        //?Adding TextField for Admin Password
        passwordField1 = new JPasswordField();
        passwordField1.setBounds(150,120,150,30);
        passwordField1.setForeground(Color.WHITE);
        passwordField1.setFont(FontLoader.getTextFont(15));
        passwordField1.setBackground(new Color(62, 66,66));
        add(passwordField1);

        //!Adding Logo
        ImageIcon labelImage = new ImageIcon(ClassLoader.getSystemResource("icon/login1.gif"));
        Image scaledImage = labelImage.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon finalImage = new ImageIcon(scaledImage);
        JLabel label = new JLabel(finalImage);
        label.setBounds(320,-30,280,300);
        add(label);

        //!Adding Buttons
        //?Adding Login Button
        b1 = new JButton("Login");
        b1.setBounds(40,190,120,30);
        b1.setFont(FontLoader.getButtonFont(17));
        b1.setBackground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        //?Adding Cancel Button
        b2 = new JButton("CANCEL");
        b2.setBounds(180,190,120,30);
        b2.setFont(FontLoader.getButtonFont(17));
        b2.setBackground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        //! Main Frame
        setTitle("Hotel Management System - Admin Login Page");
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        setLocation(400,270);
        setSize(600,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                DBCon c = new DBCon();
                String username = textField1.getText();
                char[] password = passwordField1.getPassword();
                String password1 = new String(password);

                String q="SELECT * FROM adminLogin WHERE BINARY username='"+username+"' AND BINARY password ='"+password1+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if(resultSet.next()) {
                    new Admin();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "INVALID INFORMATION BRO!!");
                }
            }catch(Exception E) {
                E.getStackTrace();
            }
        } else {
            new Dashboard();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        FontLoader.Fonts();
        new AdminLogin();
    }
}