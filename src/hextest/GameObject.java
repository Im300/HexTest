/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextest;

import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public abstract class GameObject {
    
    protected double x;
    protected double y;
    protected int velX;
    protected int velY;
    
    ObjHandler handler;
    
    Hexagon hex;
    
    int clickType;
    Rectangle2D clickRect;
    Ellipse2D clickEllipse;
    Hexagon clickHex;
    String printVar;
            
    //Boolean visible;
    //Boolean clickable = true;
    Boolean selected = false;

    public GameObject(double x, double y, ObjHandler handler) {
        this.x = x;
        this.y = y;
        this.handler = handler;
    }
    
    public abstract void tick();
    public abstract void render (Graphics g);

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public int getVelX() {
        return velX;
    }
    public void setVelX(int velX) {
        this.velX = velX;
    }
    public int getVelY() {
        return velY;
    }
    public void setVelY(int velY) {
        this.velY = velY;
    }
    public void setSelected() {
        this.selected = true;
    }
    public void removeSelected() {
        this.selected = false;
    }
    
}
