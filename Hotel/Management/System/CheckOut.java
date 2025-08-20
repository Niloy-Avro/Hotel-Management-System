package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import  java.util.Date;

public class CheckOut extends JFrame {

    CheckOut() {
        //! Panel
        JPanel panel = new JPanel();
        panel.setBounds(5,5,875,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);
        //!Adding Image
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/Check-out.gif"));
        Image image1 = image.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel label = new JLabel(image2);
        label.setBounds(540,130,250,250);
        panel.add(label);
        //!Adding Labels
        //? adding the heading
        JLabel label1 = new JLabel("CHECk-Out Information");
        label1.setBounds(250,17,350,30);
        label1.setFont(FontLoader.getHeadingFont(23));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        //?Adding in Form -> IDnumber
        JLabel label2 = new JLabel("Document ID ");
        label2.setBounds(64, 67, 200, 25);
        label2.setForeground(Color.WHITE);
        label2.setFont(FontLoader.getLabelFont(15));
        panel.add(label2);
        //*JCombobox(-Dropdown & filter together) to add IDnumber
        JComboBox<String> ch = new JComboBox<>();
        ch.setBounds(230, 70, 220, 25);
        ch.setBackground(new Color(16,108,115));
        ch.setForeground(Color.WHITE);
        ch.setFont(FontLoader.getTextFont(14));
        panel.add(ch);
            //*getting IDnumber from database
            try {
                DBCon c = new DBCon();
                String q = "SELECT IDnumber FROM customer";
                ResultSet resultSet = c.statement.executeQuery(q);
                while(resultSet.next()) {
                    ch.addItem(resultSet.getString("IDnumber"));
                }
            } catch(Exception e) {
                e.printStackTrace();
            }

        //? Adding In form -> Room Number
        JLabel label3 = new JLabel("Room Number ");
        label3.setBounds(64, 114, 200, 25);
        label3.setForeground(Color.WHITE);
        label3.setFont(FontLoader.getLabelFont(15));
        panel.add(label3);
        //*TextField for Checked-in
        JTextField tf = new JTextField();
        tf.setBounds(230,117,220,25);
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
        //*TextField for name
        JTextField tf1 = new JTextField();
        tf1.setBounds(230,160,220,25);
        tf1.setBackground(new Color(16,108,115));
        tf1.setForeground(Color.WHITE);
        tf1.setEditable(false);
        tf1.setFont(FontLoader.getTextFont(14));
        panel.add(tf1);


        //? Adding In form -> Checked-in
        JLabel label5 = new JLabel("Checked-in ");
        label5.setBounds(64, 203, 200, 25);
        label5.setForeground(Color.WHITE);
        label5.setFont(FontLoader.getLabelFont(15));
        panel.add(label5);
        //*TextField for Checked-in
        JTextField tf2 = new JTextField();
        tf2.setBounds(230,205,220,25);
        tf2.setBackground(new Color(16,108,115));
        tf2.setForeground(Color.WHITE);
        tf2.setEditable(false);
        tf2.setFont(FontLoader.getTextFont(14));
        panel.add(tf2);

        //? Adding In form -> Checked-Out
        JLabel label6 = new JLabel("Checked-Out ");
        label6.setBounds(64, 243, 200, 25);
        label6.setForeground(Color.WHITE);
        label6.setFont(FontLoader.getLabelFont(15));
        panel.add(label6);

        Date date = new Date();

        //*TextField for Checked-Out
        JTextField tf3 = new JTextField(date.toString());
        tf3.setBounds(230,245,220,25);
        tf3.setBackground(new Color(16,108,115));
        tf3.setForeground(Color.WHITE);
        tf3.setFont(FontLoader.getTextFont(14));
        tf3.setEditable(false);
        panel.add(tf3);

        //? Adding In form -> Pending amount
        JLabel label7 = new JLabel("Pending Amount (Rs) ");
        label7.setBounds(64, 288, 200, 25);
        label7.setForeground(Color.WHITE);
        label7.setFont(FontLoader.getLabelFont(15));
        panel.add(label7);
        //*TextField for Pending Amount
        JTextField tf4 = new JTextField();
        tf4.setBounds(230,290,220,25);
        tf4.setBackground(new Color(16,108,115));
        tf4.setForeground(Color.WHITE);
        tf4.setFont(FontLoader.getTextFont(14));
        panel.add(tf4);


        //!Adding Buttons
        //?Update Button
        JButton b1 = new JButton("REMOVE");
        b1.setBounds(64,355,150,25);
        b1.setBackground(Color.WHITE);
        b1.setFont(FontLoader.getButtonFont(17));
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = ch.getSelectedItem().toString();
                try {
                    DBCon c = new DBCon();
                    String q1 = "DELETE FROM customer WHERE IDnumber = ?";
                    PreparedStatement ps = c.connection.prepareStatement(q1);
                    ps.setString(1, id);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Check Out Successful");
                    setVisible(false);
                    new Reception();
                }catch(Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        //?Check Button
        JButton b3 = new JButton("CHECK");
        b3.setBounds(298,355,150,25);
        b3.setBackground(Color.WHITE);
        b3.setFont(FontLoader.getButtonFont(17));
        panel.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = ch.getSelectedItem().toString();
                try {
                    DBCon c = new DBCon();

                    String q = "SELECT room, deposit, checkintime, name FROM customer WHERE IDnumber = ?";
                    PreparedStatement ps = c.connection.prepareStatement(q);
                    ps.setString(1, id);
                    ResultSet resultSet = ps.executeQuery();

                    String roomNumber = null;
                    int deposit = 0;

                    if (resultSet.next()) {
                        roomNumber = resultSet.getString("room");
                        deposit = resultSet.getInt("deposit");

                        tf.setText(roomNumber);
                        tf1.setText(resultSet.getString("name"));
                        tf2.setText(resultSet.getString("checkintime"));
                    }

                    tf4.setText("");

                    if (roomNumber != null) {
                        String q1 = "SELECT price FROM room WHERE roomnumber = ?";
                        PreparedStatement ps1 = c.connection.prepareStatement(q1);
                        ps1.setString(1, roomNumber);
                        ResultSet resultSet1 = ps1.executeQuery();

                        if (resultSet1.next()) {
                            int price = resultSet1.getInt("price");
                            int pendingAmt = price - deposit;
                            tf4.setText(""+pendingAmt);
                        }
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });
        //?Back Button
        JButton b2 = new JButton("BACK");
        b2.setBounds(180,405,150,25);
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
        new CheckOut();
    }
}
