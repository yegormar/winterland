package winterland.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlsPanel extends JPanel {
    public ControlsPanel(){
        setOpaque(false);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton roll = new JButton("Roll");
        add(roll);

        // Add your custom action listener to the button
        roll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Your custom action goes here
                System.out.println("Button clicked!");
            }
        });

        JPanel diceHolder = new JPanel();
        JLabel dice = new JLabel("0");
        dice.setFont(new Font("Arial", Font.BOLD, 20));
        diceHolder.add(dice);
        add(diceHolder);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 50);
    }

}
