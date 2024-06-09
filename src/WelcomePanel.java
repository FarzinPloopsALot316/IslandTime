import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WelcomePanel extends JPanel implements ActionListener {
    private static boolean demo;

    private JFrame enclosingFrame;

    private JButton demoGame;
    private JButton fullGame;

    private BufferedImage crazyImg;
    private BufferedImage playerStand;
    private BufferedImage Riyun;
    private BufferedImage Needle;
    private BufferedImage Stella;
    private BufferedImage Nancy;
    private BufferedImage background;
    private BufferedImage title;

    private Clip sound;

    public WelcomePanel (JFrame frame) {
        enclosingFrame = frame;

        try {
            background = ImageIO.read(new File("src/grass.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            playerStand = ImageIO.read(new File("src/PlayerStand.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            crazyImg = ImageIO.read(new File("src/MichealCrazy.png"));
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
            Stella = ImageIO.read(new File("src/Stella.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            Nancy = ImageIO.read(new File("src/Nancy.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            title = ImageIO.read(new File("src/title.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        demoGame = new JButton("<   Demo Game   >");
        add(demoGame);
        demoGame.addActionListener(this);

        fullGame = new JButton("<     Full Game    >");
        add(fullGame);
        fullGame.addActionListener(this);

        playSound();
    }

    public void playSound () {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/day3.wav").getAbsoluteFile());
            sound = AudioSystem.getClip();
            sound.open(audioInputStream);
            sound.loop(Clip.LOOP_CONTINUOUSLY);
            sound.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void paintComponent (Graphics g) {
        g.drawImage(background, 0,0, null);
        g.setColor(Color.pink);
        g.fillRect(325, 225, 225, 200);
        g.drawImage(title, 225, 50, null);
        g.drawImage(crazyImg, 115,225, null);
        g.drawImage(playerStand, 605, 225, null);
        g.drawImage(Riyun, 70, 475,null);
        g.drawImage(Needle, 270, 475,null);
        g.drawImage(Stella, 470, 475,null);
        g.drawImage(Nancy, 670, 475,null);
        fullGame.setLocation(355, 265);
        demoGame.setLocation(355, 345);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton && e.getSource() == demoGame) {
            requestFocusInWindow();
            demo = true;
            sound.stop();
            sound.close();
            enclosingFrame.setVisible(false);
            new MainFrame();
        } else {
            requestFocusInWindow();
            demo = false;
            sound.stop();
            sound.close();
            enclosingFrame.setVisible(false);
            new MainFrame();
        }
        repaint();
    }

    public static boolean isDemo () {
        return demo;
    }
}
