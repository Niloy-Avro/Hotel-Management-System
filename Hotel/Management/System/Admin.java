package Hotel.Management.System;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Admin extends JFrame implements ActionListener {
    JButton add_Employee, add_Room, add_Driver, logout, back;

    Admin() {
        //? Adding button1 -> add employee
        add_Employee = new JButton("ADD OR REMOVE EMPLOYEE");
        add_Employee.setBounds(250,150,300,30);
        add_Employee.setBackground(Color.WHITE);
        add_Employee.setForeground(Color.BLACK);
        add_Employee.setFont(FontLoader.getButtonFont(19));
        add_Employee.addActionListener(this);
        add(add_Employee);

        //? Adding button2 -> add Room
        add_Room = new JButton("ADD OR REMOVE ROOM");
        add_Room.setBounds(250,300,300,30);
        add_Room.setBackground(Color.WHITE);
        add_Room.setForeground(Color.BLACK);
        add_Room.setFont(FontLoader.getButtonFont(19));
        add_Room.addActionListener(this);
        add(add_Room);

        //? Adding button3 -> add Driver
        add_Driver = new JButton("ADD OR REMOVE DRIVER");
        add_Driver.setBounds(250,450,300,30);
        add_Driver.setBackground(Color.WHITE);
        add_Driver.setForeground(Color.BLACK);
        add_Driver.setFont(FontLoader.getButtonFont(19));
        add_Driver.addActionListener(this);
        add(add_Driver);

        //? Adding button4 -> Back
        back = new JButton("BACK");
        back.setBounds(10,760,140,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(FontLoader.getButtonFont(19));
        back.addActionListener(this);
        add(back);

        //? Adding button5 -> Log Out
        logout = new JButton("LOG OUT");
        logout.setBounds(160,760,140,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(FontLoader.getButtonFont(19));
        logout.addActionListener(this);
        add(logout);

        //! Adding Icons
        //? employee icon
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image image11 = image1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon image12 = new ImageIcon(image11);
        JLabel label1 =  new JLabel(image12);
        label1.setBounds(70,100,120,120);
        add(label1);
        //? room icon
        ImageIcon image2 = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image image21 = image2.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon image22 = new ImageIcon(image21);
        JLabel label2 = new JLabel(image22);
        label2.setBounds(70,250,120,120);
        add(label2);
        //? driver icon
        ImageIcon image3 = new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image image31 = image3.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon image32 = new ImageIcon(image31);
        JLabel label3 = new JLabel(image32);
        label3.setBounds(70,400,120,120);
        add(label3);
        //? hotel logo
        ImageIcon image4 = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image image41 = image4.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon image42 = new ImageIcon(image41);
        JLabel label4 = new JLabel(image42);
        label4.setBounds(800,200,400,400);
        add(label4);


        //! Main frame
        setTitle("Hotel Management System - Admin Page");
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        setSize(1950,1080);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==add_Employee) {
            new AddEmployee();
            setVisible(false);
        } else if (e.getSource()==add_Room) {
            new AddRoom();
            setVisible(false);
        } else if (e.getSource()==add_Driver) {
            FontLoader.Fonts();
            new AddDriver();
            setVisible(false);
        } else if (e.getSource()==logout) {
            System.out.println("Nikal gaya Bhai");
            System.exit(99999);
        } else if (e.getSource()==back) {
            new Dashboard();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        FontLoader.Fonts();
        new Admin();
    }
}