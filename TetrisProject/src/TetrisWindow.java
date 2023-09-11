import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// TetrisWindow class for creating the game window
public class TetrisWindow extends JFrame {
    public TetrisWindow() {
        TetrisUI tetrisUI = new TetrisUI();
        add(tetrisUI);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        int newH = Tetris.BOARD_HEIGHT + 7;
        int newW = Tetris.BOARD_WIDTH;
        setSize(newW * TetrisUI.CELL_SIZE, newH * TetrisUI.CELL_SIZE);
        setLocationRelativeTo(null);
        setTitle("Tetris Game");
        setResizable(false);
        setVisible(true);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TetrisWindow());
    }
}