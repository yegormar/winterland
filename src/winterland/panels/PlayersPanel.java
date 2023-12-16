package winterland.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import winterland.labels.Player;

public class PlayersPanel extends JPanel {
    public PlayersPanel(){
        setOpaque(false);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Test Player
        ImageIcon red = new ImageIcon("res/payer_red.png");
        Player playerRed = new Player(red);
        add(playerRed, BorderLayout.NORTH);

        // Test Player
        ImageIcon blue = new ImageIcon("res/payer_blue.png");
        Player playerBlue = new Player(blue);
        add(playerBlue, BorderLayout.NORTH);

        // Test Player
        ImageIcon green = new ImageIcon("res/payer_green.png");
        Player playerGreen = new Player(green);
        add(playerGreen, BorderLayout.NORTH);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 50);
    }

}
