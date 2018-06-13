/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import Iterator.ArrayIterator;
import Iterator.MyIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ahmed
 */
public class BarSubject implements Subject {

    private List<Observer> observers = new ArrayList<Observer>();
    private int size;


    public BarSubject() {
        
        size=0;
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
        System.out.println("observer plate added");
        
        size++;
        System.out.println("SIZE OF ARRAY: "+size);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
        System.out.println("observer plate removed");
        size--;
    }

    
    
    
    //Iterator iter =  iterator.getIterator();
       
    
    
    
    @Override
    public void notifyObservers() {
//
//        for (int i = 0; i < 3; i++) {
//            int lastElement = size-1;
//            observers.get(lastElement).update();
//            unregister(observers.get(lastElement));
//                
//        }
    }

}
