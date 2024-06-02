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

public class Day2GrassPanel extends JPanel implements ActionListener, KeyListener {
    private int RiyunIdx;
    private int NeedleIdx;
    private Player player;
    private Villager riyun;
    private Villager needle;
    private MayorVillager mayor;
    private String playerHome;
    private String rDialogue;
    private String nDialogue;

    private final double MOVE_AMT = 0.5;
    private JFrame enclosingFrame;
    private BufferedImage background;
    private BufferedImage playerStand;
    private BufferedImage playerRight;
    private BufferedImage playerLeft;
    private BufferedImage Riyun;
    private BufferedImage RiyunHouse;
    private BufferedImage NeedleHouse;
    private BufferedImage PlayerHouse;
    private BufferedImage MayorHouse;
    private BufferedImage Needle;
    private int charWidth;
    private int charHeight;
    private Clip sound;
    private JButton rButton;
    private JButton nButton;
    private boolean[] pressedKeys;
    private ArrayList<String> riyunSpeaks;
    private ArrayList<String> needleSpeaks;

    public Day2GrassPanel (JFrame frame) {
        this.NeedleIdx = 0;
        this.RiyunIdx = 0;
        this.player = GraphicsPanel.getPlayer();
        this.mayor = GraphicsPanel.getMicheal();
        this.riyun = Day2Panel.getRiyun();
        this.needle = Day2Panel.getNeedle();
        this.charWidth = player.getWidth();
        this.charHeight = player.getHeight();
        this.playerHome = Day1Panel.getHouse();

        this.riyunSpeaks = new ArrayList<>();
        riyunSpeaks.add("Oh. Hey. What do you want, " + player.getName() + "? " + riyun.getCatchphrase());

        riyunSpeaks.add("Just a dude. Riyun's the name, or as that weirdo introduced already."); //1
        riyunSpeaks.add("Nothing much, just chilling, " + riyun.getCatchphrase()); //2

        riyunSpeaks.add("I'm not really looking forward to do anything I guess. " + riyun.getCatchphrase());
        riyunSpeaks.add("Maybe just living here and going about my day on a secluded island is all there is on my calendar.");
        riyunSpeaks.add("So, what's up with you? Not that I really care, " + riyun.getCatchphrase()); //5
        riyunSpeaks.add("Oh, that Micheal guy?");
        riyunSpeaks.add("I don't like him, " + riyun.getCatchphrase());
        riyunSpeaks.add("Dude gives me the ick.");
        riyunSpeaks.add("He's way too happy and dapper of a guy.");
        riyunSpeaks.add("It makes him feel suspicious, " + riyun.getCatchphrase());
        riyunSpeaks.add("And I think I saw him watching you sleep when I got here and looked for him.");
        riyunSpeaks.add("I walked into the tent wanting to ask him something, and he was just standing there, watching you.");
        riyunSpeaks.add("I'd watch out for that creep if I were you, " + riyun.getCatchphrase());

        riyunSpeaks.add("Suit yourself. I'm not the one getting stalked anyway, " + riyun.getCatchphrase());
        riyunSpeaks.add("Yeah. For real. Be careful.");

        riyunSpeaks.add("Anyway, could you possibly leave? Tryna unpack some furniture here, " + riyun.getCatchphrase());


        this.needleSpeaks = new ArrayList<>();
        needleSpeaks.add("oh em gee haiiiiiii pookie! " + needle.getCatchphrase());

        needleSpeaks.add("am needleeee I am sooo excited to be hereeee" + needle.getCatchphrase());
        needleSpeaks.add("i found a ant in the gras and made it my freind" + needle.getCatchphrase());

        needleSpeaks.add("i wanna have a good time hereee and make new friends and have fun" + needle.getCatchphrase());
        needleSpeaks.add("then i wanna go make a tree house and then with friend and then go swimming and then blow up mount rushmore and then go cocnut tree harvestign and then-");

        needleSpeaks.add("oh i like mikal" + needle.getCatchphrase());
        needleSpeaks.add("he is very nice but he is a very weird guy some time");
        needleSpeaks.add("this morning when I talk about mak new friend and i talk about you");
        needleSpeaks.add("and I say oh em gee I would love to meet " + player.getName() + " and mak new friend!");
        needleSpeaks.add("he eyes turn mad and he turn mad and yell at me.");
        needleSpeaks.add("plz watch out for him");

        needleSpeaks.add("oka! i trust you, fried!");
        needleSpeaks.add("yaaa :(");

        needleSpeaks.add("oh no me ant ran away sry I hav to look for ant bye " + player.getName() + "! " + needle.getCatchphrase());

        this.rDialogue = riyunSpeaks.get(RiyunIdx);
        this.nDialogue = needleSpeaks.get(NeedleIdx);

        this.enclosingFrame = frame;

        rButton = new JButton("⟹");
        add(rButton);
        rButton.addActionListener(this);

        nButton = new JButton("⟹");
        add(nButton);
        nButton.addActionListener(this);

        pressedKeys = new boolean[128];
        addKeyListener(this);

        setFocusable(true);
        requestFocusInWindow();

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

        try {
            background = ImageIO.read(new File("src/grass.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            RiyunHouse = ImageIO.read(new File("src/RiyunHouse.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            NeedleHouse = ImageIO.read(new File("src/NeedleHouse.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            MayorHouse = ImageIO.read(new File("src/MayorHome.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            PlayerHouse = ImageIO.read(new File(playerHome));
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

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        rButton.setLocation(-820, -450);
        nButton.setLocation(-840, -450);
        riyun.setX(120);
        riyun.setY(180);
        needle.setX(120);
        needle.setY(400);
        g.drawImage(background, 0,0, null);
        g.drawImage(MayorHouse, 200, 20, null);
        g.drawImage(PlayerHouse, 500, 20, null);
        g.drawImage(RiyunHouse, 50, 200, null);
        g.drawImage(NeedleHouse, 50, 400, null);
        g.drawImage(Riyun, riyun.getX(), riyun.getY(), null);
        g.drawImage(Needle, needle.getX(), needle.getY(), null);
        g.drawImage(player.getCurrentImage(), (int) player.getXCoord(), (int) player.getYCoord(), null);

        if (player.playerRect().intersects(riyun.VillagerRect()) && RiyunIdx < riyunSpeaks.size() - 1) { //remember to reset player coodinates after convo
            g.drawImage(background, 0,0, null);
            g.fillRect(0, 400, 900, 200);
            rButton.setLocation(820, 450);
            g.drawImage(Riyun, 300, 220, null);
            g.drawImage(playerStand, 500, 220, null);
            g.setColor(Color.CYAN);
            g.drawString(rDialogue, 100, 500);
        }

        if (pressedKeys[65]) {
            player.moveLeft();
            g.drawImage(player.getCurrentImage(), (int) player.getXCoord(), (int) player.getYCoord(), player.getWidth(), player.getHeight(), null);
        }

        // player moves right (d)
        if (pressedKeys[68]) {
            player.moveRight();
            g.drawImage(player.getCurrentImage(), (int) player.getXCoord(), (int) player.getYCoord(), player.getWidth(), player.getHeight(), null);
        }

        // player moves up (w)
        if (pressedKeys[87]) {
            player.moveUp();
        }

        // player moves down (s)
        if (pressedKeys[83]) {
            player.moveDown();
        }
    }

    public void keyTyped(KeyEvent e) { }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = true;
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = false;
        player.setCurrentImage(playerStand);
    }

    public void actionPerformed(ActionEvent e) {
        if (RiyunIdx < riyunSpeaks.size() - 1) {
            if (e.getSource() instanceof JButton && e.getSource() == nButton) {
                requestFocusInWindow();
                RiyunIdx++;
                rDialogue = riyunSpeaks.get(RiyunIdx);
                repaint();
            }
        }
    }
}
