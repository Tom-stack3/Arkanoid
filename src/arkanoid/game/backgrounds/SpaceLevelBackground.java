package arkanoid.game.backgrounds;

import arkanoid.shapes.Ball;
import arkanoid.shapes.Block;
import arkanoid.shapes.Point;
import arkanoid.shapes.Rectangle;
import arkanoid.shapes.special.Moon;

import java.awt.Color;
import java.util.Random;

/**
 * @author Tommy Zaft
 * <p>
 * The SpaceLevel level Background.
 */
public class SpaceLevelBackground extends Background {
    private static final int NUMBER_OF_STARS = 400;

    /**
     * constructor.
     */
    public SpaceLevelBackground() {
        this.addSprite(new Block(new Rectangle(new Point(0, 0), SCREEN_WIDTH, SCREEN_HEIGHT,
                new Color(42, 20, 106))));
        // draw stars
        Random rand = new Random();
        for (int i = 0; i < NUMBER_OF_STARS; i++) {
            int x = rand.nextInt(SCREEN_WIDTH - 2 * BORDER_SIZE) + BORDER_SIZE;
            int y = rand.nextInt(SCREEN_WIDTH - 2 * BORDER_SIZE) + BORDER_SIZE;
            int size = rand.nextInt(2) + 1;
            this.addSprite(new Ball(new Point(x, y), size, Color.white));
        }
        this.addSprite(new Moon(175, 430));
    }
}
