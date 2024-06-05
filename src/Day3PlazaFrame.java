import javax.swing.*;

public class Day3PlazaFrame {

    private Day3PlazaPanel panel;

    public Day3PlazaFrame () {
        JFrame frame = new JFrame("Island Time Day 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        panel = new Day3PlazaPanel(frame);
        frame.add(panel);

        frame.setVisible(true);
    }
}
