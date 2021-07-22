package arkanoid.shapes.special;

import arkanoid.shapes.Point;
import arkanoid.shapes.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Tommy Zaft
 * <p>
 * Drawing of a cloud.
 */
public class Moon implements Sprite {
    private final int size;
    private final int x;
    private final int y;
    private final List<Point> craters;
    private final List<Integer> cratersRadius;

    private static final Color MOON_COLOR = new Color(198, 198, 198);
    private static final Color CRATER_COLOR = new Color(170, 170, 170);
    private static final int NUM_OF_CRATERS = 45;
    private static final int MAX_PERCENTAGE_OF_SIZE = 18;


    /**
     * constructor.
     *
     * @param x    x of the center of the moon.
     * @param y    y of the center of the moon.
     * @param size size.
     */
    public Moon(int x, int y, int size) {
        this.size = size;
        this.x = x;
        this.y = y;
        this.craters = new ArrayList<>();
        this.cratersRadius = new ArrayList<>();
        initCraters();
    }

    /**
     * initialize craters on the moon.
     */
    private void initCraters() {
        Random rand = new Random();
        for (int i = 0; i < NUM_OF_CRATERS; i++) {
            int craterRadius = (int) ((size) * ((rand.nextInt(MAX_PERCENTAGE_OF_SIZE - 1) + 1) / 100.0));
            craters.add(getCraterPoint(craterRadius));
            cratersRadius.add(craterRadius);
        }
    }

    /**
     * constructor.
     *
     * @param x x of the center of the circle.
     * @param y y of the center of the circle.
     */
    public Moon(int x, int y) {
        this(x, y, 58);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(MOON_COLOR);
        d.fillCircle(x, y, size);
        d.setColor(CRATER_COLOR);
        for (int i = 0; i < craters.size(); i++) {
            d.fillCircle((int) craters.get(i).getX(), (int) craters.get(i).getY(), cratersRadius.get(i));
        }
    }

    /**
     * randomXOrY.
     *
     * @param digit x or y
     * @return randomXOrY
     */
    private int randomXOrY(int digit) {
        Random rand = new Random();
        int sign = 1;
        if (rand.nextBoolean()) {
            sign = -1;
        }
        return sign * rand.nextInt(size) + digit;
    }

    /**
     * get crater Point.
     *
     * @param radius radius
     * @return get crater Point
     */
    private Point getCraterPoint(int radius) {
        Point center = new Point(x, y);
        Point craterCenter = new Point(randomXOrY(x), randomXOrY(y));
        while (center.distance(craterCenter) > size - radius) {
            craterCenter = new Point(randomXOrY(x), randomXOrY(y));
        }
        return craterCenter;
    }

    @Override
    public void timePassed() {
        //nothing
    }
}
