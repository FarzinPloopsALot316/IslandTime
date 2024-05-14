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
    private JButton button;
    private JTextField textField;
    private BufferedImage background;

    public GraphicsPanel () {
        Micheal = new MayorVillager("hah haa", 42, "May", 15);
        try {
            background = ImageIO.read(new File("src/uhm.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            mayorImg = ImageIO.read(new File("src/uhm.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        button = new JButton("Enter");
        textField =  new JTextField(15);
    }

    public void paintComponent (Graphics g) {
        g.drawImage(mayorImg, 200, 0, null);
        g.fillRect(0, 200, 200, 300);
        g.drawString("Hello hello? Is this the newcomer speaking?", 100, 300);
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

    }
}
