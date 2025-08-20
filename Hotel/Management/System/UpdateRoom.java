package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame {

    UpdateRoom() {
        //! Panel
        JPanel panel = new JPanel();
        panel.setBounds(5,5,875,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);
        //!Adding Image
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image image1 = image.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel label = new JLabel(image2);
        label.setBounds(540,130,250,250);
        panel.add(label);
        //!Adding Labels
        //? adding the heading
        JLabel label1 = new JLabel("Room Status Information");
        label1.setBounds(250,17,400,30);
        label1.setFont(FontLoader.getHeadingFont(23));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        //?Adding in Form -> Room Number
        JLabel label2 = new JLabel("Room Number ");
        label2.setBounds(64, 67, 200, 25);
        label2.setForeground(Color.WHITE);
        label2.setFont(FontLoader.getLabelFont(15));
        panel.add(label2);
        //*JCombobox(-Dropdown & filter together) to add Room Number
        JComboBox<String> ch = new JComboBox<>();
        ch.setBounds(230, 70, 220, 25);
        ch.setBackground(new Color(16,108,115));
        ch.setForeground(Color.WHITE);
        ch.setFont(FontLoader.getTextFont(14));
        panel.add(ch);
        //*getting Room Number from database
        try {
            DBCon c = new DBCon();
            String q = "SELECT roomnumber FROM room";
            ResultSet resultSet = c.statement.executeQuery(q);
            while(resultSet.next()) {
                ch.addItem(resultSet.getString("roomnumber"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        //? Adding In form -> ID number
        JLabel label3 = new JLabel("ID Number ");
        label3.setBounds(64, 112, 200, 25);
        label3.setForeground(Color.WHITE);
        label3.setFont(FontLoader.getLabelFont(15));
        panel.add(label3);
        //*TextField for ID number
        JTextField tf = new JTextField();
        tf.setBounds(230,115,220,25);
        tf.setBackground(new Color(16,108,115));
        tf.setForeground(Color.WHITE);
        tf.setFont(FontLoader.getTextFont(14));
        tf.setEditable(false);
        panel.add(tf);

        //? Adding In form -> Name
        JLabel label4 = new JLabel("Name ");
        label4.setBounds(64, 158, 200, 25);
        label4.setForeground(Color.WHITE);
        label4.setFont(FontLoader.getLabelFont(15));
        panel.add(label4);
        //*TextField for Name
        JTextField tf1 = new JTextField();
        tf1.setBounds(230,160,220,25);
        tf1.setBackground(new Color(16,108,115));
        tf1.setForeground(Color.WHITE);
        tf1.setFont(FontLoader.getTextFont(14));
        tf1.setEditable(false);
        panel.add(tf1);

        //? Adding In form -> Availability
        JLabel label5 = new JLabel("Availability ");
        label5.setBounds(64, 202, 200, 25);
        label5.setForeground(Color.WHITE);
        label5.setFont(FontLoader.getLabelFont(15));
        panel.add(label5);
        //*TextField for Availability
        JComboBox<String> ch1 = new JComboBox<>(new String[] {"Available", "Occupied"});
        ch1.setBounds(230,205,220,25);
        ch1.setBackground(new Color(16,108,115));
        ch1.setForeground(Color.WHITE);
        ch1.setFont(FontLoader.getTextFont(14));
        panel.add(ch1);

        //? Adding In form -> Cleaning Status
        JLabel label6 = new JLabel("Cleaning Status ");
        label6.setBounds(64, 249, 200, 25);
        label6.setForeground(Color.WHITE);
        label6.setFont(FontLoader.getLabelFont(15));
        panel.add(label6);
        //*TextField for Cleaning Status
        JComboBox<String> ch2 = new JComboBox<>(new String[] {"Clean", "Ongoing", "Pending to Clean"});
        ch2.setBounds(230,247,220,25);
        ch2.setBackground(new Color(16,108,115));
        ch2.setForeground(Color.WHITE);
        ch2.setFont(FontLoader.getTextFont(14));
        panel.add(ch2);


        //!Adding Buttons
        //?Update Button
        JButton b1 = new JButton("UPDATE");
        b1.setBounds(64,340,150,25);
        b1.setBackground(Color.WHITE);
        b1.setFont(FontLoader.getButtonFont(17));
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String roomNumber = ch.getSelectedItem().toString();

                    DBCon c = new DBCon();
                    String q = "SELECT IDnumber FROM customer WHERE room = ?";
                    PreparedStatement ps = c.connection.prepareStatement(q);
                    ps.setString(1, roomNumber);
                    ps.executeQuery();



                    String q1 = "UPDATE room SET cleaning_status = '"+ ch2.getSelectedItem()+"' WHERE roomnumber= ?";
                    PreparedStatement ps1 = c.connection.prepareStatement(q1);
                    ps1.setString(1, roomNumber);
                    ps1.executeUpdate();
                    String q2 = "UPDATE room SET availability = 'Available' WHERE roomnumber= ?";
                    PreparedStatement ps2 = c.connection.prepareStatement(q2);
                    ps2.setString(1, roomNumber);
                    ps2.executeUpdate();
                    String q3 = "UPDATE customer SET room = NULL WHERE room= ?";
                    PreparedStatement ps3 = c.connection.prepareStatement(q3);
                    ps3.setString(1, roomNumber);
                    ps3.executeUpdate();

                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);
                    new Reception();
                }catch(Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        //?Check Button
        JButton b3 = new JButton("CHECK");
        b3.setBounds(298,340,150,25);
        b3.setBackground(Color.WHITE);
        b3.setFont(FontLoader.getButtonFont(17));
        panel.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String roomNumber = ch.getSelectedItem().toString();
                try {
                    DBCon c = new DBCon();
                    String q = "SELECT * FROM room WHERE roomnumber ='"+roomNumber+"'";
                    ResultSet resultSet = c.statement.executeQuery(q);

                    while(resultSet.next()){
                        ch2.setSelectedItem(resultSet.getString("cleaning_status"));
                        ch1.setSelectedItem(resultSet.getString("availability"));
                    }


                    String q1 = "SELECT * FROM customer WHERE room = '"+roomNumber+"'";
                    ResultSet resultSet1 = c.statement.executeQuery(q1);
                    while(resultSet1.next()){
                        tf.setText(resultSet1.getString("IDnumber"));
                        tf1.setText(resultSet1.getString("name"));
                    }
                }catch(Exception e1) {
                    e1.printStackTrace();
                }

            }
        });
        //?Back Button
        JButton b2 = new JButton("BACK");
        b2.setBounds(180,390,150,25);
        b2.setBackground(Color.WHITE);
        b2.setFont(FontLoader.getButtonFont(17));
        panel.add(b2);
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Reception();
            }
        });


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

    public static void main(String[] args) {
        FontLoader.Fonts();
        new UpdateRoom();
    }
}