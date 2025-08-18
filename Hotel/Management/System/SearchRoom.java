package Hotel.Management.System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {
    SearchRoom() {
        //!Panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,790,590);
        panel.setLayout(null);
        add(panel);

        //!Adding Label
        //?Heading Label
        JLabel label = new JLabel("Search For Room ");
        label.setBounds(270,18,250,31);
        label.setForeground(Color.WHITE);
        label.setFont(FontLoader.getHeadingFont(23));
        panel.add(label);
        //?CheckBox
        JCheckBox ch1 = new JCheckBox("Only Display Available");
        ch1.setBounds(470,100,205,23);
        ch1.setForeground(Color.WHITE);
        ch1.setBackground(new Color(3,45,48));
        ch1.setFont(FontLoader.getLabelFont(15));
        panel.add(ch1);
        //?Adding label to Search by Bed type
        JLabel label1 = new JLabel("Search For Bed Type ");
        label1.setBounds(110,94,160,40);
        label1.setForeground(Color.WHITE);
        label1.setFont(FontLoader.getTextFont(14));
        panel.add(label1);
            //* --->choice
            Choice c1 = new Choice();
            c1.add("Single Bed");
            c1.add("Double Bed");
            c1.setBounds(270,100,150,20);
            c1.setFont(FontLoader.getTextFont(14));
            panel.add(c1);


        //! add table
        String[] columnNames = {"Room Number", "Availability", "Price", "Bed Type", "Status"};
        Object[][] data = {};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(3,45,48));
        table.setFont(FontLoader.getTextFont(14));
        table.setRowHeight(35);
        table.getTableHeader().setFont(FontLoader.getLabelFont(15));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setBackground(new Color(3,45,48));
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(15, 233, 760, 340);
        pane.getViewport().setBackground(new Color(3,45,48));
        pane.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        panel.add(pane);
        //!database connection to show data in table
        try {
            DBCon c = new DBCon();
            String q = "SELECT * FROM room";
            ResultSet resultSet = c.statement.executeQuery(q);
            while(resultSet.next()) {
                model.addRow(new Object[] {
                        resultSet.getString("roomnumber"),
                        resultSet.getString("availability"),
                        resultSet.getString("price"),
                        resultSet.getString("bed_type"),
                        resultSet.getString("cleaning_status")
                });
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        //!Adding Buttons
        //?Search Button
        JButton b1 = new JButton("Search");
        b1.setBounds(230,180,150,25);
        b1.setFont(FontLoader.getButtonFont(17));
        b1.setForeground(Color.BLACK);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "SELECT * FROM room WHERE bed_type = '"+c1.getSelectedItem()+"'";
                String q1 = "SELECT * FROM room WHERE availability = 'Available' AND bed_type = '"+c1.getSelectedItem()+"'";
                try {
                    DBCon c = new DBCon();
                    ResultSet resultSet1 = c.statement.executeQuery(q);
                    model.setRowCount(0);
                    while(resultSet1.next()) {
                        model.addRow(new Object[] {
                            resultSet1.getString("roomnumber"),
                            resultSet1.getString("availability"),
                            resultSet1.getString("availability"),
                            resultSet1.getString("price"),
                            resultSet1.getString("bed_type"),
                            resultSet1.getString("cleaning_status")
                        });
                    }
                    if(ch1.isSelected()) {
                        model.setRowCount(0);
                        ResultSet resultSet2 = c.statement.executeQuery(q1);
                        while(resultSet2.next()) {
                            model.addRow(new Object[] {
                                resultSet2.getString("roomnumber"),
                                resultSet2.getString("availability"),
                                resultSet2.getString("availability"),
                                resultSet2.getString("price"),
                                resultSet2.getString("bed_type"),
                                resultSet2.getString("cleaning_status")
                            });
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
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
        new SearchRoom();
    }
}
