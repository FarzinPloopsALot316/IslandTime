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

public class Day2MichealPanel extends JPanel implements ActionListener {
    private ArrayList<String> mayorList;
    private int idx;
    private String dialogue;

    private JFrame enclosingFrame;
    private BufferedImage mayorImg;
    private BufferedImage crazyImg;
    private BufferedImage playerStand;
    private BufferedImage background;
    private JButton button;
    private JButton youWeird;
    private JButton wasWorried;
    private Clip sound;

    public Day2MichealPanel (JFrame frame) {
        mayorList = new ArrayList<>();
        mayorList.add("Oh. Hi! Hah haa!");
        mayorList.add("Y-you were looking for me?");
        mayorList.add("You worried so much for me???? You had concern for me??? You cared for me?");
        mayorList.add("I-I knew you were a good friend I-");
        mayorList.add("Ah.. hahh.. wha..");
        mayorList.add("Ah.. oh.. I see.. I'm just, ahem.");
        mayorList.add("Sorry about that, hah haa!..");
        mayorList.add("You must have spent all day looking for little ol' me.."); //7

        mayorList.add("WHAT'S WRONG WITH ME? HOW DARE YOU! I'M NOT WEIRD. I'M NOT INSANE. NOTHINGS WRONG WITH ME!"); //8 red

        mayorList.add("You're so kind... You're so special... I just..-"); //9 blue

        mayorList.add("I- well. Ugh, sorry! Can't think!"); //10
        mayorList.add("Two more villagers will be arriving tomorrow.");
        mayorList.add("Can't wait for you to meet them, hah haa.");
        mayorList.add("Our town is growing so much... this calls for a celebration!");
        mayorList.add("I'll be holding a town meeting for all of us. A ceremonial speech for our growth, hah haa!");
        mayorList.add("He looked up at the sky, then at you. His eyes didn't hold that same comfort they did before."); //15 green
        mayorList.add("Well, the sun is already setting!");
        mayorList.add("Why don't you go hang out with your villager buddies then call it a day? Hah haa!");
        mayorList.add("I'll see you tomorrow morning!");
        mayorList.add("I'm gonna be a bit busy tonight. I won't be here to talk for now.");
        mayorList.add("I'll see you tomorrow morning, though.");
        mayorList.add("See you later, hah haa!");

        mayorList.add("For the night, you go to your house to sleep."); //22 red
        mayorList.add("Suddenly, a pain sears across your head.");
        mayorList.add("It spreads through your body, to every vein and bone.");
        mayorList.add("Your legs burn with a pain, like a bone was broken.");
        mayorList.add("You try to get up, and when you try to scream, nothing comes out.");
        mayorList.add("You're tied down somewhere. You can't see anything.");
        mayorList.add("And so you try to sleep the pain away.");
        dialogue = mayorList.get(idx);

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
            playerStand = ImageIO.read(new File("src/PlayerStand.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            background = ImageIO.read(new File("src/grass.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        button = new JButton("⟹");
        add(button);
        button.addActionListener(this);

        youWeird = new JButton("The heck is wrong with you?");
        add(youWeird);
        youWeird.addActionListener(this);

        wasWorried = new JButton("Yeah, I got concerned!");
        add(wasWorried);
        wasWorried.addActionListener(this);
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

    public void playStatic () {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Static.wav").getAbsoluteFile());
            sound = AudioSystem.getClip();
            sound.open(audioInputStream);
            sound.loop(Clip.LOOP_CONTINUOUSLY);
            sound.start();
        } catch (Exception e) {
            System.out.println(e);
        }
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

    public void paintComponent (Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,900,600);
        g.drawImage(background, 0, 0, null);
        g.fillRect(0, 400, 900, 200);
        button.setLocation(820,450);
        wasWorried.setLocation(-690, -430);
        youWeird.setLocation(-690, -470);

        if (idx == 7) {
            button.setLocation(-820,-450);
            wasWorried.setLocation(670, 430);
            youWeird.setLocation(670, 470);
        }

        if (idx == 9) {
            g.setColor(Color.BLUE);
        } else if (idx == 8) {
            g.setColor(Color.RED);
        } else if (idx == 15) {
            g.setColor(Color.GREEN);
        } else {
            g.setColor(Color.WHITE);
        }

        if (idx == 9) {
            sound.stop();
            sound.close();
        }

        if (idx == 8) {
            sound.stop();
            sound.close();
            playStatic();
        }

        if (idx == 10) {
            sound.stop();
            sound.close();
            playDay2Sound();
        }

        if (idx == 22) {
            sound.stop();
            sound.close();
            playStatic();
        }

        if (idx >= 22) {
            g.setColor(Color.BLACK);
            g.fillRect(0,0,900,600);
            button.setLocation(820,450);
            g.setColor(Color.RED);
        } else if (idx < 4 || idx == 8) {
            g.drawImage(playerStand, 500,220, null);
            g.drawImage(crazyImg, 250,220, null);
        } else {
            g.drawImage(playerStand, 500,220, null);
            g.drawImage(mayorImg, 250,220, null);
        }

        g.drawString(dialogue, 100, 500);
    }

    public void actionPerformed(ActionEvent e) {
        if (idx < mayorList.size() - 1) {
            if (e.getSource() instanceof JButton && e.getSource() == youWeird) {
                requestFocusInWindow();
                idx = 8;
                dialogue = mayorList.get(idx);
                repaint();
            } else if (e.getSource() instanceof JButton && idx == 8) {
                requestFocusInWindow();
                idx = 10;
                dialogue = mayorList.get(idx);
                repaint();
            } else if (e.getSource() instanceof JButton && e.getSource() == wasWorried) {
                requestFocusInWindow();
                idx = 9;
                dialogue = mayorList.get(idx);
                repaint();
            } else if (e.getSource() instanceof JButton) {
                requestFocusInWindow();
                idx++;
                dialogue = mayorList.get(idx);
                repaint();
            }
        } else {
            sound.stop();
            sound.close();
            enclosingFrame.setVisible(false);
            new Day3Frame();
        }
    }
}
