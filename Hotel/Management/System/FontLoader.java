package Hotel.Management.System;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FontLoader {

    private static Font headingFont;
    private static Font labelFont;
    private static Font buttonFont;
    private static Font textFont;

    public static void Fonts() {
        try {
            headingFont = Font.createFont(Font.TRUETYPE_FONT, new File("P:/Hotel-Management-System/src/Resources/CS-Rocky-Vintage.otf"));
            labelFont = Font.createFont(Font.TRUETYPE_FONT, new File("P:/Hotel-Management-System/src/Resources/Rafine-Semibold.otf"));
            buttonFont = Font.createFont(Font.TRUETYPE_FONT, new File("P:/Hotel-Management-System/src/Resources/Quano.otf"));
            textFont = Font.createFont(Font.TRUETYPE_FONT, new File("P:/Hotel-Management-System/src/Resources/poppins.regular.ttf"));

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(headingFont);
            ge.registerFont(labelFont);
            ge.registerFont(buttonFont);
            ge.registerFont(textFont);

            System.out.println("All fonts loaded successfully!");
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    // Getter methods
    public static Font getHeadingFont(float size) {
        return headingFont.deriveFont(size);
    }

    public static Font getLabelFont(float size) {
        return labelFont.deriveFont(size);
    }

    public static Font getButtonFont(float size) {
        return buttonFont.deriveFont(size);
    }
    public static Font getTextFont(float size) {
        return textFont.deriveFont(size);
    }

}
