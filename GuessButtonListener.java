import javax.swing.*;
import java.awt.event.*;

public class GuessButtonListener implements ActionListener {
    private final HangmanGame game;
    private final char letter;
    private final GameFieldsPanel panel;

    public GuessButtonListener(HangmanGame game, char letter, GameFieldsPanel panel) {
        this.game = game;
        this.letter = letter;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setEnabled(false);
        if (!game.isAlreadyGuessed(letter)) {
            game.guess(letter);
        }
        panel.frame.updateUIState();
    }
}
