/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memento;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Caretaker {
     private static Caretaker instance;
    private Caretaker() {
    }
    public static Caretaker getInstance() {

        if (instance == null) {
            instance = new Caretaker();
        }
        return instance;
    }
    ArrayList<Memento> ScoresList = new ArrayList<Memento>();
   
    private int scoreCount=0;
    public void addMemento(Memento score)
    {
        System.out.println("Prev "+ScoresList.size());
        ScoresList.add(score);
        scoreCount++;
        System.out.println("After "+ScoresList.size());
    }
    
    public Memento getLastMemento()
    {
        System.out.println(ScoresList.size());
        return ScoresList.get(ScoresList.size()-1);
    }
    
   
}
