import javax.swing.*;

public class Day3GrassFrame implements Runnable {

    private Day3GrassPanel panel;

    public Day3GrassFrame () {
        JFrame frame = new JFrame("Day 3: Talk with the other villagers.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        panel = new Day3GrassPanel(frame);
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
