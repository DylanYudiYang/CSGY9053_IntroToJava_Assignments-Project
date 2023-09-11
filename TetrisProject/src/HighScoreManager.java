import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HighScoreManager {
    private static final String DB_URL = "jdbc:sqlite:highscore.db";
    private static final String TABLE_NAME = "highscores";
    private static final String SCORE_COLUMN_NAME = "score";

    public HighScoreManager() {
        initDB();
    }

    private void initDB() {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (\n"
                + SCORE_COLUMN_NAME + " INTEGER NOT NULL\n"
                + ");";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {

            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveScore(int score) {
        String sql = "INSERT INTO " + TABLE_NAME + " (" + SCORE_COLUMN_NAME + ") VALUES(?)";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, score);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isNewHighScore(int score) {
        int highScore = getHighestScore();
        return score > highScore;
    }

    public static int getHighestScore() {
        String sql = "SELECT MAX(" + SCORE_COLUMN_NAME + ") AS maxScore FROM " + TABLE_NAME;

        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            if (resultSet.next()) {
                return resultSet.getInt("maxScore");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0; // return 0 if there's no score in the database yet or an error occurred
    }
}
