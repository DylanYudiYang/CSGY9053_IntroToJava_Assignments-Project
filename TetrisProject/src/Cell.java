
import java.awt.Color;

public class Cell {
    private boolean filled;
    private Color color;

    public Cell() {
        this.filled = false;
        this.color = Color.BLACK;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
