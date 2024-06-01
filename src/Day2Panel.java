import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Day2Panel extends JPanel implements ActionListener {
    private static Villager riyun;
    private static Villager needle;
    private static Player player;
    private static MayorVillager mayor;

    private JFrame enclosingFrame;
    private BufferedImage background;
    private BufferedImage mayorImg;
    private BufferedImage crazyImg;
    private BufferedImage playerStand;
    private BufferedImage playerLeft;
    private BufferedImage playerRight;
    private BufferedImage Riyun;
    private BufferedImage Needle;
    private JButton button;
    private Clip sound;

    public Day2Panel (JFrame frame) {
        riyun = new Villager("Riyun", "hiissss..", 17);
        needle = new Villager("Needle", "uwu", 17);
        mayor = GraphicsPanel.getMicheal();
        player = GraphicsPanel.getPlayer();

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

        button = new JButton("⟹");
        add(button);
        button.addActionListener(this);
        playDay2Sound();
    }

    public void paintComponent (Graphics g) {
        g.fillRect(0, 0, 900, 600);
        g.drawImage(background,45, 0, null);

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

    public void actionPerformed(ActionEvent e) {

    }
}
