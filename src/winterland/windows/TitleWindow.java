package winterland.windows;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleWindow extends JFrame {
    public TitleWindow() {
        setTitle("Your Title"); // Replace with your title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Your Title");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel, BorderLayout.NORTH);

        JLabel descriptionLabel = new JLabel("Your Description"); // Replace with your description
        panel.add(descriptionLabel, BorderLayout.CENTER);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current window
                openMainWindow(); // Open the main window
            }
        });
        panel.add(startButton, BorderLayout.SOUTH);

        add(panel);
        setLocationRelativeTo(null); // Center the window on the screen
    }

    private void openMainWindow() {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }
}