package winterland.panels;

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

public class BoardPanel extends JPanel implements ActionListener{
    public static Player[] players = new Player[3]; // This is array of players
    public static int[] playerSteps = new int[players.length]; // Index of current step for each player

    public static final int TIMER_DELAY = 250; // 1000 milliseconds = 1 second
    private static final int JUMP_DISTANCE = 5;

    public static int activeNumber = 0;
    private boolean inGame = false;
    private boolean jumpUp = true;
    private static final int circleSize = 50;

    private Image backgroundImage;
    private Timer timer;

    public BoardPanel() {
        setSize(1000, 1000);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Load the background image
        ImageIcon imageIcon = new ImageIcon("res/background.jpeg");
        backgroundImage = imageIcon.getImage();

        // Panel with controls
        ControlsPanel controlsPanel = new ControlsPanel();
        add(controlsPanel);

        // Prepare Red Player
        ImageIcon red = new ImageIcon("res/payer_red.png");
        Player playerRed = new Player(red);
        players[0] = playerRed;
        playerSteps[0] = 0;

        // Prepare White Player
        ImageIcon blue = new ImageIcon("res/payer_blue.png");
        Player playerBlue = new Player(blue);
        players[1] = playerBlue;
        playerSteps[1] = 0;

        // Prepare Green Player
        ImageIcon green = new ImageIcon("res/payer_green.png");
        Player playerGreen = new Player(green);
        players[2] = playerGreen;
        playerSteps[2] = 0;

        // Start timer to show players movements and active player
        // Speed of the snake
        timer = new Timer(TIMER_DELAY, this);
        timer.start();

        inGame = true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (inGame){
            doDrawing(g);
        }

    }

    private void doDrawing(Graphics g) {
        System.out.println("Called doDrawing()");

        // Draw the background image
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        // Show circles
        drawCircles(g);

        // Show players in the correct circles
        showPlayers(g);
    }

    private void drawCircles(Graphics g) {
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

    /*
     * Show players in the correct circles
     */
    public void showPlayers(Graphics g){
        for (int i = 0; i < players.length; i++) {
            Player player = players[i];
            int stepIndex = playerSteps[i];
            Step step = Winterland.steps[stepIndex];

            int x = step.getX();
            int y = step.getY();

            // This is to make active player jump
            if (i == activeNumber) {
                if (jumpUp) {
                    y = y + JUMP_DISTANCE;
                    jumpUp = false;
                } else {
                    y = y - JUMP_DISTANCE;
                    jumpUp = true;
                }
            }

            if (i == 0){
                g.drawImage(player.getImage(), x - 5, y - 5, this);
            } else if (i == 1){
                g.drawImage(player.getImage(), x + 20, y - 5, this);
            } else {
                g.drawImage(player.getImage(), x + 10, y + 10, this);
            }
        }
    }

    /*
     * This method is will be called every time when Timer is triggered
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Timer action is called");
        repaint();
    }
}