package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t6;
    JComboBox<String> t5, t7;
    JRadioButton t4m, t4f;
    JButton b1,b2,b3;
    AddEmployee() {
        //! Panel
        JPanel panel = new JPanel();
        panel.setBounds(5,5,875,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);
        //! Label
        //? adding the heading
        JLabel label =new JLabel("Add or Delete Employee Details");
        label.setBounds(194,10,500,50);
        label.setFont(FontLoader.getHeadingFont(23));
        label.setForeground(Color.WHITE);
        panel.add(label);

        //? adding in form -> Employee name
        JLabel l1 = new JLabel("NAME");
        l1.setBounds(64,68,152,22);
        l1.setFont(FontLoader.getLabelFont(15));
        l1.setForeground(Color.WHITE);
        panel.add(l1);
        //* TextField to write Employee name
        t1 = new JTextField();
        t1.setBounds(200,70,200,20);
        t1.setFont(FontLoader.getTextFont(14));
        t1.setForeground(Color.WHITE);
        t1.setBackground(new Color(16,108,115));
        panel.add(t1);


        //? adding in form -> Contact number
        JLabel l2 = new JLabel("Ph NUMBER");
        l2.setBounds(64,113,152,22);
        l2.setFont(FontLoader.getLabelFont(15));
        l2.setForeground(Color.WHITE);
        panel.add(l2);
        //* TextField to write Contact Number
        t2 = new JTextField();
        t2.setBounds(200,115,200,20);
        t2.setFont(FontLoader.getTextFont(14));
        t2.setForeground(Color.WHITE);
        t2.setBackground(new Color(16,108,115));
        panel.add(t2);


        //? adding in form -> email
        JLabel l3 = new JLabel("EMAIL");
        l3.setBounds(64,153,152,22);
        l3.setFont(FontLoader.getLabelFont(15));
        l3.setForeground(Color.WHITE);
        panel.add(l3);
        //* TextField to write Email
        t3 = new JTextField();
        t3.setBounds(200,155,200,20);
        t3.setFont(FontLoader.getTextFont(14));
        t3.setForeground(Color.WHITE);
        t3.setBackground(new Color(16,108,115));
        panel.add(t3);


        //? adding in form -> Gender
        JLabel l4 = new JLabel("GENDER");
        l4.setBounds(64,199,152,22);
        l4.setFont(FontLoader.getLabelFont(15));
        l4.setForeground(Color.WHITE);
        panel.add(l4);
        //* TextField to write Gender - Male
        t4m = new JRadioButton("Male");
        t4m.setBounds(200,200,70,27);
        t4m.setFont(FontLoader.getTextFont(14));
        t4m.setForeground(Color.WHITE);
        t4m.setBackground(new Color(3,45,48));
        panel.add(t4m);
        //* TextField to write Gender - Female
        t4f = new JRadioButton("Female");
        t4f.setBounds(270,200,80,27);
        t4f.setFont(FontLoader.getTextFont(14));
        t4f.setForeground(Color.WHITE);
        t4f.setBackground(new Color(3,45,48));
        panel.add(t4f);
        //* Creating a Button Group So that one can select only one
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(t4m);
        genderGroup.add(t4f);


        //? adding in form -> Education Details
        JLabel l5 = new JLabel("EDUCATION");
        l5.setBounds(64,242,152,22);
        l5.setFont(FontLoader.getLabelFont(15));
        l5.setForeground(Color.WHITE);
        panel.add(l5);

        //* TextField to write Education Details
        t5 = new JComboBox<>(new String[] {"Graduation", "Secondary", "High Secondary"});
        t5.setBounds(200,245,200,20);
        t5.setFont(FontLoader.getTextFont(14));
        t5.setForeground(Color.WHITE);
        t5.setBackground(new Color(16,108,115));
        panel.add(t5);

        //? adding in form -> Employee ID (for Delete)
        JLabel l6 = new JLabel("EMP ID");
        l6.setBounds(64, 287, 152, 22);
        l6.setFont(FontLoader.getLabelFont(15));
        l6.setForeground(Color.WHITE);
        panel.add(l6);
        //* TextField to write Employee ID
        t6 = new JTextField();
        t6.setBounds(200, 290, 200, 20);
        t6.setFont(FontLoader.getTextFont(14));
        t6.setForeground(Color.WHITE);
        t6.setBackground(new Color(16,108,115));
        panel.add(t6);


        //? adding in form -> Department Details
        JLabel l7 = new JLabel("DEPARTMENT");
        l7.setBounds(64,332,152,22);
        l7.setFont(FontLoader.getLabelFont(15));
        l7.setForeground(Color.WHITE);
        panel.add(l7);
        //* TextField to write Department Details
        t7 = new JComboBox<>(new String[] {"Manager", "Housekeeping", "Food", "Security", "Reception"});
        t7.setBounds(200,335,200,20);
        t7.setFont(FontLoader.getTextFont(14));
        t7.setForeground(Color.WHITE);
        t7.setBackground(new Color(16,108,115));
        panel.add(t7);

        //! adding Button
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

        //! adding logo
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/addemp.png"));
        Image image1 = image.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel label1 = new JLabel(image2);
        label1.setBounds(470,90,300,300);
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
            String gender = null;
            if(t4m.isSelected()) {
                gender = "Male";
            } else if(t4f.isSelected()) {
                gender = "Female";
            }
            if(gender == null) {
                JOptionPane.showMessageDialog(null, "Please select gender");
                return;
            }
            try {
                DBCon c = new DBCon();
                String q = "INSERT INTO employee(name, contact_number, email, gender, education_details, empID, department) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = c.connection.prepareStatement(q);
                ps.setString(1, t1.getText());
                ps.setString(2, t2.getText());
                ps.setString(3, t3.getText());
                ps.setString(4, gender);
                ps.setString(5, (String) t5.getSelectedItem());
                ps.setInt(6, Integer.parseInt(t6.getText()));
                ps.setString(7, (String) t7.getSelectedItem());
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Employee Details Successfully Added");
                new Admin();
                setVisible(false);

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            try {
                DBCon c = new DBCon();
                String q = "DELETE FROM employee WHERE empID = ?";
                PreparedStatement ps = c.connection.prepareStatement(q);
                ps.setInt(1, Integer.parseInt(t6.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Employee Details Successfully Deleted");
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
        new AddEmployee();
    }
}