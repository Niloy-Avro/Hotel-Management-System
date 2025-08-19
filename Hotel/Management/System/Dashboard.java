package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    JButton admin,rec;

    Dashboard() {
        //!Adding Reception Buttons and Related Icon
        //?Adding Reception Button
        rec = new JButton("RECEPTION");
        rec.setBounds(300,620,140,50);
        rec.setFont(FontLoader.getButtonFont(19));
        rec.setBackground(new Color(0, 0, 0));
        rec.setForeground(Color.WHITE);
        rec.addActionListener(this);
        add(rec);
        //?Adding Reception Icon
        ImageIcon recimg =  new ImageIcon(ClassLoader.getSystemResource("icon/Reception.png"));
        Image recimg1 = recimg.getImage().getScaledInstance(100,120, Image.SCALE_DEFAULT);
        ImageIcon recimg2 = new ImageIcon(recimg1);
        JLabel label2 = new JLabel(recimg2);
        label2.setBounds(275,450,200,195);
        add(label2);

        //! Adding Admin Button and Related Icon
        //?Adding Admin Button
        admin = new JButton("ADMIN");
        admin.setBounds(1100,620,140,50);
        admin.setFont(FontLoader.getButtonFont(19));
        admin.setBackground(new Color(0, 0, 0));
        admin.setForeground(Color.WHITE);
        add(admin);
        admin.addActionListener(this);
        //?Adding Admin Icon
        ImageIcon adminimg =  new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));
        Image adminimg1 = adminimg.getImage().getScaledInstance(100,120, Image.SCALE_DEFAULT);
        ImageIcon adminimg2 = new ImageIcon(adminimg1);
        JLabel label3 = new JLabel(adminimg2);
        label3.setBounds(1069,450,200,195);
        add(label3);

        //!Adding the Background gif File
        ImageIcon image =  new ImageIcon(ClassLoader.getSystemResource("icon/dashboard1.gif"));
        Image image1 = image.getImage().getScaledInstance(1950,1090, Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel label = new JLabel(image2);
        label.setBounds(0,0,1550,1000);
        add(label);

        //!Main Frame
        setTitle("Hotel Management System - Dashboard");
        setLayout(null);
        setSize(1950, 1090);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set window title bar icon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        setIconImage(icon.getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==rec) {
            new Reception();
            setVisible(false);
        } else  {
            new AdminLogin();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        FontLoader.Fonts();
        new Dashboard();
    }

}