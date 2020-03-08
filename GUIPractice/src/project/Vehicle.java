package application;
 
import javafx.scene.Scene;
import javafx.scene.paint.Color;
 
public class Vehicle extends Obstacle {
    private int respawnX, despawnX;
    private static Color color;
    private static int size;
    private int LR;
   
    public Vehicle (int startingX, int startingY, String direction) {
        super(startingX, startingY, color, direction, size);
        if (direction.equals("L")) {
            LR = -50;
            //if (size.euqal(2))
            if (size==2) {
            	respawnX = 650;
                despawnX = -100;
                this.color = setFill(ORANGE);
            }else if (size==1) {
            	respawnX = 700;
                despawnX = -50;
                this.color = setFill(RED);
            }
            
        } else if (direction.equals("R")) {
            LR = 50;
            if (size==2) {
            	respawnX = -100;
                despawnX = 650;
                this.color = setFill(ORANGE);
            }else if (size==1) {
            	respawnX = -50;
                despawnX = 700;
                this.color = setFill(RED);
            }
        }
        
    }
    
    /*
     * Move alongside log while within bounds.
     */
    public void Interaction(Avatar a, Scene cScene) {
        if (super.withinBounds(a)) {
            super.move(super.getDirection(), cScene);
            if (super.getDirection() == "L") {
                a.setX(a.getX()-super.getMoveLen());
            } else {
                a.setX(a.getX()+super.getMoveLen());
            }
        } else {
            super.move(super.getDirection(), cScene);
        }
        resetVehicle();
    }
   
    public void resetVehicle() {
        String cDirect = super.getDirection();
        if (cDirect.equals("R")) {
            if (super.getX() > despawnX) {
                super.setX(respawnX);
                System.out.println("RESPAWNED!");
            }
        } else {
            if (super.getX() < despawnX) {
                super.setX(respawnX);
            }
        }
    }
   
}