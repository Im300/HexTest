/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextest;

import java.awt.Graphics;
import java.awt.Point;

public class Camera {
    
    double x;
    double y;
    double xVelocity;
    double yVelocity;
    
    double cameraSpeed;
    
    Point position;
    
    public Camera(double x, double y) {
        this.position = new Point((int) x, (int) y);
        
        this.cameraSpeed = 0.5;
        
    }
    
    public void tick() {

        x = x + xVelocity;
        y = y + yVelocity;
    }
    
    public void render(Graphics g) {
        
    }
    
    public void setCameraSpeed(double cameraSpeed) {
        this.cameraSpeed = cameraSpeed;
    }
    public double getCameraSpeed() {
        return cameraSpeed;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getX() {
        return x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getY() {
        return y;
    }
    public void setXVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }
    public double getXVelocity() {
        return xVelocity;
    }
    public void setYVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }
    public double getYVelocity() {
        return yVelocity;
    }
    
    
    
    
}
