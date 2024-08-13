package edu.wit.cs.comp1050;

//TODO: document this class
public class Point2D {
    private final double x;
    private final double y;

    // Constructor to initialize coordinates
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Get the x coordinate
    public double getX() {
        return x;
    }

    // Get the y coordinate
    public double getY() {
        return y;
    }

    // String representation of the coordinate
    @Override
    public String toString() {
        return String.format("(%.3f, %.3f)", x, y);
    }

    // Overriding equals method to compare two points within a threshold
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point2D point = (Point2D) o;
        return Shape2D.closeEnough(this.x, point.x) && Shape2D.closeEnough(this.y, point.y);
    }

    // Static method to compute the Euclidean distance between two points
    public static double distance(Point2D p1, Point2D p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }

    // Method to compute the distance from this point to another point
    public double distanceTo(Point2D p) {
        return Point2D.distance(this, p);
    }
}
