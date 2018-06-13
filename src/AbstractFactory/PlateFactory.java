/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory;

import AbstractFactory.AbstractFactory;
import Strategy.MovingHorizontal;
import eg.edu.alexu.csd.oop.game.sample.object.Plate;
import eg.edu.alexu.csd.oop.game.sample.object.Pokeball;
import eg.edu.alexu.csd.oop.game.sample.object.Shape;
import java.awt.Color;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Katary
 */
public class PlateFactory extends AbstractFactory {

    int[] positionY = {40, 80};
    int[] positionX = {0, 800};
    
    private static final HashMap<Color, Shape> usedObjects = new HashMap<Color, Shape>();

    @Override
    public Shape createShape(int level) {

        Color color = getRandColor();
        Shape shape = usedObjects.get(color);//FLYWEIGHT DESIGN PATTERN

        switch (level) {
            case 1:

                if (shape == null || shape.isOnScreen()) {//creates a new object if the same object is on screen 
                    shape = new Plate(false, color);
                    usedObjects.put(color, shape);
                    System.out.println("CREATE A NEW Plate");
                } else {
                    System.out.println("DID NOT CREATE A NEW Plate");
                }
                shape.setX(generateX(positionX, 2));
                shape.setY(generateY(positionY, 1));
                break;

            case 2:
                int x, y;
                do {
                    x = generateX(positionX, 2);
                    y = generateX(positionY, 2);
                } while ((x == 800 && y == 80));

                if (shape == null || shape.isOnScreen()) {//creates a new object if the same object is on screen 
                    shape = new Plate(false, color);
                    usedObjects.put(color, shape);
                    System.out.println("CREATE A NEW Plate");
                } else {
                    System.out.println("DID NOT CREATE A NEW Plate");
                }

                shape.setX(x);
                shape.setY(y);
                break;
            case 3:

                if (shape == null || shape.isOnScreen()) {//creates a new object if the same object is on screen 
                    shape = new Plate(false, color);
                    usedObjects.put(color, shape);
                    System.out.println("CREATE A NEW Plate");
                } else {
                    System.out.println("DID NOT CREATE A NEW Plate");
                }
                shape.setX(generateX(positionX, 2));
                shape.setY(generateY(positionY, 2));
                break;
        }

        shape.setOnScreen(true);
        shape.setMovingDirection(new MovingHorizontal());
        
        return shape;

    }

}