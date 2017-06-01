/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextest;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    
    ObjHandler handler;
    Camera cam;
    
    private boolean[] keydown = new boolean[4];

    public KeyInput(ObjHandler handler, Camera cam) {
        this.handler = handler;
        this.cam = cam;
        
        keydown[0] = false;
        keydown[1] = false;
        keydown[2] = false;
        keydown[3] = false;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT) { cam.setXVelocity(cam.getCameraSpeed()); keydown[0] = true; }
        if(key == KeyEvent.VK_RIGHT) { cam.setXVelocity(-cam.getCameraSpeed()); keydown[1] = true; }
        if(key == KeyEvent.VK_UP) { cam.setYVelocity(cam.getCameraSpeed()); keydown[2] = true; }
        if(key == KeyEvent.VK_DOWN) { cam.setYVelocity(-cam.getCameraSpeed()); keydown[3] = true; }
        
        if(key == KeyEvent.VK_ESCAPE) System.exit(1);
        if(key == KeyEvent.VK_Q) System.exit(1); 
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT) keydown[0] = false;
        if(key == KeyEvent.VK_RIGHT) keydown[1] = false;
        if(key == KeyEvent.VK_UP) keydown[2] = false;
        if(key == KeyEvent.VK_DOWN) keydown[3] = false;
        
        if (!keydown[0] && !keydown[1]) {
            cam.setXVelocity(0);
        }

        if (!keydown[2] && !keydown[3]) {
            cam.setYVelocity(0);
        }
    }
}
