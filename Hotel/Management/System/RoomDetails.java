package Hotel.Management.System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class RoomDetails extends JFrame {

    RoomDetails() {
        //!Panel
        JPanel panel = new JPanel(new BorderLayout(10, 10)); // Use BorderLayout with gaps
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(3, 45, 48));
        panel.setLayout(null);
        add(panel);
        //!Labels
        //? adding the heading
        JLabel label1 = new JLabel("Room Details");
        label1.setBounds(355,10,400,50);
        label1.setFont(FontLoader.getHeadingFont(23));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        //!Adding Table
        //?Setting Col name Explicitly and for data part leaving empty
        //* Ekhane String array te amra Col er Explicit nam dite parbo
        //* data namok Array te amra data store korte parbo pore tay empty ache
        //* data array 2D karon ota table er hisabe store korbe data [row number][col number]
        //* uporer column-er naam (columnNames) ebong khali data (data) diye ekta table model toiri kora hocche.
        //* ei model object-take ekta JTable-e set kora hoy, jate user table-ta dekhte paay.
        //* model.addRow() method use kore notun data (row) table-e jog kora hoy.
        String[] columnNames = {"Room Number", "Availability", "Price", "Bed Type", "Cleaning Status"};
        Object[][] data = {};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        //?Table Body Part
        JTable table = new JTable(model);
        table.setBackground(new Color(3, 45, 48));
        table.setForeground(Color.WHITE);
        table.setFont(FontLoader.getTextFont(14));
        table.setRowHeight(30);
        //? Table Header Part
        table.getTableHeader().setFont(FontLoader.getLabelFont(17));
        table.getTableHeader().setBackground(new Color(3, 45, 48));
        table.getTableHeader().setForeground(Color.WHITE);
        //? JTable must be placed inside a JScrollPane
        //* Opore sundor kore column-er naam gulo dekha jabe, ebong tar niche data thakbe.
        //* Jokhon data gulo screen-er theke beshi hoye jabe, JScrollPane automatically ekta vertical scrollbar toiri kore debe.
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(30,77,830,420);
        pane.getViewport().setBackground(new Color(3, 45, 48));
        pane.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        panel.add(pane);

        //! database connection to show data in table
        try {
            DBCon c = new DBCon();
            String q = "SELECT * FROM room";
            ResultSet resultset = c.statement.executeQuery(q);
            while (resultset.next()) {
                model.addRow(new Object[]{
                    resultset.getString("roomnumber"),
                    resultset.getString("availability"),
                    resultset.getString("price"),
                    resultset.getString("bed_type"),
                    resultset.getString("cleaning_status")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //! add back button
        JButton btn = new JButton("BACK");
        btn.setBounds(300,530,300,30);
        btn.setForeground(Color.BLACK);
        btn.setBackground(Color.WHITE);
        btn.setFont(FontLoader.getButtonFont(17));
        panel.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Reception();
            }
        });


        //!Main frame
        setUndecorated(true);
        setLayout(null);
        setSize(900,600);
        setLocation(500,100);
        setVisible(true);
        // Set window title bar icon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        setIconImage(icon.getImage());
    }

    public static void main(String[] args) {
        FontLoader.Fonts();
        new RoomDetails();
    }
}
