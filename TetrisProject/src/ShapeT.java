
import java.awt.Color;

public class ShapeT extends Tetromino {
    private static final int[][][] SHAPES = {
        {
            {0, 1, 0},
            {1, 1, 1}
        },
        {
            {1, 0},
            {1, 1},
            {1, 0}
        },
        {
            {1, 1, 1},
            {0, 1, 0}
        },
        {
            {0, 1},
            {1, 1},
            {0, 1}
        }
    };

    private int rotationState;

    public ShapeT() {
        super();
        shape = SHAPES[0];
        color = Color.MAGENTA;
        rotationState = 0;
    }

    @Override
    public void rotateClockwise() {
        rotationState = (rotationState + 1) % 4;
        shape = SHAPES[rotationState];
    }

    @Override
    public void rotateCounterClockwise() {
        rotationState = (rotationState - 1 + 4) % 4;
        shape = SHAPES[rotationState];
    }
}
