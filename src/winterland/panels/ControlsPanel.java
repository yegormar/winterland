package winterland.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class ControlsPanel extends JPanel {

    private JLabel dice;

    public ControlsPanel() {
        setOpaque(false);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton roll = new JButton("Roll");
        add(roll);

        // Add your custom action listener to the button
        roll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Use SwingWorker for background tasks
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        Random random = new Random();
                        int number = 0;

                        // Change numbers randomly 10 times to make a roll
                        for (int i = 0; i < 10; i++) {
                            number = 1 + random.nextInt(6);
                            dice.setText(Integer.toString(number));

                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        }

                        // Move active player as many steps as we got in the random number
                        for (int i = 0; i < number; i++) {
                            int currentStep = BoardPanel.playerSteps[BoardPanel.activeNumber];

                            // Move 1 step and wait some time
                            int newStep = currentStep + 1;
                            BoardPanel.playerSteps[BoardPanel.activeNumber] = newStep;
                            repaint();

                            try {
                                Thread.sleep(BoardPanel.TIMER_DELAY * 2);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        }

                        // Make next player active
                        if (BoardPanel.activeNumber == BoardPanel.players.length - 1) {
                            BoardPanel.activeNumber = 0;
                        } else {
                            BoardPanel.activeNumber++;
                        }

                        return null;
                    }
                };

                worker.execute(); // Start the SwingWorker
            }
        });

        JPanel diceHolder = new JPanel();
        dice = new JLabel("0");
        dice.setFont(new Font("Arial", Font.BOLD, 20));
        diceHolder.add(dice);
        add(diceHolder);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 50);
    }

}
