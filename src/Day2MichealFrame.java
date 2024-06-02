import javax.swing.*;

public class Day2MichealFrame {

    private Day2MichealPanel panel;

    public Day2MichealFrame () {
        JFrame frame1 = new JFrame("Island Time Day 2");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(900, 600);
        frame1.setLocationRelativeTo(null);

        panel = new Day2MichealPanel(frame1);
        frame1.add(panel);

        frame1.setVisible(true);
    }
}
