package winterland.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlsPanel extends JPanel {
    public ControlsPanel(){
        setOpaque(false);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton roll = new JButton("Roll");
        add(roll);

        JLabel dice = new JLabel("0");
        dice.setFont(new Font("Arial", Font.BOLD, 20));
        add(dice);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 50);
    }

}
