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
    private boolean riyunSpoke;
    private boolean needleSpoke;

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
    private JButton whatDoing;
    private JButton whoYou;
    private JButton micheal;
    private JButton uhmMicheal;
    private JButton nonsense;
    private JButton dontWorry;
    private JButton forReal;
    private JButton michealSearch;
    private boolean[] pressedKeys;
    private ArrayList<String> riyunSpeaks;
    private ArrayList<String> needleSpeaks;

    public Day2GrassPanel (JFrame frame) {
        this.riyunSpoke = false;
        this.needleSpoke = false;
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
        riyunSpeaks.add("I'd watch out for that creep if I were you, " + riyun.getCatchphrase()); //13

        riyunSpeaks.add("Suit yourself. I'm not the one getting stalked anyway, " + riyun.getCatchphrase()); //14
        riyunSpeaks.add("Yeah. For real. Be careful."); //15

        riyunSpeaks.add("Anyway, could you possibly leave? Tryna unpack some furniture here, " + riyun.getCatchphrase()); //16
        riyunSpeaks.add("Should not print.");


        this.needleSpeaks = new ArrayList<>();
        needleSpeaks.add("oh em gee haiiiiiii pookie! " + needle.getCatchphrase());

        needleSpeaks.add("am needleeee I am sooo excited to be hereeee" + needle.getCatchphrase());
        needleSpeaks.add("i found a ant in the gras and made it my freind" + needle.getCatchphrase());

        needleSpeaks.add("i wanna have a good time hereee and make new friends and have fun" + needle.getCatchphrase());
        needleSpeaks.add("then i wanna go make a tree house and then with friend and then go swimming and then blow up mount rushmore and then go cocnut tree harvestign and then-"); //5

        needleSpeaks.add("oh i like mikal" + needle.getCatchphrase()); //5
        needleSpeaks.add("he is very nice but he is a very weird guy some time");
        needleSpeaks.add("this morning when I talk about mak new friend and i talk about you");
        needleSpeaks.add("and I say oh em gee I would love to meet " + player.getName() + " and mak new friend!");
        needleSpeaks.add("he eyes turn mad and he turn mad and yell at me");
        needleSpeaks.add("plz watch out for him"); //10

        needleSpeaks.add("oka! i trust you, fried!"); //11
        needleSpeaks.add("yaaa :("); //12

        needleSpeaks.add("oh no me ant ran away sry I hav to look for ant bye " + player.getName() + "! " + needle.getCatchphrase()); //13
        needleSpeaks.add("Should not print.");

        this.rDialogue = riyunSpeaks.get(RiyunIdx);
        this.nDialogue = needleSpeaks.get(NeedleIdx);

        this.enclosingFrame = frame;

        rButton = new JButton("⟹");
        add(rButton);
        rButton.addActionListener(this);

        nButton = new JButton("⟹");
        add(nButton);
        nButton.addActionListener(this);

        whatDoing = new JButton("What are you doing?");
        add(whatDoing);
        whatDoing.addActionListener(this);

        whoYou = new JButton("Who are you again?");
        add(whoYou);
        whoYou.addActionListener(this);

        micheal = new JButton("Opinions on Micheal?");
        add(micheal);
        micheal.addActionListener(this);

        nonsense = new JButton("Nonsense!");
        add(nonsense);
        nonsense.addActionListener(this);

        forReal = new JButton("Wait for real?");
        add(forReal);
        forReal.addActionListener(this);

        uhmMicheal = new JButton("Uhm, opinions on Micheal?-");
        add(uhmMicheal);
        uhmMicheal.addActionListener(this);

        dontWorry = new JButton("I'll be fine, thank you.");
        add(dontWorry);
        dontWorry.addActionListener(this);

        michealSearch = new JButton("Search for Micheal?");
        add(michealSearch);
        michealSearch.addActionListener(this);

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
        whatDoing.setLocation(-720, -430);
        whoYou.setLocation(-720, -470);
        micheal.setLocation(-720, -470);
        nonsense.setLocation(-720, -470);
        dontWorry.setLocation(-820, -470);
        forReal.setLocation(-720, -470);
        uhmMicheal.setLocation(-720, -470);
        nonsense.setLocation(-720, -470);
        michealSearch.setLocation(-720, -470);
        riyun.setX(120);
        riyun.setY(150);
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

        if (player.playerRect().intersects(riyun.VillagerRect()) && RiyunIdx < riyunSpeaks.size() - 1) {//riyun's conversation
            g.drawImage(background, 0,0, null);
            g.setColor(Color.BLACK);
            g.fillRect(0, 400, 900, 200);
            rButton.setLocation(820, 450);
            whatDoing.setLocation(-720, -430);
            whoYou.setLocation(-720, -470);
            micheal.setLocation(-720, -470);
            uhmMicheal.setLocation(-720, -470);
            nonsense.setLocation(-720, -470);
            dontWorry.setLocation(-820, -470);
            forReal.setLocation(-720, -470);
            if (RiyunIdx == 0) {
                rButton.setLocation(-820, -450);
                whatDoing.setLocation(720, 430);
                whoYou.setLocation(720, 470);
            }
            if (RiyunIdx == 5) {
                rButton.setLocation(-820, -450);
                micheal.setLocation(720, 450);
            }
            if (RiyunIdx == 13) {
                rButton.setLocation(-820, -450);
                nonsense.setLocation(750, 430);
                forReal.setLocation(750, 470);
            }
            g.drawImage(Riyun, 300, 220, null);
            g.drawImage(playerStand, 500, 220, null);
            g.setColor(Color.CYAN);
            g.drawString(rDialogue, 100, 500);
        }

        if (player.playerRect().intersects(needle.VillagerRect()) && NeedleIdx < needleSpeaks.size() - 1 && riyunSpoke) {
            g.drawImage(background, 0,0, null);
            g.setColor(Color.BLACK);
            g.fillRect(0, 400, 900, 200);
            nButton.setLocation(820, 450);
            whatDoing.setLocation(-720, -430);
            whoYou.setLocation(-720, -470);
            uhmMicheal.setLocation(-720, -470);
            dontWorry.setLocation(-720, -470);
            forReal.setLocation(-720, -470);
            if (NeedleIdx == 0) {
                nButton.setLocation(-820, -450);
                whatDoing.setLocation(720, 430);
                whoYou.setLocation(720, 470);
            }
            if (NeedleIdx == 4) {
                nButton.setLocation(-820, -450);
                uhmMicheal.setLocation(670, 450);
            }
            if (NeedleIdx == 10) {
                nButton.setLocation(-820, -450);
                dontWorry.setLocation(720, 430);
                forReal.setLocation(720, 470);
            }
            g.drawImage(Needle, 300, 220, null);
            g.drawImage(playerStand, 500, 220, null);
            g.setColor(Color.MAGENTA);
            g.drawString(nDialogue, 100, 500);
        }

        if (needleSpoke && riyunSpoke && NeedleIdx == 14) {
            michealSearch.setLocation(720, 500);
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
            if (e.getSource() instanceof JButton && e.getSource() == whoYou) {
                requestFocusInWindow();
                RiyunIdx = 1;
                rDialogue = riyunSpeaks.get(RiyunIdx);
                repaint();
            } else if (e.getSource() instanceof JButton && RiyunIdx == 1) {
                requestFocusInWindow();
                RiyunIdx = 3;
                rDialogue = riyunSpeaks.get(RiyunIdx);
                repaint();
            } else if (e.getSource() instanceof JButton && e.getSource() == whatDoing) {
                requestFocusInWindow();
                RiyunIdx = 2;
                rDialogue = riyunSpeaks.get(RiyunIdx);
                repaint();
            } else if (e.getSource() instanceof JButton && e.getSource() == nonsense) {
                requestFocusInWindow();
                RiyunIdx = 14;
                rDialogue = riyunSpeaks.get(RiyunIdx);
                repaint();
            } else if (e.getSource() instanceof JButton && RiyunIdx == 14) {
                requestFocusInWindow();
                RiyunIdx = 16;
                rDialogue = riyunSpeaks.get(RiyunIdx);
                riyunSpoke = true;
                repaint();
            } else if (e.getSource() instanceof JButton && e.getSource() == forReal) {
                requestFocusInWindow();
                RiyunIdx = 15;
                rDialogue = riyunSpeaks.get(RiyunIdx);
                repaint();
            } else if (e.getSource() instanceof JButton && e.getSource() == rButton || e.getSource() == micheal) {
                requestFocusInWindow();
                RiyunIdx++;
                rDialogue = riyunSpeaks.get(RiyunIdx);
                repaint();
                if (RiyunIdx == 16) {
                    riyunSpoke = true;
                }
            }
        }

        if (NeedleIdx < needleSpeaks.size() - 1 && RiyunIdx == riyunSpeaks.size() - 1) {
            if (e.getSource() instanceof JButton && e.getSource() == whoYou) {
                requestFocusInWindow();
                NeedleIdx = 1;
                nDialogue = needleSpeaks.get(NeedleIdx);
                repaint();
            } else if (e.getSource() instanceof JButton && e.getSource() == whatDoing) {
                requestFocusInWindow();
                NeedleIdx = 2;
                nDialogue = needleSpeaks.get(NeedleIdx);
                repaint();
            } else if (e.getSource() instanceof JButton && e.getSource() == dontWorry) {
                requestFocusInWindow();
                NeedleIdx = 11;
                nDialogue = needleSpeaks.get(NeedleIdx);
                repaint();
            } else if (e.getSource() instanceof JButton && NeedleIdx == 11) {
                requestFocusInWindow();
                NeedleIdx = 13;
                nDialogue = needleSpeaks.get(NeedleIdx);
                needleSpoke = true;
                repaint();
            } else if (e.getSource() instanceof JButton && e.getSource() == forReal) {
                requestFocusInWindow();
                NeedleIdx = 12;
                nDialogue = needleSpeaks.get(NeedleIdx);
                repaint();
            } else if (e.getSource() instanceof JButton && (e.getSource() == nButton || e.getSource() == uhmMicheal)) {
                requestFocusInWindow();
                NeedleIdx++;
                nDialogue = needleSpeaks.get(NeedleIdx);
                repaint();
                if (NeedleIdx == 14) {
                    needleSpoke = true;
                }
            }
        }
        if (e.getSource() instanceof JButton && e.getSource() == michealSearch) {
            sound.stop();
            sound.close();
            enclosingFrame.setVisible(false);
            new SearchFrame();
        }
    }
}
