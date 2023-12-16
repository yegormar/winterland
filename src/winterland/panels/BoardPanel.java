package winterland.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import winterland.Step;
import winterland.Winterland;
import winterland.labels.Player;

public class BoardPanel extends JPanel {
    public Player[] players = new Player[3];
    public static int playerRedStep = 0;
    public static int playerWhiteStep = 0;
    public static int playerBlueStep = 0;

    private static final int TIMER_DELAY = 200; // 1000 milliseconds = 1 second
    private static final int JUMP_DISTANCE = 10;

    public static int activeNumber = 0;

    private boolean jumpUp = true;

    private final int circleSize = 50;

    private Image backgroundImage;

    public BoardPanel() {
        setSize(1000, 1000);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Load the background image
        ImageIcon imageIcon = new ImageIcon("res/background.jpeg");
        backgroundImage = imageIcon.getImage();

//        PlayersPanel playersPanel = new PlayersPanel();
//        add(playersPanel);

        ControlsPanel controlsPanel = new ControlsPanel();
        add(controlsPanel);

        // Red Player
        ImageIcon red = new ImageIcon("res/payer_red.png");
        Player playerRed = new Player(red);
        players[0] = playerRed;
        add(playerRed);

        // White Player
        ImageIcon blue = new ImageIcon("res/payer_blue.png");
        Player playerBlue = new Player(blue);
        players[1] = playerBlue;
        add(playerBlue);

        // Green Player
        ImageIcon green = new ImageIcon("res/payer_green.png");
        Player playerGreen = new Player(green);
        players[2] = playerGreen;
        add(playerGreen);

        Timer timer = new Timer(TIMER_DELAY, new ActionListener() {
            Player activePlayer = players[activeNumber];
            private int currentY = activePlayer.getY();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (jumpUp){
                    currentY = currentY + JUMP_DISTANCE;
                    jumpUp = false;
                } else {
                    currentY = currentY - JUMP_DISTANCE;
                    jumpUp = true;
                }


                players[activeNumber].setLocation(activePlayer.getX(), currentY);
            }
        });

        timer.start();
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

    public void movePlayer(int playerIndex, int stepNumber){
        Step step = Winterland.steps[stepNumber];
        Player player = players[playerIndex];
        player.setLocation(step.getX(), step.getY());
    }
}