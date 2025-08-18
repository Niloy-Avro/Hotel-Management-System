package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.sql.ResultSet;


public class NewCustomer extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4;
    JRadioButton r1,r2;
    JComboBox<String> ch1, ch2;
    JButton b1,b2;

    NewCustomer() {
        //! Panel
        JPanel panel = new JPanel();
        panel.setBounds(5,5,875,490);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);
        
        //!image icon
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image image1 = image.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel imagelabel = new JLabel(image2);
        imagelabel.setBounds(550,150,200,200);
        panel.add(imagelabel);

        //!Labels
        //? adding the heading
        JLabel label1 = new JLabel("NEW CUSTOMER FORM");
        label1.setBounds(300,10,400,50);
        label1.setFont(FontLoader.getHeadingFont(23));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        //? Adding in Form -> proof
        JLabel label2 = new JLabel("ID Proof ");
        label2.setBounds(64,67,152,25);
        label2.setFont(FontLoader.getLabelFont(15));
        label2.setForeground(Color.WHITE);
        panel.add(label2);
        //* Adding Combobox -> proof_text
        ch2 = new JComboBox<>(new String[]{"Passport","Aadhaar Card", "Voter Card", "Driving License"});
        ch2.setBounds(200,70,220,25);
        ch2.setFont(FontLoader.getTextFont(14));
        ch2.setForeground(Color.WHITE);
        ch2.setBackground(new Color(16,108,115));
        panel.add(ch2);

        //? Adding in Form -> Name
        JLabel label3 = new JLabel("NAME ");
        label3.setBounds(64,111,200,25);
        label3.setFont(FontLoader.getLabelFont(15));
        label3.setForeground(Color.WHITE);
        panel.add(label3);
        //* Adding Textfield -> name
        t1 = new JTextField();
        t1.setBounds(200,111,220,25);
        t1.setFont(FontLoader.getTextFont(14));
        t1.setForeground(Color.WHITE);
        t1.setBackground(new Color(16,108,115));
        panel.add(t1);

        //? Adding in Form -> IDNumber
        JLabel label4 = new JLabel("ID NUMBER ");
        label4.setBounds(64,152,200,25);
        label4.setFont(FontLoader.getLabelFont(15));
        label4.setForeground(Color.WHITE);
        panel.add(label4);
        //* Adding Textfield -> ID number
        t2 = new JTextField();
        t2.setBounds(200,152,220,25);
        t2.setFont(FontLoader.getTextFont(14));
        t2.setForeground(Color.WHITE);
        t2.setBackground(new Color(16,108,115));
        panel.add(t2);

        //? Adding in Form -> Gender
        JLabel label5 = new JLabel("Gender");
        label5.setBounds(64,193,200,25);
        label5.setFont(FontLoader.getLabelFont(15));
        label5.setForeground(Color.WHITE);
        panel.add(label5);
        //* Adding Checkbox -> gender
        //? Male
        r1 = new JRadioButton("Male");
        r1.setBounds(200,194,70,27);
        r1.setFont(FontLoader.getTextFont(14));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(3,45,48));
        panel.add(r1);
        //? female
        r2 = new JRadioButton("Female");
        r2.setBounds(290,194,80,27);
        r2.setFont(FontLoader.getTextFont(14));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(3,45,48));
        panel.add(r2);
        //* Creating a Button Group So that one can select only one
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        //? Adding in Form -> Room Number
        JLabel label6 = new JLabel("Room No. ");
        label6.setBounds(64,235,100,25);
        label6.setForeground(Color.WHITE);
        label6.setFont(FontLoader.getLabelFont(15));
        panel.add(label6);
        //*showing the all room in dropdown list
        ch1 = new JComboBox<>();
        ch1.setBounds(200,235,220,20);
        ch1.setFont(FontLoader.getLabelFont(14));
        ch1.setForeground(Color.WHITE);
        ch1.setBackground(new Color(3,45,48));
        panel.add(ch1);
            //* Getting data from database to show in choice dropdown
            try {
                DBCon c = new DBCon();
                ResultSet resultset = c.statement.executeQuery("SELECT * FROM room");
                while(resultset.next()) {
                    ch1.addItem(resultset.getString("roomnumber"));
                }
            } catch(Exception e) {
                e.printStackTrace();
            }

        //? Adding in Form -> deposit money
        JLabel label7 = new JLabel("Deposit ");
        label7.setBounds(64,276,200,25);
        label7.setForeground(Color.WHITE);
        label7.setFont(FontLoader.getLabelFont(15));
        panel.add(label7);
        //* Adding Textfield -> deposit money
        t3 = new JTextField();
        t3.setBounds(200,276,220,25);
        t3.setFont(FontLoader.getLabelFont(14));
        t3.setForeground(Color.WHITE);
        t3.setBackground(new Color(16,108,115));
        panel.add(t3);

        //? Adding in Form -> Checked in time
        JLabel label8 = new JLabel("Checked-In ");
        label8.setBounds(64,317,200,25);
        label8.setForeground(Color.WHITE);
        label8.setFont(FontLoader.getLabelFont(15));
        panel.add(label8);

        Date date = new Date();

        t4 = new JTextField(date.toString());
        t4.setBounds(200, 317, 220, 25);
        t4.setForeground(Color.WHITE);
        t4.setBackground(new Color(16,108,115));
        t4.setFont(FontLoader.getTextFont(15));
        t4.setEditable(false); //making the field un-editable
        panel.add(t4);


        //! adding Button
        //?Add Button
        b1 = new JButton("ADD");
        b1.setBounds(64,375,150,25);
        b1.setBackground(Color.WHITE);
        b1.setFont(FontLoader.getButtonFont(17));
        b1.addActionListener(this);
        panel.add(b1);
        //?Back Button
        b2 = new JButton("BACK");
        b2.setBounds(270,375,150,25);
        b2.setBackground(Color.WHITE);
        b2.setFont(FontLoader.getButtonFont(17));
        b2.addActionListener(this);
        panel.add(b2);

        //!Main Frame
        setUndecorated(true );
        setLayout(null);
        setSize(885,500);
        setLocation(110,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1) {
            //? -> Gender Checking
            String gender = null;
            if(r1.isSelected()) {
                gender ="Male";
            } else if(r2.isSelected()) {
                gender = "Female";
            }
            if(gender == null) {
                JOptionPane.showMessageDialog(null, "Please select gender");
                return;
            }

            //? -> ID Number Checking
            String IDnumber = t2.getText();
            if (IDnumber == null) {
                JOptionPane.showMessageDialog(null, "Please enter ID Number");
                return;
            }
            DBCon c = new DBCon();
            try {
                String q1 = "SELECT COUNT(*) FROM customer WHERE IDnumber = '" + IDnumber + "'";
                PreparedStatement ps1 = c.connection.prepareStatement(q1);
                ResultSet resultSet1 = ps1.executeQuery();
                if (resultSet1.next() && resultSet1.getInt("count(*)") == 1) {
                    JOptionPane.showMessageDialog(null, "This ID Number already exists!");
                    return;
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            //? -> Storing Data
            try {
                String q = "INSERT INTO customer(document, name, IDnumber, gender, room, deposit, checkintime) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = c.connection.prepareStatement(q);
                ps.setString(1, (String)ch2.getSelectedItem());
                ps.setString(2, t1.getText());
                ps.setString(3, IDnumber);
                ps.setString(4, gender);
                ps.setString(5, (String)ch1.getSelectedItem());
                ps.setInt(6, Integer.parseInt(t3.getText()));
                ps.setString(7, t4.getText());
                ps.executeUpdate();
                //? -> changing room  status in room table
                String q2 = "UPDATE room SET availability ='Occupied' WHERE roomnumber = '"+ch1.getSelectedItem()+"'";
                c.statement.executeUpdate(q2);

                JOptionPane.showMessageDialog(null, "Customer Details Successfully Added");
                new Reception();
                setVisible(false);

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        FontLoader.Fonts();
        new NewCustomer();
    }
}