import javax.swing.*;
import java.awt.*;

public class GameFieldsPanel extends JPanel {
    final HangmanGame game;
    final HangmanFrame frame;
    final JLabel wordLabel = new JLabel();
    final JLabel infoLabel = new JLabel();
    final JPanel buttonPanel = new JPanel();

    public GameFieldsPanel(HangmanGame game, HangmanFrame frame) {
        this.game = game;
        this.frame = frame;
        setLayout(new BorderLayout());
        wordLabel.setFont(new Font("Monospaced", Font.BOLD, 28));
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        add(wordLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(infoLabel, BorderLayout.SOUTH);

        buttonPanel.setLayout(new GridLayout(2, 13));
        for (char c = 'A'; c <= 'Z'; c++) {
            JButton btn = new JButton(String.valueOf(c));
            btn.addActionListener(new GuessButtonListener(game, c, this));
            buttonPanel.add(btn);
        }
        update();
    }

    public void update() {
        wordLabel.setText(game.getCurrentWordState());
        infoLabel.setText("attempts left : " + game.getRemainingTries() + " / wrong letters : " + game.getWrongGuesses());
        if (game.isWon()) {
            showEndDialog("축하합니다! 정답입니다!");
        } else if (game.isLost()) {
            showEndDialog("게임 오버! 정답은: " + game.getWordToGuess());
        }
    }

    private void showEndDialog(String message) {
        int result = JOptionPane.showConfirmDialog(this, message + "\n다시 시작하시겠습니까?", "게임 종료", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            frame.restartGame();
        } else {
            System.exit(0);
        }
    }
}
