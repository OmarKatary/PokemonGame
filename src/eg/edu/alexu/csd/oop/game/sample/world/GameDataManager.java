/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game.sample.world;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.sample.object.Shape;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author pc
 */
public class GameDataManager {

    private static GameDataManager instance;
    private static long currentTime = System.currentTimeMillis();
    private static int randomSeconds = 1;
    private int score = 0;
    public static int intersectCount = 0;
    public int width;
    public int height;
    private static boolean firstLeftIntersect = true;
    private static boolean firstRightIntersect = true;
    private final List<GameObject> constant = new LinkedList<>();
    private final List<GameObject> moving = new LinkedList<>();
    private final List<GameObject> control = new LinkedList<>();
    private final List<Integer> pileLeft = new LinkedList<Integer>();
    private final List<Integer> pileRight = new LinkedList<Integer>();
    private int color;
    private int levelIndex;
    private GameDataManager() {
    }


    public static GameDataManager getInstance() {

        if (instance == null) {
            instance = new GameDataManager();
        }
        return instance;
    }

    
    public List<GameObject> getConstant() {
        return constant;
    }

    public List<GameObject> getMoving() {
        return moving;
    }

    public List<GameObject> getControl() {
        return control;
    }
     public List<Integer> getPileLeft() {
        return pileLeft;
    }
      public List<Integer> getPileRight() {
        return pileRight;
    }

    public static void setFirstLeftIntersect(boolean intersect) {
        GameDataManager.firstLeftIntersect = intersect;
    }

    public static boolean isFirstLeftIntersect() {
        return firstLeftIntersect;
    }
    public static void setFirstRightIntersect(boolean intersect) {
        GameDataManager.firstRightIntersect = intersect;
    }

    public static boolean isFirstRightIntersect() {
        return firstRightIntersect;
    }
    
    public void setFuckingScore(int score)
    {
        this.score=score;
    }

    public int getScore() {
        return score;
    }

    public void setScore() {
        this.score++;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static int getIntersectCount() {
        return intersectCount;
    }

    public static void setCurrentTime() {
        GameDataManager.currentTime = System.currentTimeMillis();
    }

    public static void setRandomSeconds() {
        GameDataManager.randomSeconds = (int) (Math.floor(Math.random() * 4) + 1);
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public int getRandomSeconds() {
        return randomSeconds;
    }

    public boolean Getintersect(GameObject o1, GameObject o2) {
        return 
//                (Math.abs((o1.getX() + o1.getWidth() / 2) - (o2.getX() + o2.getWidth() / 2)) <= o1.getWidth()) 
//                && (Math.abs((o1.getY() + o1.getHeight() / 2) - (o2.getY())) <= o1.getHeight());
        (Math.abs((o1.getX() + o1.getWidth() / 2) - (o2.getX() + o2.getWidth() / 2)) <= o1.getWidth())&&
                (Math.abs(o1.getY() + o1.getHeight() ) == o2.getY());
    }

    private Color getRandColor() {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(getColor());
        return ColorFactory.getInstance().getColor(index);
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return this.color;
    }
    
   public void setLevelIndex(int levelIndex){
       this.levelIndex = levelIndex;
   }

    public Shape getPlayObject(int startPos, int width) {
        return Flyobj.getInstance().Flyobj(getRandColor(), width, startPos,levelIndex);
    }
}
