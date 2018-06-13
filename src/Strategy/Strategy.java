/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import eg.edu.alexu.csd.oop.game.sample.object.BarObject;
import eg.edu.alexu.csd.oop.game.sample.object.Shape;

/**
 *
 * @author ahmed
 */
public interface Strategy {

    boolean isMovingHorizontal();
    void move(Shape plate);

}
