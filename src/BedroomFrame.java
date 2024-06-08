import javax.swing.*;
public class BedroomFrame implements Runnable {
    private BedroomPanel panel;

    public BedroomFrame () {
        JFrame frame = new JFrame("Day ???: Feed him.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);

        panel = new BedroomPanel(frame);
        frame.add(panel);

        frame.setVisible(true);
        Thread thread = new Thread(this);
        thread.start();
    }

    public void run() {
        while (true) {
            panel.repaint();
        }
    }
}
