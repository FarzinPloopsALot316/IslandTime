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

public class Day3GrassPanel extends JPanel implements ActionListener, KeyListener {
    private JFrame enclosingFrame;

    private int RiyunIdx;
    private int NeedleIdx;
    private int StellaNanIdx;
    private Player player;
    private Villager riyun;
    private Villager needle;
    private Villager stella;
    private Villager nancy;
    private MayorVillager mayor;
    private String playerHome;
    private String rDialogue;
    private String nDialogue;
    private String snDialogue;
    private boolean riyunSpoke;
    private boolean needleSpoke;
    private boolean stellaNanSpoke;

    private BufferedImage background;
    private BufferedImage playerStand;
    private BufferedImage Riyun;
    private BufferedImage Needle;
    private BufferedImage Stella;
    private BufferedImage Nancy;
    private BufferedImage PlayerHouse;
    private BufferedImage RiyunHouse;
    private BufferedImage NeedleHouse;
    private BufferedImage StellaHouse;
    private BufferedImage NancyHouse;
    private BufferedImage MayorHouse;

    private JButton rButton; //riyun's button
    private JButton nButton; //needle's button
    private JButton snButton; //stella and nancy's button
    private JButton plazaButton;

    private boolean[] pressedKeys;

    private ArrayList<String> riyunSpeaks;
    private ArrayList<String> needleSpeaks;
    private ArrayList<String> StellaNanSpeaks;

    private Clip sound;

    public Day3GrassPanel (JFrame frame) {
        this.enclosingFrame = frame;
        this.riyunSpoke = false;
        this.needleSpoke = false;
        this.stellaNanSpoke = false;
        this.NeedleIdx = 0;
        this.RiyunIdx = 0;
        this.StellaNanIdx = 0;
        this.player = GraphicsPanel.getPlayer();
        this.mayor = GraphicsPanel.getMicheal();
        this.riyun = Day2Panel.getRiyun();
        this.needle = Day2Panel.getNeedle();
        this.stella = new Villager("Stella", "pumpkin", 21);
        this.nancy = new Villager("Nancy", "munchkin", 21);
        this.playerHome = Day1Panel.getHouse();

        this.riyunSpeaks = new ArrayList<>();

        riyunSpeaks.add("Oh. Morning, " + riyun.getCatchphrase());
        riyunSpeaks.add("Looks like you didn't get a lot of sleep. Your eyes are kinda sagging.");
        riyunSpeaks.add("Oh well. Happens. But watch out for yourself, would you, " + riyun.getCatchphrase());
        riyunSpeaks.add("Anyway, heard there's gonna be a town meeting today.");
        riyunSpeaks.add("Your cute little boyfriend mayor is gonna propose to you.");
        riyunSpeaks.add("Hah I'm joking. It's just gonna be a celebratory speech for the start of the town, " + riyun.getCatchphrase());
        riyunSpeaks.add("Also, I saw the two new villagers that arrived today.");
        riyunSpeaks.add("They're kinda odd, and one of them are rude, but I don't mind their attitude, " + riyun.getCatchphrase());
        riyunSpeaks.add("How about you go and catch up with em?");
        riyunSpeaks.add("I think they'll fancy you, haha. " + riyun.getCatchphrase()); //9
        riyunSpeaks.add("Should not print.");

        this.needleSpeaks = new ArrayList<>();

        needleSpeaks.add("they sooo meaaan :(");
        needleSpeaks.add("i wanted to talk to the blond gril stela");
        needleSpeaks.add("but she say my face look lik sur face of moon bumpy and holey" + needle.getCatchphrase());
        needleSpeaks.add("then they say ew when i say she prety");
        needleSpeaks.add("i just want be nice" + needle.getCatchphrase());
        needleSpeaks.add("oh but am think they are together so");
        needleSpeaks.add("oh ya mayor will give big talk i need to find cloth" + needle.getCatchphrase());
        needleSpeaks.add("bye bye pookie" + needle.getCatchphrase());
        needleSpeaks.add("Should not print.");

        this.StellaNanSpeaks = new ArrayList<>();

        StellaNanSpeaks.add("Stella: Uhm, whooo on earth are you, " + stella.getCatchphrase() + "??");
        StellaNanSpeaks.add("Stella: Okay well, can you like... leave us alone?");
        StellaNanSpeaks.add("Stella: You look so weird.");
        StellaNanSpeaks.add("Nancy: Stella, let's just not..." + nancy.getCatchphrase() + "."); //3 yellow
        StellaNanSpeaks.add("Stella: Like ew, what's with that unnecessarily long hairstyle, " + stella.getCatchphrase() + ".");
        StellaNanSpeaks.add("Stella: And that dress is soo last generation.");
        StellaNanSpeaks.add("Stella: What are you, some kind of momma's girl?");
        StellaNanSpeaks.add("Stella: Your mom's probably dead anyways " + stella.getCatchphrase() + ".");
        StellaNanSpeaks.add("Nancy: Stella come on now, they haven't even said anythin', " + nancy.getCatchphrase() + "."); //8 yellow
        StellaNanSpeaks.add("Stella: Ugh she just looks like a wh*re."); //sooo family friendly
        StellaNanSpeaks.add("Stella: Whatever. I just hate people. I'm sorry Nancyboo, " + stella.getCatchphrase() + ".");
        StellaNanSpeaks.add("Nancy: Come, let's get ready for the town speech."); //11 yellow
        StellaNanSpeaks.add("Stella: Alrighty boo.");
        StellaNanSpeaks.add("Stella: And you, mayor's long haired slut.");
        StellaNanSpeaks.add("Stella: Keep away from me and Nancy. We don't hang out with weirdos, " + stella.getCatchphrase() + ".");
        StellaNanSpeaks.add("Should not print.");

        this.rDialogue = riyunSpeaks.get(RiyunIdx);
        this.nDialogue = needleSpeaks.get(NeedleIdx);
        this.snDialogue = StellaNanSpeaks.get(StellaNanIdx);

        rButton = new JButton("⟹");
        add(rButton);
        rButton.addActionListener(this);

        nButton = new JButton("⟹");
        add(nButton);
        nButton.addActionListener(this);

        snButton = new JButton("⟹");
        add(snButton);
        snButton.addActionListener(this);

        plazaButton = new JButton("Go to Town Plaza");
        add(plazaButton);
        plazaButton.addActionListener(this);

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
            background = ImageIO.read(new File("src/grass.png"));
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
            StellaHouse = ImageIO.read(new File("src/StellaHouse.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            NancyHouse = ImageIO.read(new File("src/NancyHouse.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        player.setX(325);
        player.setY(0);
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
        super.paintComponent(g);
        rButton.setLocation(-820, -450);
        nButton.setLocation(-840, -450);
        snButton.setLocation(-840, -450);
        plazaButton.setLocation(-350, -500);

        riyun.setX(120);
        riyun.setY(150);

        needle.setX(120);
        needle.setY(400);

        stella.setX(620);
        stella.setY(400);

        nancy.setX(620);
        nancy.setY(150);

        g.drawImage(background, 0,0, null);
        g.drawImage(MayorHouse, 250, 20, null);
        g.drawImage(PlayerHouse, 550, 20, null);
        g.drawImage(RiyunHouse, 50, 200, null);
        g.drawImage(NeedleHouse, 50, 400, null);
        g.drawImage(NancyHouse, 750, 200, null);
        g.drawImage(StellaHouse, 750, 400, null);
        g.drawImage(Riyun, riyun.getX(), riyun.getY(), null);
        g.drawImage(Needle, needle.getX(), needle.getY(), null);
        g.drawImage(Stella, stella.getX(), stella.getY(), null);
        g.drawImage(Nancy, nancy.getX(), nancy.getY(), null);
        g.drawImage(player.getCurrentImage(), (int) player.getXCoord(), (int) player.getYCoord(), null);

        if (player.playerRect().intersects(riyun.VillagerRect()) && RiyunIdx < riyunSpeaks.size() - 1) { //riyun's conversation
            g.drawImage(background, 0,0, null);
            g.setColor(Color.BLACK);
            g.fillRect(0, 400, 900, 200);
            rButton.setLocation(820, 450);
            g.setColor(Color.CYAN);
            g.drawImage(Riyun, 300, 220, null);
            g.drawImage(playerStand, 500, 220, null);
            g.drawString(rDialogue, 100, 500);
        }

        if (player.playerRect().intersects(needle.VillagerRect()) && NeedleIdx < needleSpeaks.size() - 1 && riyunSpoke) {
            g.drawImage(background, 0,0, null);
            g.setColor(Color.BLACK);
            g.fillRect(0, 400, 900, 200);
            nButton.setLocation(820, 450);
            g.setColor(Color.MAGENTA);
            g.drawImage(Needle, 300, 220, null);
            g.drawImage(playerStand, 500, 220, null);
            g.drawString(nDialogue, 100, 500);
        }

        if ((player.playerRect().intersects(stella.VillagerRect()) || player.playerRect().intersects(nancy.VillagerRect())) && StellaNanIdx < StellaNanSpeaks.size() - 1 && needleSpoke) {
            //yellow: 3, 8, 11
            g.drawImage(background, 0, 0, null);
            g.setColor(Color.BLACK);
            g.fillRect(0, 400, 900, 200);
            snButton.setLocation(820, 450);
            g.setColor(Color.PINK);
            if (StellaNanIdx == 3 || StellaNanIdx == 8 || StellaNanIdx == 11) {
                g.setColor(Color.YELLOW);
            }
            g.drawImage(Nancy, 200, 220, null);
            g.drawImage(Stella, 300, 220, null);
            g.drawImage(playerStand, 600, 220, null);
            g.drawString(snDialogue, 100, 500);
        }

        if (riyunSpoke && needleSpoke && stellaNanSpoke && StellaNanIdx == StellaNanSpeaks.size() - 1) {
            plazaButton.setLocation(350, 500);
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

    public void actionPerformed (ActionEvent e) {
        if (RiyunIdx < riyunSpeaks.size() - 1) {
            if (e.getSource() instanceof JButton && e.getSource() == rButton) {
                requestFocusInWindow();
                RiyunIdx++;
                rDialogue = riyunSpeaks.get(RiyunIdx);
                if (RiyunIdx == 9) {
                    riyunSpoke = true;
                }
            }
        }

        if (NeedleIdx < needleSpeaks.size() - 1 && RiyunIdx == riyunSpeaks.size() - 1) {
            if (e.getSource() instanceof JButton && e.getSource() == nButton) {
                requestFocusInWindow();
                NeedleIdx++;
                nDialogue = needleSpeaks.get(NeedleIdx);
                if (NeedleIdx == 7) {
                    needleSpoke = true;
                }
            }
        }

        if (StellaNanIdx < StellaNanSpeaks.size() - 1 && RiyunIdx == riyunSpeaks.size() - 1 && NeedleIdx == needleSpeaks.size() - 1) {
            if (e.getSource() instanceof JButton && e.getSource() == snButton) {
                requestFocusInWindow();
                StellaNanIdx++;
                snDialogue = StellaNanSpeaks.get(StellaNanIdx);
                if (StellaNanIdx == 14) {
                    stellaNanSpoke = true;
                }
            }
        }

        if (e.getSource() instanceof JButton && e.getSource() == plazaButton) {
            requestFocusInWindow();
            sound.stop();
            sound.close();
            enclosingFrame.setVisible(false);
            new Day3PlazaFrame();
        }
        repaint();
    }

    public void keyTyped (KeyEvent e) {}

    public void keyPressed (KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = true;
    }

    public void keyReleased (KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = false;
        player.setCurrentImage(playerStand);
    }
}
