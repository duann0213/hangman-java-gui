import javax.swing.*;
import java.awt.*;

public class StickfigureComponent extends JComponent {
    private final HangmanGame game;

    public StickfigureComponent(HangmanGame game) {
        this.game = game;
        setPreferredSize(new Dimension(200, 300));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Gallows
        g2.drawLine(50, 250, 150, 250); // base
        g2.drawLine(100, 250, 100, 50); // pole
        g2.drawLine(100, 50, 160, 50);  // top
        g2.drawLine(160, 50, 160, 80);  // rope

        int wrong = game.getWrongGuessCount();
        if (wrong >= 1) g2.drawOval(140, 80, 40, 40);           // head
        if (wrong >= 2) g2.drawLine(160, 120, 160, 180);        // body
        if (wrong >= 3) g2.drawLine(160, 130, 130, 160);        // left arm
        if (wrong >= 4) g2.drawLine(160, 130, 190, 160);        // right arm
        if (wrong >= 5) g2.drawLine(160, 180, 140, 220);        // left leg
        if (wrong >= 6) g2.drawLine(160, 180, 180, 220);        // right leg
    }
}