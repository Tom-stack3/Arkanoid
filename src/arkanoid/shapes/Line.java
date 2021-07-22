package arkanoid.shapes;

import static java.lang.Double.NaN;

/**
 * @author Tommy Zaft
 * <p>
 * Represents a line.
 * Line has a start Point and an end point.
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * constructor for Line.
     *
     * @param start the start Point of the line.
     * @param end   the end Point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * constructor for Line.
     *
     * @param x1 the x of the start Point of the line.
     * @param y1 the y of the start Point of the line.
     * @param x2 the x of the end Point of the line.
     * @param y2 the y of the end Point of the line.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * returns the length of the line.
     *
     * @return returns the length of the line
     */
    public double length() {
        return this.start.distance(this.end());
    }

    /**
     * returns the middle Point of the line.
     *
     * @return returns the middle Point of the line.
     */
    public Point middle() {
        double x3 = (this.start.getX() + this.end.getX()) / 2;
        double y3 = (this.start.getY() + this.end.getY()) / 2;
        return new Point(x3, y3);
    }

    /**
     * returns the start point of the line.
     *
     * @return returns the start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * returns the end point of the line.
     *
     * @return returns the end point of the line.
     */
    public Point end() {
        return this.end;
    }


    /**
     * returns the slope of the line.
     * (the m in y=m*x+b).
     * if the line is x=p : for some p, we return Nan.
     *
     * @return returns the slope of the line.
     */
    private double getSlope() {
        // if the line is x = p : for some p
        if (this.end.getX() == this.start.getX()) {
            return NaN;
        }
        double slope = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
        return slope;
    }


    /**
     * returns the b in y=mx+b of the line.
     * if the line is x=p : for some p, we return Nan.
     *
     * @return returns the b in y=mx+b of the line.
     */
    private double getB() {
        // y = m*x + b --> b = y - m*x
        return this.start.getY() - this.getSlope() * this.start.getX();
    }

    /**
     * The method checks if this line contains the point p received.
     *
     * @param p the point to check if line contains or not.
     * @return true if this line contains Point p, false otherwise.
     */
    public boolean containsPoint(Point p) {
        if (p == null || Double.isNaN(p.getX()) || Double.isNaN(p.getY())) {
            return false;
        }
        double m = this.getSlope();
        // if the line is x = p : for some p
        if (Double.isNaN(m)) {
            if (Point.doubleEquals(p.getX(), this.start.getX())) {
                // if the point is on the line (between start and end)
                if (p.isBetweenTwoPoints(this.start, this.end)) {
                    return true;
                }
            }
            return false;
        }
        // y = m*x + b --> b = y - m*x
        double b = this.getB();
        // if the point is on the line (y[p] = m*x[p] + b)
        if (Point.doubleEquals(p.getY(), m * p.getX() + b)) {
            // if the point is on the line (between start and end)
            if (p.isBetweenTwoPoints(this.start, this.end)) {
                return true;
            }
        }
        // else, we return false.
        return false;
    }


    /**
     * finds the intersection between two equations of two lines.
     * (not considering their length)
     *
     * @param other the other line to find intersection with.
     * @return returns the intersection points between two lines, not considering their length.
     */
    private Point noLengthIntersection(Line other) {
        double m1 = this.getSlope();
        double b1 = this.getB();
        double m2 = other.getSlope();
        double b2 = other.getB();
        // if both are x = p : for some p.
        if (Double.isNaN(m1) && Double.isNaN(m2)) {
            return null;
        }
        // if this line is x = p : for some p.
        if (Double.isNaN(m1)) {
            return new Point(this.start.getX(), m2 * this.start.getX() + b2);
        }
        // if the other line is x = p : for some p.
        if (Double.isNaN(m2)) {
            return new Point(other.start().getX(), m1 * other.start().getX() + b1);
        }
        double interX = (b2 - b1) / (m1 - m2);
        if (interX == -0.0) {
            interX = 0.0;
        }
        double interY = m1 * interX + b1;
        if (interY == -0.0) {
            interY = 0.0;
        }
        // we return the intersection point.
        return new Point(interX, interY);
    }

    /**
     * The method checks if this line and Line other received, intersect.
     *
     * @param other the other line to check intersection with.
     * @return true if this line and other line intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        // if the first line contains the start or the end of the second line.
        if (this.containsPoint(other.start()) || this.containsPoint(other.end())) {
            return true;
        }
        // if the second line contains the start or the end of the first line.
        if (other.containsPoint(this.start()) || other.containsPoint(this.end())) {
            return true;
        }
        // we calculate the intersection of the two equations of the lines.
        Point intersection = this.noLengthIntersection(other);
        if (this.containsPoint(intersection) && other.containsPoint(intersection)) {
            return true;
        }

        return false;
    }

    /**
     * finds intersection Point between two lines with the same slope.
     *
     * @param other the other line to find intersection with.
     * @return the intersection Point between the two lines.
     * null if the two lines don't intersect or have more than one intersection point.
     */
    private Point intersectionWithEqualSlope(Line other) {
        // if the start and the end of the other line is on this line, we have more than one intersection point -> null
        if (this.containsPoint(other.start()) && this.containsPoint(other.end())) {
            return null;
        }
        // if the start and the end of this line is on the other line, we have more than one intersection point -> null
        if (other.containsPoint(this.start()) && other.containsPoint(this.end())) {
            return null;
        }
        // if the start of this line is the start of the other line and the end of this line is not on the other line.
        if (this.start.equals(other.start()) && !other.containsPoint(this.end)) {
            return this.start;
        }
        // if the start of this line is the end of the other line and the end of this line is not on the other line.
        if (this.start.equals(other.end()) && !other.containsPoint(this.end)) {
            return this.start;
        }
        // if the end of this line is the end of the other line and the start of this line is not on the other line.
        if (this.end.equals(other.end()) && !other.containsPoint(this.start)) {
            return this.end;
        }
        // if the end of this line is the start of the other line and the start of this line is not on the other line.
        if (this.end.equals(other.start()) && !other.containsPoint(this.start)) {
            return this.end;
        }
        return null;
    }

    /**
     * find and returns the intersection point of this line and Line other.
     *
     * @param other the other line to find intersection with.
     * @return returns the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {
        // if the lines do not intersect
        if (!this.isIntersecting(other)) {
            return null;
        }

        // if lines are are identical
        if (this.equals(other)) {
            // if both lines are one point
            if (this.start.equals(this.end)) {
                return this.start;
            }
            return null;
        }
        // if this lines is one point, and the second line contains it
        if (this.start.equals(this.end) && other.containsPoint(this.start)) {
            return this.start;
        }
        // if the other lines is one point, and this line contains it
        if (other.start().equals(other.end()) && this.containsPoint(other.start())) {
            return other.start();
        }

        // if the slopes are equal.
        if (Point.doubleEquals(this.getSlope(), other.getSlope())) {
            return intersectionWithEqualSlope(other);
        }

        // if the no length intersection is on the lines.
        Point noLengthIntersection = this.noLengthIntersection(other);
        if (this.containsPoint(noLengthIntersection) && other.containsPoint(noLengthIntersection)) {
            return this.noLengthIntersection(other);
        }

        // else, the is more then one intersection. so we return null.
        return null;
    }

    /**
     * check if two lines are equal.
     *
     * @param other second line.
     * @return returns true is the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        if (this.start.equals(other.start()) && this.end.equals(other.end())) {
            return true;
        } else if (this.start.equals(other.end()) && this.end.equals(other.start())) {
            return true;
        }
        return false;
    }

    /**
     * gives the y corresponding to the x coordinate according to this line's equation.
     *
     * @param x the x coordinate
     * @return the y coordinate fits the x
     */
    public double getYOnLine(double x) {
        double slope = this.getSlope();
        double b = this.getB();
        return slope * x + b;
    }

    /**
     * gives the x corresponding to the y coordinate according to this line's equation.
     *
     * @param y the y coordinate
     * @return the x coordinate fits the y
     */
    public double getXOnLine(double y) {
        return (y - this.getB()) / this.getSlope();
    }

    /**
     * finds the closest intersection with rectangle to start of Line.
     *
     * @param rect the rectangle to work with
     * @return If this line does not intersect with the rectangle - return null.
     * Otherwise - return the closest intersection point to the start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        java.util.List<Point> points = rect.intersectionPoints(this);

        // if this line does not intersect with the rectangle
        if (points.isEmpty()) {
            return null;
        }

        Point closestPoint = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            if (this.start.distance(points.get(i)) < this.start.distance(closestPoint)) {
                closestPoint = points.get(i);
            }
        }
        return closestPoint;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}