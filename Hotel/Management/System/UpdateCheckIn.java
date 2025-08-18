package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateCheckIn extends JFrame {

    UpdateCheckIn() {
        //! Panel
        JPanel panel = new JPanel();
        panel.setBounds(5,5,875,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);
        //!Adding Image
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image1 = image.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel label = new JLabel(image2);
        label.setBounds(540,130,250,250);
        panel.add(label);
        //!Adding Labels
        //? adding the heading
        JLabel label1 = new JLabel("CHECk-in Information");
        label1.setBounds(300,17,320,30);
        label1.setFont(FontLoader.getHeadingFont(23));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        //?Adding in Form -> IDnumber
        JLabel label2 = new JLabel("ID: ");
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

        //? Adding In form -> room number
        JLabel label3 = new JLabel("Room Number ");
        label3.setBounds(64, 112, 200, 25);
        label3.setForeground(Color.WHITE);
        label3.setFont(FontLoader.getLabelFont(15));
        panel.add(label3);
        //*TextField for room number
        JTextField tf3 = new JTextField();
        tf3.setBounds(230,115,220,25);
        tf3.setBackground(new Color(16,108,115));
        tf3.setForeground(Color.WHITE);
        tf3.setFont(FontLoader.getTextFont(14));
        panel.add(tf3);

        //? Adding In form -> name
        JLabel label4 = new JLabel("Name ");
        label4.setBounds(64, 157, 200, 25);
        label4.setForeground(Color.WHITE);
        label4.setFont(FontLoader.getLabelFont(15));
        panel.add(label4);
        //*TextField for name
        JTextField tf4 = new JTextField();
        tf4.setBounds(230,160,220,25);
        tf4.setBackground(new Color(16,108,115));
        tf4.setForeground(Color.WHITE);
        tf4.setFont(FontLoader.getTextFont(14));
        panel.add(tf4);

        //? Adding In form -> Checked-in
        JLabel label5 = new JLabel("Checked-In ");
        label5.setBounds(64, 203, 200, 25);
        label5.setForeground(Color.WHITE);
        label5.setFont(FontLoader.getLabelFont(15));
        panel.add(label5);
        //*TextField for Checked-in
        JTextField tf5 = new JTextField();
        tf5.setBounds(230,205,220,25);
        tf5.setBackground(new Color(16,108,115));
        tf5.setForeground(Color.WHITE);
        tf5.setFont(FontLoader.getTextFont(14));
        panel.add(tf5);

        //? Adding In form -> Amount Paid
        JLabel label6 = new JLabel("Amount Paid (Rs) ");
        label6.setBounds(64, 250, 200, 25);
        label6.setForeground(Color.WHITE);
        label6.setFont(FontLoader.getLabelFont(15));
        panel.add(label6);
        //*TextField for Amount Paid
        JTextField tf6 = new JTextField();
        tf6.setBounds(230,250,220,25);
        tf6.setBackground(new Color(16,108,115));
        tf6.setForeground(Color.WHITE);
        tf6.setFont(FontLoader.getTextFont(14));
        panel.add(tf6);

        //? Adding In form -> Pending amount
        JLabel label7 = new JLabel("Pending Amount (Rs) ");
        label7.setBounds(64, 295, 200, 25);
        label7.setForeground(Color.WHITE);
        label7.setFont(FontLoader.getLabelFont(15));
        panel.add(label7);
        //*TextField for Pending Amount
        JTextField tf7 = new JTextField();
        tf7.setBounds(230,295,220,25);
        tf7.setBackground(new Color(16,108,115));
        tf7.setForeground(Color.WHITE);
        tf7.setFont(FontLoader.getTextFont(14));
        panel.add(tf7);

        //? Adding In form -> Contact Number
        JLabel label8 = new JLabel("Gender ");
        label8.setBounds(64, 339, 200, 25);
        label8.setForeground(Color.WHITE);
        label8.setFont(FontLoader.getLabelFont(15));
        panel.add(label8);
        //*TextField for Pending Amount
        JTextField tf8 = new JTextField();
        tf8.setBounds(230,340,220,25);
        tf8.setBackground(new Color(16,108,115));
        tf8.setForeground(Color.WHITE);
        tf8.setFont(FontLoader.getTextFont(14));
        panel.add(tf8);


        //!Adding Buttons
        //?Update Button
        JButton b1 = new JButton("UPDATE");
        b1.setBounds(64,395,150,25);
        b1.setBackground(Color.WHITE);
        b1.setFont(FontLoader.getButtonFont(17));
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String roomnumber = tf3.getText();
                try {
                    DBCon c = new DBCon();
                    String q = "UPDATE room SET cleaning_status = 'Pending to Clean' WHERE roomnumber= ?";
                    PreparedStatement ps1 = c.connection.prepareStatement(q);
                    ps1.setString(1, roomnumber);
                    ps1.executeUpdate();

                    String q1 = "UPDATE customer SET deposit = ? WHERE IDnumber = ?";
                    PreparedStatement ps = c.connection.prepareStatement(q1);
                    ps.setInt(1, Integer.parseInt(tf6.getText()));
                    ps.setString(2, ch.getSelectedItem().toString());
                    ps.executeUpdate();
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
        b3.setBounds(298,395,150,25);
        b3.setBackground(Color.WHITE);
        b3.setFont(FontLoader.getButtonFont(17));
        panel.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = ch.getSelectedItem().toString();
                try {
                    DBCon c = new DBCon();
                    String q = "SELECT * FROM customer WHERE IDnumber ='"+id+"'";
                    ResultSet resultSet = c.statement.executeQuery(q);

                    while(resultSet.next()){
                        tf3.setText(resultSet.getString("room"));
                        tf4.setText(resultSet.getString("name"));
                        tf5.setText(resultSet.getString("checkintime"));
                        tf6.setText(resultSet.getString("deposit"));
                        tf8.setText(resultSet.getString("gender"));
                    }
                    String q1 = "SELECT * FROM room WHERE roomnumber = '"+tf3.getText()+"'";
                    ResultSet resultSet1 = c.statement.executeQuery(q1);
                    while(resultSet1.next()) {
                        String price = resultSet1.getString("price");
                        int pendingAmt = Integer.parseInt(price) - Integer.parseInt(tf6.getText());
                        tf7.setText(""+pendingAmt);
                    }
                }catch(Exception e1) {
                    e1.printStackTrace();
                }

            }
        });
        //?Back Button
        JButton b2 = new JButton("BACK");
        b2.setBounds(180,445,150,25);
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
    }

    public static void main(String[] args) {
        FontLoader.Fonts();
        new UpdateCheckIn();
    }
}