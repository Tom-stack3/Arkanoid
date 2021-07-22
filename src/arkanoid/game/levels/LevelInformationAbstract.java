package arkanoid.game.levels;

import arkanoid.shapes.Block;
import arkanoid.shapes.Sprite;
import arkanoid.shapes.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tommy Zaft
 * <p>
 * An abstract class implements LevelInformation.
 */
public abstract class LevelInformationAbstract implements LevelInformation {
    private final List<Velocity> velocities;
    private List<Block> blocks;
    private final Sprite background;

    private final int paddleWidth;
    private final int paddleSpeed;

    private final int numOfBalls;
    private final int ballsSpeed;
    private final Color ballColor;

    private final String levelName;

    /**
     * constructor.
     *
     * @param paddleWidth paddleWidth
     * @param paddleSpeed paddleSpeed
     * @param numOfBalls  numOfBalls
     * @param ballsSpeed  ballsSpeed
     * @param background  background
     * @param levelName   levelName
     * @param ballColor   ballColor
     */
    public LevelInformationAbstract(int paddleWidth, int paddleSpeed, int numOfBalls,
                                    int ballsSpeed, Sprite background, String levelName, Color ballColor) {
        this.paddleWidth = paddleWidth;
        this.paddleSpeed = paddleSpeed;
        this.numOfBalls = numOfBalls;
        this.ballsSpeed = ballsSpeed;
        this.velocities = initVelocity();
        this.background = background;
        this.levelName = levelName;
        this.blocks = initBlocks();
        this.ballColor = ballColor;
    }

    /**
     * init blocks.
     *
     * @return List<Block> of blocks.
     */
    protected abstract List<Block> initBlocks();

    /**
     * init Velocities.
     *
     * @return list of the Velocities initialized.
     */
    protected List<Velocity> initVelocity() {
        List<Velocity> velocitiesCopy = new ArrayList<>();
        int numOfBallsInHalf = numOfBalls / 2;
        for (int i = 0; i < numOfBalls / 2; i++) {
            velocitiesCopy.add(new Velocity(Velocity.fromAngleAndSpeed((-90.0 + (90.0 / (numOfBallsInHalf + 1))
                    * (i + 1)), ballsSpeed)));
        }
        if (numOfBalls % 2 == 1) {
            velocitiesCopy.add(new Velocity(Velocity.fromAngleAndSpeed(0, ballsSpeed)));
        }
        for (int i = 0; i < numOfBallsInHalf; i++) {
            velocitiesCopy.add(new Velocity(Velocity.fromAngleAndSpeed((90.0 / (numOfBallsInHalf + 1)) * (i + 1),
                    ballsSpeed)));
        }

        return velocitiesCopy;
    }

    @Override
    public int numberOfBalls() {
        return this.velocities.size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return this.velocities;
    }

    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }

    @Override
    public String levelName() {
        return this.levelName;
    }

    @Override
    public Sprite getBackground() {
        return this.background;
    }

    @Override
    public Color getBallColor() {
        return this.ballColor;
    }

    @Override
    public List<Block> blocks() {
        return this.blocks;
    }

    /**
     * get number of blocks.
     *
     * @return get number of blocks
     */
    public int getNumOfBlocks() {
        return blocks.size();
    }

    @Override
    public abstract int numberOfBlocksToRemove();
}
