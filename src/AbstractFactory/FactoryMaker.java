/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory;

import AbstractFactory.AbstractFactory;
import java.util.Random;

/**
 *
 * @author Katary
 */
public class FactoryMaker {
    
    public static AbstractFactory getFactory() {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(2);
        
        switch(index){
            case 0: 
                return new PokeballFactory();
               
            case 1: 
                return new PlateFactory();
 
                
        }
       return null;  
    }
}
