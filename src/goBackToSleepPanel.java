import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class goBackToSleepPanel extends JFrame {
    private JFrame enclosingFrame;
    private BufferedImage image;

    public goBackToSleepPanel (JFrame frame) {
        this.enclosingFrame = frame;

        try {
            image = ImageIO.read(new File("src/basement.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void paintComponent (Graphics g) {
        g.drawImage(image, 50, 0, null);
        g.fillRect(0, 400, 900, 200);
        g.setColor(Color.RED);
        g.drawString("Go back to sleep... I'm not done with you.", 100, 500);
    }

}
