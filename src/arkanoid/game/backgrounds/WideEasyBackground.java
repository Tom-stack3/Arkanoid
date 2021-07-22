package arkanoid.game.backgrounds;

import arkanoid.shapes.Block;
import arkanoid.shapes.Point;
import arkanoid.shapes.Rectangle;
import arkanoid.shapes.special.Building;
import arkanoid.shapes.special.Cloud;

import java.awt.Color;

/**
 * @author Tommy Zaft
 * <p>
 * The WideEasy level Background.
 */
public class WideEasyBackground extends Background {
    /**
     * constructor.
     */
    public WideEasyBackground() {
        this.addSprite(new Block(new Rectangle(new Point(0, 0), SCREEN_WIDTH, SCREEN_HEIGHT,
                new Color(81, 75, 120))));
        int i = BORDER_SIZE;
        while (i < SCREEN_WIDTH - BORDER_SIZE) {
            Building building = new Building(i, SCREEN_HEIGHT);
            this.addSprite(building);
            i += building.getWidth();
        }
        this.addSprite(new Cloud(200, 420));
        this.addSprite(new Cloud(600, 460, 22, 0.5));
        this.addSprite(new Cloud(410, 410, 21, 0.4));
        this.addSprite(new Cloud(390, 425, 18, 0.3));
        this.addSprite(new Cloud(50, 370, 19, 0.3));
        this.addSprite(new Cloud(740, 360, 18, 0.2));
    }
}
