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

public class Night1Panel extends JFrame implements ActionListener {
    private JFrame enclosingFrame;
    private BufferedImage mayorImg;
    private BufferedImage playerStand;
    private BufferedImage background;
    private Clip sound;
    private JButton button;
    private ArrayList<String> strings;
    private int idx;
    private String dialogue;

    public Night1Panel (JFrame frame) {
        button = new JButton("⟹");
        add(button);
        button.addActionListener(this);
        enclosingFrame = frame;
        try {
            playerStand = ImageIO.read(new File("src/PlayerStand.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            mayorImg = ImageIO.read(new File("src/MichealStand.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            background = ImageIO.read(new File("src/campfire.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        playIntro();
        strings = new ArrayList<>();
        strings.add("Oh wonderful! You found all the wood! Hah haa!");
        strings.add("How sweet! Our camp fire is ablaze, and the view is like nothing before on this night!");
        strings.add("Micheal's phone rings. He picks it up."); //2 pink
        strings.add("Hello! Who is this?");
        strings.add("Oh golly, 2 visitors!! This is amazing!!");
        strings.add("Hah haa! Yes yes, have then over by tomorrow! I will gladly arrange their plots.");
        strings.add("Hah haa, you too!");
        strings.add("He hangs up. Micheal smiles, looking at you, meeting your gaze."); //7 pink
        strings.add("Did you hear that! Two more villagers! We're already making so many friends!!");
        strings.add("You smile politely, starting to feel dizzy. You needed rest after a long day."); //9 pink
        strings.add("Hah haa... you look tired. I'll let you sleep.");
        strings.add("I'll get you some more anesthesia, if you want.");
        strings.add("Hah haa. I'm joking silly.");
        strings.add("Sweet dreams..."); //13
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
        g.fillRect(0, 0, 900, 600);
        g.drawImage(background,0, 0, null);
        g.fillRect(0, 400, 900, 200);
        button.setLocation(820, 450);
        g.setColor(Color.white);
        if (idx == 2 || idx == 7 || idx == 9) {
            g.setColor(Color.green);
        }
        g.drawString(dialogue, 100, 500);
    }
    public void actionPerformed(ActionEvent e) {
        if (idx < strings.size() -1) {
            if (e.getSource() instanceof JButton) {
                requestFocusInWindow();
                idx++;
                dialogue = strings.get(idx);
                repaint();
            }
        } else {
            sound.stop();
            sound.close();
            enclosingFrame.setVisible(false);
        }
    }
}
