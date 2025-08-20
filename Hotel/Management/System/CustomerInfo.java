package Hotel.Management.System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame {

    JButton btn;

    CustomerInfo(){
        //!Panel
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(3, 45, 48));
        panel.setLayout(null);
        add(panel);
        //!Adding Label
        //? adding the heading
        JLabel label1 = new JLabel("Customer Details");
        label1.setBounds(320,12,400,50);
        label1.setFont(FontLoader.getHeadingFont(23));
        label1.setForeground(Color.WHITE);
        panel.add(label1);
        add(panel);

        //! add table
        String[] columnNames = {"Document", "Name", "ID Number", "Room", "Deposit", "Check-in Time"};
        Object[][] data = {};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setBackground(new Color(3, 45, 48));
        table.setForeground(Color.WHITE);
        table.setFont(FontLoader.getTextFont(14));
        table.setRowHeight(30);
        table.getTableHeader().setFont(FontLoader.getLabelFont(16));
        table.getTableHeader().setBackground(new Color(3, 45, 48));
        table.getTableHeader().setForeground(Color.WHITE);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(30,77,830,420);
        pane.getViewport().setBackground(new Color(3, 45, 48));
        pane.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        panel.add(pane);
        //! database connection  to show data in table
        try {
            DBCon c = new DBCon();
            String deptData = "SELECT * FROM customer";
            ResultSet resultset = c.statement.executeQuery(deptData);
            while(resultset.next()) {
                model.addRow(new Object[] {
                    resultset.getString("document"),
                    resultset.getString("name"),
                    resultset.getString("IDnumber"),
                    resultset.getString("room"),
                    resultset.getString("deposit"),
                    resultset.getString("checkintime")
                });
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        //! add back button
        //?Back Button
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
        new CustomerInfo();
    }
}
