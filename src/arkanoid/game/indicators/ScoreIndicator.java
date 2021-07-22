package arkanoid.game.indicators;

import arkanoid.game.Counter;
import arkanoid.shapes.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Tommy Zaft
 * <p>
 * In charge of displaying the score.
 */
public class ScoreIndicator implements Sprite {
    private final Counter score;
    private static final int X = 350;
    private static final int Y = 35;
    private static final int FONT_SIZE = 18;

    /**
     * constructor.
     *
     * @param score the score counter.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        String textToDisplay = "Score: " + this.score.getValue();
        d.drawText(X, Y, textToDisplay, FONT_SIZE);
    }

    @Override
    public void timePassed() {

    }
}
