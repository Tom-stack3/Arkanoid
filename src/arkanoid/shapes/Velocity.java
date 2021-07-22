package arkanoid.shapes;

/**
 * @author Tommy Zaft
 * <p>
 * Represents Velocity
 * Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;

    // constructors

    /**
     * Constructor for velocity. creates a velocity instance
     *
     * @param dx the change in position on the `x`
     * @param dy the change in position on the `y`
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * copy constructor.
     *
     * @param velocity other
     */
    public Velocity(Velocity velocity) {
        this.dx = velocity.dx;
        this.dy = velocity.dy;
    }

    /**
     * Constructor for velocity when no dx and dy were specified.
     * Sets dx and dy to be 0.
     */
    public Velocity() {
        this(0, 0);
    }

    /**
     * returns the dx of the velocity.
     *
     * @return returns the dx of the velocity
     */
    public double getDx() {
        return dx;
    }

    /**
     * returns the dy of the velocity.
     *
     * @return returns the dy of the velocity
     */
    public double getDy() {
        return dy;
    }

    /**
     * Converts velocity in terms and angle and a speed to dx dy.
     *
     * @param angle the angle of the direction of the ball movement (assuming up is angle 0).
     *              means that to move right, the angle specified is 90.
     * @param speed the speed of the ball movement.
     * @return returns the velocity in terms of dx dy.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        // we convert the angle to radians.
        angle = Math.toRadians(angle - 90);
        double dx = (Math.cos(angle)) * speed;
        double dy = (Math.sin(angle)) * speed;
        return new Velocity(dx, dy);
    }

    /**
     * Takes a point with position (x,y) and returns a new point with position (x+dx, y+dy).
     *
     * @param p Point (x,y) to move.
     * @return returns the new point, after moving it. (x,y) --> (x+dx, y+dy).
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + dx, p.getY() + dy);
    }

    /**
     * Checks if the velocity given is equal to this.
     *
     * @param v the velocity to compare to.
     * @return true - if this velocity equals to v. otherwise - false.
     */
    public boolean equals(Velocity v) {
        return (this.getDx() == v.getDx()) && (this.getDy() == v.getDy());
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}