import javax.swing.*;
public class WelcomeFrame {
    private WelcomePanel panel;

    public WelcomeFrame () {

        JFrame frame1 = new JFrame("Island Time Day 1");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(900, 600);
        frame1.setLocationRelativeTo(null); // auto-centers frame in screen

        panel = new WelcomePanel(frame1);
        frame1.add(panel);

        frame1.setVisible(true);
    }
}
