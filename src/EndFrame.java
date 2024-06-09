import javax.swing.*;

public class EndFrame {

    private EndPanel panel;

    public EndFrame () {
        JFrame frame = new JFrame("Island Time: Thank you for playing!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        panel = new EndPanel(frame);
        frame.add(panel);

        frame.setVisible(true);
    }
}
