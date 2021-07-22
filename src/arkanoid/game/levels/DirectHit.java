package arkanoid.game.levels;

import arkanoid.game.backgrounds.DirectHitBackground;
import arkanoid.shapes.Block;
import arkanoid.shapes.Point;
import arkanoid.shapes.Rectangle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * @author Tommy Zaft
 * <p>
 * The DirectHit level information.
 */
public class DirectHit extends LevelInformationAbstract {
    private static final int PADDLE_WIDTH = 50;
    private static final int PADDLE_SPEED = 10;
    private static final Color BLOCK_COLOR = new Color(141, 223, 220);

    /**
     * constructor.
     */
    public DirectHit() {
        super(PADDLE_WIDTH, PADDLE_SPEED, 1, 5, new DirectHitBackground(),
                "Donut Hit", Color.white);
    }

    @Override
    protected List<Block> initBlocks() {
        return new ArrayList<>(Arrays.asList(new Block(new Rectangle(new Point(375, 250),
                50, 50, BLOCK_COLOR))));
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.getNumOfBlocks();
    }
}
