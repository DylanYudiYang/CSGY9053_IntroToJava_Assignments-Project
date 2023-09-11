# Tetris Game in Java

This is a simple implementation of the classic Tetris game in Java. The game uses Java's Swing library for the graphical user interface and SQLite database for managing high scores.

## Features

- Seven different Tetriminos: I, J, L, O, S, T, Z.
- Real-time Tetrimino falling.
- User controls for moving and rotating Tetriminos.
- Collision detection for Tetriminos and game board boundaries.
- Line clearing when a row is completely filled.
- Game over when a new Tetrimino cannot be spawned.
- Restart game option after game over.
- High score tracking and display using jdbc and SQLite.

## Requirements

- Java 8 or higher.
- SQLite JDBC driver.

## How to Play
 - Use the left and right arrow keys to move the falling Tetrimino horizontally.
 - Use the up arrow key & Z button to rotate the falling Tetrimino cockwise or counterclockwise.
 - Use the down arrow key to drop the falling Tetrimino faster.
 - Use P button key to pause/continue the game.
 - The game is over when a new Tetrimino cannot be spawned.
 - When the game is over, you can choose to restart the game or exit.