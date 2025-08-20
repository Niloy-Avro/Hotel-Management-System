package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash() {
        ImageIcon splashImage = new ImageIcon(ClassLoader.getSystemResource("icon/splash.gif"));
        Image splashImage1 = splashImage.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon splashImage2 = new ImageIcon(splashImage1);
        JLabel label = new JLabel(splashImage2);
        label.setBounds(0, 0, 600, 300);
        add(label);

        setUndecorated(true);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        setLocation(400,270);
        setSize(600,300);
        setVisible(true);
        // Set window title bar icon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        setIconImage(icon.getImage());


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