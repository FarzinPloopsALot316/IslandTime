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

public class WoodPanel extends JPanel implements ActionListener, KeyListener {
    private final double MOVE_AMT = 0.4;
    private JFrame enclosingFrame;
    private Player player;

    private BufferedImage playerStand;
    private BufferedImage playerRight;
    private BufferedImage playerLeft;
    private BufferedImage wood;
    private BufferedImage grassField;
    private BufferedImage basement;
    private boolean[] pressedKeys;
    private int woodCount;
    private int woodHeight;
    private int woodWidth;
    private Clip sound;
    private ArrayList<Wood> logs;
    private JButton button;

    public WoodPanel (JFrame enclosingFrame) {
        button = new JButton("⟹");
        add(button);
        button.addActionListener(this);
        logs = new ArrayList<>();
        Wood wood1 = new Wood(100, 100);
        Wood wood2 = new Wood(100, 200);
        Wood wood3 = new Wood(100, 300);
        Wood wood4 = new Wood(100, 400);
        Wood wood5 = new Wood(100, 500);
        logs.add(wood1);
        logs.add(wood2);
        logs.add(wood3);
        logs.add(wood4);
        logs.add(wood5);
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
            grassField = ImageIO.read(new File("src/grass.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            wood = ImageIO.read(new File("src/wood.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            basement = ImageIO.read(new File("src/basement.jpg"));
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

    public void playSpooky () {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/spooky.wav").getAbsoluteFile());
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
        button.setLocation(-820, -450);
        g.drawImage(grassField, 0, 0, null);
        g.drawImage(playerStand, (int) player.getXCoord(), (int) player.getYCoord(), player.getWidth(), player.getHeight(), null);
        for (int i = 0; i < logs.size(); i++) {
            g.drawImage(wood, logs.get(i).getX(), logs.get(i).getY(), logs.get(i).getWidthAndHeight(), logs.get(i).getWidthAndHeight(),null);
            if (player.playerRect().intersects(logs.get(i).woodRect())) {
                woodCount++;
                logs.remove(i);
                i--;
            }
        }

        if (woodCount == 5) {
            g.fillRect(0, 0, 900, 600);
            g.drawImage(basement, 0, 0, null);
            sound.stop();
            sound.close();
            playSpooky();
            g.setColor(Color.BLACK);
            g.fillRect(0, 400, 900, 200);
            g.setColor(Color.RED);
            g.drawString("Go back to sleep... I'm, not done with you, hah haa...", 100, 500);
            button.setLocation(820, 450);
        }

        //player moves left (a)
        if (pressedKeys[65]) {
            player.moveLeft();
            g.drawImage(player.getCurrentImage(), (int) player.getXCoord(), (int) player.getYCoord(), player.getWidth(), player.getHeight(), null);
        }

        // player moves right (d)
        if (pressedKeys[68]) {
            player.moveRight();
            g.drawImage(player.getCurrentImage(), (int) player.getXCoord(), (int) player.getYCoord(), player.getWidth(), player.getHeight(), null);
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
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = false;
        player.setCurrentImage(playerStand);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            sound.stop();
            sound.close();
            enclosingFrame.setVisible(false);
            player.setX(450);
            player.setY(250);
            new Night1Frame();
        }
    }
}
