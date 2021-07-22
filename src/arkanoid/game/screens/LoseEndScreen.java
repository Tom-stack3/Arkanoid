package arkanoid.game.screens;

import arkanoid.game.Animation;
import arkanoid.shapes.special.SadSmiley;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Tommy Zaft
 * <p>
 * The end screen showing up if a player wins the game. Closes when a 'space' is entered.
 */
public class LoseEndScreen implements Animation {
    private final int score;

    /**
     * constructor.
     *
     * @param score score
     */
    public LoseEndScreen(int score) {
        this.score = score;
    }


    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        int textX = d.getWidth() / 2 - 250;
        d.setColor(Color.RED);
        d.drawText(textX - 4, 7 * d.getHeight() / 18, "Oof, You lose.", 70);
        d.drawText(textX - 2, 7 * d.getHeight() / 18 + 50, "Final score: " + score, 20);
        d.drawText(textX - 2, 7 * d.getHeight() / 18 + 200, "Press space to continue", 20);

        d.setColor(Color.white);
        d.drawText(textX, 7 * d.getHeight() / 18, "Oof, You lose.", 70);
        d.drawText(textX, 7 * d.getHeight() / 18 + 50, "Final score: " + score, 20);
        d.drawText(textX, 7 * d.getHeight() / 18 + 200, "Press space to continue", 20);


        int x = d.getWidth() / 2;
        int y = 7 * d.getHeight() / 18 + 100;
        new SadSmiley(x, y).drawOn(d);

    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
