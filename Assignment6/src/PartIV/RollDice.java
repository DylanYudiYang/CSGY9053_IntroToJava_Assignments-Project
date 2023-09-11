package PartIV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RollDice extends JFrame {
    private ImagePanel[] dieImages;
    private JButton rollButton;
    private JLabel resultLabel;
    private int dotIndex = 0;
    boolean finished = false;

    public RollDice() {
        // Title
        setTitle("Roll the Dice");

        // Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Dice
        JPanel dicePanel = new JPanel();
        dieImages = new ImagePanel[2];
        for (int i = 1; i <= 2; i++) {
            dieImages[i - 1] = new ImagePanel(new Image[]{new ImageIcon("die" + 1 + ".png").getImage()});
        }
        for (ImagePanel dieImage : dieImages) {
            dicePanel.add(dieImage);
        }
        mainPanel.add(dicePanel, BorderLayout.NORTH);

        // Grid
        JPanel squarePanel = new JPanel();
        squarePanel.setLayout(new GridLayout(5, 5));
        squarePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        for (int i = 0; i < 25; i++) {
            JPanel square = new JPanel();
            square.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            if (i == 0) {
                // initial dot
                JLabel dotLabel = new JLabel(".");
                dotLabel.setForeground(Color.BLACK);
                square.add(dotLabel);
            }
            squarePanel.add(square);
        }
        mainPanel.add(squarePanel, BorderLayout.CENTER);

        // Roll dice & Result
        JPanel buttonPanel = new JPanel();
        rollButton = new JButton("Roll dice");
        resultLabel = new JLabel("Result:");
        buttonPanel.add(rollButton);
        buttonPanel.add(resultLabel);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Listener for Roll dice
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (!finished){
                dicePanel.removeAll();
                dicePanel.revalidate();
                dicePanel.repaint();
                // Renew
                Random random = new Random(); 
                int tmpresult = 0;
                for (int i = 1; i <= 2; i++) {
                	int randomIndex = random.nextInt(5) + 1;
                	dotIndex += randomIndex;
                	tmpresult += randomIndex;
                    dieImages[i - 1] = new ImagePanel(new Image[]{new ImageIcon("die" + randomIndex + ".png").getImage()});
                    
                }
                for (ImagePanel dieImage : dieImages) {
                    dicePanel.add(dieImage);
                }
                resultLabel.setText("Result: " + tmpresult);
                
            	squarePanel.removeAll();
            	squarePanel.revalidate();
            	squarePanel.repaint();
                squarePanel.setLayout(new GridLayout(5, 5));
                squarePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                if (dotIndex < 25){
                	for (int i = 0; i < 25; i++) {
                    JPanel square = new JPanel();
                    square.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                    if (i == dotIndex) {
                   
                        JLabel dotLabel = new JLabel(".");
                        dotLabel.setForeground(Color.BLACK);
                        square.add(dotLabel);
                    }
                    
                    squarePanel.add(square);
                }
                }
                else { //finish
                	finished = true;
                	resultLabel.setText("Finished!");
                }
            }}
        });

        // Setting
        setPreferredSize(new Dimension(400, 400));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);
        pack();
    }

    public static void main(String[] args) {
        new RollDice();
    }
}

