
import java.awt.Color;
import java.awt.Point;

public abstract class Tetromino {
    protected int[][] shape;
    protected Color color;
    protected Point position;

    public Tetromino() {
        position = new Point(0, 0);
    }

    public int[][] getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setPosition(int x, int y) {
        position.setLocation(x, y);
    }

    public void move(int dx, int dy) {
        position.translate(dx, dy);
    }

    public void moveDown() {
        move(0, 1);
    }

    public void moveLeft() {
        move(-1, 0);
    }

    public void moveRight() {
        move(1, 0);
    }

    public abstract void rotateClockwise();

    public abstract void rotateCounterClockwise();
}
