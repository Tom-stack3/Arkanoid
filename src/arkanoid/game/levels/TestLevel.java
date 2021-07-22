package arkanoid.game.levels;

import arkanoid.game.backgrounds.FinalOneBackground;
import arkanoid.shapes.Block;
import arkanoid.shapes.Point;
import arkanoid.shapes.Rectangle;
import arkanoid.shapes.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tommy Zaft
 * <p>
 * Testing level.
 */
public class TestLevel extends LevelInformationAbstract {
    private static final int PADDLE_WIDTH = 200;
    private static final int PADDLE_SPEED = 10;
    private static final Color BLOCK_COLOR = new Color(141, 223, 220);

    /**
     * constructor.
     */
    public TestLevel() {
        super(PADDLE_WIDTH, PADDLE_SPEED, 1, 5, new FinalOneBackground(),
                "Test Level", Color.black);
    }

    @Override
    protected List<Block> initBlocks() {
        return new ArrayList<>(Arrays.asList(new Block(new Rectangle(new Point(900, 250),
                50, 50, BLOCK_COLOR))));
    }

    @Override
    protected List<Velocity> initVelocity() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(new Velocity(10, -5));

        return velocities;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.getNumOfBlocks();
    }
}
