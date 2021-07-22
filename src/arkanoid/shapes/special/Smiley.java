package arkanoid.shapes.special;

import arkanoid.shapes.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Tommy Zaft
 * <p>
 * Drawing of a Smiley light
 */
public class Smiley implements Sprite {
    private static final Color YELLOW = new Color(255, 200, 61);
    private static final Color RED = new Color(250, 85, 87);
    private final Color faceColor;
    private final int x;
    private final int y;

    /**
     * constructor.
     *
     * @param x         x of the center of the circle.
     * @param y         y of the center of the circle.
     * @param faceColor the color of the face of the Smiley.
     */
    public Smiley(int x, int y, Color faceColor) {
        this.faceColor = faceColor;
        this.x = x;
        this.y = y;
    }

    /**
     * constructor.
     *
     * @param x x of the center of the circle.
     * @param y y of the center of the circle.
     */
    public Smiley(int x, int y) {
        this(x, y, YELLOW);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(faceColor);
        d.fillCircle(x, y, 50);
        d.setColor(Color.black);
        d.drawCircle(x, y, 50);
        // eyes
        d.fillCircle(x + 16, y - 19, 6);
        d.fillCircle(x - 16, y - 19, 6);
        int mouthX = x - 24;
        int mouthY = y + 5;
        int ovalHeight = 30;
        int rectHeight = 7;
        d.fillOval(mouthX, mouthY - 8, 50, ovalHeight);
        d.setColor(faceColor);
        d.fillRectangle(mouthX, mouthY - rectHeight - 10, 50, rectHeight + 10);
        d.setColor(Color.white);
        d.fillRectangle(mouthX, mouthY, 50, rectHeight);
        d.setColor(Color.black);
        d.drawRectangle(mouthX, mouthY, 50, rectHeight);
    }

    @Override
    public void timePassed() {
        //nothing
    }
}
