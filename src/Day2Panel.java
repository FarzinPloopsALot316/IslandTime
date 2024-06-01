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
    private ArrayList<String> day2List;
    private int idx;
    private String dialogue;

    private JFrame enclosingFrame;
    private BufferedImage background;
    private BufferedImage mayorImg;
    private BufferedImage mayorLeft;
    private BufferedImage crazyImg;
    private BufferedImage playerStand;
    private BufferedImage playerLeft;
    private BufferedImage playerRight;
    private BufferedImage Riyun;
    private BufferedImage Needle;
    private JButton button;
    private Clip sound;

    public Day2Panel (JFrame frame) {
        idx = 0;
        riyun = new Villager("Riyun", "hiissss..", 17);
        needle = new Villager("Needle", "uwu", 17);
        mayor = GraphicsPanel.getMicheal();
        player = GraphicsPanel.getPlayer();
        day2List = new ArrayList<>();
        day2List.add("Ah, there you are, " + player.getName() + "! We were all just anxious to see you, hah haa!");
        day2List.add("Our new villagers arrived via Pilot's plane whilst you were asleep.");
        day2List.add("I've talked with these two, and they've happily agreed to move in with us on the island!");
        day2List.add("Isn't that right, friends?");
        day2List.add("yaasss uwu"); // 4, magenta
        day2List.add("Yeah sure."); //5, cyan
        day2List.add("Alrighty! Time to introduce our new buddies.");
        day2List.add("This is Riyun! He's the totally rad and gothic dude who'll be living on Plot 2."); //7
        day2List.add("Don't be too scared of his fangs and snake like tongue. He doesn't bite, hah haa!");
        day2List.add("Say hi, Riyun!");
        day2List.add("Riyun: Hey."); //10, cyan
        day2List.add("And this is Needle! He's got the craziest, coolest hairstyle and loves k pop."); //11
        day2List.add("He loves archery too! I bet he'll be a great neighbor for Riyun on Plot 3.");
        day2List.add("Greet yourself, Needle!");
        day2List.add("Needle: oh my gosh haiiiiiiiii :3 uwu TwT :P"); //14, magenta
        day2List.add("Well, with all said and done, these are our two very new residents!");
        day2List.add("A scream echoes in the distance. It sounded like a girl who was in distress."); //16, green
        day2List.add("It did feel distant... but also... somewhat close."); //17, green
        day2List.add("Riyun: What was that? The heck?"); //18, cyan
        day2List.add("Needle: oh erm that aint sound right pookie!..."); //19, magenta
        day2List.add("Oh... maybe it was a eagle. A lot of those screeching eagles live here, hah haa!");
        day2List.add("Don't worry about it, all's good! Hah haa.");
        day2List.add("Well, I got some things to check on alright! While I'm gone, why don't you three get along together?");
        day2List.add("Walk further down the island and your houses will be there! Including yours, " + player.getName() + "!");
        day2List.add("Have fun and get along! I'll be back in a jiffy, hah haa!");

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
            mayorLeft = ImageIO.read(new File("src/MichealLeft.png"));
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
        dialogue = day2List.get(idx);
        playDay2Sound();
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

    public void playScream2 () { // do not loop
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/scream2.wav").getAbsoluteFile());
            sound = AudioSystem.getClip();
            sound.open(audioInputStream);
            sound.start();
        } catch (Exception e) {
            System.out.println(e);
        }
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
        //for cyan: indexes 5, 10, 18
        //for magenta: indexes 4, 14, 19
        //for green: indexes 16, 17
        //for scream: index 16
        g.fillRect(0, 0, 900, 600);
        g.drawImage(background,45, 0, null);
        g.fillRect(0, 400, 900, 200);
        if (idx == 7) {
            g.drawImage(Riyun, 350,220, null);
        } else {
            g.drawImage(Riyun, 200,220, null);
        }

        if (idx == 11) {
            g.drawImage(Needle, 350,220, null);
        } else {
            g.drawImage(Needle, 40,220, null);
        }

        g.setColor(Color.WHITE);
        if (idx == 5 || idx == 10 || idx == 18) {
            g.setColor(Color.CYAN);
        }
        if (idx == 4 || idx == 14 || idx == 19) {
            g.setColor(Color.MAGENTA);
        }
        if (idx == 16 || idx == 17) {
            g.setColor(Color.GREEN);
        }
        if (idx == 16) {
            sound.stop();
            sound.close();
            playScream2();
        }
        if (idx == 18) {
            sound.stop();
            sound.close();
            playDay2Sound();
        }
        if (idx >= 7 && idx <= 11) {
            g.drawImage(mayorLeft, 450,220, null);
        } else if (idx >= 16 && idx <= 19) {
            g.drawImage(crazyImg, 450,220, null);
        } else {
            g.drawImage(mayorImg, 450,220, null);
        }
        button.setLocation(820, 450);
        g.drawImage(playerStand, 660,220, null);
        g.drawString(dialogue, 100, 500);
    }

    public void actionPerformed(ActionEvent e) {
        if (idx < day2List.size() -1) {
            if (e.getSource() instanceof JButton) {
                requestFocusInWindow();
                idx++;
                dialogue = day2List.get(idx);
                repaint();
            }
        } else {
            sound.stop();
            sound.close();
            enclosingFrame.setVisible(false);
        }
    }
}
