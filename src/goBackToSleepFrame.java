import javax.swing.*;
public class goBackToSleepFrame {
    private goBackToSleepPanel panel;
    private JFrame enclosingFrame;

    public goBackToSleepFrame () {
        JFrame frame1 = new JFrame("don't worry.");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(900, 600); // 540 height of image + 40 for window menu bar
        frame1.setLocationRelativeTo(null); // auto-centers frame in screen

        panel = new goBackToSleepPanel(frame1);
        frame1.add(panel);

        frame1.setVisible(true);
    }
}
