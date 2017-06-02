/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextest;

import java.awt.BorderLayout;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame implements Runnable {
    
    private JPanel mousePanel;
    private GamePanel gamePanel;
    
    private Thread thread;
    private Boolean running = false;
    
    public ObjHandler handler;
    
    Grid grid;
    Camera cam;
        
    public Game() { 
        super("hextest");
        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        //setLocationRelativeTo(null);
        setVisible(true);  
        
        handler = new ObjHandler();
        
        cam = new Camera(0, 0);

        mousePanel = new JPanel();
        add(mousePanel, BorderLayout.CENTER);
        
        gamePanel = new GamePanel(handler, cam);
        add(gamePanel);
        pack();
        
        int hexSize = 80;
        Point2D origin = new Point2D.Double(0, 0);
        grid = new Grid(origin.getX(), origin.getY(), handler, 30, hexSize, 0);
        
        handler.addObject(grid);
        
        KeyInput keyhandler = new KeyInput(handler, cam);
        this.addKeyListener(keyhandler);
       
        start();
    }
    
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    
    public synchronized void stop() {
        try {
            thread.join();
            running = false;    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >=1) {
                tick();
                delta--;
            }
            if (running) {
                render();
                frames++;        
            }
            
            
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.print(frames + "  ");
                frames = 0;
            }
        }
        stop();
    }
    
    private void tick() {
        
        handler.tick();
        //hud.tick();
        cam.tick();
    }
    
    private void render() {
        
        gamePanel.render();
    }
    
    public static void main(String[] args) {
        
        new Game(); 
    } 
}
