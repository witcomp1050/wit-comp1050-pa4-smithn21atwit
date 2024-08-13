package edu.wit.cs.comp1050;

//TODO: document this class
public class Rectangle extends Shape2D {
    private final Point2D lowerLeft;
    private final Point2D upperRight;

    // Constructor to initialize rectangle with any two points
    public Rectangle(String color, Point2D p1, Point2D p2) {
        super(color, "Rectangle");

        double x1 = Math.min(p1.getX(), p2.getX());
        double y1 = Math.min(p1.getY(), p2.getY());
        double x2 = Math.max(p1.getX(), p2.getX());
        double y2 = Math.max(p1.getY(), p2.getY());

        this.lowerLeft = new Point2D(x1, y1);
        this.upperRight = new Point2D(x2, y2);
    }

    // Equals method to compare rectangles
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return lowerLeft.equals(rectangle.lowerLeft) && upperRight.equals(rectangle.upperRight);
    }

    // Get the lower-left corner
    public Point2D getLowerLeft() {
        return lowerLeft;
    }

    // Get the upper-right corner
    public Point2D getUpperRight() {
        return upperRight;
    }

    // Calculate the area of the rectangle
    @Override
    public double getArea() {
        return (upperRight.getX() - lowerLeft.getX()) * (upperRight.getY() - lowerLeft.getY());
    }

    // Calculate the perimeter of the rectangle
    @Override
    public double getPerimeter() {
        return 2 * ((upperRight.getX() - lowerLeft.getX()) + (upperRight.getY() - lowerLeft.getY()));
    }

    // Get the center of the rectangle
    @Override
    public Point2D getCenter() {
        return new Point2D(
            (lowerLeft.getX() + upperRight.getX()) / 2,
            (lowerLeft.getY() + upperRight.getY()) / 2
        );
    }

    // Get the vertices of the rectangle
    @Override
    public Point2D[] getVertices() {
        return new Point2D[] {
            lowerLeft,                              // (0.000, 0.000) - lower-left
            new Point2D(lowerLeft.getX(), upperRight.getY()), // (0.000, 1.000) - upper-left
            upperRight,                             // (2.000, 1.000) - upper-right
            new Point2D(upperRight.getX(), lowerLeft.getY())  // (2.000, 0.000) - lower-right
        };
    

    }
}