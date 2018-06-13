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
public class Orginator {

    private static Orginator instance;
    private Orginator() {
    }
    public static Orginator getInstance() {

        if (instance == null) {
            instance = new Orginator();
        }
        return instance;
    }
    
    private int[] Score = new int[2];

    public void Set(int score , int Time) {
         Score[0]=score;
         Score[1]=Time;
         System.out.println("Score is "+Score[0] + " Time is "+Score[1]);
    }
    
    public Memento createMomento()
    {
       System.out.println("Score is "+Score[0] + " Time is "+Score[1]);
        return new Memento(Score[0],Score[1]);
    }
   
    public int[] RestoreLastMemento(Memento memento)
    {
        int[] score =memento.getScore();
        return score;
    }
    
}
