package arkanoid.game;

import java.util.List;
import java.util.ArrayList;

import arkanoid.shapes.Line;
import arkanoid.shapes.Point;
import arkanoid.shapes.Collidable;

/**
 * @author Tommy Zaft
 * <p>
 * Represents a GameLevel Environment.
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * creates a new GameLevel Environment with an empty collidable list.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }

    /**
     * creates a new GameLevel Environment with the collidable list received.
     *
     * @param collidables the collidable list to initialize with
     */
    public GameEnvironment(List<Collidable> collidables) {
        this.collidables = new ArrayList<>();
        this.collidables.addAll(collidables);
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c a given collidable to add.
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**
     * return the information about the closest collision that is going to occur,
     * between the object moving in trajectory Line and the collidables in the game environment.
     *
     * @param trajectory the trajectory Line of the object's movement.
     * @return If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {

        CollisionInfo closestCollisionInfo = null;

        // Make a copy of the collidables before iterating over them.
        List<Collidable> collidablesCopy = new ArrayList<>(this.collidables);

        for (Collidable c : collidablesCopy) {
            Point collisionPoint = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());

            if (collisionPoint != null) {
                if (closestCollisionInfo == null || collisionPoint.distance(trajectory.start())
                        < closestCollisionInfo.collisionPoint().distance(trajectory.start())) {
                    closestCollisionInfo = new CollisionInfo(collisionPoint, c);
                }
            }
        }
        return closestCollisionInfo;
    }

    /**
     * remove collidable from environment.
     *
     * @param c collidable to remove.
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }

    /**
     * returns the Collidables list.
     *
     * @return returns the Collidables list.
     */
    public List<Collidable> getCollidableList() {
        return this.collidables;
    }
}
