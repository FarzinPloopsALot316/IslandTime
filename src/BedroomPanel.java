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
    private JFrame enclosingFrame;
    private Document firstLetter;
    private Document secondLetter;
    private Document thirdLetter;
    private Document fourthLetter;

    private Player player;
    private boolean[] pressedKeys;
    private boolean read1;
    private boolean read2;
    private boolean read3;
    private boolean read4;
    private boolean michealSpoke;

    private ArrayList<String> letter1;
    private ArrayList<String> letter2;
    private ArrayList<String> letter3;
    private ArrayList<String> letter4;
    private ArrayList<String> mayorSpeaks;

    private String dialogue1;
    private String dialogue2;
    private String dialogue3;
    private String dialogue4;
    private String mayorDialogue;

    private int idx1;
    private int idx2;
    private int idx3;
    private int idx4;
    private int mayorIdx;

    private BufferedImage letter;
    private BufferedImage background;
    private BufferedImage playerStand;
    private BufferedImage mayor;

    private Clip sound;
    private Clip roar;

    private JButton button;
    private JButton one; //i got lazy naming things
    private JButton two;
    private JButton three;
    private JButton four;

    public BedroomPanel (JFrame frame) {
        enclosingFrame = frame;
        player = new Player("PLACEHOLDER", "N/A", 17);
        player.setX(361);
        player.setY(389);

        firstLetter = new Document(50,150);
        secondLetter = new Document(275, 250);
        thirdLetter = new Document(450, 150);
        fourthLetter = new Document(750, 250);

        read1 = false;
        read2 = false;
        read3 = false;
        read4 = false;
        michealSpoke = false;

        letter1 = new ArrayList<>();
        letter1.add("November 2, 2120");
        letter1.add("Today, she and I made eye contact. Her name is " + player.getName() + ".");
        letter1.add("I've been watching her for a while.");
        letter1.add("I see what time she walks out of her house, trying to get to work.");
        letter1.add("Where she works, where she lounges during her break time, who she speaks with.");
        letter1.add("I put a tracker on her car, a camera in her house, all whilst she wasn't looking.");
        letter1.add("All to plan this perfectly, to know what she does, where she goes, and what time.");
        letter1.add("But today, as I sat across the cafe from where she usually stays during her lunch break, she spotted me.");
        letter1.add(player.getName() + "'s caramel eyes and my mint blue eyes.");
        letter1.add("She made eye contact with me.");
        letter1.add("She's perfect.");
        letter1.add("She's so beautiful.");
        letter1.add("She's my everything.");
        letter1.add("I need to know more. I need to know when I can ask her.");
        letter1.add("I need to know when she's most gullible.");
        letter1.add("She can't refuse me. I'll force her to be my friend, I'll beat it into her if I must.");
        letter1.add("She's going to be a perfect best friend.");
        letter1.add("I'm going to show Mom that I can have a human best friend."); //17
        letter1.add("Should not print.");
        idx1 = 0;
        dialogue1 = letter1.get(idx1);

        letter2 = new ArrayList<>();
        letter2.add("December 13, 2120");
        letter2.add("She waved at me today!!!");
        letter2.add("I was sitting at the cafe during the usual time and there she was.");
        letter2.add("She saw me and waved kindly at me while I was pretending to read a book.");
        letter2.add("She recognised me.");
        letter2.add("She's going to be an amazing friend.");
        letter2.add("I know it.");
        letter2.add("And when I ask her out, I know she won't refuse."); //7
        letter2.add("I won't mess up. This Sound Moon won't make me insane this time!");
        letter2.add("She won't end up like the last one.");
        letter2.add("That one's remains are buried. The mistakes have rotted away.");
        letter2.add("This time I won't eat anybody.");
        letter2.add("Should not print.");
        idx2 = 0;
        dialogue2 = letter2.get(idx2);

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
        letter3.add("She'll regret her words. And if she doesn't, I'll make her regret them."); //12
        letter3.add("Should not print.");
        idx3 = 0;
        dialogue3 = letter3.get(idx3);

        letter4 = new ArrayList<>();
        letter4.add("February 21, 2121");
        letter4.add("I did it.");
        letter4.add("Saw her at the park on a bench, and took my chance.");
        letter4.add("Her head's bleeding. Hope that doesn't give her aches or head pain later on.");
        letter4.add("I did it. She's mine now. My best friend.");
        letter4.add("She's going to wake up soon, and I'll comfort and soothe her whilst she's blinded by pain.");
        letter4.add("She'll have no choice but to accept my warmth from the insanity of her isolation and pain.");
        letter4.add("She passes out so much. I must have hit something important pretty hard.");
        letter4.add("I'm not gonna take her to the hospital. I can't get caught.");
        letter4.add("I'll just keep giving her amnesia everytime she wakes up screaming in pain.");
        letter4.add("I won't eat her. I'll prove that I'm a good werewolf who has control.");
        letter4.add("I've always wanted a human friend, and now that I have one, I'll prove I can keep one.");
        letter4.add("She's my best friend now."); //12
        letter4.add("Should not print.");
        idx4 = 0;
        dialogue4 = letter4.get(idx4);

        mayorSpeaks = new ArrayList<>();
        mayorSpeaks.add("What are you doing here, " + player.getName() + "?");
        mayorSpeaks.add("My my, you're being awfully disobedient, hah haa.");
        mayorSpeaks.add("Sneaking through to my bedroom.");
        mayorSpeaks.add("You must have read it all.");
        mayorSpeaks.add("That's okay. Totally fine, hah haa!");
        mayorSpeaks.add("Best friends are always curious about each other after all, hah haa!");
        mayorSpeaks.add("Well that's just okay.");
        mayorSpeaks.add("I'm so hungry. The moon's up.");
        mayorSpeaks.add("But oh, don't worry. I won't lay a tooth on you, hah haa!");
        mayorSpeaks.add("Not on my dear best friend. No no, not at all!");
        mayorSpeaks.add("Come closer! Allow me to comfort you, " + player.getName() + ".");
        mayorSpeaks.add("You can trust me, you know, hah haa.");
        mayorIdx = 0;
        mayorDialogue = mayorSpeaks.get(mayorIdx);

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

        one = new JButton("⟹");
        add(one);
        one.addActionListener(this);

        two = new JButton("⟹");
        add(two);
        two.addActionListener(this);

        three = new JButton("⟹");
        add(three);
        three.addActionListener(this);

        four = new JButton("⟹");
        add(four);
        four.addActionListener(this);

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

    public void playRoar () {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/michealRoar.wav").getAbsoluteFile());
            roar = AudioSystem.getClip();
            roar.open(audioInputStream);
            roar.loop(Clip.LOOP_CONTINUOUSLY);
            roar.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        one.setLocation(-820,-450);
        two.setLocation(-820,-450);
        three.setLocation(-820,-450);
        four.setLocation(-820,-450);
        button.setLocation(-820,-450);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,900,600);
        g.drawImage(background, 0,0, null);
        g.drawImage(player.getCurrentImage(), (int) player.getXCoord(), (int) player.getYCoord(), null);

        if (!read1 || !read2 || !read3 || !read4) {
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

        if (!read1) {
            g.drawImage(letter, firstLetter.getX(), firstLetter.getY(), null);
            if (player.playerRect().intersects(firstLetter.letterRect()) && idx1 < letter1.size() - 1) {
                g.setColor(Color.BLACK);
                one.setLocation(820,450);
                g.fillRect(0,400,900,200);
                g.setColor(Color.BLUE);
                g.drawString(dialogue1, 100, 500);
            }
        } else if (!read2) {
            g.drawImage(letter, secondLetter.getX(), secondLetter.getY(), null);
            if (player.playerRect().intersects(secondLetter.letterRect()) && idx2 < letter2.size() - 1) {
                g.setColor(Color.BLACK);
                two.setLocation(820,450);
                g.fillRect(0,400,900,200);
                g.setColor(Color.BLUE);
                g.drawString(dialogue2, 100, 500);
            }
        } else if (!read3) {
            g.drawImage(letter, thirdLetter.getX(), thirdLetter.getY(), null);
            if (player.playerRect().intersects(thirdLetter.letterRect()) && idx3 < letter3.size() - 1) {
                g.setColor(Color.BLACK);
                three.setLocation(820,450);
                g.fillRect(0,400,900,200);
                g.setColor(Color.RED);
                g.drawString(dialogue3, 100, 500);
            }
        } else if (!read4) {
            g.drawImage(letter, fourthLetter.getX(), fourthLetter.getY(), null);
            if (player.playerRect().intersects(fourthLetter.letterRect()) && idx4 < letter4.size() - 1) {
                g.setColor(Color.BLACK);
                four.setLocation(820,450);
                g.fillRect(0,400,900,200);
                g.setColor(Color.RED);
                g.drawString(dialogue4, 100, 500);
            }
        }

        if (read1 && read2 && read3 && read4) {
            if (!michealSpoke) {
                sound.stop();
                sound.close();
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, 900, 600);
                g.fillRect(0, 400, 900, 200);
                g.drawImage(mayor, 0, 220, null);
                g.setColor(Color.RED);
                button.setLocation(820, 450);
                g.drawString(mayorDialogue, 100, 500);
                g.drawImage(playerStand, 725, 220, null);
            } else {
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, 900, 600);
                g.fillRect(0, 400, 900, 200);
                g.drawImage(playerStand, 400, 220, null);
                g.drawImage(mayor, 300, 220, null);
            }
        }

        if (mayorIdx == 11) { //this glitch is intentional.
            playRoar();
        }
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

    public void actionPerformed(ActionEvent e) {
        if (idx1 < letter1.size() - 1) {
            if (e.getSource() instanceof JButton && e.getSource() == one) {
                requestFocusInWindow();
                idx1++;
                dialogue1 = letter1.get(idx1);
                if (idx1 == 17) {
                    read1 = true;
                }
            }
        }

        if (read1 && idx2 < letter2.size() - 1) {
            if (e.getSource() instanceof JButton && e.getSource() == two) {
                requestFocusInWindow();
                idx2++;
                dialogue2 = letter2.get(idx2);
                if (idx2 == 11) {
                    read2 = true;
                }
            }
        }

        if (read1 && read2 && idx3 < letter3.size() - 1) {
            if (e.getSource() instanceof JButton && e.getSource() == three) {
                requestFocusInWindow();
                idx3++;
                dialogue3 = letter3.get(idx3);
                if (idx3 == 12) {
                    read3 = true;
                }
            }
        }

        if (read1 && read2 && read3 && idx4 < letter4.size() - 1) {
            if (e.getSource() instanceof JButton && e.getSource() == four) {
                requestFocusInWindow();
                idx4++;
                dialogue4 = letter4.get(idx4);
                if (idx4 == 12) {
                    read4 = true;
                }
            }
        }

        if (read1 && read2 && read3 && read4) {
            if (mayorIdx < mayorSpeaks.size() - 1) {
                if (e.getSource() instanceof JButton) {
                    requestFocusInWindow();
                    mayorIdx++;
                    mayorDialogue = mayorSpeaks.get(mayorIdx);
                    if (mayorIdx == 11) {
                        michealSpoke = true;
                    }
                }
            }
        }
        repaint();
    }
}
