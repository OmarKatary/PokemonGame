/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterator;

import eg.edu.alexu.csd.oop.game.GameObject;

/**
 *
 * @author ahmed
 */
public interface MyIterator {

   
   public boolean hasNext();
   public GameObject next();
   public void remove();
   public int getIndex();



}
