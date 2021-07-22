package arkanoid.shapes.special;

import arkanoid.shapes.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.Random;

/**
 * @author Tommy Zaft
 * <p>
 * Drawing of a building.
 */
public class Building implements Sprite {
    private static final Color[] BODY_COLORS = {
            new Color(184, 199, 210), Color.gray,
            new Color(138, 129, 148), new Color(106, 107, 127),
            new Color(161, 154, 169), new Color(80, 77, 84),
            new Color(185, 184, 187), new Color(115, 101, 116),
            new Color(128, 125, 136)
    };

    private static final Color[] WINDOW_COLORS = {
            new Color(25, 42, 60), new Color(85, 120, 155),
            new Color(77, 108, 140), new Color(45, 140, 215),
            new Color(56, 70, 83), new Color(65, 94, 124),
            new Color(76, 92, 106), new Color(24, 40, 57),
            new Color(50, 84, 125)
    };

    private static final int MAX_WIDTH = 50;
    private static final int MIN_WIDTH = 25;
    private static final int MAX_HEIGHT = 150;
    private static final int MIN_HEIGHT = 50;

    private final int x;
    private final int y;
    private final int maxHeight;
    private int width;
    private int height;
    private Color bodyColor;
    private Color windowsColor;
    private int numOfWindowsInRow;
    private int numOfWindowsRows;

    /**
     * constructor.
     *
     * @param x         x of the left bottom of the building
     * @param y         y of the left bottom of the building
     * @param maxHeight the max height of the building
     */
    public Building(int x, int y, int maxHeight) {
        this.x = x;
        this.y = y;
        this.maxHeight = maxHeight;
        initBuilding();
    }

    /**
     * constructor.
     *
     * @param x x of the left bottom of the building
     * @param y y of the left bottom of the building
     */
    public Building(int x, int y) {
        this(x, y, MAX_HEIGHT);
    }

    /**
     * init a building.
     */
    private void initBuilding() {
        Random rand = new Random();
        this.width = rand.nextInt(MAX_WIDTH - MIN_WIDTH) + MIN_WIDTH;
        this.height = rand.nextInt(maxHeight - MIN_HEIGHT) + MIN_WIDTH;
        this.bodyColor = BODY_COLORS[(rand.nextInt(100) + BODY_COLORS.length) % BODY_COLORS.length];
        this.windowsColor = WINDOW_COLORS[(rand.nextInt(100) + WINDOW_COLORS.length) % WINDOW_COLORS.length];
        this.numOfWindowsInRow = rand.nextInt(3) + 2;
        this.numOfWindowsRows = rand.nextInt(5) + 2;
        ;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(bodyColor);
        d.fillRectangle(x, y - height, width, height);
        d.setColor(windowsColor);
        int windowWidth = width / (numOfWindowsInRow + 1);
        int windowHeight = height / (numOfWindowsRows + 1);
        int currentY = this.y - height + windowHeight / 3;
        for (int row = 0; row < numOfWindowsRows; row++) {
            int currentX = this.x + windowWidth / 3;
            for (int c = 0; c < numOfWindowsInRow; c++) {
                if (currentX + windowWidth > this.x + this.width) {
                    break;
                }
                d.fillRectangle(currentX, currentY, windowWidth, windowHeight);
                currentX += 3 * windowWidth / 2;
            }
            if (currentY + windowHeight > this.y + this.height) {
                break;
            }
            currentY += 3 * windowHeight / 2;
        }
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
