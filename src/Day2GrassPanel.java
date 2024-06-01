import javax.swing.*;
import javax.imageio.ImageIO;
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

public class Day2GrassPanel extends JPanel {
    private Player player;

    private final double MOVE_AMT = 0.5;
    private JFrame enclosingFrame;
    private BufferedImage background;
    private BufferedImage playerStand;
    private BufferedImage playerRight;
    private BufferedImage playerLeft;
    private BufferedImage Riyun;
    private BufferedImage RiyunHouse;
    private BufferedImage NeedleHouse;
    private BufferedImage Needle;
    private int charWidth;
    private int charHeight;
    private Clip sound;

    public Day2GrassPanel (JFrame frame) {
        this.player = GraphicsPanel.getPlayer();

        this.enclosingFrame = frame;

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

        try {
            Riyun = ImageIO.read(new File("src/Riyun.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            Needle = ImageIO.read(new File("src/Needle.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            background = ImageIO.read(new File("src/grass.jpg"));
        } catch (IOException e) {
            System.out.println(e);
        }
        playDay2Sound();
    }

    public void playDay2Sound () {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/day2.wav").getAbsoluteFile());
            sound = AudioSystem.getClip();
            sound.open(audioInputStream);
            sound.loop(Clip.LOOP_CONTINUOUSLY);
            sound.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
    }

}
