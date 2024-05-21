import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class WoodPanel extends JPanel implements ActionListener {
    private final double MOVE_AMT = 0.4;
    private JFrame enclosingFrame;
    private Player player;
    private double playerX;
    private double playerY;

    private BufferedImage playerStand;
    private BufferedImage playerRight;
    private BufferedImage playerLeft;
    private BufferedImage wood;
    private BufferedImage grassField;

    public WoodPanel (JFrame enclosingFrame) {
        this.enclosingFrame = enclosingFrame;
        player = GraphicsPanel.getPlayer();
    }

    public void actionPerformed(ActionEvent e) {

    }
}
