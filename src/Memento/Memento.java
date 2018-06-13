/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memento;

/**
 *
 * @author User
 */
public class Memento {

    private int info[] = new int[2];
    public Memento(int scores , int currentTime) {
        info[0] = scores;
        info[1]=currentTime;
    }
    
    public int[] getScore()
    {
        return info;
    }

}
