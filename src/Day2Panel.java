import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Day2Panel extends JPanel {
    private JFrame enclosingFrame;
    private BufferedImage background;

    public Day2Panel (JFrame frame) {
        enclosingFrame = frame;
        try {
            background = ImageIO.read(new File("src/islandBeach.jpg"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
