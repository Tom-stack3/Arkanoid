package arkanoid.game.levels;

import arkanoid.game.backgrounds.Background;
import arkanoid.game.backgrounds.WideEasyBackground;
import arkanoid.shapes.Block;
import arkanoid.shapes.Point;
import arkanoid.shapes.Rectangle;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tommy Zaft
 * <p>
 * The Wide and easy level.
 */
public class WideEasy extends LevelInformationAbstract {
    private static final int PADDLE_WIDTH = 500;
    private static final int PADDLE_SPEED = 6;

    private static final int NUM_OF_BALLS = 10;
    private static final int BALLS_SPEED = 4;

    private static final int SCREEN_WIDTH = 800;

    private static final int Y_OF_ROW = 100 + Background.BORDER_SIZE;
    private static final int BLOCK_HEIGHT = 23;
    private static final int BLOCK_WIDTH = 50;
    private static final int NUM_OF_BLOCKS_IN_ROW = (SCREEN_WIDTH - 2 * Background.BORDER_SIZE) / BLOCK_WIDTH;

    private static final Color[] BLOCK_COLORS = {
            new Color(250, 85, 87), new Color(249, 162, 114),
            new Color(250, 207, 113), new Color(135, 183, 111),
            new Color(141, 223, 220), new Color(255, 214, 214),
            new Color(234, 154, 255)
    };

    /**
     * constructor.
     */
    public WideEasy() {
        super(PADDLE_WIDTH, PADDLE_SPEED, NUM_OF_BALLS, BALLS_SPEED, new WideEasyBackground(),
                "Night city", Color.white);
    }

    @Override
    protected List<Block> initBlocks() {
        List<Block> blocks = new ArrayList<>();

        for (int i = 0; i < NUM_OF_BLOCKS_IN_ROW; i++) {
            int x = SCREEN_WIDTH - BLOCK_WIDTH - Background.BORDER_SIZE - i * BLOCK_WIDTH;
            Block b = new Block(new Rectangle(new Point(x, Y_OF_ROW), BLOCK_WIDTH, BLOCK_HEIGHT, BLOCK_COLORS[i / 2]));
            blocks.add(b);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.getNumOfBlocks();
    }
}
