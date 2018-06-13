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
public class MovingVertical implements Strategy {

    @Override
    public boolean isMovingHorizontal() {
        return false;
    }

     @Override
    public void move(Shape plate){
         plate.setY(plate.getY() + 2);

    }

}
