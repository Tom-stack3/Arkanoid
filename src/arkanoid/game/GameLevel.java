package arkanoid.game;

import arkanoid.game.hitListeners.BallRemover;
import arkanoid.game.hitListeners.BlockRemover;
import arkanoid.game.hitListeners.ScoreTrackingListener;
import arkanoid.game.indicators.LevelNameIndicator;
import arkanoid.game.indicators.ScoreIndicator;
import arkanoid.game.levels.LevelInformation;
import arkanoid.game.screens.KeyPressStoppableAnimation;
import arkanoid.game.screens.PauseScreen;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

import arkanoid.shapes.Sprite;
import arkanoid.shapes.Collidable;
import arkanoid.shapes.Paddle;
import arkanoid.shapes.Block;
import arkanoid.shapes.Rectangle;
import arkanoid.shapes.Ball;
import arkanoid.shapes.Point;

import arkanoid.game.hitListeners.HitListener;

/**
 * @author Tommy Zaft
 * <p>
 * Represents a Game Level.
 */
public class GameLevel implements Animation {
    private final LevelInformation levelInformation;

    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter blockCounter;
    private Counter scoreCounter;
    private Counter ballsCounter;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;


    private static final int BORDER_SIZE = 50;
    private static final Color BORDER_COLOR = Color.gray;

    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;

    private static final int BALLS_RADIUS = 5;

    private static final int POINTS_FOR_CLEARING_LEVEL = 100;

    /**
     * constructor.
     *
     * @param levelInformation levelInformation
     * @param ks               KeyboardSensor
     * @param ar               AnimationRunner
     * @param gui              GUI
     * @param scoreCounter     Counter
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor ks, AnimationRunner ar, GUI gui,
                     Counter scoreCounter) {
        this.levelInformation = levelInformation;
        this.scoreCounter = scoreCounter;
        this.keyboard = ks;
        this.runner = ar;
        this.gui = gui;
    }


    /**
     * adds a Collidable object to the GameLevel Environment.
     *
     * @param c the Collidable to add.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * adds a sprite to the SpriteCollection list.
     *
     * @param s the sprite to add.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle) and add them to the game.
     */
    public void initialize() {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.blockCounter = new Counter();
        this.ballsCounter = new Counter(levelInformation.numberOfBalls());

        //add Background
        this.addSprite(levelInformation.getBackground());

        Paddle paddle = new Paddle(this.keyboard, levelInformation.paddleWidth(), levelInformation.paddleSpeed());
        paddle.addToGame(this);

        List<Block> blocks = levelInformation.blocks();
        blockCounter.increase(blocks.size());
        List<Block> borders = new ArrayList<>();

        Block topBorder = new Block(new Rectangle(new Point(0, 0), SCREEN_WIDTH - BORDER_SIZE, BORDER_SIZE
                , BORDER_COLOR));
        Block rightBorder = new Block(new Rectangle(new Point(SCREEN_WIDTH - BORDER_SIZE, 0), BORDER_SIZE,
                SCREEN_HEIGHT, BORDER_COLOR));
        Block leftBorder = new Block(new Rectangle(new Point(0, BORDER_SIZE), BORDER_SIZE,
                SCREEN_HEIGHT - BORDER_SIZE, BORDER_COLOR));
        borders.add(topBorder);
        borders.add(rightBorder);
        borders.add(leftBorder);
        Block deathZone = new Block(new Rectangle(new Point(-SCREEN_WIDTH, SCREEN_HEIGHT + BALLS_RADIUS),
                3 * SCREEN_WIDTH, BORDER_SIZE, BORDER_COLOR));


        HitListener blockHitListener = new BlockRemover(this, this.blockCounter);
        HitListener scoreHitListener = new ScoreTrackingListener(this.scoreCounter);
        for (Block bl : borders) {
            bl.addToGame(this);
        }
        for (Block bl : blocks) {
            bl.addHitListener(blockHitListener);
            bl.addHitListener(scoreHitListener);
            bl.addToGame(this);
        }
        HitListener ballsHitListener = new BallRemover(this, this.ballsCounter);
        deathZone.addHitListener(ballsHitListener);
        deathZone.addToGame(this);

        ScoreIndicator scoreIndicator = new ScoreIndicator(this.scoreCounter);
        this.addSprite(scoreIndicator);

        LevelNameIndicator levelNameIndicator = new LevelNameIndicator(levelInformation.levelName());
        this.addSprite(levelNameIndicator);

        Ball[] balls = this.initBalls();

        for (Ball b : balls) {
            b.addToGame(this);
        }
        this.running = true;
    }

    /**
     * init balls.
     *
     * @return Balls[] balls
     */
    private Ball[] initBalls() {
        Ball[] balls = new Ball[levelInformation.numberOfBalls()];
        //744, 57
        int startingX = 400, startingY = 530;

        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Ball(new Point(startingX, startingY), BALLS_RADIUS, levelInformation.getBallColor(),
                    this.environment);
            balls[i].setVelocity(levelInformation.initialBallVelocities().get(i));
        }
        return balls;
    }

    /**
     * get number of balls.
     *
     * @return number of balls
     */
    public int getNumberOfBalls() {
        return ballsCounter.getValue();
    }

    /**
     * Run the game - start the animation loop.
     */
    public void run() {

        //this.runner = new AnimationRunner(this.gui, FRAMES_PER_SECOND);

        this.runner.run(new CountdownAnimation(3, 3, this.sprites,
                levelInformation.getBallColor()));
        this.runner.run(this);
        this.running = false;
    }


    /**
     * remove collidable from the GameLevel environment.
     *
     * @param c collidable to remove.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * remove sprite from collection.
     *
     * @param s sprite to remove.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * returns the border size.
     *
     * @return returns the border size.
     */
    public static int getBorderSize() {
        return BORDER_SIZE;
    }

    /**
     * returns the screen width.
     *
     * @return returns the screen width.
     */
    public static int getScreenWidth() {
        return SCREEN_WIDTH;
    }

    /**
     * returns the screen height.
     *
     * @return returns the screen height.
     */
    public static int getScreenHeight() {
        return SCREEN_HEIGHT;
    }

    /**
     * testing initializer.
     */
    public void initializeTest() {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();

        this.gui = new GUI("Arkanoid GameLevel", SCREEN_WIDTH, SCREEN_HEIGHT);

        Paddle paddle = new Paddle(gui.getKeyboardSensor());
        paddle.addToGame(this);

        List<Block> blocks = new ArrayList<Block>();

        Block topBorder = new Block(new Rectangle(new Point(0, 0), SCREEN_WIDTH - BORDER_SIZE, BORDER_SIZE
                , BORDER_COLOR));
        Block bottomBorder = new Block(new Rectangle(new Point(BORDER_SIZE, SCREEN_HEIGHT - BORDER_SIZE),
                SCREEN_WIDTH - BORDER_SIZE, BORDER_SIZE, BORDER_COLOR));
        Block rightBorder = new Block(new Rectangle(new Point(SCREEN_WIDTH - BORDER_SIZE, 0), BORDER_SIZE,
                SCREEN_HEIGHT - BORDER_SIZE, BORDER_COLOR));
        Block leftBorder = new Block(new Rectangle(new Point(0, BORDER_SIZE), BORDER_SIZE,
                SCREEN_HEIGHT - BORDER_SIZE, BORDER_COLOR));
        blocks.add(topBorder);
        blocks.add(bottomBorder);
        blocks.add(rightBorder);
        blocks.add(leftBorder);

        blocks.add(new Block(new Rectangle(new Point(100, 100), 200, 200, Color.cyan)));
        blocks.add(new Block(new Rectangle(new Point(500, 200), 100, 200, Color.yellow)));
        blocks.add(new Block(new Rectangle(new Point(400, 400), 30, 30, Color.gray)));
        blocks.add(new Block(new Rectangle(new Point(430, 400), 50, 50, Color.gray)));


        for (Block bl : blocks) {
            bl.addToGame(this);
        }

        Ball[] balls = new Ball[2];
        //balls[0] = new Ball(new Point(200, 350), 5, Color.darkGray, this.environment);
        balls[0] = new Ball(new Point(99, 99), 5, Color.darkGray, this.environment);
        balls[1] = new Ball(new Point(600, 110), 5, Color.pink, this.environment);

        balls[0].setVelocity(-1, -1);
        balls[1].setVelocity(15, -6);

        for (Ball b : balls) {
            b.addToGame(this);
        }
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

        // if the game is done :)
        if (this.blockCounter.getValue() == 0 || this.ballsCounter.getValue() == 0) {
            if (this.blockCounter.getValue() == 0) {
                this.scoreCounter.increase(POINTS_FOR_CLEARING_LEVEL);
            }
            this.running = false;
        }

        if (this.keyboard.isPressed("p")) {
            KeyPressStoppableAnimation screen = new KeyPressStoppableAnimation(keyboard, KeyboardSensor.SPACE_KEY,
                    new PauseScreen());
            this.runner.run(screen);
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}
