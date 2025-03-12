import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

import edu.princeton.cs.algs4.Point2D;

// Computes the convex hull of a set of 2D points
public class ConvexHullBuilder {
    private Stack<Point2D> hull = new Stack<Point2D>(); // Stack to store the points on the convex hull

    // Constructor takes an ArrayList of Point2D objects and builds the convex hull
    public ConvexHullBuilder(ArrayList<Point2D> points) {
        ArrayList<Point2D> sortedPoints = sortPoints(points); // Sort the points in polar order
        buildHull(sortedPoints); // Build the convex hull
    }

    // Returns the points on the convex hull
    public Iterable<Point2D> hull() {
        return hull;
    }

    // Sorts the points in polar order with respect to the lowest point
    private ArrayList<Point2D> sortPoints(ArrayList<Point2D> points) {
        // Find the lowest point
        Point2D lowest = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            Point2D current = points.get(i);
            if (current.y() < lowest.y() || (current.y() == lowest.y() && current.x() < lowest.x())) {
                lowest = current;
            }
        }

        // Comparator for sorting points based on polar angle from the lowest point
        final Point2D lowestPoint = lowest;
        Comparator<Point2D> polarOrder = new Comparator<Point2D>() {
            public int compare(Point2D q1, Point2D q2) {
                double angle1 = polarAngle(lowestPoint, q1);
                double angle2 = polarAngle(lowestPoint, q2);
                if (angle1 < angle2) return -1;
                if (angle1 > angle2) return +1;
                return 0;
            }
        };

        // Sort the points in polar order
        ArrayList<Point2D> sortedPoints = new ArrayList<Point2D>(points);
        sortedPoints.remove(lowest);
        Collections.sort(sortedPoints, polarOrder);
        sortedPoints.add(0, lowest);

        return sortedPoints;
    }

    // Computes the polar angle between two points with respect to a reference point
    private double polarAngle(Point2D p, Point2D q) {
        return Math.atan2(q.y() - p.y(), q.x() - p.x());
    }

    // Builds the convex hull using the sorted points
    private void buildHull(ArrayList<Point2D> sortedPoints) {
        if (sortedPoints.size() < 3) {
            // If there are fewer than 3 points, it's not possible to compute the convex hull
            throw new IllegalArgumentException("At least 3 points are required to compute the convex hull");
        }
    
        hull.push(sortedPoints.get(0)); // Push the first two points onto the stack
        hull.push(sortedPoints.get(1));
    
        // Process the remaining points to build the convex hull
        for (int i = 2; i < sortedPoints.size(); i++) {
            Point2D top = hull.pop();
            while (hull.size() >= 1 && Point2D.ccw(hull.peek(), top, sortedPoints.get(i)) <= 0) {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(sortedPoints.get(i));
        }
    }
}
