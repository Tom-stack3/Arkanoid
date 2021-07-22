package arkanoid.shapes.special;

import arkanoid.shapes.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Tommy Zaft
 * <p>
 * Drawing of a Among-us character
 * (some may say amogus).
 */
public class Amongus implements Sprite {
    private static final Color RED = new Color(195, 17, 17);
    private static final Color EYES = new Color(153, 204, 205);
    private static final Color OUTER_EYES = new Color(86, 141, 141);

    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final Color bodyColor;

    /**
     * constructor.
     *
     * @param x         x
     * @param y         y
     * @param bodyColor the bodyColor
     */
    public Amongus(int x, int y, Color bodyColor) {
        this.x = x;
        this.y = y;
        this.width = 80;
        this.height = 60;
        this.bodyColor = bodyColor;
    }

    /**
     * default constructor.
     *
     * @param x x
     * @param y y
     */
    public Amongus(int x, int y) {
        this(x, y, RED);
    }

    @Override
    public void drawOn(DrawSurface d) {
        // backpack
        d.setColor(bodyColor);
        d.fillOval(x - 20, y - height + 5, width / 2, height);
        // body
        d.fillCircle(x + width / 2, y - height, width / 2);
        d.fillOval(x, y - height / 4, width, height / 2);
        d.fillRectangle(x, y - height, width, height);

        final int legsY = y - height + 53 + 45 * height / 100;
        // right leg
        drawLeg(d, legsY, x);


        // left leg
        final int leftLegX = x + width - width / 3;
        drawLeg(d, legsY, leftLegX);

        // eyes
        d.setColor(OUTER_EYES);
        d.fillOval(x + 20, y - height - 20, 75 * width / 100, height / 2);
        d.setColor(EYES);
        d.fillOval(x + 25, y - height - 20, 68 * width / 100, height / 2 - 5);
    }

    /**
     * draw a leg.
     *
     * @param d     DrawSurface
     * @param legsY legY
     * @param legX  legX
     */
    private void drawLeg(DrawSurface d, int legsY, int legX) {
        d.setColor(bodyColor);
        d.fillRectangle(legX, y - height + 60, width / 3, 45 * height / 100);
        d.fillOval(legX, legsY, width / 3, height / 4);
        d.fillRectangle(legX, y - height + 60, width / 3, 45 * height / 100);
        d.fillOval(legX, y - height + 53, width / 3, height / 4);
    }

    /**
     * get width of building.
     *
     * @return get width of building.
     */
    public int getWidth() {
        return width;
    }

    @Override
    public void timePassed() {
        //nothing
    }
}
