package edu.wit.cs.comp1050;

//TODO: document this class
public class PA4b {
    
    public static final String ERR_USAGE = "Please supply correct inputs: color x1 y1 x2 y2 x3 y3";
    public static final int NUM_ARGS = 7;

    // Method to produce a CSV string of all shape vertices
    public static String shapeVertices(Shape2D[] shapes) {
        StringBuilder sb = new StringBuilder();
        for (Shape2D shape : shapes) {
            Point2D[] vertices = shape.getVertices();
            for (int i = 0; i < vertices.length; i++) {
                sb.append(String.format("\"%s\",%.3f,%.3f", shape.getColor(), vertices[i].getX(), vertices[i].getY()));
                if (i < vertices.length - 1) {
                    sb.append("\n");
                }
            }
            if (shape instanceof Triangle) {
                Rectangle aabb = ((Triangle) shape).getAxisAlignedBoundingBox();
                Point2D[] aabbVertices = aabb.getVertices();
                for (int i = 0; i < aabbVertices.length; i++) {
                    sb.append("\n").append(String.format("\"%s\",%.3f,%.3f", shape.getColor(), aabbVertices[i].getX(), aabbVertices[i].getY()));
                }
            }
        }
        return sb.toString();
    }


    // Main method to validate input and output the corresponding CSV to the terminal
    public static void main(String[] args) {
        if (args.length != NUM_ARGS) {
            System.out.println(ERR_USAGE);
            return;
        }

        try {
            String color = args[0];
            double x1 = Double.parseDouble(args[1]);
            double y1 = Double.parseDouble(args[2]);
            double x2 = Double.parseDouble(args[3]);
            double y2 = Double.parseDouble(args[4]);
            double x3 = Double.parseDouble(args[5]);
            double y3 = Double.parseDouble(args[6]);

            Triangle triangle = new Triangle(color, new Point2D(x1, y1), new Point2D(x3, y3), new Point2D(x2, y2));
            System.out.print(shapeVertices(new Shape2D[] { triangle }));

        } catch (NumberFormatException e) {
            System.out.println(ERR_USAGE);
        }
    }
}