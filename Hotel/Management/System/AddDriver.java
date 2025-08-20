package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class AddDriver extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4,t6;
    JComboBox<String> t5;
    JButton b1,b2,b3;

    AddDriver() {
        //! Add Panel
        JPanel panel = new JPanel();
        panel.setBounds(5,5,875,490);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);
        //! Add Label
        //? add heading
        JLabel label = new JLabel("Add or Remove Driver Details");
        label.setBounds(225,15,450,33);
        label.setFont(FontLoader.getHeadingFont(23));
        label.setForeground(Color.WHITE);
        panel.add(label);
        //? 6> Adding in Form -> Driver Id
        JLabel label0 = new JLabel("DRIVER ID");
        label0.setBounds(64,70,1520,22);
        label0.setFont(FontLoader.getLabelFont(14));
        label0.setForeground(Color.WHITE);
        panel.add(label0);
        //* TextField to write Driver Id
        t6 = new JTextField();
        t6.setBounds(220,70,200,20);
        t6.setFont(FontLoader.getTextFont(14));
        t6.setForeground(Color.WHITE);
        t6.setBackground(new Color(16,108,115));
        panel.add(t6);
        //? 1> Adding in form -> Name
        JLabel label1 = new JLabel("NAME");
        label1.setBounds(64,119,1520,22);
        label1.setFont(FontLoader.getLabelFont(14));
        label1.setForeground(Color.WHITE);
        panel.add(label1);
        //* TextField to write Driver name
        t1 = new JTextField();
        t1.setBounds(220,120,200,20);
        t1.setFont(FontLoader.getTextFont(14));
        t1.setForeground(Color.WHITE);
        t1.setBackground(new Color(16,108,115));
        panel.add(t1);
        //? 2> Adding in Form -> mobile number
        JLabel label2 = new JLabel("CONTACT NUMBER");
        label2.setBounds(64,169,1520,22);
        label2.setFont(FontLoader.getLabelFont(14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);
        //* TextField to write Mobile number
        t2 = new JTextField();
        t2.setBounds(220,170,200,20);
        t2.setFont(FontLoader.getTextFont(14));
        t2.setForeground(Color.WHITE);
        t2.setBackground(new Color(16,108,115));
        panel.add(t2);
        //? 3> Adding in Form -> Car Company
        JLabel label3 = new JLabel("CAR COMPANY");
        label3.setBounds(64,219,1520,22);
        label3.setFont(FontLoader.getLabelFont(14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);
        //* TextField to write Car Company
        t3 = new JTextField();
        t3.setBounds(220,220,200,20);
        t3.setFont(FontLoader.getTextFont(14));
        t3.setForeground(Color.WHITE);
        t3.setBackground(new Color(16,108,115));
        panel.add(t3);
        //? 4> Adding Car Model
        JLabel label4 = new JLabel("CAR MODEL");
        label4.setBounds(64,269,1520,22);
        label4.setFont(FontLoader.getLabelFont(14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);
        //* TextField to write Car Model
        t4 = new JTextField();
        t4.setBounds(220,270,200,20);
        t4.setFont(FontLoader.getTextFont(14));
        t4.setForeground(Color.WHITE);
        t4.setBackground(new Color(16,108,115));
        panel.add(t4);
        //? 5> Adding Available or not
        JLabel label5 = new JLabel("AVAILABLE");
        label5.setBounds(64,319,1520,22);
        label5.setFont(FontLoader.getLabelFont(14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);
        //* Combo box to select Availability
        t5 = new JComboBox<>(new String[] {"YES", "NO"});
        t5.setBounds(220,320,200,20);
        t5.setBackground(new Color(16,108,115));
        t5.setForeground(Color.WHITE);
        t5.setFont(FontLoader.getTextFont(14));
        panel.add(t5);

        //! Add Button
        //?Add Button
        b1 = new JButton("ADD");
        b1.setBounds(64,375,150,25);
        b1.setBackground(Color.WHITE);
        b1.setFont(FontLoader.getButtonFont(17));
        b1.addActionListener(this);
        panel.add(b1);
        //?Delete Button
        b2 = new JButton("DELETE");
        b2.setBounds(155,430,150,25);
        b2.setBackground(Color.WHITE);
        b2.setFont(FontLoader.getButtonFont(17));
        b2.addActionListener(this);
        panel.add(b2);
        //?Back Button
        b3 = new JButton("BACK");
        b3.setBounds(250,375,150,25);
        b3.setBackground(Color.WHITE);
        b3.setFont(FontLoader.getButtonFont(17));
        b3.addActionListener(this);
        panel.add(b3);

        //! Add Icon on Panel
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/license.png"));
        Image image1 = image.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel labelImg = new JLabel(image2);
        labelImg.setBounds(500,100,250,250);
        panel.add(labelImg);

        //! Main Frame
        setUndecorated(true);
        setLayout(null);
        setLocation(110,200);
        setSize(885,500);
        setVisible(true);
        // Set window title bar icon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        setIconImage(icon.getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {
            try {
                DBCon c = new DBCon();
                String q = "INSERT INTO driver VALUES (?,?,?,?,?,?)";
                PreparedStatement ps = c.connection.prepareStatement(q);
                ps.setInt(1, Integer.parseInt(t6.getText()));
                ps.setString(2, t1.getText());
                ps.setString(3, t2.getText());
                ps.setString(4, t3.getText());
                ps.setString(5, t4.getText());
                ps.setString(6, (String) t5.getSelectedItem());
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null,"Successfully added");
                new Admin();
                setVisible(false);
            } catch (Exception e1) {
                e1.getStackTrace();
            }
        } else if(e.getSource()==b2) {
            try {
                DBCon c = new DBCon();
                String q = "DELETE FROM driver WHERE driverID = ?";
                PreparedStatement ps = c.connection.prepareStatement(q);
                ps.setInt(1, Integer.parseInt(t6.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Driver Details Successfully Deleted");
                new Admin();
                setVisible(false);
            } catch(Exception e1)  {
                e1.getStackTrace();
            }
        } else {
            new Admin();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        FontLoader.Fonts();
        new AddDriver();
    }
}
