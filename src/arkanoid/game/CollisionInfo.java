package arkanoid.game;

import arkanoid.shapes.Point;
import arkanoid.shapes.Collidable;

/**
 * @author Tommy Zaft
 * <p>
 * Gives information about a collision.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * creates a new Collision info instance.
     *
     * @param collisionPoint  the collision point.
     * @param collisionObject the collision object.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * returns the point at which the collision occurs.
     *
     * @return returns the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * returns the collidable object involved in the collision.
     *
     * @return returns the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}
