package arkanoid.shapes.special;

import arkanoid.game.backgrounds.Background;
import arkanoid.shapes.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Tommy Zaft
 * <p>
 * Drawing of a cloud.
 */
public class Cloud implements Sprite {
    private final int size;
    private int x;
    private final int y;
    private int lastCircleRadius;
    private int lastCircleCenterX;
    private final double speed;
    private int framesPassedSinceLastDrawing;

    private static final Color[] COLORS = {
            new Color(170, 170, 170), new Color(187, 187, 187),
            new Color(204, 204, 204)
    };

    /**
     * constructor.
     *
     * @param x     x of the center of the cloud.
     * @param y     y of the center of the cloud.
     * @param size  size.
     * @param speed speed
     */
    public Cloud(int x, int y, int size, double speed) {
        this.size = size;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.framesPassedSinceLastDrawing = (int) (1 / speed);
    }

    /**
     * constructor.
     *
     * @param x x of the center of the circle.
     * @param y y of the center of the circle.
     */
    public Cloud(int x, int y) {
        this(x, y, 30, 0.5);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(COLORS[0]);
        d.fillCircle(x, y, size);
        int nextX = x - 80 * size / 100;
        int nextY = y + 50 * size / 100;
        d.fillCircle(nextX, nextY, 80 * size / 100);
        d.setColor(COLORS[1]);
        nextX = nextX - 50 * size / 100;
        nextY = nextY - 75 * size / 100;
        d.fillCircle(nextX, nextY, 75 * size / 100);
        nextX = nextX - 50 * size / 100;
        nextY = nextY + 70 * size / 100;
        d.fillCircle(nextX, nextY, 70 * size / 100);
        d.setColor(COLORS[2]);
        nextX = nextX - 60 * size / 100;
        nextY = nextY - 60 * size / 100;
        d.fillCircle(nextX, nextY, 70 * size / 100);
        lastCircleRadius = 70 * size / 100;
        lastCircleCenterX = nextX;
    }

    /**
     * move the cloud.
     *
     * @param speedToMove speed
     */
    public void move(int speedToMove) {
        int newLeftMostPart = lastCircleCenterX + speedToMove - lastCircleRadius;
        if (newLeftMostPart > Background.SCREEN_WIDTH - Background.BORDER_SIZE) {
            this.x = 0;
        } else {
            this.x += speedToMove;
        }
    }

    @Override
    public void timePassed() {
        if (framesPassedSinceLastDrawing == (int) (1 / speed)) {
            move(1);
            framesPassedSinceLastDrawing = 0;
        } else {
            framesPassedSinceLastDrawing++;
        }
    }
}
