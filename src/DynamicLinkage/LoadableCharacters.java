/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicLinkage;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.sample.world.Clown;

/**
 *
 * @author ahmed
 */
public abstract class LoadableCharacters implements GameObject {

    World world;

    public void setEnvironment(World world) {

        this.world = world;

    }
    
    
    public abstract void start(); 

}
