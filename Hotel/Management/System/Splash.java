package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash() {
        ImageIcon splashImage = new ImageIcon(ClassLoader.getSystemResource("icon/splash.gif"));
        Image splashImage1 = splashImage.getImage().getScaledInstance(800,500,Image.SCALE_DEFAULT);
        ImageIcon splashImage2 = new ImageIcon(splashImage1);
        JLabel label = new JLabel(splashImage2);
        label.setBounds(0, 0, 845, 600);
        add(label);

        setTitle("Hotel Management System");
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        setLocation(300, 80);
        setSize(858, 680);
        setVisible(true);


        try {
            Thread.sleep(2000);
            new Login();
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FontLoader.Fonts();
        new Splash();
    }

}