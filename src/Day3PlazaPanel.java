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

public class Day3PlazaPanel extends JPanel implements ActionListener {
    private Player player;
    private ArrayList<String> speech;
    private int speechIdx;
    private String dialogue;
    private Town town;

    private JFrame enclosingFrame;

    private BufferedImage background;
    private BufferedImage playerStand;
    private BufferedImage Riyun;
    private BufferedImage Needle;
    private BufferedImage Stella;
    private BufferedImage Nancy;
    private BufferedImage mayorStand;

    private TextField message;

    private JButton button;

    private Clip sound;

    public Day3PlazaPanel (JFrame frame) {
        player = GraphicsPanel.getPlayer();
        town = GraphicsPanel.getTown();
        speech = new ArrayList<>();
        speechIdx = 0;

        speech.add("Hello hello! Good afternoon, my fellow townspeople!");
        speech.add("I, Micheal Whitlock, have gathered us here today as no longer just a man with a dream, but as a proud mayor.");
        speech.add("For today, we commemorate the start of growth, the procedure of progress, and the humble beginnings of a new community.");
        speech.add("That's right people, hah haa!");
        speech.add("Today is the official grand opening of our town, " + town.getName() + "!");
        speech.add("There was a scattered applause, and a cheer from Needle. Micheal smiles.");
        speech.add("He looks around, his smile wide and bright.");
        speech.add("He was definately much more happier and more collected than he was yesterday.");
        speech.add("His eyes sparkled a radiant blue under the sun.");
        speech.add("Yet..");
        speech.add("Things still felt off-putting.");
        speech.add("He spotted you, waving at you from the dirt perch.");
        speech.add("You nod politely, waving back as he continued his speech.");
        speech.add("Since a child, I've dreamed beyond possibilities, beyond my range of reach, hah haa.");
        speech.add("Always seeking to empower, to be the proud leader of something successful, something extraordinary.");
        speech.add("But, you know what, hah haa?");
        speech.add("I've always wanted a friend.");
        speech.add("Good people to be around, to put my faith and trust in.");
        speech.add("People who I can support, and in turn, can support me too, hah haa!");
        speech.add("And today, not only because of me, but also because of the hard efforts of my townsfolk, can I make that possible.");
        speech.add("I wish to lead a community where friendship, kindness, and fun could flourish, hah haa!");
        speech.add("And I promise, I'll make it all happen on this very tropical island.");
        speech.add("For you, for me, and for the new future we look forward too.");
        speech.add("And especially..");
        speech.add("He looks directly at you. The whole town faces you.");
        speech.add("For you, " + player.getName() + ".");
        speech.add("Hah haa! Why don't you come up here and share a word! We'd love to hear from you, hah haa.");
        speech.add("You nod, walking up to the perch.");
        speech.add("Say something! Cmon, you gotta share something with your fellow neighbors, hah haa!");
        speech.add("After all, this was only possible because of your choices!");
        speech.add("placeholder");
        speech.add("People cheer and applaud. Riyun smiles. Needle waves his arms like a maniac, and Nancy nods. Stella rolls her eyes.");
        speech.add("Should not print.");

        dialogue = speech.get(speechIdx);

        this.enclosingFrame = frame;

        button = new JButton("⟹");
        add(button);
        button.addActionListener(this);

        try {
            playerStand = ImageIO.read(new File("src/PlayerStand.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            mayorStand = ImageIO.read(new File("src/MichealStand.png"));
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
            background = ImageIO.read(new File("src/plaza.jpeg"));
        } catch (IOException e) {
            System.out.println(e);
        }
        playDay3Sound();
    }

    public void playDay3Sound () {
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
        g.drawImage(background, 0,-100, null);
        button.setLocation(820, 450);
        g.drawImage(mayorStand, 362, 50, null);
        g.drawImage(playerStand, 362, 220, null);
        g.drawImage(Riyun, 480, 220, null);
        g.drawImage(Needle, 725, 220, null);
        g.drawImage(Stella, 50, 220, null);
        g.drawImage(Nancy, 150, 220, null);
        g.drawImage(playerStand, 362, 220, null);
        g.setColor(Color.BLACK);
        g.fillRect(0, 400, 900, 200);
        g.setColor(Color.WHITE);
        g.drawString(dialogue, 100, 500);
    }

    public void actionPerformed(ActionEvent e) {
        if (speechIdx < speech.size() - 1) {
            if (e.getSource() instanceof JButton) {
                requestFocusInWindow();
                speechIdx++;
                dialogue = speech.get(speechIdx);
            }
        } else {
            requestFocusInWindow();
            sound.stop();
            sound.close();
            enclosingFrame.setVisible(false);
        }
        repaint();
    }
}
