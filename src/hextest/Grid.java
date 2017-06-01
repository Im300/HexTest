/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class Grid extends GameObject {

    Point2D origin;
    int size;
    int radius;
    int padding;
    int half;
    
    Hexagon grid[][];
    
    //public Grid(Point2D origin, int size, int radius, int padding) {
    public Grid(double x, double y, ObjHandler handler, int size, int radius, int padding) {
        super(x, y, handler);
        
        handler.addObject(this);
        
        origin = new Point2D.Double(x, y);
        this.size = size;
        this.radius = radius;
        this.padding = padding;

        half = size / 2;
        
        grid = new Hexagon[size][];
        
        //Count the number of hexes to initialize column arrays
        for (int row = 0; row < size; row++) {

            //find the amount of hexes in this column
            int cols = size - java.lang.Math.abs(row - half);

            grid[row] = new Hexagon[cols];
        }
        
        double ang30 = Math.toRadians(30);
        double xOff = Math.cos(ang30) * (radius + padding);
        double yOff = Math.sin(ang30) * (radius + padding);

        for (int row = 0; row < size; row++) {
            
            int cols = size - java.lang.Math.abs(row - half);

            for (int col = 0; col < cols; col++) {
                
                int tempX = (int)  (origin.getX() + xOff * (col * 2 + 1 - cols));
                int tempY = (int)  (origin.getY() + yOff * (row - half) * 3);

                Hexagon tempHex = new Hexagon(tempX, tempY, radius);
                grid[row][col] = tempHex;
            }
        }
    }
    
    public void tick() {
        
    }
    
    public void render(Graphics g) {
        
        Graphics2D g2d = (Graphics2D)g;
        drawGrid(g2d, false);
    }
    
    //New
    public void drawGrid(Graphics2D g2d, Boolean selected) {

        for (int i=0; i< size; i++) {
            
            int l = size - java.lang.Math.abs(i - half);
            
            for (int j=0; j< l; j++) {
                
                //Hexagon tempHex = grid[i][j];
                
                g2d.setColor(Color.RED);
                g2d.setFont(new Font("TimesRoman", Font.PLAIN, 24)); //MINE
                g2d.drawString(i + "," + j, (int) (grid[i][j].center.getX() - 25),(int) (grid[i][j].center.getY()));
                grid[i][j].draw(g2d, 2, Color.WHITE, false);
                
            }
        }
    }
}
