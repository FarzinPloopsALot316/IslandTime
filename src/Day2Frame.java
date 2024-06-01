import javax.swing.*;

public class Day2Frame {
    private Day2Panel panel;

    public Day2Frame () {
        JFrame frame = new JFrame("Island Time Day 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        panel = new Day2Panel(frame);
        frame.add(panel);

        frame.setVisible(true);
    }
}
