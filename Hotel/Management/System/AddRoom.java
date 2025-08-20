package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class AddRoom extends JFrame implements ActionListener {
     JTextField t1,t3;
     JComboBox<String> t2,t4,t5;
     JButton b1,b2,b3;
    AddRoom() {
        //! Panel
        JPanel panel = new JPanel();
        panel.setBounds(5,5,875,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);
        //! Label
        //? adding the heading
        JLabel label =new JLabel("Add or delete Room");
        label.setBounds(300,17,300,30);
        label.setFont(FontLoader.getHeadingFont(23));
        label.setForeground(Color.WHITE);
        panel.add(label);
        //? adding in form -> room number
        JLabel l1 = new JLabel(" ROOM NUMBER");
        l1.setBounds(64,67,152,22);
        l1.setFont(FontLoader.getLabelFont(15));
        l1.setForeground(Color.WHITE);
        panel.add(l1);
        //* TextField to write room number
        t1 = new JTextField();
        t1.setBounds(220,70,200,20);
        t1.setFont(FontLoader.getTextFont(14));
        t1.setForeground(Color.WHITE);
        t1.setBackground(new Color(16,108,115));
        panel.add(t1);

        //? adding in form -> Availability
        JLabel l2 = new JLabel("AVAILIBILITY");
        l2.setBounds(64,127,152,22);
        l2.setFont(FontLoader.getLabelFont(15));
        l2.setForeground(Color.WHITE);
        panel.add(l2);
        //* TextField to write Availability
        t2 = new JComboBox<>(new String[] {"Available", "Occupied"});
        t2.setBounds(220,130,200,20);
        t2.setFont(FontLoader.getTextFont(14));
        t2.setForeground(Color.WHITE);
        t2.setBackground(new Color(16,108,115));
        panel.add(t2);

        //? adding in form -> price
        JLabel l3 = new JLabel("PRICE");
        l3.setBounds(64,187,152,22);
        l3.setFont(FontLoader.getLabelFont(15));
        l3.setForeground(Color.WHITE);
        panel.add(l3);
        //* TextField to write price
        t3 = new JTextField();
        t3.setBounds(220,190,200,20);
        t3.setFont(FontLoader.getTextFont(14));
        t3.setForeground(Color.WHITE);
        t3.setBackground(new Color(16,108,115));
        panel.add(t3);


        //? adding in form -> bed type
        JLabel l4 = new JLabel("BED TYPE");
        l4.setBounds(64,247,152,22);
        l4.setFont(FontLoader.getLabelFont(15));
        l4.setForeground(Color.WHITE);
        panel.add(l4);
        //* TextField to write bed type
        t4 = new JComboBox<>(new String[] {"Double Bed", "Single Bed"});
        t4.setBounds(220,250,200,20);
        t4.setFont(FontLoader.getTextFont(14));
        t4.setForeground(Color.WHITE);
        t4.setBackground(new Color(16,108,115));
        panel.add(t4);

        //? adding in form -> Cleaning Status
        JLabel l5 = new JLabel("CLEANING STATUS");
        l5.setBounds(64,307,152,22);
        l5.setFont(FontLoader.getLabelFont(15));
        l5.setForeground(Color.WHITE);
        panel.add(l5);
        //* TextField to write cleaning status
        t5 = new JComboBox<>(new String[] {"Clean", "Ongoing", "Pending to Clean"});
        t5.setBounds(220,310,200,20);
        t5.setFont(FontLoader.getTextFont(14));
        t5.setForeground(Color.WHITE);
        t5.setBackground(new Color(16,108,115));
        panel.add(t5);

        //! Adding Button
        //?Add Button
        b1 = new JButton("ADD");
        b1.setBounds(64,375,150,25);
        b1.setBackground(Color.WHITE);
        b1.setFont(FontLoader.getButtonFont(17));
        b1.addActionListener(this);
        panel.add(b1);
        //?Delete Button
        b2 = new JButton("DELETE");
        b2.setBounds(160,430,150,25);
        b2.setBackground(Color.WHITE);
        b2.setFont(FontLoader.getButtonFont(17));
        b2.addActionListener(this);
        panel.add(b2);
        //?Back Button
        b3 = new JButton("BACK");
        b3.setBounds(269,375,150,25);
        b3.setBackground(Color.WHITE);
        b3.setFont(FontLoader.getButtonFont(17));
        b3.addActionListener(this);
        panel.add(b3);

        //! adding logo
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/roomser.png"));
        Image image1 = image.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel label1 = new JLabel(image2);
        label1.setBounds(460,80,300,300);
        panel.add(label1);
        //! Main Frame
        setUndecorated(true);
        setLocation(110,200);
        setLayout(null);
        setSize(885,500);
        setVisible(true);
        // Set window title bar icon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        setIconImage(icon.getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                DBCon c = new DBCon();
                String q = "INSERT INTO room VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = c.connection.prepareStatement(q);
                ps.setInt(1, Integer.parseInt(t1.getText()));
                ps.setString(2, (String) t2.getSelectedItem());
                ps.setString(3, t3.getText());
                ps.setString(4, (String) t4.getSelectedItem());
                ps.setString(5, (String) t5.getSelectedItem());
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Room Successfully Added");
                new Admin();
                setVisible(false);

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            try {
                DBCon c = new DBCon();
                String q = "DELETE FROM room WHERE roomnumber = ?";
                PreparedStatement ps = c.connection.prepareStatement(q);
                ps.setInt(1, Integer.parseInt(t1.getText()));
                ps.executeUpdate();

                String q2 = "ALTER TABLE employee AUTO_INCREMENT = 1";
                PreparedStatement ps2 = c.connection.prepareStatement(q2);
                ps2.executeUpdate();

                JOptionPane.showMessageDialog(null, "Room Successfully Deleted");
                new Admin();
                setVisible(false);

            } catch (Exception e1) {
                e1.getStackTrace();
            }
        } else  {
            new Admin();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        FontLoader.Fonts();
        new AddRoom();
    }
}