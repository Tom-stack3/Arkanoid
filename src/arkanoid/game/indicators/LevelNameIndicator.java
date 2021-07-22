package arkanoid.game.indicators;

import arkanoid.shapes.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Tommy Zaft
 * <p>
 * In charge of displaying the Level's name.
 */
public class LevelNameIndicator implements Sprite {
    private final String levelName;
    private static final int X = 500;
    private static final int Y = 35;
    private static final int FONT_SIZE = 18;

    /**
     * constructor.
     *
     * @param name the level's name.
     */
    public LevelNameIndicator(String name) {
        this.levelName = name;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        String textToDisplay = "Level Name: " + this.levelName;
        d.drawText(X, Y, textToDisplay, FONT_SIZE);
    }

    @Override
    public void timePassed() {

    }
}
