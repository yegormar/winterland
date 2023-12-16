package winterland.windows;

import javax.swing.JFrame;
import winterland.panels.BoardPanel;

class MainWindow extends JFrame {
    public MainWindow() {
        setTitle("Winterland Game"); // Replace with your main window title

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1030, 1030);

        // Top panel - board of the game
        BoardPanel boardPanel = new BoardPanel();

        // Add panels to the window
        add(boardPanel);

        setLocationRelativeTo(null); // Center the window on the screen
    }
}