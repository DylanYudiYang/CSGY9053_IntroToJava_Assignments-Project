
import java.awt.Color;

public class ShapeO extends Tetromino {
    private static final int[][] SHAPE = {
        {1, 1},
        {1, 1}
    };

    public ShapeO() {
        super();
        shape = SHAPE;
        color = Color.YELLOW;
    }

    @Override
    public void rotateClockwise() {
        // The O-shaped Tetrimino does not rotate
    }

    @Override
    public void rotateCounterClockwise() {
        // The O-shaped Tetrimino does not rotate
    }
}
