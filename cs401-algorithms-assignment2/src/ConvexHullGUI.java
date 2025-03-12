import java.util.ArrayList;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

// GUI class to visualize the convex hull construction
public class ConvexHullGUI {

    public static void main(String[] args) {
        // Set up the canvas
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0, 10000);
        StdDraw.setYscale(0, 10000);
        StdDraw.enableDoubleBuffering();

        ArrayList<Point2D> pointList = new ArrayList<Point2D>();

        while (true) {
            if (StdDraw.isMousePressed()) {
                // User clicks, add point to the list
                int x = (int) (Math.round(StdDraw.mouseX()));
                int y = (int) (Math.round(StdDraw.mouseY()));
                pointList.add(new Point2D(x, y));

                if (pointList.size() >= 3) { // Check if there are enough points to compute convex hull
                    // Compute convex hull
                    ConvexHullBuilder convexBuilder = new ConvexHullBuilder(pointList);

                    StdDraw.clear();

                    drawConvexHull(pointList, convexBuilder.hull());
                } else {
                    drawPoints(pointList);
                }
            }
            StdDraw.show();
            StdDraw.pause(20);
        }
    }

    // Plot the convex hull
    private static void drawConvexHull(ArrayList<Point2D> pointList, Iterable<Point2D> hull) {
        drawPoints(pointList);  // Plot the original points in black
        drawHullPoints(hull);   // Plot the convex hull points in red
        drawHullLines(hull);    // Plot the convex hull edges in blue
    }

    // Plot the original points in black
    private static void drawPoints(ArrayList<Point2D> pointList) {
        int n = pointList.size(); // Number of points
        StdDraw.setPenRadius(.01);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < n; i++)
            pointList.get(i).draw();
    }

    // Plot the convex hull points in red
    private static void drawHullPoints(Iterable<Point2D> hull) {
        StdDraw.setPenColor(StdDraw.RED);
        for (Point2D p : hull)
            p.draw();
    }

    // Plot the convex hull edges in blue
    private static void drawHullLines(Iterable<Point2D> hull) {
        StdDraw.setPenRadius();
        StdDraw.setPenColor(StdDraw.BLUE);
        Point2D prev = null;
        for (Point2D p : hull) {
            if (prev != null)
                prev.drawTo(p);
            prev = p;
        }
        // Connect the first and last points to complete the hull
        for (Point2D p : hull) {
            prev.drawTo(p);
            break;
        }
    }
}
