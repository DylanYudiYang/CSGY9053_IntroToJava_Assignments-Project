
import java.awt.Color;

public class ShapeZ extends Tetromino {
    private static final int[][][] SHAPES = {
        {
            {1, 1, 0},
            {0, 1, 1}
        },
        {
            {0, 1},
            {1, 1},
            {1, 0}
        }
    };

    private int rotationState;

    public ShapeZ() {
        super();
        shape = SHAPES[0];
        color = Color.RED;
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
