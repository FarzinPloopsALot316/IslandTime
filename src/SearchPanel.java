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

public class SearchPanel extends JPanel implements ActionListener {
    private int beachIdx;
    private int woodsIdx;
    private int cliffIdx;
    private String beachDialogue;
    private String woodsDialogue;
    private String cliffDialogue;
    private boolean beachReq;
    private boolean woodsReq;
    private boolean cliffReq;
    private int searches;

    private JFrame enclosingFrame;
    private BufferedImage grass;
    private BufferedImage beach;
    private BufferedImage woods;
    private BufferedImage cliff;
    private BufferedImage player;
    private BufferedImage ew;
    private JButton bButton;
    private JButton wButton;
    private JButton cButton;
    private JButton beachArea;
    private JButton woodsArea;
    private JButton cliffArea;
    private JButton eerie;
    private ArrayList<String> beachSearch;
    private ArrayList<String> woodsSearch;
    private ArrayList<String> cliffSearch;
    private Clip sound;

    public SearchPanel (JFrame frame) {
        searches = 0;
        beachIdx = 0;
        woodsIdx = 0;
        cliffIdx = 0;
        beachReq = false;
        woodsReq = false;
        cliffReq = false;
        enclosingFrame = frame;

        bButton = new JButton("⟹");
        add(bButton);
        bButton.addActionListener(this);

        wButton = new JButton("⟹");
        add(wButton);
        wButton.addActionListener(this);

        cButton = new JButton("⟹");
        add(cButton);
        cButton.addActionListener(this);

        woodsArea = new JButton("Search through the woods?");
        add(woodsArea);
        woodsArea.addActionListener(this);

        beachArea = new JButton("Search around the beach shore?");
        add(beachArea);
        beachArea.addActionListener(this);

        cliffArea = new JButton("Search the cliff?");
        add(cliffArea);
        cliffArea.addActionListener(this);

        eerie = new JButton("\"Look I'm sorry, we tried everything we could. We can't find your daughter.\"");
        add(eerie);
        eerie.addActionListener(this);

        beachSearch = new ArrayList<>();
        woodsSearch = new ArrayList<>();
        cliffSearch = new ArrayList<>();

        beachSearch.add("You look around the shore in hopes that maybe Micheal will be there.");
        beachSearch.add("You found nothing but the calming breeze of the waters swaying avast.");
        beachSearch.add("Calling out his name, nothing reciprocated except for the calls of seagulls and the gush of the ocean.");
        beachSearch.add("Micheal wasn't here.");
        beachSearch.add("Should not print.");

        woodsSearch.add("You look around the heavy vegetation of the woods and it's massive trees, calling for Micheal.");
        woodsSearch.add("Nothing but the chirps of birds responded to your requests.");
        woodsSearch.add("Micheal wasn't here.");
        woodsSearch.add("Should not print.");

        cliffSearch.add("Look away, she won't be a problem anymore.");
        cliffSearch.add("Should not print.");

        beachDialogue = beachSearch.get(beachIdx);
        woodsDialogue = woodsSearch.get(woodsIdx);
        cliffDialogue = cliffSearch.get(cliffIdx);

        try {
            grass = ImageIO.read(new File("src/grass.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            beach = ImageIO.read(new File("src/islandBeach.jpg"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            woods = ImageIO.read(new File("src/woods.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            cliff = ImageIO.read(new File("src/CliffSide.jpg"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            player = ImageIO.read(new File("src/PlayerStand.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            ew = ImageIO.read(new File("src/GRRR.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

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

    public void playStatic() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/radio.wav").getAbsoluteFile());
            sound = AudioSystem.getClip();
            sound.open(audioInputStream);
            sound.loop(Clip.LOOP_CONTINUOUSLY);
            sound.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void paintComponent (Graphics g) {
        if (searches < 3) {
            g.drawImage(grass, 0, 0, null);
            g.drawImage(player, 345, 389, null);
            bButton.setLocation(-820, -450);
            wButton.setLocation(-820, -450);
            cButton.setLocation(-820, -450);
            eerie.setLocation(-320, -290);
            beachArea.setLocation(320, 100);
            woodsArea.setLocation(330, 200);
            cliffArea.setLocation(360, 300);
            if (beachReq) {
                bButton.setLocation(820, 450);
                wButton.setLocation(-820, -450);
                cButton.setLocation(-820, -450);
                eerie.setLocation(-320, -290);
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, 900, 600);
                g.drawImage(beach, 45, 0, null);
                g.setColor(Color.BLACK);
                g.fillRect(0, 400, 900, 200);
                beachArea.setLocation(-820, -400);
                woodsArea.setLocation(-820, -400);
                cliffArea.setLocation(-820, -400);
                g.setColor(Color.green);
                g.drawString(beachDialogue, 100, 500);
            }
            if (woodsReq) {
                bButton.setLocation(-820, -450);
                wButton.setLocation(820, 450);
                cButton.setLocation(-820, -450);
                eerie.setLocation(-320, -290);
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, 900, 600);
                g.drawImage(woods, 0, 0, null);
                g.setColor(Color.BLACK);
                g.fillRect(0, 400, 900, 200);
                beachArea.setLocation(-820, -400);
                woodsArea.setLocation(-820, -400);
                cliffArea.setLocation(-820, -400);
                g.setColor(Color.green);
                g.drawString(woodsDialogue, 100, 500);
            }
            if (cliffReq) {
                bButton.setLocation(-820, -450);
                wButton.setLocation(-820, -450);
                cButton.setLocation(820, 450);
                eerie.setLocation(-320, -290);
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, 900, 600);
                g.drawImage(cliff, 0, 0, null);
                g.drawImage(ew, 500, 125, null);
                g.setColor(Color.BLACK);
                g.fillRect(0, 400, 900, 200);
                beachArea.setLocation(-820, -400);
                woodsArea.setLocation(-820, -400);
                cliffArea.setLocation(-820, -400);
                g.setColor(Color.green);
                g.drawString(cliffDialogue, 100, 500);
            }
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(0,0,900,600);
            g.drawImage(player, 345, 389, null);
            bButton.setLocation(-820, -450);
            wButton.setLocation(-820, -450);
            cButton.setLocation(-820, -450);
            beachArea.setLocation(-320, -100);
            woodsArea.setLocation(-330, -200);
            cliffArea.setLocation(-360, -300);
            eerie.setLocation(180, 290);
        }

        if (searches == 4) {
            sound.stop();
            sound.close();
            enclosingFrame.setVisible(false);
            new Day2MichealFrame();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton && e.getSource() == beachArea && beachIdx < beachSearch.size() - 1) {
            beachReq = true;
        } else if (e.getSource() instanceof JButton && e.getSource() == woodsArea && woodsIdx < woodsSearch.size() - 1) {
            woodsReq = true;
        } else if (e.getSource() instanceof JButton && e.getSource() == cliffArea && cliffIdx < cliffSearch.size() - 1) {
            sound.stop();
            sound.close();
            playStatic();
            try {
                player = ImageIO.read(new File("src/lostPlayer.png"));
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
            cliffReq = true;
        } else if (e.getSource() instanceof JButton && e.getSource() == bButton && beachIdx < beachSearch.size() - 1) {
            requestFocusInWindow();
            beachIdx++;
            beachDialogue = beachSearch.get(beachIdx);
            repaint();
            if (beachIdx == 4) {
                searches++;
                beachReq = false;
            }
        } else if (e.getSource() instanceof JButton && e.getSource() == wButton && woodsIdx < woodsSearch.size() - 1) {
            requestFocusInWindow();
            woodsIdx++;
            woodsDialogue = woodsSearch.get(woodsIdx);
            repaint();
            if (woodsIdx == 3) {
                searches++;
                woodsReq = false;
            }
        } else if (e.getSource() instanceof JButton && e.getSource() == cButton && cliffIdx < cliffSearch.size() - 1) {
            requestFocusInWindow();
            cliffIdx++;
            cliffDialogue = cliffSearch.get(cliffIdx);
            repaint();
            if (cliffIdx == 1) {
                searches++;
                cliffReq = false;
            }
        } else if (e.getSource() instanceof JButton && e.getSource() == eerie) {
            requestFocusInWindow();
            searches++;
        }
        repaint();
    }
}
