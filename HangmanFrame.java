import javax.swing.*;
import java.awt.*;

public class HangmanFrame extends JFrame {
    private final HangmanGame game;
    private final GameFieldsPanel gamePanel;
    private final StickfigureComponent figurePanel;

    public HangmanFrame() {
        game = new HangmanGame(WordManager.pickRandomWord());
        gamePanel = new GameFieldsPanel(game, this);
        figurePanel = new StickfigureComponent(game);

        setTitle("Hangman Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(figurePanel, BorderLayout.WEST);
        add(gamePanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void updateUIState() {
        gamePanel.update();
        figurePanel.repaint();
    }

    public void restartGame() {
        dispose();
        new HangmanFrame();
    }
}