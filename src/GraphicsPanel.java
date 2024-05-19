import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GraphicsPanel extends JPanel implements KeyListener, MouseListener, ActionListener {
    private MayorVillager Micheal;
    private String name;
    private String month;
    private int date;
    private Player player;
    private Time time;
    private Town town;
    private boolean accepted;

    private JFrame enclosingFrame;
    private JButton button;
    private JButton accept;
    private JButton decline;
    private BufferedImage mayorImg;
    private BufferedImage crazyImg;
    private JTextField textField;
    private BufferedImage background;
    private String dialogue;
    private int introIdx;

    public GraphicsPanel (JFrame frame) {
        enclosingFrame = frame;
        introIdx = 0;
        name = "Player";
        Micheal = new MayorVillager("hah haa", 24, "August", 15);
        try {
            background = ImageIO.read(new File("src/reception.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

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
        time = new Time();
        button = new JButton("⟹");
        add(button);
        button.addActionListener(this);
        accept = new JButton("Okay, sure!");
        add(accept);
        accept.addActionListener(this);
        decline = new JButton("No, sorry.");
        add(decline);
        decline.addActionListener(this);
        addKeyListener(this);
        addMouseListener(this);
        textField = new JTextField(15);
        add(textField);
        textField.addActionListener(this);
        dialogue = Micheal.getDialogue(0);
    }

    public void paintComponent (Graphics g) {
        textField.setLocation(-300, -300);
        accept.setLocation(-350, 300);
        decline.setLocation(-400, 300);
        g.drawImage(background, 0, 0, null);
        g.drawImage(mayorImg, 375, 275, null);
        g.fillRect(0, 400, 900, 200);
        g.setColor(Color.white);
        button.setLocation(820, 450);
        if (introIdx == 7) {
            textField.setLocation(350, 400);
        }
        if (introIdx == 12) {
            textField.setLocation(350, 400);
            g.setColor(Color.WHITE);
        }
        if (introIdx == 18) {
            button.setLocation(-300, 450);
            accept.setLocation(780, 430);
            decline.setLocation(780, 470);
            g.setColor(Color.WHITE);
        }
        if (introIdx == 19) {
            button.setLocation(820, 450);
            accept.setLocation(-350, 300);
            decline.setLocation(-400, 300);
            Micheal.increaseFriendship(5);
            g.setColor(Color.BLUE);
        }
        if (introIdx == 20) {
            textField.setLocation(350, 400);
        }
        if (introIdx == 21) {
            textField.setLocation(350, 400);
        }
        if (introIdx == 22) {
            button.setLocation(820, 450);
            accept.setLocation(-350, 300);
            decline.setLocation(-400, 300);
            Micheal.decreaseFriendship(5);
            player = new Player(name, "N/A", 0);
            g.drawImage(crazyImg, 375, 275, null);
            g.setColor(Color.BLACK);
            g.fillRect(0, 400, 900, 200);
            g.setColor(Color.RED);
        }
        g.drawString(dialogue, 100, 500);
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void actionPerformed(ActionEvent e) {
        if (introIdx < Micheal.getMichealIntroLength() - 1) {
            if (e.getSource() instanceof JButton && introIdx == 7) {
                requestFocusInWindow();
                name = textField.getText();
                introIdx++;
                dialogue = name + ". " + Micheal.getDialogue(introIdx);
                textField.setLocation(-300, -300);
                repaint();
            } else if (e.getSource() instanceof JButton && introIdx == 12) {
                requestFocusInWindow();
                String townName = textField.getText();
                town = new Town(townName);
                introIdx++;
                dialogue = Micheal.getDialogue(introIdx) + town.getName() + ".";
                textField.setLocation(-300, -300);
                repaint();
            } else if (e.getSource() instanceof JButton && e.getSource() == accept) {
                requestFocusInWindow();
                accepted = true;
                introIdx = 19;
                accept.setLocation(-350, 300);
                decline.setLocation(-400, 300);
                button.setLocation(820, 450);
                dialogue = Micheal.getDialogue(introIdx);
            } else if (e.getSource() instanceof JButton && e.getSource() == decline) {
                requestFocusInWindow();
                accepted = false;
                introIdx = 22;
                accept.setLocation(-350, 300);
                decline.setLocation(-400, 300);
                button.setLocation(820, 450);
                dialogue = Micheal.getDialogue(introIdx);
            } else if (e.getSource() instanceof JButton && introIdx == 20) {
                requestFocusInWindow();
                month = textField.getText();
                introIdx++;
                dialogue = Micheal.getDialogue(introIdx);
                textField.setLocation(-300, -300);
                repaint();
            } else if (e.getSource() instanceof JButton && introIdx == 21) {
                requestFocusInWindow();
                date = Integer.parseInt(textField.getText());
                introIdx = 24;
                dialogue = Micheal.getDialogue(introIdx);
                textField.setLocation(-300, -300);
                player = new Player(name, month, date);
                repaint();
            } else if (e.getSource() instanceof JButton) {
                requestFocusInWindow();
                introIdx++;
                dialogue = Micheal.getDialogue(introIdx);
                repaint();
            }
        } else {
            enclosingFrame.setVisible(false);
        }
    }
}
