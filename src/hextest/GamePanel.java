/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    
    public static final int DEFAULT_WIDTH = 1280, DEFAULT_HEIGHT = 720;
    //public static final int DEFAULT_WIDTH = 640, DEFAULT_HEIGHT = (DEFAULT_WIDTH / 16) * 9;
    
    ObjHandler handler;
    Camera cam;
    
    int printVar;
    
    public GamePanel(ObjHandler handler, Camera cam) {
        super();
        this.handler = handler;
        this.cam = cam;
        
        this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        this.setMaximumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        this.setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        this.setVisible(true); 
        this.setBackground(Color.BLACK);
    } 
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        cam.render(g);

        g2d.translate(cam.getX(), cam.getY());
        
        handler.render(g);
        
        g2d.translate(-cam.getX(), -cam.getY());
    }
    
    public void render() {
        this.repaint();
    }
    
}
