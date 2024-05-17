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
    private JButton button;
    private JFrame frame;
    private BufferedImage mayorImg;
    private JTextField textField;
    private BufferedImage background;
    private String dialogue;
    private int introIdx;

    public GraphicsPanel () {
        introIdx = 0;
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
        button = new JButton("⟹");
        add(button);
        button.addActionListener(this);
        addKeyListener(this);
        addMouseListener(this);
        textField =  new JTextField(15);
        add(textField);
        textField.addActionListener(this);
        textField.setVisible(false);
        dialogue = Micheal.getDialogue(introIdx);
    }

    public void paintComponent (Graphics g) {
        g.drawImage(background, 0, 0, null);
        g.drawImage(mayorImg, 400, 300, null);
        g.fillRect(0, 400, 900, 200);
        g.setColor(Color.white);
        g.drawString(dialogue, 100, 500);
        button.setLocation(820, 450);
        if (introIdx == 7) {
            textField.setVisible(true);
            textField.setLocation(450, 300);
        }
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
        if (e.getSource() instanceof JButton && introIdx == 7) {
            String name = textField.getText();
            System.out.println(name);
            introIdx++;
            dialogue = name + ". " + Micheal.getDialogue(introIdx);
            textField.setVisible(false);
            repaint();
        } else if (e.getSource() instanceof JButton) {
            requestFocusInWindow();
            introIdx++;
            dialogue = Micheal.getDialogue(introIdx);
            repaint();
        }
    }
}
