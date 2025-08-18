package Hotel.Management.System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUp extends JFrame{

    PickUp() {
        //!Panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,790,590);
        panel.setLayout(null);
        add(panel);
        //!Adding Labels
        //? Heading
        JLabel label = new JLabel("Pick Up Service");
        label.setBounds(290,15,230,31);

        label.setFont(FontLoader.getHeadingFont(23));
        label.setForeground(Color.WHITE);
        panel.add(label);
        //? Type of car
        JLabel label1 = new JLabel("Type of Car : ");
        label1.setBounds(232,100,100,30);
        label1.setFont(FontLoader.getLabelFont(15));
        label1.setForeground(Color.WHITE);
        panel.add(label1);
        //*DropDown of cars form Database
        Choice ch = new Choice();
        ch.setBounds(360,104,210,25);
        ch.setFont(FontLoader.getTextFont(14));
        panel.add(ch);
            //* --> connection to car model data
            try {
                DBCon c = new DBCon();
                String q="SELECT DISTINCT carModel FROM driver";
                ResultSet resultSet = c.statement.executeQuery(q);
                while(resultSet.next()) {
                    ch.add(resultSet.getString("carModel"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        //? Adding Table
        String[] columnNames = {"ID", "Name", "Contact", "Car Company", "Car Model", "Availability"};
        Object[][] data = {};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(3,45,48));
        table.setFont(FontLoader.getTextFont(14));
        table.getTableHeader().setFont(FontLoader.getLabelFont(16));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setBackground(new Color(3,45,48));
        table.setRowHeight(35);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(15, 233, 760, 340);
        pane.getViewport().setBackground(new Color(3,45,48));
        pane.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        panel.add(pane);
            //* --> connection to driver data to show in table
            try {
                DBCon c = new DBCon();
                String q="SELECT * FROM driver";
                ResultSet resultset = c.statement.executeQuery(q);
                while(resultset.next()) {
                    model.addRow(new Object[] {
                        resultset.getString("driverID"),
                        resultset.getString("name"),
                        resultset.getString("mbNumber"),
                        resultset.getString("carCompany"),
                        resultset.getString("carModel"),
                        resultset.getString("Available")
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        //! Adding Buttons
        //?Search Button
        JButton b1 = new JButton("Display");
        b1.setBounds(230,180,150,25);
        b1.setFont(FontLoader.getButtonFont(17));
        b1.setForeground(Color.BLACK);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0); // clears all previous rows from the table before adding new data
                String q ="SELECT * FROM driver WHERE carModel ='"+ch.getSelectedItem()+"'";
                try {
                    DBCon c =new DBCon();
                    ResultSet resultset = c.statement.executeQuery(q);
                    while(resultset.next()) {
                        model.addRow(new Object[] {
                            resultset.getString("driverID"),
                            resultset.getString("name"),
                            resultset.getString("mbNumber"),
                            resultset.getString("carCompany"),
                            resultset.getString("carModel"),
                            resultset.getString("Available")
                        });
                    }
                } catch(Exception E) {
                    E.printStackTrace();
                }
            }
        });
        //?Back Button
        JButton b2 = new JButton("Back");
        b2.setBounds(420,180,150,25);
        b2.setFont(FontLoader.getButtonFont(17));
        b2.setForeground(Color.BLACK);
        panel.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Reception();
            }
        });

        //!Main Frame
        setUndecorated(true);
        setLayout(null);
        setSize(800,600);
        setLocation(500,100);
        setVisible(true);
    }


    public static void main(String[] args) {
        FontLoader.Fonts();
        new PickUp();
    }
}
