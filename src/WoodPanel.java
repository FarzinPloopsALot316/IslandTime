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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class WoodPanel extends JPanel implements ActionListener, KeyListener {
    private final double MOVE_AMT = 0.4;
    private JFrame enclosingFrame;
    private Player player;

    private BufferedImage playerStand;
    private BufferedImage playerRight;
    private BufferedImage playerLeft;
    private BufferedImage wood;
    private BufferedImage grassField;
    private boolean[] pressedKeys;
    private int woodCount;
    private int woodHeight;
    private int woodWidth;
    private Clip sound;

    public WoodPanel (JFrame enclosingFrame) {
        this.enclosingFrame = enclosingFrame;
        player = GraphicsPanel.getPlayer();
        woodCount = 0;
        pressedKeys = new boolean[128];
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
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
            grassField = ImageIO.read(new File("src/grass.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            wood = ImageIO.read(new File("src/wood.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        playIntro();
    }

    public void playIntro () {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Intro.wav").getAbsoluteFile());
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
        g.drawImage(grassField, 0, 0, null);
        g.drawImage(playerStand, (int) player.getXCoord(), (int) player.getYCoord(), player.getWidth(), player.getHeight(), null);
        //player moves left (a)
        if (pressedKeys[65]) {
            player.moveLeft();
            g.drawImage(playerLeft, (int) player.getXCoord(), (int) player.getYCoord(), player.getWidth(), player.getHeight(), null);
        }

        // player moves right (d)
        if (pressedKeys[68]) {
            player.moveRight();
            g.drawImage(playerRight, (int) player.getXCoord(), (int) player.getYCoord(), player.getWidth(), player.getHeight(), null);
        }

        // player moves up (w)
        if (pressedKeys[87]) {
            player.moveUp();
        }

        // player moves down (s)
        if (pressedKeys[83]) {
            player.moveDown();
        }
    }

    public void keyTyped(KeyEvent e) { }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = true;
        System.out.println(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = false;
    }

    public void actionPerformed(ActionEvent e) {

    }
}
