package arkanoid.shapes;

import arkanoid.game.hitListeners.HitListener;
import biuoop.DrawSurface;

import arkanoid.game.GameLevel;
import arkanoid.game.HitNotifier;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tommy Zaft
 * <p>
 * Represents a collidable block. implements the Collidable interface.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private List<HitListener> hitListeners;

    /**
     * Constructor for the block.
     *
     * @param rectangle the rectangle to set.
     */
    public Block(Rectangle rectangle) {
        this.rectangle = rectangle;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * Return the Rectangle block.
     *
     * @return Return the Rectangle block.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double newDx = currentVelocity.getDx();
        double newDy = currentVelocity.getDy();

        this.notifyHit(hitter);

        // if we hit a corner:
        if (rectangle.getTopSide().containsPoint(collisionPoint)
                && (rectangle.getLeftSide().containsPoint(collisionPoint)
                || rectangle.getRightSide().containsPoint(collisionPoint))) {
            newDy = newDy * -1;
            newDx = newDx * -1;
            return new Velocity(newDx, newDy);
        } else if (rectangle.getBottomSide().containsPoint(collisionPoint)
                && (rectangle.getLeftSide().containsPoint(collisionPoint)
                || rectangle.getRightSide().containsPoint(collisionPoint))) {
            newDy = newDy * -1;
            newDx = newDx * -1;
            return new Velocity(newDx, newDy);
        }

        if (rectangle.getTopSide().containsPoint(collisionPoint) && currentVelocity.getDy() >= 0) {
            // if we hit the top side of the block.
            newDy = newDy * -1;
            return new Velocity(newDx, newDy);
        }

        if (rectangle.getBottomSide().containsPoint(collisionPoint) && currentVelocity.getDy() <= 0) {
            // if we hit the bottom side of the block.
            newDy = newDy * -1;
            return new Velocity(newDx, newDy);
        }

        if (rectangle.getRightSide().containsPoint(collisionPoint) && currentVelocity.getDx() <= 0) {
            // if we hit the right side of the block.
            newDx = newDx * -1;
            return new Velocity(newDx, newDy);
        }

        if (rectangle.getLeftSide().containsPoint(collisionPoint) && currentVelocity.getDx() >= 0) {
            // if we hit the left side of the block.
            newDx = newDx * -1;
            return new Velocity(newDx, newDy);
        }

        return new Velocity(newDx, newDy);
    }

    /**
     * remove this block from the gameLevel.
     *
     * @param gameLevel the gameLevel to remove from
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    /**
     * draws the block onto the surface.
     *
     * @param surface the surface to draw on
     */
    public void drawOn(DrawSurface surface) {
        this.rectangle.drawOn(surface);
    }

    /**
     * adds the block to the gameLevel.
     *
     * @param gameLevel the gameLevel to add the block into
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
        gameLevel.addCollidable(this);
    }

    @Override
    public void timePassed() {

    }

    /**
     * notify all the listeners that a ball hit the rectangle.
     *
     * @param hitter the ball hit the rectangle
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public String toString() {
        return "Block@" + Integer.toHexString(hashCode()) + "Color:" + this.rectangle.getColor().toString()
                + "Top-left corner:" + this.rectangle.getUpperLeft();
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
