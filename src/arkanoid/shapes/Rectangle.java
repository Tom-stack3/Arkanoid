package arkanoid.shapes;

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Tommy Zaft
 * <p>
 * Represents a Rectangle.
 * Rectangle has:
 * a upper left Point, a height, a width, and his sides (as Lines).
 */
public class Rectangle {
    private Point upperLeft;
    private Line topSide;
    private Line bottomSide;
    private Line rightSide;
    private Line leftSide;
    private double width;
    private double height;
    private Color color;

    /**
     * Creates a new rectangle with upperLeft point and width/height.
     * with a default color.
     * also save it's topSide, bottomSide, rightSide and leftSide.
     *
     * @param upperLeft the upper left point of the rectangle.
     * @param width     the width of the rectangle.
     * @param height    the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;

        Point upperRight = new Point(upperLeft.getX() + this.width, upperLeft.getY());
        Point bottomRight = new Point(upperRight.getX(), upperRight.getY() + this.height);
        Point bottomLeft = new Point(upperLeft.getX(), upperLeft.getY() + this.height);

        this.topSide = new Line(upperLeft, upperRight);
        this.bottomSide = new Line(bottomLeft, bottomRight);
        this.rightSide = new Line(upperRight, bottomRight);
        this.leftSide = new Line(upperLeft, bottomLeft);

        this.color = Color.cyan;
    }


    /**
     * Creates a new rectangle with upperLeft point and width/height.
     * also save it's topSide, bottomSide, rightSide and leftSide.
     *
     * @param upperLeft the upper left point of the rectangle.
     * @param width     the width of the rectangle.
     * @param height    the height of the rectangle.
     * @param color     the color of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height, Color color) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;

        Point upperRight = new Point(upperLeft.getX() + this.width, upperLeft.getY());
        Point bottomRight = new Point(upperRight.getX(), upperRight.getY() + this.height);
        Point bottomLeft = new Point(upperLeft.getX(), upperLeft.getY() + this.height);

        this.topSide = new Line(upperLeft, upperRight);
        this.bottomSide = new Line(bottomLeft, bottomRight);
        this.rightSide = new Line(upperRight, bottomRight);
        this.leftSide = new Line(upperLeft, bottomLeft);

        this.color = color;
    }


    /**
     * returns a (possibly empty) List of intersection points of the rectangle with the specified line.
     *
     * @param line line to get intersection points with.
     * @return a (possibly empty) List of intersection points with the specified line.
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> points = new ArrayList<Point>();
        Point withTopSide = line.intersectionWith(this.topSide);
        Point withRightSide = line.intersectionWith(this.rightSide);
        Point withLeftSide = line.intersectionWith(this.leftSide);
        Point withBottomSide = line.intersectionWith(this.bottomSide);
        if (withTopSide != null) {
            points.add(withTopSide);
        }
        if (withRightSide != null) {
            points.add(withRightSide);
        }
        if (withLeftSide != null) {
            points.add(withLeftSide);
        }
        if (withBottomSide != null) {
            points.add(withBottomSide);
        }

        return points;
    }

    /**
     * draws the rectangle onto the surface.
     *
     * @param surface the surface to draw on
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
        surface.setColor(Color.darkGray);
        surface.drawRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
    }


    /**
     * Returns the width of the rectangle.
     *
     * @return Returns the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Returns the height of the rectangle.
     *
     * @return Returns the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Returns the upper-left point of the rectangle.
     *
     * @return Returns the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Returns the top side of the rectangle.
     *
     * @return Returns the top side of the rectangle.
     */
    public Line getTopSide() {
        return topSide;
    }

    /**
     * Returns the bottom side of the rectangle.
     *
     * @return Returns the bottom side of the rectangle.
     */
    public Line getBottomSide() {
        return bottomSide;
    }

    /**
     * Returns the right side of the rectangle.
     *
     * @return Returns the left side of the rectangle.
     */
    public Line getRightSide() {
        return rightSide;
    }

    /**
     * Returns the left side of the rectangle.
     *
     * @return Returns the left side of the rectangle.
     */
    public Line getLeftSide() {
        return leftSide;
    }

    /**
     * Returns the color of the rectangle.
     *
     * @return Returns the color of the rectangle.
     */
    public Color getColor() {
        return this.color;
    }
}
