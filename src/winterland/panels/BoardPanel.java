package winterland.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import winterland.Step;
import winterland.Winterland;

public class BoardPanel extends JPanel {

    private final int circleSize = 50;

    private Image backgroundImage;

    public BoardPanel() {
        setSize(1000, 1000);

        // Load the background image
        ImageIcon imageIcon = new ImageIcon("res/background.jpeg");
        backgroundImage = imageIcon.getImage();

        PlayersPanel players = new PlayersPanel();
        add(players);

        ControlsPanel controls = new ControlsPanel();
        add(controls);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        // Draw circles on the panel
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < Winterland.steps.length; i++) {
            Step step = Winterland.steps[i];
            int x = step.getX();
            int y = step.getY();

            // Set the color with 50% transparency (alpha = 128)
            if (step.getColor() == Step.COLOR_RED) {
                g2d.setColor(new Color(255, 0, 0, 128));
            } else if (step.getColor() == Step.COLOR_WHITE) {
                g2d.setColor(new Color(255, 255, 255, 200));
            } else {
                g2d.setColor(new Color(0, 255, 0, 128));
            }

            Ellipse2D circle = new Ellipse2D.Double(x, y, circleSize, circleSize);
            g2d.fill(circle);
        }
    }
}