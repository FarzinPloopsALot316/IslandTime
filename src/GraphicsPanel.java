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
    private Player player;
    private BufferedImage mayorImg;
    private JTextField textField;
    private BufferedImage background;
    private boolean[] pressedKeys;
    private String dialogue;

    public GraphicsPanel () {
        Micheal = new MayorVillager("hah haa", 24, "August", 15);
        try {
            background = ImageIO.read(new File("src/reception.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            mayorImg = ImageIO.read(new File("src/uhm.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        addKeyListener(this);
        addMouseListener(this);
        textField =  new JTextField(15);
        pressedKeys = new boolean[128];
        dialogue = "Hello hello? Is this the newcomer speaking?";
    }

    public void paintComponent (Graphics g) {
        g.drawImage(background, 0, 0, null);
        g.drawImage(mayorImg, 400, 300, null);
        g.fillRect(0, 400, 900, 200);
        g.setColor(Color.white);
        g.drawString(dialogue, 100, 500);
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = true;
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = true;
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

    }
}
