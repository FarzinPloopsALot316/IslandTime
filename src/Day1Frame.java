import javax.swing.*;
public class Day1Frame {
    private Day1Panel panel;

    public Day1Frame() {

        JFrame frame1 = new JFrame("Island Time Day 1");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(900, 600); // 540 height of image + 40 for window menu bar
        frame1.setLocationRelativeTo(null); // auto-centers frame in screen

        panel = new Day1Panel(frame1);
        frame1.add(panel);

        frame1.setVisible(true);
    }

    public void run() {
        panel.repaint();
    }
}
