package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame{

    Reception() {
        //! Big main panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(280,5,1238,820);
        panel.setBackground(new Color(3,45,45));
        add(panel);
        ImageIcon imagePanel = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image image1Panel = imagePanel.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon image2Panel = new ImageIcon(image1Panel);
        JLabel label = new JLabel(image2Panel);
        label.setBounds(300, 20 ,800,800);
        panel.add(label);
        //! small side panel1
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,270,820);
        panel1.setBackground(Color.BLACK);
        add(panel1);
        ImageIcon imagePanel1 = new ImageIcon(ClassLoader.getSystemResource("icon/login1.gif"));
        Image image1Panel1 = imagePanel1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon image2Panel1 = new ImageIcon(image1Panel1);
        JLabel label1 = new JLabel(image2Panel1);
        label1.setBounds(5,600,270,200);
        panel1.add(label1);

        //! adding button in small side panel1
        //? button1 -> New Customer Form
        JButton btnNCF = new JButton("New Customer Form");
        btnNCF.setBounds(30,30,200,30);
        btnNCF.setBackground(new Color(166, 166, 166));
        btnNCF.setForeground(Color.BLACK);
        btnNCF.setFont(FontLoader.getButtonFont(15));
        panel1.add(btnNCF);
        btnNCF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FontLoader.Fonts();
                    new NewCustomer();
                    setVisible(false);
                } catch(Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //? button2 -> Room Details
        JButton btnRoom = new JButton("Room Details");
        btnRoom.setBounds(30,80,200,30);
        btnRoom.setBackground(new Color(166, 166, 166));
        btnRoom.setForeground(Color.BLACK);
        btnRoom.setFont(FontLoader.getButtonFont(15));
        panel1.add(btnRoom);
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new RoomDetails();
                    setVisible(false);
                } catch(Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //? button3 -> Department Details
        JButton btnDept = new JButton("Department");
        btnDept.setBounds(30,130,200,30);
        btnDept.setBackground(new Color(166, 166, 166));
        btnDept.setForeground(Color.BLACK);
        btnDept.setFont(FontLoader.getButtonFont(15));
        panel1.add(btnDept);
        btnDept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Department();
                    setVisible(false);
                } catch(Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //? button4 -> All Employee info
        JButton btnEmp = new JButton("All Employee info");
        btnEmp.setBounds(30,180,200,30);
        btnEmp.setBackground(new Color(166, 166, 166));
        btnEmp.setForeground(Color.BLACK);
        btnEmp.setFont(FontLoader.getButtonFont(15));
        panel1.add(btnEmp);
        btnEmp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new EmployeeInfo();
                    setVisible(false);
                } catch(Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //? button5 -> Customer info
        JButton btnCustomer = new JButton("Customer info");
        btnCustomer.setBounds(30,230,200,30);
        btnCustomer.setBackground(new Color(166, 166, 166));
        btnCustomer.setForeground(Color.BLACK);
        btnCustomer.setFont(FontLoader.getButtonFont(15));
        panel1.add(btnCustomer);
        btnCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CustomerInfo();
                    setVisible(false);
                } catch(Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //? button6 -> Manager info
        JButton btnManager = new JButton("Manager info");
        btnManager.setBounds(30,280,200,30);
        btnManager.setBackground(new Color(166, 166, 166));
        btnManager.setForeground(Color.BLACK);
        btnManager.setFont(FontLoader.getButtonFont(15));
        panel1.add(btnManager);
        btnManager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ManagerInfo();
                    setVisible(false);
                } catch(Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //? button5 -> Checkout info
        JButton btnCheckout = new JButton("Checkout");
        btnCheckout.setBounds(30,330,200,30);
        btnCheckout.setBackground(new Color(166, 166, 166));
        btnCheckout.setForeground(Color.BLACK);
        btnCheckout.setFont(FontLoader.getButtonFont(15));
        panel1.add(btnCheckout);
        btnCheckout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                } catch(Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //? button6 -> Update CheckIn info
        JButton btnCheckin = new JButton("Update CheckIn info");
        btnCheckin.setBounds(30,380,200,30);
        btnCheckin.setBackground(new Color(166, 166, 166));
        btnCheckin.setForeground(Color.BLACK);
        btnCheckin.setFont(FontLoader.getButtonFont(15));
        panel1.add(btnCheckin);
        btnCheckin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FontLoader.Fonts();
                    new UpdateCheckIn();
                    setVisible(false);
                } catch(Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //? button7 -> Update Room Status
        JButton btnRoomStatus = new JButton("Update Room Status");
        btnRoomStatus.setBounds(30,430,200,30);
        btnRoomStatus.setBackground(new Color(166, 166, 166));
        btnRoomStatus.setForeground(Color.BLACK);
        btnRoomStatus.setFont(FontLoader.getButtonFont(15));
        panel1.add(btnRoomStatus);
        btnRoomStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                } catch(Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //? button8 -> PickUp Service
        JButton btnPickup = new JButton("Pick Up Service");
        btnPickup.setBounds(30,480,200,30);
        btnPickup.setBackground(new Color(166, 166, 166));
        btnPickup.setForeground(Color.BLACK);
        btnPickup.setFont(FontLoader.getButtonFont(15));
        panel1.add(btnPickup);
        btnPickup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new PickUp();
                    setVisible(false);
                } catch(Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //? button9 -> Search Room
        JButton btnSearchRoom = new JButton("Search Room");
        btnSearchRoom.setBounds(30,530,200,30);
        btnSearchRoom.setBackground(new Color(166, 166, 166));
        btnSearchRoom.setForeground(Color.BLACK);
        btnSearchRoom.setFont(FontLoader.getButtonFont(15));
        panel1.add(btnSearchRoom);
        btnSearchRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new SearchRoom();
                    setVisible(false);
                } catch(Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //! adding button in big main panel
        //? button1 -> Back to dashboard
        JButton btnDashboard = new JButton("Back to Dashboard");
        btnDashboard.setBounds(1010,30,200,30);
        btnDashboard.setBackground(new Color(166, 166, 166));
        btnDashboard.setForeground(Color.BLACK);
        btnDashboard.setFont(FontLoader.getButtonFont(18));
        panel.add(btnDashboard);
        btnDashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Dashboard();
                    setVisible(false);
                } catch(Exception E) {
                    E.printStackTrace();
                }
            }
        });



        //! main frame
        setTitle("Hotel Management System - Reception Page");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(1950,1090);
        setVisible(true);
    }

    public static void main(String[] args) {
        FontLoader.Fonts();
        new Reception();
    }
}