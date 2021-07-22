package arkanoid.shapes;

import java.awt.Color;

import arkanoid.game.GameLevel;
import biuoop.DrawSurface;

import arkanoid.game.GameEnvironment;
import arkanoid.game.CollisionInfo;

/**
 * @author Tommy Zaft
 * <p>
 * Represents a Ball.
 * a Ball has s center Point, a Radius (r), a Color, a Velocity and a GameLevel Environment.
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private Color color;
    private Velocity velocity;
    private GameEnvironment environment;


    /**
     * Constructor for ball. Creates a ball instance.
     *
     * @param center          the center of the ball.
     * @param r               the radius of the ball.
     * @param color           the color of the ball.
     * @param gameEnvironment the game environment.
     */
    public Ball(Point center, int r, Color color, GameEnvironment gameEnvironment) {
        r = Math.abs(r);
        this.center = center;
        this.r = r;
        this.color = color;
        this.velocity = new Velocity();
        this.environment = gameEnvironment;
    }

    /**
     * Constructor for ball. Creates a ball instance.
     *
     * @param center the center of the ball.
     * @param r      the radius of the ball.
     * @param color  the color of the ball.
     */
    public Ball(Point center, int r, Color color) {
        this(center, r, color, new GameEnvironment());
    }

    /**
     * Constructor for ball. creates a ball instance
     *
     * @param x               the x of the center of the ball.
     * @param y               the y of the center of the ball.
     * @param r               the radius of the ball.
     * @param color           the color of the ball.
     * @param gameEnvironment the game environment.
     */
    public Ball(double x, double y, int r, Color color, GameEnvironment gameEnvironment) {
        this(new Point(x, y), r, color, gameEnvironment);
    }

    /**
     * Constructor for ball with a new GameEnvironment. creates a ball instance
     *
     * @param x     the x of the center of the ball.
     * @param y     the y of the center of the ball.
     * @param r     the radius of the ball.
     * @param color the color of the ball.
     */
    public Ball(double x, double y, int r, Color color) {
        this(new Point(x, y), r, color, new GameEnvironment());
    }

    /**
     * Constructor for ball with a default color and a new GameEnvironment. creates a ball instance
     *
     * @param center the center of the ball.
     * @param r      the radius of the ball.
     */
    public Ball(Point center, int r) {
        this(center, r, Color.orange, new GameEnvironment());
    }

    /**
     * Constructor for ball with a default color. creates a ball instance
     *
     * @param center          the center of the ball.
     * @param r               the radius of the ball.
     * @param gameEnvironment the game environment.
     */
    public Ball(Point center, int r, GameEnvironment gameEnvironment) {
        this(center, r, Color.orange, gameEnvironment);
    }

    /**
     * we set the GameLevel Environment of the ball.
     *
     * @param e the game environment.
     */
    public void setGameEnvironment(GameEnvironment e) {
        this.environment = e;
    }

    /**
     * remove this block from the gameLevel.
     *
     * @param gameLevel the gameLevel to remove from
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }

    /**
     * we set the velocity of the ball.
     *
     * @param v the Velocity wanted.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * we set the velocity of the ball.
     *
     * @param dx the dx wanted.
     * @param dy the dy wanted.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * gets the center of the ball.
     *
     * @return returns the center Point.
     */
    public Point getCenter() {
        return center;
    }

    /**
     * gets the radius of the ball.
     *
     * @return returns the radius.
     */
    public int getSize() {
        return r;
    }

    /**
     * gets the color of the ball.
     *
     * @return returns the color of the ball.
     */
    public Color getColor() {
        return color;
    }

    /**
     * gets the velocity of the ball.
     *
     * @return returns the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * gets the x of the center of the ball.
     *
     * @return returns the x of the center of the ball.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * gets the y of the center of the ball.
     *
     * @return returns the y of the center of the ball.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * moves the ball one step.
     */
    public void moveOneStep() {
        Line trajectory = new Line(this.center, this.getVelocity().applyToPoint(this.center));
        CollisionInfo info = environment.getClosestCollision(trajectory);

        // if the ball won't collide with anything
        if (info == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
            return;
        }

        this.velocity = info.collisionObject().hit(this, info.collisionPoint(), this.velocity);


        Line topSide = info.collisionObject().getCollisionRectangle().getTopSide();
        Line bottomSide = info.collisionObject().getCollisionRectangle().getBottomSide();
        Line rightSide = info.collisionObject().getCollisionRectangle().getRightSide();
        Line leftSide = info.collisionObject().getCollisionRectangle().getLeftSide();
        if (bottomSide.containsPoint(info.collisionPoint())) {
            // if we hit a corner
            if (rightSide.containsPoint(info.collisionPoint()) || leftSide.containsPoint(info.collisionPoint())) {
                return;
            }
            // if we hit the bottom of a block
            this.center.setY(info.collisionPoint().getY() + r);
            this.center.setX(info.collisionPoint().getX());
        } else if (topSide.containsPoint(info.collisionPoint())) {
            // if we hit a corner
            if (rightSide.containsPoint(info.collisionPoint()) || leftSide.containsPoint(info.collisionPoint())) {
                return;
            }
            // if we hit the top of a block
            this.center.setY(info.collisionPoint().getY() - r);
            this.center.setX(info.collisionPoint().getX());
        } else if (rightSide.containsPoint(info.collisionPoint())) {
            // if we hit the right side of a block
            this.center.setY(info.collisionPoint().getY());
            this.center.setX(info.collisionPoint().getX() + r);

        } else if (leftSide.containsPoint(info.collisionPoint())) {
            // if we hit the left side of a block
            this.center.setY(info.collisionPoint().getY());
            this.center.setX(info.collisionPoint().getX() - r);
        }
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface the given DrawSurface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), r);
    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * adds the ball to the gameLevel.
     *
     * @param gameLevel the gameLevel to add the ball into
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    /**
     * returns the game environment.
     *
     * @return returns the game environment.
     */
    public GameEnvironment getGameEnvironment() {
        return this.environment;
    }
}
