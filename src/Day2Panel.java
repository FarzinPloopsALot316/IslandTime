import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Day2Panel extends JPanel implements ActionListener {
    private JFrame enclosingFrame;
    private BufferedImage background;
    private BufferedImage mayorImg;
    private BufferedImage crazyImg;
    private BufferedImage playerStand;
    private BufferedImage playerLeft;
    private BufferedImage playerRight;
    private JButton button;

    public Day2Panel (JFrame frame) {
        enclosingFrame = frame;
        try {
            background = ImageIO.read(new File("src/islandBeach.jpg"));
        } catch (IOException e) {
            System.out.println(e);
        }

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
            playerStand = ImageIO.read(new File("src/PlayerStand.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            playerLeft = ImageIO.read(new File("src/PlayerLeft.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            playerRight = ImageIO.read(new File("src/PlayerRight.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        button = new JButton("⟹");
        add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
