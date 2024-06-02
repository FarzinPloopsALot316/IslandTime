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

public class Day1Panel extends JPanel implements ActionListener, Runnable {
    private MayorVillager mayor;
    private Player player;
    private String dialogue;
    private Pilot pilot;
    private int planeIdx;
    private int mayorDay1Idx;
    private double mayorX;
    private double mayorY;

    private BufferedImage grass;

    private BufferedImage mayorImg;
    private BufferedImage crazyImg;
    private BufferedImage mayorRight;
    private BufferedImage mayorLeft;
    private BufferedImage playerStand;
    private BufferedImage playerLeft;
    private BufferedImage playerRight;
    private BufferedImage planeBackground;
    private BufferedImage beach;
    private BufferedImage mayorHouse;
    private BufferedImage emoHouse;
    private BufferedImage preppyHouse;
    private BufferedImage cliff;
    private JButton button;
    private JButton okaySorry;
    private JButton ughFine;
    private JButton whatWolves;
    private JButton theEmoOne;
    private JButton thePinkOne;
    private JButton skip;
    private JFrame enclosingFrame;
    private Clip ambience;
    private static String house;

    public Day1Panel (JFrame frame) {
        mayorX = 0;
        mayorY = 0;
        pilot = new Pilot();
        planeIdx = 0;
        mayorDay1Idx = -1;
        mayor = GraphicsPanel.getMicheal();
        player = GraphicsPanel.getPlayer();

        enclosingFrame = frame;
        try {
            mayorImg = ImageIO.read(new File("src/MichealStand.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            crazyImg = ImageIO.read(new File("src/MichealCrazy.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            mayorRight = ImageIO.read(new File("src/MichealRight.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            mayorLeft = ImageIO.read(new File("src/MichealLeft.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            planeBackground = ImageIO.read(new File("src/plane.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            beach = ImageIO.read(new File("src/islandBeach.jpg"));
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
            grass = ImageIO.read(new File("src/grass.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            mayorHouse = ImageIO.read(new File("src/MayorHome.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            emoHouse = ImageIO.read(new File("src/goth.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            preppyHouse = ImageIO.read(new File("src/preppy.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            cliff = ImageIO.read(new File("src/CliffSide.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        button = new JButton("⟹");
        add(button);
        button.addActionListener(this);
        okaySorry = new JButton("Okay, sorry!");
        add(okaySorry);
        okaySorry.addActionListener(this);
        ughFine = new JButton("Ugh, fine.");
        add(ughFine);
        ughFine.addActionListener(this);
        whatWolves = new JButton("Werewolves?");
        add(whatWolves);
        whatWolves.addActionListener(this);
        theEmoOne = new JButton("The gothic one!");
        add(theEmoOne);
        theEmoOne.addActionListener(this);
        thePinkOne = new JButton("The pink one!");
        add(thePinkOne);
        thePinkOne.addActionListener(this);
        skip = new JButton("Skip ⟹");
        add(skip);
        skip.addActionListener(this);
        dialogue = pilot.getDialogue(planeIdx);
        playIntro();
    }

    public void playIntro () {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Intro.wav").getAbsoluteFile());
            ambience = AudioSystem.getClip();
            ambience.open(audioInputStream);
            ambience.loop(Clip.LOOP_CONTINUOUSLY);
            ambience.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void playAmbience () {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Ambience.wav").getAbsoluteFile());
            ambience = AudioSystem.getClip();
            ambience.open(audioInputStream);
            ambience.loop(Clip.LOOP_CONTINUOUSLY);
            ambience.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void playStatic () {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Static.wav").getAbsoluteFile());
            ambience = AudioSystem.getClip();
            ambience.open(audioInputStream);
            ambience.loop(Clip.LOOP_CONTINUOUSLY);
            ambience.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void playRadio () {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/radio.wav").getAbsoluteFile());
            ambience = AudioSystem.getClip();
            ambience.open(audioInputStream);
            ambience.loop(Clip.LOOP_CONTINUOUSLY);
            ambience.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void paintComponent (Graphics g) {
        if (planeIdx < 29) {
            whatWolves.setLocation(-400, -400);
            okaySorry.setLocation(-400, -400);
            ughFine.setLocation(-400, -400);
            theEmoOne.setLocation(-400, -400);
            thePinkOne.setLocation(-400, -400);
            g.fillRect(0, 0, 900, 600);
            g.drawImage(planeBackground,46, 0, null);
            g.fillRect(0, 400, 900, 200);
            button.setLocation(820, 450);
            skip.setLocation(790, 50);
            g.setColor(Color.WHITE);
            if (planeIdx < 3) {
                g.setColor(Color.PINK);
            }
            if (planeIdx == 4) {
                g.setColor(Color.PINK);
            }
            if (planeIdx == 6) {
                button.setLocation(-400, -400);
                okaySorry.setLocation(775, 470);
                ughFine.setLocation(775, 430);
            }
            if (planeIdx > 6) {
                button.setLocation(820, 450);
                okaySorry.setLocation(-440, -440);
                ughFine.setLocation(-440, -440);
            }
            if (planeIdx == 9) {
                g.setColor(Color.PINK);
            }
            if (planeIdx == 10) {
                g.setColor(Color.PINK);
                ambience.stop();
                ambience.close();
                playRadio();
            }
            if (planeIdx > 10 && planeIdx < 18) {
                g.setColor(Color.YELLOW);
            }
            if (planeIdx == 18) {
                g.setColor(Color.PINK);
            }
            if (planeIdx == 19) {
                button.setLocation(-400, -400);
                whatWolves.setLocation(750, 450);
            }
            if (planeIdx == 20) {
                button.setLocation(820, 450);
                whatWolves.setLocation(-400, -400);
                ambience.stop();
                ambience.close();
                playAmbience();
            }
            if (planeIdx == 24) {
                g.setColor(Color.PINK);
            }
            if (planeIdx == 25) {
                g.setColor(Color.PINK);
            }
            if (planeIdx == 28) {
                g.setColor(Color.PINK);
            }
            g.drawString(dialogue, 100, 500);
        } else {
            g.fillRect(0, 0, 900, 600);
            g.drawImage(beach,35, 0, null);
            g.fillRect(0, 400, 900, 200);
            button.setLocation(820, 450);
            g.setColor(Color.WHITE);
            if (mayorDay1Idx == 0) {
                ambience.stop();
                ambience.close();
                playIntro();
                g.drawImage(playerRight, 500, 200, null);
                g.drawImage(mayorRight, 0, 200, null);
            } else {
                g.drawImage(mayorImg, 300, 200, null);
                g.drawImage(playerStand, 500, 200, null);
                if (mayorDay1Idx > 2 && mayorDay1Idx < 7) {
                    g.drawImage(grass, 0, 0, null);
                    g.setColor(Color.BLACK);
                    g.fillRect(0, 400, 900, 200);
                    button.setLocation(820, 450);
                    g.setColor(Color.GREEN);
                    if (mayorDay1Idx == 5) {
                        g.drawImage(mayorHouse, 100, 0, null);
                    }
                    if (mayorDay1Idx == 6) {
                        g.drawImage(emoHouse, 200, 300, null);
                        g.drawImage(preppyHouse, 400, 300, null);
                        button.setLocation(-400, -400);
                        theEmoOne.setLocation(790, 430);
                        thePinkOne.setLocation(790, 470);
                    }
                }
                if (mayorDay1Idx == 7) {
                    theEmoOne.setLocation(-790, -730);
                    thePinkOne.setLocation(-790, -770);
                    button.setLocation(820, 450);
                }
                if (mayorDay1Idx == 8) {
                    g.drawImage(cliff, 0,0, null);
                    g.setColor(Color.BLACK);
                    g.fillRect(0, 400, 900, 200);
                    g.setColor(Color.RED);
                    ambience.stop();
                    ambience.close();
                    playRadio();
                }
                if (mayorDay1Idx == 9) {
                    ambience.stop();
                    ambience.close();
                    playIntro();
                }
            }
            g.drawString(dialogue, 100, 500);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton && e.getSource() == skip) {
            house = "src/preppy.png";
            ambience.stop();
            ambience.close();
            enclosingFrame.setVisible(false);
            new WoodFrame();
        } else {
            if (planeIdx < pilot.getPlaneDialogueLength() - 1) {
                if (e.getSource() instanceof JButton && e.getSource() == okaySorry) {
                    requestFocusInWindow();
                    planeIdx = 7;
                    dialogue = pilot.getDialogue(planeIdx);
                    repaint();
                } else if (e.getSource() instanceof JButton && e.getSource() == ughFine) {
                    requestFocusInWindow();
                    planeIdx = 8;
                    dialogue = pilot.getDialogue(planeIdx);
                    repaint();
                } else if (e.getSource() instanceof JButton && (planeIdx == 7 || planeIdx == 8)) {
                    requestFocusInWindow();
                    planeIdx = 9;
                    dialogue = pilot.getDialogue(planeIdx);
                    repaint();
                } else if (e.getSource() instanceof JButton) {
                    requestFocusInWindow();
                    planeIdx++;
                    dialogue = pilot.getDialogue(planeIdx);
                    repaint();
                }
            } else if (mayorDay1Idx < GraphicsPanel.getMicheal().getMichealDay1Length() - 1) {
                planeIdx++;
                if (e.getSource() instanceof JButton && e.getSource() == theEmoOne) {
                    requestFocusInWindow();
                    house = "src/goth.jpg";
                    mayorDay1Idx++;
                    dialogue = mayor.getDay1Dialogue(mayorDay1Idx);
                    repaint();
                } else if (e.getSource() instanceof JButton && e.getSource() == thePinkOne) {
                    requestFocusInWindow();
                    house = "src/preppy.png";
                    mayorDay1Idx++;
                    dialogue = mayor.getDay1Dialogue(mayorDay1Idx);
                    repaint();
                } else if (e.getSource()  instanceof JButton) {
                    requestFocusInWindow();
                    mayorDay1Idx++;
                    dialogue = mayor.getDay1Dialogue(mayorDay1Idx);
                    repaint();
                }
            } else {
                ambience.stop();
                ambience.close();
                enclosingFrame.setVisible(false);
                new WoodFrame();
            }
        }
    }

    public static String getHouse () {
        return house;
    }


    public void run() {}
}
