import javax.swing.*;

public class WoodFrame {
    private WoodPanel panel;

    public WoodFrame () {
        JFrame frame1 = new JFrame("Day 1: Collect the wood around the map for the fire.");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(900, 600); // 540 height of image + 40 for window menu bar
        frame1.setLocationRelativeTo(null); // auto-centers frame in screen

        panel = new WoodPanel(frame1);
        frame1.add(panel);

        frame1.setVisible(true);
    }

    public void run() {
        panel.repaint();
    }
}
