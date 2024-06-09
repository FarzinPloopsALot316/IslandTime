import javax.swing.*;

public class BasementFrame implements Runnable {

    private BasementPanel panel;

    public BasementFrame () {
        JFrame frame = new JFrame("Day ???: Unlock the basement door.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        panel = new BasementPanel(frame);
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
