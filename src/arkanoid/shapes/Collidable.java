package arkanoid.shapes;

import biuoop.DrawSurface;

/**
 * @author Tommy Zaft
 * <p>
 * An interface for a collidable object.
 */
public interface Collidable {
    /**
     * Return the "collision shape" of the object.
     *
     * @return Return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param hitter          the ball that hits the blocks.
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity of the object hitting us
     * @return The return is the new velocity expected after the hit (based on the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

    /**
     * draws the collidable onto the surface.
     *
     * @param surface the surface to draw on
     */
    void drawOn(DrawSurface surface);
}
