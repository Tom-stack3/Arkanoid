package arkanoid.shapes;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import arkanoid.game.GameLevel;

import java.awt.Color;

/**
 * @author Tommy Zaft
 * <p>
 * Represents a paddle.
 */
public class Paddle implements Sprite, Collidable {
    private final biuoop.KeyboardSensor keyboard;
    private Block block;

    private final int paddleWidth;
    private static final int PADDLE_HEIGHT = 10;
    private static final Color PADDLE_COLOR = Color.orange;

    private final int paddleStartingX;

    private static final int PADDLE_STARTING_Y = 550 - PADDLE_HEIGHT;

    private final int paddleSpeed;

    private static final int[] ANGLES_OF_BOUNCING = {300, 330, -1, 30, 60};
    private static final int NUM_OF_REIGNS = ANGLES_OF_BOUNCING.length;

    // game variables
    private static final int BORDER_SIZE = 50;
    private static final int SCREEN_WIDTH = 800;

    /**
     * constructor for paddle.
     *
     * @param keyboard the KeyboardSensor keyboard.
     */
    public Paddle(KeyboardSensor keyboard) {
        this(keyboard, 100, 4);
    }

    /**
     * constructor for paddle.
     *
     * @param keyboard    the KeyboardSensor keyboard.
     * @param paddleSpeed paddle speed.
     * @param paddleWidth width.
     */
    public Paddle(KeyboardSensor keyboard, int paddleWidth, int paddleSpeed) {
        this.paddleWidth = paddleWidth;
        this.paddleStartingX = 800 / 2 - paddleWidth / 2;
        this.paddleSpeed = paddleSpeed;
        this.keyboard = keyboard;
        Rectangle rectangle = new Rectangle(new Point(paddleStartingX, PADDLE_STARTING_Y), paddleWidth,
                PADDLE_HEIGHT, PADDLE_COLOR);
        this.block = new Block(rectangle);
    }

    /**
     * moves the paddle left.
     */
    public void moveLeft() {
        Rectangle rectangle = this.block.getCollisionRectangle();
        Point newUpperLeft = new Point(rectangle.getUpperLeft().getX() - paddleSpeed,
                rectangle.getUpperLeft().getY());
        rectangle = new Rectangle(newUpperLeft, rectangle.getWidth(), rectangle.getHeight(), rectangle.getColor());
        if (isInBounds(rectangle)) {
            this.block = new Block(rectangle);
        } else {
            newUpperLeft.setX(BORDER_SIZE);
            this.block = new Block(new Rectangle(newUpperLeft, rectangle.getWidth(), rectangle.getHeight(),
                    rectangle.getColor()));
        }
    }

    /**
     * moves the paddle right.
     */
    public void moveRight() {
        Rectangle rectangle = this.block.getCollisionRectangle();
        Point newUpperLeft = new Point(rectangle.getUpperLeft().getX() + paddleSpeed,
                rectangle.getUpperLeft().getY());
        rectangle = new Rectangle(newUpperLeft, rectangle.getWidth(), rectangle.getHeight(), rectangle.getColor());
        if (isInBounds(rectangle)) {
            this.block = new Block(rectangle);
        } else {
            newUpperLeft.setX(SCREEN_WIDTH - BORDER_SIZE - this.paddleWidth);
            this.block = new Block(new Rectangle(newUpperLeft, rectangle.getWidth(), rectangle.getHeight(),
                    rectangle.getColor()));
        }
    }


    // Sprite
    @Override
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        } else if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        this.block.drawOn(d);
    }

    /**
     * checks if a rectangle is out of bounds.
     *
     * @param r the rectangle
     * @return true - if the rectangle is out of bounds. false - the rectangle is not out of bounds.
     */
    public boolean isInBounds(Rectangle r) {
        double startX = r.getTopSide().start().getX();
        double endX = r.getTopSide().end().getX();
        if (startX < BORDER_SIZE || startX > SCREEN_WIDTH - BORDER_SIZE) {
            return false;
        }
        return !(endX < BORDER_SIZE) && !(endX > SCREEN_WIDTH - BORDER_SIZE);
    }

    // Collidable
    @Override
    public Rectangle getCollisionRectangle() {
        return this.block.getCollisionRectangle();
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // if the ball hits the bottom of the paddle.
        Point bottomLeft = this.block.getCollisionRectangle().getBottomSide().start();
        Point bottomRight = this.block.getCollisionRectangle().getBottomSide().end();
        if (collisionPoint.getX() > bottomLeft.getX() && collisionPoint.getX() < bottomRight.getX()) {
            if (collisionPoint.getY() >= bottomRight.getY()) {
                return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * -1);
            }
        }
        // if the ball hits the right or the left side of the paddle.
        Point upperRight = this.block.getCollisionRectangle().getRightSide().start();
        Point upperLeft = this.block.getCollisionRectangle().getLeftSide().start();
        if (collisionPoint.getX() >= upperRight.getX() || collisionPoint.getX() <= upperLeft.getX()) {
            if (collisionPoint.getY() > upperRight.getY()) {
                return new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy());
            }
        }
        int reign = this.getReignHit(collisionPoint);
        // if the reign is the middle reign
        if (reign == Math.ceil(NUM_OF_REIGNS / 2.0)) {
            return this.block.hit(hitter, collisionPoint, currentVelocity);
        }
        // the speed stays the same as before.
        double speed = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
        double angle = ANGLES_OF_BOUNCING[reign - 1];
        Velocity newV = Velocity.fromAngleAndSpeed(angle, speed);

        return newV;
    }

    /**
     * gets the reign hit.
     *
     * @param collisionPoint the collision point.
     * @return returns the reign hit. 1 - if the first reign hit..
     */
    private int getReignHit(Point collisionPoint) {
        double startX = this.block.getCollisionRectangle().getTopSide().start().getX();
        double endX = this.block.getCollisionRectangle().getTopSide().end().getX();
        double oneReign = (endX - startX) / NUM_OF_REIGNS;

        if (collisionPoint.getX() - startX == 0) {
            return 1;
        }
        int reign = (int) Math.ceil((collisionPoint.getX() - startX) / oneReign);
        if (reign < 1) {
            reign = 1;
        } else if (reign > 5) {
            reign = 5;
        }
        return reign;
    }

    /**
     * Add this paddle to the game.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}