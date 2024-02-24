import javax.swing.*;
import java.awt.*;

class Main {
    public static final String WINDOW_TITLE="Frame with Panel App";
    public static final int WINDOW_SIZE = 40;
    public static final int WINDOW_WIDTH_ASPECT_RATIO = 16;
    public static final int WINDOW_HEIGHT_ASPECT_RATIO = 9;

    public static void main(String[] args) {
        JFrame frame = new JFrame(WINDOW_TITLE);
        Panel panel = new Panel();
        // Lets make the window a 16x9 window with size of 400.
        int width = WINDOW_SIZE * WINDOW_WIDTH_ASPECT_RATIO;
        int height = WINDOW_SIZE * WINDOW_HEIGHT_ASPECT_RATIO;
        frame.setSize(width , height);
        //frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label1 = new JLabel("Here is the first line.");
        JLabel label2 = new JLabel("Here is the second line.");

        panel.add(label1);
        panel.add(label2);
        frame.add(panel);

        frame.setVisible(true);
    }
}