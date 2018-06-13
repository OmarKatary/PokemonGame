/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import eg.edu.alexu.csd.oop.game.sample.object.BarObject;
import eg.edu.alexu.csd.oop.game.sample.object.Shape;
import eg.edu.alexu.csd.oop.game.sample.world.GameDataManager;

/**
 *
 * @author ahmed
 */
public class MovingHorizontal implements Strategy{
    
    GameDataManager manager;

    public MovingHorizontal() {
        this.manager = GameDataManager.getInstance();
    }
    
    
    
    @Override
    public boolean isMovingHorizontal() {
        return true;
    }
    
        @Override
    public void move(Shape plate){
         if (plate.getX() < (int) (manager.getWidth() * 0.4) && plate.getY()<=50) {
                    plate.setX((plate.getX() + 2));
        }else if(plate.getX() < (int) (manager.getWidth() * 0.2) && plate.getY()>50){
                    plate.setX((plate.getX() + 2));                    
        }else if (plate.getX() > (int) (manager.getWidth() - GameDataManager.getInstance().getWidth() * 0.4 - plate.getWidth())&& plate.getY()<=50) {
                    plate.setX((plate.getX() - 2));
        }else if(plate.getX() > (int) (manager.getWidth() - GameDataManager.getInstance().getWidth() * 0.2 - plate.getWidth())&& plate.getY()>50){
                    plate.setX((plate.getX() - 2));
        } 

    }

}
