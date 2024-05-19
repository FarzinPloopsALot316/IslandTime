import javax.swing.*;
public class Day1Frame {
    private Day1Panel panel1;

    public Day1Frame () {

        JFrame frame = new JFrame("Island Time Day 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600); // 540 height of image + 40 for window menu bar
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        panel1 = new Day1Panel(frame);
        frame.add(panel1);

        frame.setVisible(true);
    }

    public void run() {
        panel1.repaint();
    }
}
