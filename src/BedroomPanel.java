import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BedroomPanel extends JPanel implements ActionListener, KeyListener {
    private Player player;
    private JFrame enclosingFrame;
    private BufferedImage letter;
    private BufferedImage background;
    private BufferedImage playerStand;
    private BufferedImage mayor;
    private JButton button;
    private Clip sound;
    private boolean[] pressedKeys;
    private ArrayList<String> letter1;
    private ArrayList<String> letter2;
    private ArrayList<String> letter3;
    private ArrayList<String> letter4;
    private int idx1;
    private int idx2;
    private int idx3;
    private int idx4;
    private String dialogue;

    public BedroomPanel (JFrame frame) {
        enclosingFrame = frame;
        player = GraphicsPanel.getPlayer();

        letter1 = new ArrayList<>();
        letter1.add("November 2, 2120");
        letter1.add("Today, she and I made eye contact,");
        letter1.add("I've been watching her for a while.");
        letter1.add("I see what time she walks out of her house, trying to get to work.");
        letter1.add("Where she works, where she lounges during her break time, who she speaks with.");
        letter1.add("I put a tracker on her car, a camera in her house, all whilst she wasn't looking.");
        letter1.add("All to plan this perfectly, to know what she does, where she goes, and what time.");
        letter1.add("But today, as I sat across the cafe from where she usually stays during her lunch break, she spotted me.");
        letter1.add("Her caramel eyes and my mint blue eyes.");
        letter1.add("She made eye contact with me.");
        letter1.add("She's perfect.");
        letter1.add("She's so beautiful.");
        letter1.add("She's my everything.");
        letter1.add("I need to know more. I need to know when I can ask her.");
        letter1.add("I need to know when she's most gullible.");
        letter1.add("She can't refuse me. I'll force her to be my friend, I'll beat it into her if I must.");
        letter1.add("She's going to be a perfect best friend.");
        letter1.add("I'm going to show Mom that I can have a human best friend.'");

        letter2 = new ArrayList<>();
        letter2.add("December 13, 2120");
        letter2.add("She waved at me today!!!");
        letter2.add("I was sitting at the cafe during the usual time and there she was.");
        letter2.add("She saw me and waved kindly at me while I was pretending to read a book.");
        letter2.add("She recognised me.");
        letter2.add("She's going to be an amazing friend.");
        letter2.add("I know it.");
        letter2.add("And when I ask her out, I know she won't refuse.");

        letter3 = new ArrayList<>();
        letter3.add("February 14, 2121");
        letter3.add("She refused me.");
        letter3.add("When I asked her out at the cafe today... she declined me.");
        letter3.add("How dare she, after all of our conversations together throughout these few months..");
        letter3.add("She thinks she's so precious.");
        letter3.add("She can only be precious to me.");
        letter3.add("That damned gothic emo brat keeps talking to her too, maybe that's why.");
        letter3.add("I'm gonna take them both, kill him, and make her my best friend forever.");
        letter3.add("I'm going to trap her in solitude forever, making me the only person she can talk to.");
        letter3.add("She'll go so crazy, she'll start loving me instead, being trapped with only me in her presence.");
        letter3.add("I'll make her have hallucinations, and those hallucinations will have ME in it.");
        letter3.add("ME! I AM THE ONLY PERSON SHE SHOULD LOVE FOR, SHOULD CARE FOR, AND SHOULD PONDER FOR!");
        letter3.add("She'll regret her words. And if she f*cking doesn't, I'll make her regret them.");

        letter4 = new ArrayList<>();
        letter4.add("February 21, 2121");
        letter4.add("I did it.");
        letter4.add("Saw her at the park on a bench, and took my chance.");
        letter4.add("Her head's bleeding. Hope that doesn't give her aches or head pain later on.");
        letter4.add("I did it. She's mine now. My best friend.");
        letter4.add("She's going to wake up soon, and I'll comfort and soothe her whilst she's blinded by pain.");
        letter4.add("She'll have no choice but to accept my warmth.");
        letter4.add("She passes out so much. I must have hti something important pretty hard.");
        letter4.add("I'm not gonna take her to the hospital. I'll just keep giving her amnesia everytime she wakes up screaming in pain.");
        letter4.add("She's my best friend now.");

        try {
            playerStand = ImageIO.read(new File("src/PlayerStand.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            mayor = ImageIO.read(new File("src/MichealCrazy.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            background = ImageIO.read(new File("src/hallway.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            letter = ImageIO.read(new File("src/letter.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        button = new JButton("⟹");
        add(button);
        button.addActionListener(this);

        pressedKeys = new boolean[128];
        addKeyListener(this);

        setFocusable(true);
        requestFocusInWindow();

        playSpooky();
    }

    public void playSpooky () {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/spooky.wav").getAbsoluteFile());
            sound = AudioSystem.getClip();
            sound.open(audioInputStream);
            sound.loop(Clip.LOOP_CONTINUOUSLY);
            sound.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
    }
    public void actionPerformed(ActionEvent e) {

    }

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = true;
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = false;
        player.setCurrentImage(playerStand);
    }
}
