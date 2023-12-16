package winterland.experiments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingImageExample {
    private static final int TIMER_DELAY = 20; // Delay in milliseconds
    private static final int MOVE_DISTANCE = 5; // Distance to move at each step

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Moving Image Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel() {
                private int imageX = 0;
                private final ImageIcon imageIcon = new ImageIcon("path/to/your/image.png");

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    imageIcon.paintIcon(this, g, imageX, 50);
                }

                private void moveImage() {
                    imageX += MOVE_DISTANCE;
                    if (imageX > getWidth()) {
                        imageX = -imageIcon.getIconWidth(); // Reset when image goes beyond the right edge
                    }
                    repaint();
                }
            };

            Timer timer = new Timer(TIMER_DELAY, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //panel.moveImage();
                }
            });

            timer.start();

            frame.getContentPane().add(panel);
            frame.setSize(400, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
