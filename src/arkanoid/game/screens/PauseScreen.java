package arkanoid.game.screens;

import arkanoid.game.Animation;
import biuoop.DrawSurface;

import arkanoid.shapes.special.Smiley;

/**
 * @author Tommy Zaft
 * <p>
 * The pause screen. Showing when 'p' is pressed.
 */
public class PauseScreen implements Animation {

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, 7 * d.getHeight() / 18, "Paused -- please press space to continue", 32);
        int x = d.getWidth() / 2;
        int y = 10 * d.getHeight() / 18;
        new Smiley(x, y).drawOn(d);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
