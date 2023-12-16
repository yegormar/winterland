package winterland.labels;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {
    private Image backgroundImage;

    public Player(ImageIcon backgroundIcon) {
        super(backgroundIcon);
        this.backgroundImage = backgroundIcon.getImage();
        setOpaque(false);
    }
}
