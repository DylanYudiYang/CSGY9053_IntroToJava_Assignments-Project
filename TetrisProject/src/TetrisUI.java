import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// TetrisUI class for displaying the Tetris game board and handling user input
class TetrisUI extends JPanel implements ActionListener, KeyListener {
    static final int CELL_SIZE = 25;
    private static final int TIMER_DELAY = 500;
    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_HEIGHT = 20;

    private Tetris tetris;
    private Timer timer;
    private JLabel scoreLabel;
    private JLabel highLabel;
    private JLabel nextLabel;
    private NextTetrominoPanel nextTetrominoPanel;
    
    public TetrisUI() {
        tetris = new Tetris();
        timer = new Timer(TIMER_DELAY, this);
        timer.start();

        setFocusable(true);
        addKeyListener(this);
        
        setLayout(new BorderLayout());
        // Create the game board panel
        JPanel boardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                // ... Paint the game board ...
                super.paintComponent(g);

                // Draw the Tetris board
                for (int i = 0; i < Tetris.BOARD_HEIGHT; i++) {
                    for (int j = 0; j < Tetris.BOARD_WIDTH; j++) {
                        Cell cell = tetris.getBoard()[i][j];
                        if (cell.isFilled()) {
                            g.setColor(cell.getColor());
                            g.fillRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                        }
                    }
                }

                // Draw the current Tetrimino
                Tetromino tetromino = tetris.getCurrentTetromino();
                g.setColor(tetromino.getColor());
                int[][] shape = tetromino.getShape();
                for (int i = 0; i < shape.length; i++) {
                    for (int j = 0; j < shape[i].length; j++) {
                        if (shape[i][j] == 1) {
                            g.fillRect((tetromino.getPosition().x + j) * CELL_SIZE,
                                    (tetromino.getPosition().y + i) * CELL_SIZE,
                                    CELL_SIZE, CELL_SIZE);
                        }
                    }
                }
                if (tetris.isGameOver()) {
                    g.setColor(Color.RED);
                    g.setFont(new Font("Arial", Font.BOLD, 36));
                    g.drawString("Game Over", 50, 200);
                }
            }
        };
        boardPanel.setPreferredSize(new Dimension(CELL_SIZE * BOARD_WIDTH, CELL_SIZE * BOARD_HEIGHT));
        add(boardPanel, BorderLayout.CENTER);
        boardPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel southPanel = new JPanel(new FlowLayout());
        scoreLabel = new JLabel("Score: " + tetris.getScore());
        scoreLabel.setBorder(BorderFactory.createLineBorder(Color.black));
       
        highLabel = new JLabel("Highest Score: " + tetris.getHighScore());
        highLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        southPanel.add(scoreLabel);
        southPanel.add(highLabel);
        southPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        add(southPanel, BorderLayout.SOUTH);

        
        JPanel northPanel = new JPanel(new FlowLayout());
        nextLabel = new JLabel("Next: ");
        nextTetrominoPanel = new NextTetrominoPanel(tetris);
        northPanel.add(nextLabel);
        northPanel.add(nextTetrominoPanel);
        northPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        add(northPanel, BorderLayout.NORTH);
        
        
    }


    private void updateScoreLabel() {
        scoreLabel.setText("Score: " + tetris.getScore());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tetris.isGameOver()) {
            timer.stop();
            showGameOverDialog();
            return;
        }
        tetris.moveDown();
        updateScoreLabel();
        nextTetrominoPanel.repaint();
        repaint();
        
    }


    @Override
    public void keyPressed(KeyEvent e) {
    	
        if (tetris.isGameOver()) {
            return;
        }

        int keyCode = e.getKeyCode();
        
        if (keyCode == KeyEvent.VK_P) {
            tetris.togglePause();
            if (tetris.isPaused()) {
                timer.stop();
            } else {
                timer.start();
            }
            return;
        }

        if (tetris.isPaused()) {
            return;
        }

        switch (keyCode) {
        
            case KeyEvent.VK_LEFT:
                tetris.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                tetris.moveRight();
                break;
            case KeyEvent.VK_DOWN:
                tetris.moveDown();
                break;
            case KeyEvent.VK_UP:
                tetris.rotateClockwise();
                break;
            case KeyEvent.VK_Z:
                tetris.rotateCounterClockwise();
                break;
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // No action needed on key release
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No action needed on key typed
    }
    public void restartGame() {
        tetris = new Tetris(); // Create a new Tetris game instance

        // Create a new timer with the same actionPerformed method
        timer = new Timer(TIMER_DELAY, this);
        timer.start(); // Start the timer again

        requestFocus(); // Request focus to the panel to continue receiving key events
        repaint(); // Repaint the panel to update the UI
    }
    
    private void showGameOverDialog() {
        int option = JOptionPane.showOptionDialog(
            this,
            "Game Over! Would you like to restart?",
            "Game Over",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new Object[] {"Restart", "Exit"},
            "Restart"
        );

        if (option == JOptionPane.YES_OPTION) {
        	tetris.setGameContinue();
            tetris.resetGameState();
        	restartGame();
        } else {
            System.exit(0);
        }
    }

}
