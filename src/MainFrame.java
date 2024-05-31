import javax.swing.*;
public class MainFrame {
    private GraphicsPanel panel;

    public MainFrame() {

        JFrame frame = new JFrame("Island Time");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        panel = new GraphicsPanel(frame);
        frame.add(panel);

        frame.setVisible(true);
    }
}
