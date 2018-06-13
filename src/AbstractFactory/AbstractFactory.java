/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory;


import eg.edu.alexu.csd.oop.game.sample.object.Shape;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Katary
 */
public abstract class AbstractFactory {
    
//    int i, j;
    
//    public AbstractFactory(int level){
//        
//    }

    public abstract Shape createShape(int level);
    
    protected int generateX(int [] positionX, int generateTo){
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(generateTo);
        
        return positionX[index];
    }
        
    
    protected int generateY(int [] positionY, int generateTo){
    Random randomGenerator = new Random();
      int index = randomGenerator.nextInt(generateTo);

       return positionY[index];
}
     protected Color getRandColor() {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(4);
        return ColorFactory.getInstance().getColor(index);
    }
    
}
