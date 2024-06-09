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

public class DemoEndPanel extends JPanel implements ActionListener {
    private JFrame enclosingFrame;
    private String dialogue;
    private ArrayList<String> end;
    private int idx;
    private JButton button;
    private BufferedImage jumpscare;
    private Clip roar;
    private Clip ambience;

    public DemoEndPanel (JFrame frame) {
        enclosingFrame = frame;
        end = new ArrayList<>();
        end.add("So what's happening with the player? Who is that girl we saw?");
        end.add("Who is this Micheal guy? Are the villagers we talk with even real?");
        end.add("Is anything real here? Or is imagination hiding something?");
        end.add("Something's wrong, but what's the problem? What's going on?");
        end.add("Well, you'll just have to play the full game to know.");
        end.add(""); //5
        end.add("Thank you for listening! Any questions :3?");
        idx = 0;
        dialogue = end.get(idx);

        button = new JButton("⟹");
        add(button);
        button.addActionListener(this);

        try {
            jumpscare = ImageIO.read(new File("src/jumpscare.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void playStatic () {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/tinnitus.wav").getAbsoluteFile());
            ambience = AudioSystem.getClip();
            ambience.open(audioInputStream);
            ambience.loop(Clip.LOOP_CONTINUOUSLY);
            ambience.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void playRoar () {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/michealRoar.wav").getAbsoluteFile());
            roar = AudioSystem.getClip();
            roar.open(audioInputStream);
            roar.loop(Clip.LOOP_CONTINUOUSLY);
            roar.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        if (idx == 5) {
            playRoar();
            playStatic();
        }

        if (idx == 6) {
            roar.stop();
            roar.close();
        }

        if (idx == 5) {
            g.setColor(Color.BLACK);
            g.fillRect(0,0, 900,600);
            button.setLocation(820, 450);
            g.drawImage(jumpscare, 145, 134, null);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(0,0, 900,600);
            button.setLocation(820, 450);
            g.setColor(Color.YELLOW);
            g.drawString(dialogue, 100,500);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (idx < end.size() - 1) {
            requestFocusInWindow();
            idx++;
            dialogue = end.get(idx);
        } else {
            enclosingFrame.setVisible(false);
        }
        repaint();
    }
}
