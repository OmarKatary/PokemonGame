/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game.sample.world;

import Iterator.ArrayIterator;
import Iterator.MyIterator;
import Memento.Caretaker;
import Memento.Orginator;
import Observer.BarSubject;
import State.DifficultyState;
import State.Medium;
import State.Hard;
import State.Easy;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.sample.object.BarObject;
import eg.edu.alexu.csd.oop.game.sample.object.ImageObject;
import eg.edu.alexu.csd.oop.game.sample.object.Shape;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ahmed
 */
public class Clown implements World {

    private static final int MAX_TIME = 1 * 60 * 1000;	// 1 minute
    private static long startTime = System.currentTimeMillis();
    private static long time = 0;
    private final int width;
    private final int height;
    private final List<GameObject> constant = new LinkedList<>();
    private final List<GameObject> moving = new LinkedList<>();
    private final List<GameObject> control = new LinkedList<>();
    private final List<Integer> pileLeft = new LinkedList<Integer>();
    private final List<Integer> pileRight = new LinkedList<Integer>();
    private String Difficulty;
    boolean count15 = true;
    boolean count30 = true;
    boolean count45 = true;

    DifficultyState Easy;
    DifficultyState Medium;
    DifficultyState Hard;
     Playing playing;
    DifficultyState state;
    BarSubject subject;

    public Clown(int screenWidth, int screenHeight, String Difficulty) {
        width = screenWidth;
        height = screenHeight;

        Easy = new Easy();
        Medium = new Medium();
        Hard = new Hard();

        if (Difficulty.equalsIgnoreCase("Easy")) {
            state = Easy;
            GameDataManager.getInstance().setLevelIndex(1);
        } else if (Difficulty.equalsIgnoreCase("Medium")) {
            state = Medium;
            GameDataManager.getInstance().setLevelIndex(2);
        } else {
            state = Hard;
            GameDataManager.getInstance().setLevelIndex(3);
        }

        GameDataManager.getInstance().setWidth(width);
        GameDataManager.getInstance().setHeight(height);
        GameDataManager.getInstance().setColor(state.getNumberOfColors());
        // control objects (hero)
//        control.add(new ImageObject(screenWidth / 3, (int) (screenHeight * 0.8), "/squirtle.png"));
//        control.add(new ImageObject(screenWidth / 3 - 20, (int) (screenHeight * 0.8) - 30, "/leftWater.png"));
//        control.add(new ImageObject(screenWidth / 3 + 80, (int) (screenHeight * 0.8) - 30, "/rightWater.png"));
//        
        control.add(new ImageObject(screenWidth / 3, (int) (screenHeight * 0.8), "/pikachu.png"));
        control.add(new ImageObject(screenWidth / 3 - 10, (int) (screenHeight * 0.8) - 50, "/thunderleft.png"));
        control.add(new ImageObject(screenWidth / 3 + 100, (int) (screenHeight * 0.8) - 50, "/thunderright.png"));
//        // moving objects (enemy)

        NumberOFBars();

        moving.add((Shape) GameDataManager.getInstance().getPlayObject(0, 0));
        subject = new BarSubject();
         MyIterator iter = new ArrayIterator(control);
        playing = new Playing(subject,iter);
        
        playing.setSpeed(state.getGameSpeed());
       
    }

    public static void setStartTime(long startTime) {
        Clown.startTime = startTime - time;
    }

    @Override
    public boolean refresh() {
        long currentTime = System.currentTimeMillis() - startTime;
        boolean timeout = currentTime > MAX_TIME; // time end and game over
        int time = (int) ((MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000);

        if (time % 15 == 0) {

            if (time == 15 && count15) {
                Orginator.getInstance().Set(GameDataManager.getInstance().getScore(), (int) time);
                Caretaker.getInstance().addMemento(Orginator.getInstance().createMomento());
                count15 = false;
            }
            if (time == 30 && count30) {
                Orginator.getInstance().Set(GameDataManager.getInstance().getScore(), (int) time);
                Caretaker.getInstance().addMemento(Orginator.getInstance().createMomento());
                count30 = false;
            }
            if (time == 45 && count45) {
                Orginator.getInstance().Set(GameDataManager.getInstance().getScore(), (int) time);
                Caretaker.getInstance().addMemento(Orginator.getInstance().createMomento());
                count45 = false;
            }

        }
        

        playing.execute(moving, control, timeout, pileLeft, pileRight);

        return !timeout;
    }

    public static long getStartTime() {
        return startTime;
    }

    public static long getTime() {
        return time;
    }

    public static void setTime(long time) {
        Clown.time = time;
    }

    @Override
    public int getSpeed() {
        return 10;
    }

    @Override
    public int getControlSpeed() {
        return 10;
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return control;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getStatus() {
        return "Score=" + GameDataManager.getInstance().getScore() + "   |   Time=" + Math.max(0, (MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000);	// update status
    }

    private void NumberOFBars() {
        int NOBs;
        NOBs = state.getNoOfBars();

        if (NOBs == 2) {
            constant.add(new BarObject(0, 50, (int) (width * 0.4), true, Color.ORANGE));
            constant.add(new BarObject(width - (int) (width * 0.4), 50, (int) (width * 0.5), true, Color.ORANGE));
        } else if (NOBs == 3) {
            constant.add(new BarObject(0, 50, (int) (width * 0.4), true, Color.ORANGE));
            constant.add(new BarObject(width - (int) (width * 0.4), 50, (int) (width * 0.5), true, Color.ORANGE));
            constant.add(new BarObject(0, 90, (int) (width * 0.2), true, Color.ORANGE));
        } else {
            constant.add(new BarObject(0, 50, (int) (width * 0.4), true, Color.ORANGE));
            constant.add(new BarObject(width - (int) (width * 0.4), 50, (int) (width * 0.5), true, Color.ORANGE));
            constant.add(new BarObject(0, 90, (int) (width * 0.2), true, Color.ORANGE));
            constant.add(new BarObject(width - (int) (width * 0.2), 90, (int) (width * 0.5), true, Color.ORANGE));
        }
    }

}
