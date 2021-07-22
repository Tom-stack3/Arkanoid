package arkanoid.game.levels;

import arkanoid.game.backgrounds.Background;
import arkanoid.game.backgrounds.SpaceLevelBackground;
import arkanoid.shapes.Block;
import arkanoid.shapes.Point;
import arkanoid.shapes.Rectangle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tommy Zaft
 * <p>
 * The SpaceLevel level information.
 */
public class SpaceLevel extends LevelInformationAbstract {
    private static final int PADDLE_WIDTH = 90;
    private static final int PADDLE_SPEED = 9;

    private static final int NUM_OF_BALLS = 2;
    private static final int BALLS_SPEED = 4;

    private static final int Y_OF_FIRST_ROW = 100 + Background.BORDER_SIZE;
    private static final int NUM_OF_BLOCKS_IN_FIRST_ROW = 12;
    private static final int NUM_OF_ROWS_OF_BLOCKS = 6;
    private static final int BLOCK_HEIGHT = 23;
    private static final int BLOCK_WIDTH = 50;

    private static final Color[] BLOCK_COLORS = {
            new Color(250, 85, 87), new Color(249, 162, 114),
            new Color(250, 207, 113), new Color(135, 183, 111),
            new Color(141, 223, 220), new Color(255, 214, 214)
    };


    /**
     * constructor.
     */
    public SpaceLevel() {
        super(PADDLE_WIDTH, PADDLE_SPEED, NUM_OF_BALLS, BALLS_SPEED, new SpaceLevelBackground(),
                "Space Mission", Color.white);
    }

    @Override
    protected List<Block> initBlocks() {
        List<Block> blocks = new ArrayList<>();
        int y = Y_OF_FIRST_ROW;
        int n = NUM_OF_BLOCKS_IN_FIRST_ROW;
        for (int i = 0; i < NUM_OF_ROWS_OF_BLOCKS; i++) {
            int x = Background.SCREEN_WIDTH - BLOCK_WIDTH - Background.BORDER_SIZE;
            for (int j = 0; j < n; j++) {
                Color blockColor;
                // if enough colors specified.
                if (i < BLOCK_COLORS.length) {
                    blockColor = BLOCK_COLORS[i];
                } else {
                    blockColor = Color.black;
                }
                Block b = new Block(new Rectangle(new Point(x, y), BLOCK_WIDTH, BLOCK_HEIGHT, blockColor));
                blocks.add(b);
                x -= BLOCK_WIDTH;
            }
            y += BLOCK_HEIGHT;
            n--;
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.getNumOfBlocks();
    }
}
