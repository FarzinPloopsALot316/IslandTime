import javax.swing.*;
public class Night1Frame {
    private Night1Panel panel;
    public Night1Frame () {
        JFrame frame = new JFrame("Island Time Day 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        panel = new Night1Panel(frame);
        frame.add(panel);

        frame.setVisible(true);
    }
}
