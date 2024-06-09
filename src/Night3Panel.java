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

public class Night3Panel extends JPanel implements ActionListener {

    private JFrame enclosingFrame;
    private Clip sound;
    private JButton button;
    private ArrayList<String> strings;
    private int idx;
    private String dialogue;
    private BufferedImage playerStand;
    private BufferedImage Riyun;
    private BufferedImage weirdo;
    private BufferedImage background;

    public Night3Panel (JFrame frame) {
        this.enclosingFrame = frame;

        button = new JButton("⟹");
        add(button);
        button.addActionListener( this);

        idx = 0;
        strings = new ArrayList<>();
        strings.add("You try to drift into sleep after a long day.");
        strings.add("As you eyes begin to flutter, you hear the screams and cries of somebody ringing in the distance.");
        strings.add("Your head begins to ache from the screaming. You get up to see what's happening."); //2
        strings.add("Uhm...");
        strings.add("You hearing that??? hiss...");
        strings.add("No clue what's happening. We gotta go investigate.");
        strings.add("Everybody else can't sleep, hiss...");
        strings.add("We both gotta go check it out.");
        strings.add("I don't think-");
        strings.add("...");
        strings.add("What's that?");
        strings.add("Over there.");
        strings.add(" ");
        strings.add("wake up."); //13
        strings.add("now's your chance.");
        dialogue = strings.get(idx);

        try {
            playerStand = ImageIO.read(new File("src/PlayerStand.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            Riyun = ImageIO.read(new File("src/Riyun.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            background = ImageIO.read(new File("src/nightWoods.jpg"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            weirdo = ImageIO.read(new File("src/lostPlayer.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        playScream();
    }

    public void playScream () {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/scream.wav").getAbsoluteFile());
            sound = AudioSystem.getClip();
            sound.open(audioInputStream);
            sound.loop(Clip.LOOP_CONTINUOUSLY);
            sound.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void paintComponent(Graphics g) {
        if (idx < 3 || idx >= 13) {
            super.paintComponents(g);
            g.setColor(Color.BLACK);
            g.fillRect(0,0,900,600);
            g.fillRect(0, 400, 900, 200);
            button.setLocation(820, 450);
            g.setColor(Color.RED);
            g.drawString(dialogue, 100, 500);
        } else if (idx == 12) {
            g.setColor(Color.BLACK);
            g.fillRect(0,0,900,600);
            g.drawImage(background, 0,-60,null);
            g.drawImage(playerStand, 125, 389, null);
            g.drawImage(Riyun, 25, 389, null);
            g.drawImage(weirdo, 650, 389, null);
            button.setLocation(820, 450);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(0,0,900,600);
            g.drawImage(background, 0,0,null);
            g.drawImage(playerStand, 500, 220, null);
            g.drawImage(Riyun, 300, 220, null);
            g.fillRect(0, 400, 900, 200);
            button.setLocation(820, 450);
            g.setColor(Color.CYAN);
            g.drawString(dialogue, 100, 500);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (idx < strings.size() - 1) {
            if (e.getSource() instanceof JButton) {
                requestFocusInWindow();
                idx++;
                dialogue = strings.get(idx);
            }
        } else {
            sound.stop();
            sound.close();
            enclosingFrame.setVisible(false);
            new BasementFrame();
        }
        repaint();
    }
}
