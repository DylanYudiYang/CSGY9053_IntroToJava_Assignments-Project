import java.awt.Point;
import java.util.Random;
import java.util.Scanner;

public class Tetris {
    static final int BOARD_WIDTH = 10;
    static final int BOARD_HEIGHT = 20;

    private Cell[][] board;
    private Tetromino currentTetromino;
    private Tetromino nextTetromino;
    private Random random;
    private int score;
    private HighScoreManager highScoreManager;
    private boolean paused;
    private boolean gameOver;
    
    public Tetris() {
        board = new Cell[BOARD_HEIGHT][BOARD_WIDTH];
        score = 0;
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                board[i][j] = new Cell();
            }
        }
        random = new Random();
        currentTetromino = generateRandomTetromino();
        nextTetromino = generateRandomTetromino();
        highScoreManager = new HighScoreManager();
        paused = false;
        gameOver = false;
    }
    
    public Cell[][] getBoard() {
        return board;
    }
    
    public Tetromino getCurrentTetromino() {
        return currentTetromino;
    }
    
    public Tetromino getNextTetromino() {
        return nextTetromino;
    }
    
    private Tetromino generateRandomTetromino() {
        int randomNum = random.nextInt(7);
        switch (randomNum) {
            case 0:
                return new ShapeI();
            case 1:
                return new ShapeJ();
            case 2:
                return new ShapeL();
            case 3:
                return new ShapeO();
            case 4:
                return new ShapeS();
            case 5:
                return new ShapeT();
            case 6:
                return new ShapeZ();
            default:
                throw new IllegalStateException("Invalid random Tetrimino number");
        }
    }
    
    public void setGameOver() {
        gameOver = true;
    }
    
    public void setGameContinue() {
        gameOver = false;
    }

    public boolean isGameOver() {
        return gameOver;
    }
    
    //Methods to handle user inputs for moving and rotating Tetriminos.

    public void moveLeft() {
        Point newPosition = new Point(currentTetromino.getPosition().x - 1, currentTetromino.getPosition().y);
        if (isValidMove(currentTetromino, newPosition)) {
            currentTetromino.setPosition(newPosition);
        }
    }

    public void moveRight() {
        Point newPosition = new Point(currentTetromino.getPosition().x + 1, currentTetromino.getPosition().y);
        if (isValidMove(currentTetromino, newPosition)) {
            currentTetromino.setPosition(newPosition);
        }
    }

    public void moveDown() {
        Point newPosition = new Point(currentTetromino.getPosition().x, currentTetromino.getPosition().y + 1);
        if (isValidMove(currentTetromino, newPosition)) {
            currentTetromino.setPosition(newPosition);
        } else {
            placeTetrominoOnBoard(currentTetromino);
            clearCompletedLines();
            currentTetromino = nextTetromino;
            nextTetromino = generateRandomTetromino();

            //Check if the game is over
            if (!isValidMove(currentTetromino, currentTetromino.getPosition())) {
                gameOver();
            }
        }
    }

    public void rotateClockwise() {
        currentTetromino.rotateClockwise();
        if (!isValidMove(currentTetromino, currentTetromino.getPosition())) {
            currentTetromino.rotateCounterClockwise(); // Revert rotation if it's not valid
        }
    }

    public void rotateCounterClockwise() {
        currentTetromino.rotateCounterClockwise();
        if (!isValidMove(currentTetromino, currentTetromino.getPosition())) {
            currentTetromino.rotateClockwise(); // Revert rotation if it's not valid
        }
    }

    private boolean isValidMove(Tetromino tetromino, Point position) {
        int[][] shape = tetromino.getShape();
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j] == 1) {
                    int x = position.x + j;
                    int y = position.y + i;

                    // Check if the new position is out of bounds or collides with existing cells on the board
                    if (x < 0 || x >= BOARD_WIDTH || y < 0 || y >= BOARD_HEIGHT || board[y][x].isFilled()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Methods to update the game state

    private void placeTetrominoOnBoard(Tetromino tetromino) {
        int[][] shape = tetromino.getShape();
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j] == 1) {
                    int x = tetromino.getPosition().x + j;
                    int y = tetromino.getPosition().y + i;
                    board[y][x].setFilled(true);
                    board[y][x].setColor(tetromino.getColor());
                }
            }
        }
    }

    private void clearCompletedLines() {
        int linesCleared = 0;

        for (int i = 0; i < BOARD_HEIGHT; i++) {
            boolean lineComplete = true;
            for (int j = 0; j < BOARD_WIDTH; j++) {
                if (!board[i][j].isFilled()) {
                    lineComplete = false;
                    break;
                }
            }

            if (lineComplete) {
                linesCleared++;
                // Shift all lines above the cleared line down by one
                for (int k = i; k > 0; k--) {
                    for (int j = 0; j < BOARD_WIDTH; j++) {
                        board[k][j].setFilled(board[k - 1][j].isFilled());
                        board[k][j].setColor(board[k - 1][j].getColor());
                    }
                }

                // Clear the top line
                for (int j = 0; j < BOARD_WIDTH; j++) {
                    board[0][j].setFilled(false);
                }
            }
        }

        updateScore(linesCleared);
    }




    // Method to check if the game is over.

    private void gameOver() {
        // Handle game over logic
    	setGameOver();

        // Check if the current score is a new high score
        if (highScoreManager.isNewHighScore(score)) {
            // Add the new high score to the list
            highScoreManager.saveScore(score);
            System.out.println("New high score!");
        }
    }

    public void resetGameState() {
        // Reset the board
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                board[i][j].setFilled(false);
            }
        }

        // Generate a new random Tetrimino
        currentTetromino = generateRandomTetromino();

    }


    private void updateScore(int linesCleared) {
        switch (linesCleared) {
            case 1:
                score += 40;
                break;
            case 2:
                score += 100;
                break;
            case 3:
                score += 300;
                break;
            case 4:
                score += 1200;
                break;
        }
    }

    public int getScore() {
        return score;
    }
    
    public void togglePause() {
        paused = !paused;
    }

    public boolean isPaused() {
        return paused;
    }
    
    public int getHighScore() {
    	return HighScoreManager.getHighestScore();
    }
}
