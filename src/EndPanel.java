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
import java.util.ArrayList;

public class EndPanel extends JPanel implements ActionListener {
    private String dialogue;
    private ArrayList<String> news;
    private int idx;
    private Player player;

    private JFrame enclosingFrame;
    private BufferedImage background;
    private BufferedImage playerStand;
    private BufferedImage micheal;
    private BufferedImage dellaine;
    private JButton button;
    private Clip tinnitus;

    public EndPanel (JFrame frame) {
        enclosingFrame = frame;

        player = GraphicsPanel.getPlayer();

        news = new ArrayList<>();
        news.add("Good morning, viewers.");
        news.add("The date is March 10, 2121.");
        news.add("Yesterday was the decade-cycled Sound Moon.");
        news.add("Around 232 deaths occurred across the nation, but the Vengeance Agency has fought well against the werewolves.");
        news.add("Civilians are doing their best to recover. Emergency personnel have already been sent to aid.");
        news.add("The agency confirmed that the moon has fully set, and that it is perfectly safe to leave your home now.");
        news.add("However, some people have gone missing.");
        news.add("After around 4 years, police has finally reopened the case for Dellaine's search, gaining another lead."); //7
        news.add("Just a month ago, another young lady by the name of " + player.getName() + " has also gone missing."); //8
        news.add("She was seen at a park bench on security cameras, where she was then brutally knocked unconscious and abducted."); //9
        news.add("The suspect seems to be related to Dellaine's search, looking to be a male adult around the age of 24.");
        news.add("Police are working hard to find the suspect and the victims."); //11
        news.add("That is all for today's main news broadcast.");
        news.add("May we all have a blessed day and recover strong from the Sound Moon.");
        news.add("The End! Thanks for playing!");

        idx = 0;
        dialogue = news.get(idx);

        try {
            background = ImageIO.read(new File("src/grass.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            playerStand = ImageIO.read(new File("src/PlayerStand.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            micheal = ImageIO.read(new File("src/MichealStand.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            dellaine = ImageIO.read(new File("src/dellaine.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        button = new JButton("⟹");
        add(button);
        button.addActionListener(this);

        playRing();
    }

    public void playRing () {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/tinnitus.wav").getAbsoluteFile());
            tinnitus = AudioSystem.getClip();
            tinnitus.open(audioInputStream);
            tinnitus.loop(Clip.LOOP_CONTINUOUSLY);
            tinnitus.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void playMusic () {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/day3.wav").getAbsoluteFile());
            tinnitus = AudioSystem.getClip();
            tinnitus.open(audioInputStream);
            tinnitus.loop(Clip.LOOP_CONTINUOUSLY);
            tinnitus.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void paintComponent (Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0, 900, 600);
        g.fillRect(0, 400, 900, 200);
        g.setColor(Color.GREEN);
        g.drawString(dialogue, 100, 500);
        button.setLocation(820,450);
        if (idx == 7) {
            g.drawImage(dellaine,361, 194, null);
        } else if (idx == 8 || idx == 9) {
            g.drawImage(playerStand,361, 194, null);
        } else if (idx == 10 || idx == 11) {
            g.drawImage(playerStand,461, 220, null);
            g.drawImage(dellaine,261, 194, null);
        }

        if (idx == 14) {
            g.drawImage(background, 0,0, null);
            g.setColor(Color.BLACK);
            g.fillRect(360, 282, 180, 25);
            g.setColor(Color.WHITE);
            g.drawString(dialogue, 360, 300);
            g.drawImage(micheal, 320, 389, null);
            try {
                playerStand = ImageIO.read(new File("src/killed.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            g.drawImage(playerStand, 420, 389, null);
        }

        if (idx == 14) {
            tinnitus.stop();
            tinnitus.close();
            playMusic();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (idx < news.size() - 1) {
            if (e.getSource() instanceof JButton) {
                requestFocusInWindow();
                idx++;
                dialogue = news.get(idx);
            }
        } else {
            tinnitus.stop();
            tinnitus.close();
            enclosingFrame.setVisible(false);
        }
        repaint(0);
    }
}
