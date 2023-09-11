
import java.awt.Color;

public class ShapeJ extends Tetromino {
    private static final int[][][] SHAPES = {
        {
            {1, 0, 0},
            {1, 1, 1}
        },
        {
            {1, 1},
            {1, 0},
            {1, 0}
        },
        {
            {1, 1, 1},
            {0, 0, 1}
        },
        {
            {0, 1},
            {0, 1},
            {1, 1}
        }
    };

    private int rotationState;

    public ShapeJ() {
        super();
        shape = SHAPES[0];
        color = Color.BLUE;
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
