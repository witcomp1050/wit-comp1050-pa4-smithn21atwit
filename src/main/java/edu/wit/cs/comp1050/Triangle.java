package edu.wit.cs.comp1050;

import java.util.Arrays;

public class Triangle extends Shape2D {
    private final Point2D p1, p2, p3;

    // Constructor to initialize triangle with three points
    public Triangle(String color, Point2D p1, Point2D p2, Point2D p3) {
        super(color, "Triangle");
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    // Calculate the area of the triangle
    @Override
    public double getArea() {
        return Math.abs((p1.getX() * (p2.getY() - p3.getY()) +
                         p2.getX() * (p3.getY() - p1.getY()) +
                         p3.getX() * (p1.getY() - p2.getY())) / 2.0);
    }

    // Calculate the perimeter of the triangle
    @Override
    public double getPerimeter() {
        return p1.distanceTo(p2) + p2.distanceTo(p3) + p3.distanceTo(p1);
    }

    // Get the centroid (center) of the triangle
    @Override
    public Point2D getCenter() {
        return new Point2D(
            (p1.getX() + p2.getX() + p3.getX()) / 3,
            (p1.getY() + p2.getY() + p3.getY()) / 3
        );
    }

    // Get the vertices of the triangle
    @Override
    public Point2D[] getVertices() {
        Point2D[] vertices = new Point2D[] { p1, p2, p3 };

        // Determine the bottom-left vertex
        Point2D bottomLeft = vertices[0];
        for (Point2D p : vertices) {
            if (p.getY() < bottomLeft.getY() || (p.getY() == bottomLeft.getY() && p.getX() < bottomLeft.getX())) {
                bottomLeft = p;
            }
        }

        // Determine the bottom-right vertex
        Point2D bottomRight = null;
        for (Point2D p : vertices) {
            if (!p.equals(bottomLeft)) {
                if (bottomRight == null || p.getY() < bottomRight.getY() || 
                    (p.getY() == bottomRight.getY() && p.getX() > bottomRight.getX())) {
                    bottomRight = p;
                }
            }
        }

        // The remaining vertex is the top vertex
        Point2D topVertex = null;
        for (Point2D p : vertices) {
            if (!p.equals(bottomLeft) && !p.equals(bottomRight)) {
                topVertex = p;
            }
        }

        // Return the vertices in the desired order: bottom-left, top, bottom-right
        return new Point2D[] { bottomLeft, bottomRight, topVertex };
    }

    // Get the axis-aligned bounding box (AABB) for this triangle
    public Rectangle getAxisAlignedBoundingBox() {
        double minX = Math.min(Math.min(p1.getX(), p2.getX()), p3.getX());
        double minY = Math.min(Math.min(p1.getY(), p2.getY()), p3.getY());
        double maxX = Math.max(Math.max(p1.getX(), p2.getX()), p3.getX());
        double maxY = Math.max(Math.max(p1.getY(), p2.getY()), p3.getY());
        return new Rectangle(getColor(), new Point2D(minX, minY), new Point2D(maxX, maxY));
    }
}