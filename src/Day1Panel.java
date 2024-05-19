import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Day1Panel extends JPanel implements ActionListener{

    private BufferedImage mayorImg;
    private BufferedImage crazyImg;
    private BufferedImage mayorRight;
    private BufferedImage mayorLeft;
    private BufferedImage planeBackground;
    private JButton button;
    private JFrame enclosingFrame;

    public Day1Panel (JFrame frame) {
        enclosingFrame = frame;
        try {
            mayorImg = ImageIO.read(new File("src/MichealStand.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            crazyImg = ImageIO.read(new File("src/MichealCrazy.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            mayorRight = ImageIO.read(new File("src/MichealRight.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            mayorLeft = ImageIO.read(new File("src/MichealLeft.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            planeBackground = ImageIO.read(new File("src/plane.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        button = new JButton("⟹");
        add(button);
        button.addActionListener(this);
    }

    public void paintComponent (Graphics g) {
        g.fillRect(0, 0, 900, 600);
        g.drawImage(planeBackground,46, 0, null);
        g.fillRect(0, 400, 900, 200);
        button.setLocation(820, 450);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
