/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game.sample.world;

import AbstractFactory.FactoryMaker;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.sample.object.BarObject;
import eg.edu.alexu.csd.oop.game.sample.object.Shape;
import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author pc
 */
public class Flyobj {

    private static final HashMap<Color, Shape> objByColor = new LinkedHashMap<Color, Shape>();
    private static Flyobj instance;

    private Flyobj() {
    }

    public static Flyobj getInstance() {

        if (instance == null) {
            instance = new Flyobj();
        }
        return instance;

    }

    public static Shape Flyobj(Color color, int width, int startPos, int levelIndex) {
        Shape obj = objByColor.get(color);
        
        if (obj == null) {
            /*(Math.random() * (width * 0.1))*/
            obj = (Shape) FactoryMaker.getFactory().createShape(levelIndex);
        }

        return obj;

    }
}
