import javax.swing.*;
import java.awt.*;

public class NextTetrominoPanel extends JPanel {
    private static final int CELL_SIZE = 25;

    private Tetris tetris;

    public NextTetrominoPanel(Tetris tetris) {
        this.tetris = tetris;
        setPreferredSize(new Dimension(4 * CELL_SIZE, 4 * CELL_SIZE));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Tetromino tetromino = tetris.getNextTetromino();
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
    }
}
