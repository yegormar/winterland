package winterland.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import winterland.labels.Player;

public class PlayersPanel extends JPanel {
    private static final int TIMER_DELAY = 200; // 1000 milliseconds = 1 second
    private static final int JUMP_DISTANCE = 10;

    public static int activeNumber = 0;
    public static Player[] players = new Player[3];

    private boolean jumpUp = true;

    public PlayersPanel(){
        setOpaque(false);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Red Player
        ImageIcon red = new ImageIcon("res/payer_red.png");
        Player playerRed = new Player(red);
        players[0] = playerRed;
        add(playerRed, BorderLayout.NORTH);

        // White Player
        ImageIcon blue = new ImageIcon("res/payer_blue.png");
        Player playerBlue = new Player(blue);
        players[1] = playerBlue;
        add(playerBlue, BorderLayout.NORTH);

        // Green Player
        ImageIcon green = new ImageIcon("res/payer_green.png");
        Player playerGreen = new Player(green);
        players[2] = playerGreen;
        add(playerGreen, BorderLayout.NORTH);

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
    public Dimension getPreferredSize() {
        return new Dimension(200, 50);
    }

}
