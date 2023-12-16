package winterland.labels;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Player{
    private Image image;

    public Player(ImageIcon image) {
        this.image = image.getImage();
    }

    public Image getImage() {
        return image;
    }
}
