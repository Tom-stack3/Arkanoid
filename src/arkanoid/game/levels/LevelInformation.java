package arkanoid.game.levels;

import arkanoid.shapes.Block;
import arkanoid.shapes.Sprite;
import arkanoid.shapes.Velocity;

import java.awt.Color;
import java.util.List;

/**
 * @author Tommy Zaft
 * <p>
 * Holds the level information.
 */
public interface LevelInformation {
    /**
     * get the number of balls.
     *
     * @return the number of balls.
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball.
     * Note that initialBallVelocities().size() == numberOfBalls()
     *
     * @return The initial velocity of each ball
     */
    List<Velocity> initialBallVelocities();

    /**
     * get the paddle speed.
     *
     * @return the paddle speed
     */
    int paddleSpeed();

    /**
     * get the paddle width.
     *
     * @return the paddle width
     */
    int paddleWidth();

    /**
     * get the level name that will be displayed at the top of the screen.
     *
     * @return the level name
     */
    String levelName();

    /**
     * Returns a sprite with the Background of the level.
     *
     * @return Returns a sprite with the Background of the level
     */
    Sprite getBackground();

    /**
     * The Blocks that make up this level, each block contains: its size, color and location.
     *
     * @return The Blocks that make up this level
     */
    List<Block> blocks();

    /**
     * Number of blocks that should be removed before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     *
     * @return the number of blocks that should be removed before the level is considered to be "cleared".
     */
    int numberOfBlocksToRemove();

    /**
     * get ball color.
     *
     * @return get ball color.
     */
    Color getBallColor();

}
