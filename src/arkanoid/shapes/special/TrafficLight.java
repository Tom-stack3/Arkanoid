package arkanoid.shapes.special;

import arkanoid.shapes.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Tommy Zaft
 * <p>
 * Drawing of a traffic light
 */
public class TrafficLight implements Sprite {
    private static final int TRAFFIC_LIGHT_WIDTH = 50;
    private static final int TRAFFIC_LIGHT_HEIGHT = 70;
    private final Color lightColor;
    private final int x;
    private final int y;

    private static final Color RED = new Color(228, 0, 0);

    /**
     * constructor.
     *
     * @param x          x
     * @param y          y
     * @param lightColor the light color.
     */
    public TrafficLight(int x, int y, Color lightColor) {
        this.lightColor = lightColor;
        this.x = x;
        this.y = y;
    }

    /**
     * constructor.
     *
     * @param x x
     * @param y y
     */
    public TrafficLight(int x, int y) {
        this(x, y, RED);

    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(x, y, TRAFFIC_LIGHT_WIDTH, TRAFFIC_LIGHT_HEIGHT);
        d.setColor(lightColor);
        d.fillCircle(x + TRAFFIC_LIGHT_WIDTH / 2, y + TRAFFIC_LIGHT_HEIGHT / 2, 40 * TRAFFIC_LIGHT_WIDTH / 100);
        d.setColor(Color.black);
    }

    @Override
    public void timePassed() {

    }
}
