
import java.awt.Color;

public class ShapeI extends Tetromino {
    private static final int[][][] SHAPES = {
        {
            {1, 1, 1, 1}
        },
        {
            {1},
            {1},
            {1},
            {1}
        }
    };

    private int rotationState;

    public ShapeI() {
        super();
        shape = SHAPES[0];
        color = Color.CYAN;
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
