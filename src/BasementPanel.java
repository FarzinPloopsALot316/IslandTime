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

public class BasementPanel extends JPanel implements ActionListener, KeyListener {
    private ArrayList<Lever> levers;
    private int leverCount;
    private Player player;
    private boolean roomStart;
    private boolean roomRight;
    private boolean roomRight2;
    private boolean roomLeft;
    private boolean roomLeft2;
    private boolean up1;
    private boolean up2;
    private boolean up3;
    private boolean up4;
    private boolean played;
    private Rectangle exit;

    private JFrame enclosingFrame;

    private BufferedImage background;
    private BufferedImage playerStand;
    private BufferedImage leverUp;
    private BufferedImage leverDown;
    private BufferedImage door;
    private BufferedImage lady;

    private Clip clank;
    private Clip sound;
    private Clip boo;

    private boolean[] pressedKeys;

    public BasementPanel (JFrame frame) {
        exit = new Rectangle(290, 55, 200,210);
        played = false;
        leverCount = 0;
        enclosingFrame = frame;
        player = GraphicsPanel.getPlayer();
        player.setX(361);
        player.setY(389);
        up1 = true;
        up2 = true;
        up3 = true;
        up4 = true;

        roomStart = true;
        roomRight = false;
        roomRight2 = false;
        roomLeft = false;
        roomLeft2 = false;

        levers = new ArrayList<>();
        Lever lever1 = new Lever(200, 100); //roomLeft
        Lever lever2 = new Lever(50, 100); //roomLeft2
        Lever lever3 = new Lever(800, 100); //roomRight
        Lever lever4 = new Lever(700, 100); //roomRight2
        levers.add(lever1);
        levers.add(lever2);
        levers.add(lever3);
        levers.add(lever4);

        try {
            background = ImageIO.read(new File("src/basement1.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            playerStand = ImageIO.read(new File("src/playerStand.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            leverUp = ImageIO.read(new File("src/leverUp.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            leverDown = ImageIO.read(new File("src/leverDown.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            door = ImageIO.read(new File("src/closed.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            lady = ImageIO.read(new File("src/lostPlayer.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        pressedKeys = new boolean[128];
        addKeyListener(this);

        playSpooky();
        setFocusable(true);
        requestFocusInWindow();
        playBoo();
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

    public void playSwitch () {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/clank.wav").getAbsoluteFile());
            clank = AudioSystem.getClip();
            clank.open(audioInputStream);
            clank.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void playBoo () {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/boo.wav").getAbsoluteFile());
            boo = AudioSystem.getClip();
            boo.open(audioInputStream);
            boo.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        if (roomStart) {
            if (player.getXCoord() + player.getWidth() >= 900) {//right
                player.setX(0);
                roomStart = false;
                roomRight = true;
                try {
                    background = ImageIO.read(new File("src/basement2.png"));
                } catch (IOException e) {
                    System.out.println(e);
                }
            } else if (player.getXCoord() <= 0) { //left
                player.setX(725);
                roomStart = false;
                roomLeft = true;
                try {
                    background = ImageIO.read(new File("src/basement2.png"));
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        } else if (roomLeft) {
            if (player.getXCoord() + player.getWidth() >= 900) { //right
                player.setX(0);
                roomLeft = false;
                roomStart = true;
                try {
                    background = ImageIO.read(new File("src/basement1.png"));
                } catch (IOException e) {
                    System.out.println(e);
                }
            } else if (player.getXCoord() <= 0) { //left
                player.setX(725);
                roomLeft = false;
                roomLeft2 = true;
                try {
                    background = ImageIO.read(new File("src/basement3.png"));
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        } else if (roomRight) {
            if (player.getXCoord() + player.getWidth() >= 900) { //right
                player.setX(0);
                roomRight = false;
                roomRight2 = true;
                try {
                    background = ImageIO.read(new File("src/basement3.png"));
                } catch (IOException e) {
                    System.out.println(e);
                }
            } else if (player.getXCoord() <= 0) { //left
                player.setX(725);
                roomRight = false;
                roomStart = true;
                try {
                    background = ImageIO.read(new File("src/basement1.png"));
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        } else if (roomLeft2) {
            if (player.getXCoord() + player.getWidth() >= 900) { //right
                player.setX(0);
                roomLeft2 = false;
                roomLeft = true;
                try {
                    background = ImageIO.read(new File("src/basement2.png"));
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        } else if (roomRight2) {
            if (player.getXCoord() <= 0) { //left
                player.setX(725);
                roomRight2 = false;
                roomRight = true;
                try {
                    background = ImageIO.read(new File("src/basement2.png"));
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }

        g.drawImage(background, 0, 0, null);

        if (roomLeft) {
            g.drawImage(levers.get(0).getImage(), levers.get(0).getX(), levers.get(0).getY(), null);
            if (player.playerRect().intersects(levers.get(0).leverRect()) && up1) {
                levers.get(0).switchDown();
                playSwitch();
                leverCount++;
                up1 = false;
            }
        } else if (roomLeft2) {
            g.drawImage(levers.get(1).getImage(), levers.get(1).getX(), levers.get(1).getY(), null);
            if (player.playerRect().intersects(levers.get(1).leverRect()) && up2) {
                levers.get(1).switchDown();
                playSwitch();
                leverCount++;
                up2 = false;
            }
        } else if (roomRight) {
            g.drawImage(levers.get(2).getImage(), levers.get(2).getX(), levers.get(2).getY(), null);
            if (player.playerRect().intersects(levers.get(2).leverRect()) && up3) {
                levers.get(2).switchDown();
                playSwitch();
                leverCount++;
                up3 = false;
            }
        } else if (roomRight2) {
            g.drawImage(levers.get(3).getImage(), levers.get(3).getX(), levers.get(3).getY(), null);
            if (player.playerRect().intersects(levers.get(3).leverRect()) && up4) {
                levers.get(3).switchDown();
                playSwitch();
                leverCount++;
                up4 = false;
            }
        }

        if (leverCount < 4 && roomStart) {
            g.drawImage(door, 290, 55, null);
        } else if (leverCount == 4 && roomStart) {
            try {
                door = ImageIO.read(new File("src/open.png"));
            } catch (IOException e) {
                System.out.println(e);
            }
            if (!played) {
                playBoo();
            }
            g.drawImage(door, 290, 55, null);
            g.drawImage(lady, 200, 200, null);
            played = true;
            if (player.playerRect().intersects(exit)) {
                sound.stop();
                sound.close();
                enclosingFrame.setVisible(false);
                new BedroomFrame();
            }
        }

        g.drawImage(player.getCurrentImage(), (int) player.getXCoord(), (int) player.getYCoord(), null);

        // player moves left (a)
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

    public void actionPerformed(ActionEvent e) {}

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
