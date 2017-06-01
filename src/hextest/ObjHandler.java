package hextest;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author David
 */
public class ObjHandler {
    
    //All objects in game
    LinkedList<GameObject> objectList = new LinkedList<GameObject>();
    
    //All visable objects in game
    LinkedList<GameObject> visibleList = new LinkedList<GameObject>();
    
    //Objects that are currently selected by the player
    LinkedList<GameObject> selectedList = new LinkedList<GameObject>();
    
    //Objects that are clickable by the player (for click-checking and culling)
    LinkedList<GameObject> clickableList = new LinkedList<GameObject>();
    
    public ObjHandler() {
        
    }
    
    public void tick() {

        for (int i = 0; i < objectList.size(); i++) {
            
            GameObject tempObject = objectList.get(i);
            tempObject.tick();
        }
    }
    
    public void render(Graphics g) {
        
        for (int i = 0; i < objectList.size(); i++) {
            
            GameObject tempObject = objectList.get(i);
            tempObject.render(g);
        }
    }
    
    public void addObject(GameObject object) {
        
        this.objectList.add(object);
    }   
    public void removeObject(GameObject object) {
        
        this.objectList.remove(object); 
    }
    
}
