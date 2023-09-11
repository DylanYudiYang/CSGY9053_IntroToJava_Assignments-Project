
import java.awt.Color;

public class ShapeS extends Tetromino {
    private static final int[][][] SHAPES = {
        {
            {0, 1, 1},
            {1, 1, 0}
        },
        {
            {1, 0},
            {1, 1},
            {0, 1}
        }
    };

    private int rotationState;

    public ShapeS() {
        super();
        shape = SHAPES[0];
        color = Color.GREEN;
        rotationState = 0;
    }

    @Override
    public void rotateClockwise() {
        rotationState = (rotationState + 1) % 2;
        shape = SHAPES[rotationState];
    }

    @Override
    public void rotateCounterClockwise() {
        rotationState = (rotationState - 1 + 2) % 2;
        shape = SHAPES[rotationState];
    }
}
