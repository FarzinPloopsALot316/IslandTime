import javax.swing.*;
public class Night3Frame {

    private Night3Panel panel;

    public Night3Frame () {
        JFrame frame = new JFrame("Island Time Day 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        panel = new Night3Panel(frame);
        frame.add(panel);

        frame.setVisible(true);
    }
}
