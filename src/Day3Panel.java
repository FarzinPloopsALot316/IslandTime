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

public class Day3Panel extends JPanel implements ActionListener {
    private JFrame enclosingFrame;
    private BufferedImage bedroomInterior;
    private JButton button;
    private Player player;
    private Clip sound;
    private ArrayList<String> wakeUp;
    private String dialogue;
    private int idx;

    public Day3Panel (JFrame frame) {
        wakeUp = new ArrayList<>();

        wakeUp.add("You wake up to the sunlight's warmth upon your skin.");
        wakeUp.add("As you arise from bed, you hear the chitter and chatter of the neighbors around you.");
        wakeUp.add("Looking out the window, you see two new villagers on the island. You go out to greet them.");

        player = GraphicsPanel.getPlayer();

        this.enclosingFrame = frame;

        button = new JButton("⟹");
        add(button);
        button.addActionListener(this);

        if (Day1Panel.getHouse().equals("src/preppy.png")) {
            try {
                bedroomInterior = ImageIO.read(new File("src/bedroomPink.jpg"));
            } catch (IOException e) {
                System.out.println(e);
            }
        } else {
            try {
                bedroomInterior = ImageIO.read(new File("src/emoBedroom.jpg"));
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        idx = 0;
        dialogue = wakeUp.get(idx);

        playDay3Sound();
    }

    public void paintComponent (Graphics g) {
        g.fillRect(0, 0, 900, 600);
        g.drawImage(bedroomInterior, 0, 0, null);
        g.fillRect(0, 400, 900, 200);
        g.setColor(Color.GREEN);
        button.setLocation(820, 450);
        g.drawString(dialogue, 100, 500);
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

    public void actionPerformed(ActionEvent e) {
        if (idx < wakeUp.size() - 1) {
            if (e.getSource() instanceof JButton) {
                requestFocusInWindow();
                idx++;
                dialogue = wakeUp.get(idx);
            }
            repaint();
        } else {
            sound.stop();
            sound.close();
            enclosingFrame.setVisible(false);
            new Day3GrassFrame();
        }
    }
}
