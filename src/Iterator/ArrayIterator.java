/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterator;


import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.List;

/**
 *
 * @author ahmed
 */
public class ArrayIterator implements MyIterator {

    int index ;
    private List<GameObject> list;

    public ArrayIterator(List list) {
        this.list = list;
        index=0;
    }

    @Override
    public boolean hasNext() {
        if (index < list.size()) {
            return true;
        }
        return false;
    }

    @Override
    public GameObject next() {
        if (this.hasNext()) {
            return list.get(index++);
        }
        return null;
    }

    @Override
    public void remove() {
        list.remove(--index);
    }


    @Override
    public int getIndex() {
       return index;
    }

}
