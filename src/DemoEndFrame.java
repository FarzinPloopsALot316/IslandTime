import javax.swing.*;

public class DemoEndFrame {
    private DemoEndPanel panel;

    public DemoEndFrame () {

        JFrame frame1 = new JFrame("What's going on?");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(900, 600);
        frame1.setLocationRelativeTo(null);

        panel = new DemoEndPanel(frame1);
        frame1.add(panel);

        frame1.setVisible(true);
    }
}
