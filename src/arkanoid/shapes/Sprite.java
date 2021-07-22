package arkanoid.shapes;

import biuoop.DrawSurface;

/**
 * @author Tommy Zaft
 * <p>
 * An interface for a Sprite object.
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     *
     * @param d the DrawSurface to draw on
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}
