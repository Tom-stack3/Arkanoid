package arkanoid.game.backgrounds;

import arkanoid.shapes.Block;
import arkanoid.shapes.Point;
import arkanoid.shapes.Rectangle;
import arkanoid.shapes.special.Donut;

import java.awt.Color;

/**
 * @author Tommy Zaft
 * <p>
 * The DirectHit level Background.
 */
public class DirectHitBackground extends Background {
    private static final int NUMBER_OF_STARS = 400;
    private static final Color BACKGROUND_COLOR = new Color(23, 135, 207);

    /**
     * constructor.
     */
    public DirectHitBackground() {
        this.addSprite(new Block(new Rectangle(new Point(0, 0), SCREEN_WIDTH, SCREEN_HEIGHT, BACKGROUND_COLOR)));
        this.addSprite(new Donut(400, 275, BACKGROUND_COLOR, 120, true));

        this.addSprite(new Donut(500, 100, BACKGROUND_COLOR, 35, false));
        this.addSprite(new Donut(102, 150, BACKGROUND_COLOR, 42, false));
        this.addSprite(new Donut(170, 480, BACKGROUND_COLOR, 30, false));
        this.addSprite(new Donut(640, 300, BACKGROUND_COLOR, 48, false));
        this.addSprite(new Donut(450, 510, BACKGROUND_COLOR, 52, false));
        this.addSprite(new Donut(680, 368, BACKGROUND_COLOR, 35, false));
    }
}
