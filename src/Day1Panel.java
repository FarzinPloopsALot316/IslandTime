import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Day1Panel extends JPanel implements ActionListener {
    private String dialogue;
    private Pilot pilot;
    private int planeIdx;

    private BufferedImage mayorImg;
    private BufferedImage crazyImg;
    private BufferedImage mayorRight;
    private BufferedImage mayorLeft;
    private BufferedImage planeBackground;
    private JButton button;
    private JButton okaySorry;
    private JButton ughFine;
    private JButton whatWolves;
    private JFrame enclosingFrame;

    public Day1Panel (JFrame frame) {
        pilot = new Pilot();
        planeIdx = 0;

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
        dialogue = pilot.getDialogue(planeIdx);
    }

    public void paintComponent (Graphics g) {
        whatWolves.setLocation(-400, -400);
        okaySorry.setLocation(-400, -400);
        ughFine.setLocation(-400, -400);
        g.fillRect(0, 0, 900, 600);
        g.drawImage(planeBackground,46, 0, null);
        g.fillRect(0, 400, 900, 200);
        button.setLocation(820, 450);
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
        }
        if (planeIdx > 10 && planeIdx < 18) {
            g.setColor(Color.YELLOW);
        }
        if (planeIdx == 18) {
            g.setColor(Color.PINK);
        }
        if (planeIdx == 19) {
            button.setLocation(-400, -400);
            whatWolves.setLocation(775, 450);
        }
        if (planeIdx == 20) {
            button.setLocation(820, 450);
            whatWolves.setLocation(-400, -400);
        }
        if (planeIdx == 24) {
            g.setColor(Color.PINK);
        }
        if (planeIdx == 25) {
            g.setColor(Color.PINK);
        }
        if (planeIdx == 27) {
            g.setColor(Color.PINK);
        }
        g.drawString(dialogue, 100, 500);
    }

    public void actionPerformed(ActionEvent e) {
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
        } else {
            System.out.println("You're passing the index bounds! Stop it!"); //test holder for now
        }
    }
}
