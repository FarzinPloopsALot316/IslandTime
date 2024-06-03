import javax.swing.*;
public class Day3Frame {
    private Day3Panel panel;
    public Day3Frame () {
        JFrame frame = new JFrame("Island Time Day 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        panel = new Day3Panel(frame);
        frame.add(panel);

        frame.setVisible(true);
    }
}
