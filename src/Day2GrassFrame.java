import javax.swing.*;

public class Day2GrassFrame implements Runnable {

    private Day2GrassPanel panel;

    public Day2GrassFrame () {
        JFrame frame = new JFrame("Talk with the other villagers.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        panel = new Day2GrassPanel(frame);
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
