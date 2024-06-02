import javax.swing.*;

public class SearchFrame {
    private SearchPanel panel;

    public SearchFrame () {
        JFrame frame = new JFrame("Search for Micheal around the island.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        panel = new SearchPanel(frame);
        frame.add(panel);

        frame.setVisible(true);
    }
}
