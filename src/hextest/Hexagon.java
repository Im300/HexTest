/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextest;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Point2D;

public class Hexagon extends Polygon {

    private static final long serialVersionUID = 1L;

    public static final int SIDES = 6;

    private Point[] points = new Point[SIDES];
    public Point center = new Point(0, 0);
    private int radius;
    private int rotation = 90;

    public Hexagon(Point center, int radius) {
        npoints = SIDES;
        xpoints = new int[SIDES];
        ypoints = new int[SIDES];

        this.center = center;
        this.radius = radius;

        updatePoints();
    }

    public Hexagon(int x, int y, int radius) {
        this(new Point(x, y), radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;

        updatePoints();
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;

        updatePoints();
    }

    public void setCenter(Point center) {
        this.center = center;

        updatePoints();
    }

    public void setCenter(int x, int y) {
        setCenter(new Point(x, y));
    }

    private double findAngle(double fraction) {
        return fraction * Math.PI * 2 + Math.toRadians((rotation + 180) % 360);
    }

    private Point findPoint(double angle) {
        int x = (int) (center.getX() + Math.cos(angle) * radius);
        int y = (int) (center.getY() + Math.sin(angle) * radius);

        return new Point(x, y);
    }

    protected void updatePoints() {
        for (int p = 0; p < SIDES; p++) {
            double angle = findAngle((double) p / SIDES);
            Point point = findPoint(angle);
            xpoints[p] = (int) point.getX();
            ypoints[p] = (int) point.getY();
            points[p] = point;
        }
    }
    
    //public void draw(Graphics2D g, int x, int y, int lineThickness, Color colorValue, boolean filled) {
    public void draw(Graphics2D g, int lineThickness, Color colorValue, boolean filled) {
        // Store before changing.
        Stroke tmpS = g.getStroke();
        Color tmpC = g.getColor();

        //g.setColor(new Color(colorValue));
        g.setColor(colorValue);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setStroke(new BasicStroke(lineThickness, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));

        //g.drawPolygon(this);
        g.drawPolygon(this.xpoints, this.ypoints, SIDES);

        // Set values to previous when done.
        g.setColor(tmpC);
        g.setStroke(tmpS);
    }
    
}
