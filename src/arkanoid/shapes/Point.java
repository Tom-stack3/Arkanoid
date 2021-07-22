package arkanoid.shapes;

/**
 * @author Tommy Zaft
 * <p>
 * Represents a point.
 * Point has a x value and a y value.
 */
public class Point {
    // the Comparison threshold for comparing a double.
    private static final double COMPARISON_THRESHOLD = 0.00001;

    private double x;
    private double y;

    /**
     * constructor for Point.
     *
     * @param x x of point.
     * @param y y of point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * checks if two doubles are equal.
     *
     * @param a double
     * @param b second double
     * @return true if a is equal to b, false otherwise.
     */
    public static boolean doubleEquals(double a, double b) {
        // if both are NaN
        if (Double.isNaN(a) && Double.isNaN(b)) {
            return true;
        }
        // if one is NaN and the other is not
        if (Double.isNaN(a) || Double.isNaN(b)) {
            return false;
        }
        return Math.abs(a - b) < Point.COMPARISON_THRESHOLD;
    }

    /**
     * calculate the distance of this point to other point.
     *
     * @param other other point to calculate distance to.
     * @return returns the distance of this point to the other point.
     */
    public double distance(Point other) {
        double x2 = other.getX();
        double y2 = other.getY();
        // we calculate and return the distance
        return Math.sqrt(((this.x - x2) * (this.x - x2)) + ((this.y - y2) * (this.y - y2)));
    }

    /**
     * check if two points are equal.
     *
     * @param other other point to check equality with.
     * @return return true is the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        if (Point.doubleEquals(this.x, other.getX()) && Point.doubleEquals(this.y, other.getY())) {
            return true;
        }
        return false;
    }

    /**
     * checks if x of point is between the x parameter of the two points, start and end.
     *
     * @param start the start of the section.
     * @param end   the end of the section.
     * @return return true is the x of point is between the x of the start point and end point, false otherwise.
     */
    private boolean isXBetween(Point start, Point end) {
        double x1 = start.getX();
        double x2 = end.getX();
        if (x1 > x2) {
            double temp = x1;
            x1 = x2;
            x2 = temp;
        }
        // we make the gap bigger between the two points.
        x1 -= COMPARISON_THRESHOLD;
        x2 += COMPARISON_THRESHOLD;
        if (this.getX() < x1 || this.getX() > x2) {
            return false;
        }
        return true;
    }

    /**
     * checks if y of point is between the y parameter of the two points, start and end.
     *
     * @param start the start of the section.
     * @param end   the end of the section.
     * @return return true is the y of point is between the y of the start point and end point, false otherwise.
     */
    private boolean isYBetween(Point start, Point end) {
        double y1 = start.getY();
        double y2 = end.getY();
        if (y1 > y2) {
            double temp = y1;
            y1 = y2;
            y2 = temp;
        }
        // we make the gap bigger between the two points.
        y1 -= COMPARISON_THRESHOLD;
        y2 += COMPARISON_THRESHOLD;
        if (this.getY() < y1 || this.getY() > y2) {
            return false;
        }
        return true;
    }

    /**
     * checks if point is between two points, start and end.
     *
     * @param start the start of the section.
     * @param end   the end of the section.
     * @return return true is the point is between start point and end point, false otherwise.
     */
    public boolean isBetweenTwoPoints(Point start, Point end) {
        // if the x value and the y value is between the start and end points.
        if (this.isXBetween(start, end) && this.isYBetween(start, end)) {
            return true;
        }
        return false;
    }

    /**
     * returns the x value of point.
     *
     * @return returns the x value of this point
     */
    public double getX() {
        return x;
    }

    /**
     * returns the y value of point.
     *
     * @return returns the y value of this point
     */
    public double getY() {
        return y;
    }

    /**
     * sets a new x for the Point.
     *
     * @param newX the new x for the Point.
     */
    public void setX(double newX) {
        this.x = newX;
    }

    /**
     * sets a new y for the Point.
     *
     * @param newY the new y for the Point.
     */
    public void setY(double newY) {
        this.y = newY;
    }

    @Override
    public String toString() {
        return "Point@" + Integer.toHexString(hashCode()) + " X:" + this.x + " Y:" + this.y;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}