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
public class Donut implements Sprite {
    private final int size;
    private final int innerRadius;
    private final int x;
    private final int y;
    private final List<Point> sparkles;
    private final List<Color> sparklesColors;
    private final List<Integer> sparklesSize;
    private final Color background;

    private static final Color PINK = new Color(241, 138, 159);
    private static final Color BROWN = new Color(245, 196, 153);
    private static final Color[] SPARKLES_COLORS = {new Color(112, 197, 217), new Color(107, 65, 0)};
    private static final int NUM_OF_SPARKLES = 700;
    private static final int MAX_PERCENTAGE_OF_SIZE = 5;
    private final Boolean drawOutside;


    /**
     * constructor.
     *
     * @param x           x of the center of the donut.
     * @param y           y of the center of the donut.
     * @param background  background
     * @param size        size.
     * @param drawOutside draw outside or not
     */
    public Donut(int x, int y, Color background, int size, Boolean drawOutside) {
        this.size = size;
        this.innerRadius = (int) (size * 0.5);
        this.x = x;
        this.y = y;
        this.sparkles = new ArrayList<>();
        this.sparklesColors = new ArrayList<>();
        this.sparklesSize = new ArrayList<>();
        this.background = background;
        this.drawOutside = drawOutside;
        initSparkles();
    }

    /**
     * initialize craters on the donut.
     */
    private void initSparkles() {
        Random rand = new Random();
        for (int i = 0; i < NUM_OF_SPARKLES; i++) {
            int radius = (int) ((size) * ((rand.nextInt(MAX_PERCENTAGE_OF_SIZE - 1) + 1) / 100.0));
            sparkles.add(getSparkleLine(radius));
            sparklesColors.add(SPARKLES_COLORS[rand.nextInt(SPARKLES_COLORS.length)]);
            sparklesSize.add(radius);
        }
    }

    /**
     * constructor.
     *
     * @param x          x of the center of the circle.
     * @param y          y of the center of the circle.
     * @param background background
     */
    public Donut(int x, int y, Color background) {
        this(x, y, background, 60, false);
    }

    @Override
    public void drawOn(DrawSurface d) {
        if (drawOutside) {
            d.setColor(BROWN);
            d.fillCircle(x - 5, y - 5, size);
        }
        d.setColor(PINK);
        d.fillCircle(x, y, size);
        d.setColor(BROWN);
        d.fillCircle(x, y, innerRadius);
        d.setColor(background);
        d.fillCircle(x, y, (int) (innerRadius * 0.9));
        for (int i = 0; i < sparkles.size(); i++) {
            d.setColor(sparklesColors.get(i));
            d.fillCircle((int) sparkles.get(i).getX(), (int) sparkles.get(i).getY(), sparklesSize.get(i));
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
     * get Point.
     *
     * @param radius radius
     * @return get Point
     */
    private Point getSparkleLine(int radius) {
        Point center = new Point(x, y);
        Point start = new Point(randomXOrY(x), randomXOrY(y));
        double dist = center.distance(start);
        while (dist + radius > size || dist - radius < innerRadius) {
            start = new Point(randomXOrY(x), randomXOrY(y));
            dist = center.distance(start);
        }
        return start;
    }

    @Override
    public void timePassed() {
        //nothing
    }
}
