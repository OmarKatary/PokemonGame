/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this temshape file, choose Tools | Temshapes
 * and open the temshape in the editor.
 */
package eg.edu.alexu.csd.oop.game.sample.world;

import AbstractFactory.FactoryMaker;
import Iterator.ArrayIterator;
import Iterator.MyIterator;
import Observer.BarSubject;
import Observer.Observer;
import Strategy.MovingVertical;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.sample.object.BarObject;
import eg.edu.alexu.csd.oop.game.sample.object.Shape;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author pc
 */
public class Playing {

    GameDataManager manager;
    BarSubject subject;
    int speed;
    MyIterator iter;

    public Playing(BarSubject subject, MyIterator iter) {

        manager = GameDataManager.getInstance();
        this.subject = subject;
        this.iter = iter;

    }

    public void execute(List<GameObject> moving, List<GameObject> control, boolean timeOut, List<Integer> pileLeft, List<Integer> pileRight) {
  
            
            for (int i = 0; i < moving.size(); i++) {
                Shape shape = (Shape) moving.get(i);

                //Timeout? empty list
                checkDirection(shape);
                if (checkTimeOut(timeOut)) {
                    moving.clear();
                    break;
                } else {
                    shape.getMovingDirection().move(shape);
                    //does it move in X or Y 
                    if (shape.getMovingDirection().isMovingHorizontal()) {
                    } else {

                        //Is it at end of screen? remove from list
                        if (atEndOfScreen(shape, manager.getHeight())) {
                            moving.remove(i);
                            shape.setOnScreen(false);

                            break;
                        }
                        if (isFirstIntersect(timeOut, i, moving, control, pileLeft, 1)) {
                            GameDataManager.setFirstLeftIntersect(false);
                            break;
                        } else if (otherIntersect(timeOut, i, moving, control, pileLeft)) {
                            if (isThreeOrMore(pileLeft)) {
//                                System.out.println("Intersect count" + countIntersect);
                                if (areTheySame(control, pileLeft)) {
                                    if (pileLeft.isEmpty()) {
                                        GameDataManager.setFirstLeftIntersect(true);
                                    }
                                    break;
                                }
                            }
                        }

                        if (isFirstIntersect(timeOut, i, moving, control, pileRight, 2)) {
                            GameDataManager.setFirstRightIntersect(false);
                            break;
                        } else if (otherIntersect(timeOut, i, moving, control, pileRight)) {
                            if (isThreeOrMore(pileRight)) {
//                                System.out.println("Intersect count" + countIntersect);
                                if (areTheySame(control, pileRight)) {
                                    if (pileRight.isEmpty()) {
                                        GameDataManager.setFirstRightIntersect(true);
                                    }
                                    break;
                                }
                            }
                        }

                    }
                }

            }
            randomPlate(moving, manager.getWidth());
        }
    

    private void checkDirection(Shape shape) {

        if ((shape.getX() >= (int) (manager.getWidth() * 0.4) && shape.getX() <= (int) (manager.getWidth() - manager.getWidth() * 0.4 - shape.getWidth())) && (shape.getY() <= 50)) {
              shape.setMovingDirection(new MovingVertical());
        } else if ((shape.getX() >= (int) (manager.getWidth() * 0.2) && shape.getX() <= (int) (manager.getWidth() - manager.getWidth() * 0.2 - shape.getWidth())) && (shape.getY() > 50)) {
              shape.setMovingDirection(new MovingVertical());
       } 
//else {
//            shape.setMovingDirection(new MovingVertical());
//        }
   }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    boolean checkTimeOut(boolean timeOut) {
        return timeOut;
    }

    boolean atEndOfScreen(Shape shape, int height) {
        if (shape.getY() == manager.getHeight()) {
            return true;
        }
        return false;
    }

    boolean isFirstIntersect(boolean timeOut, int current, List<GameObject> moving, List<GameObject> control, List<Integer> pile, int pileNumber) {
        if ((!timeOut & manager.Getintersect(moving.get(current), control.get(pileNumber))) && (GameDataManager.isFirstRightIntersect() == true || GameDataManager.isFirstLeftIntersect() == true)) {
            //-15 to raise the bar above subject a bit
            moving.get(current).setY(control.get(pileNumber).getY() - moving.get(current).getHeight());
            control.add(moving.get(current));
            pile.add(control.size() - 1);

            subject.register((Observer) moving.get(current));
            moving.remove(moving.get(current));
            return true;
        }
        return false;
    }

    boolean otherIntersect(boolean timeOut, int current, List<GameObject> moving, List<GameObject> control, List<Integer> pile) {
//         System.out.println(pileLeft.size()); 
        //pileLeft.add(control.size()-1);
        if (pile.size() >= 1 && !timeOut & manager.Getintersect(moving.get(current), control.get(pile.get(pile.size() - 1)))) {
            moving.get(current).setY(control.get(pile.get(pile.size() - 1)).getY() - moving.get(current).getHeight());
            control.add(moving.get(current));
            pile.add(control.size() - 1);

            subject.register((Observer) moving.get(current));
            moving.remove(moving.get(current));
            return true;
        }
        return false;
    }

    boolean isThreeOrMore(List<Integer> pileLeft) {
        return (pileLeft.size() >= 3);
    }

    boolean areTheySame(List<GameObject> control, List<Integer> pile) {

        Shape checkColors1 = (Shape) control.get(pile.get(pile.size() - 1));
        Shape checkColors2 = (Shape) control.get(pile.get(pile.size() - 2));
        Shape checkColors3 = (Shape) control.get(pile.get(pile.size() - 3));

        if (checkColors1.getColor() == checkColors2.getColor() && checkColors1.getColor() == checkColors3.getColor()) {

            control.remove(pile.get(pile.size() - 1));
            control.remove(pile.get(pile.size() - 2));
            control.remove(pile.get(pile.size() - 3));

            checkColors1.setVisible(false);
            checkColors2.setVisible(false);
            checkColors3.setVisible(false);

            pile.remove(pile.size() - 1);
            pile.remove(pile.size() - 1);
            pile.remove(pile.size() - 1);

            subject.notifyObservers();

            manager.setScore();
            return true;
        }
        return false;
    }

    void randomPlate(List<GameObject> moving, int width) {
//        System.out.println("in");
//        System.out.println("current: " + manager.getCurrentTime());
//        System.out.println("random: " + manager.getRandomSeconds());
//        boolean test = manager.getCurrentTime() + manager.getRandomSeconds() < System.currentTimeMillis();
//        System.out.println(test);
        if (manager.getCurrentTime() + (manager.getRandomSeconds() * this.speed * 100) < System.currentTimeMillis()) {
//           System.out.println("in2"); 
            moving.add(manager.getPlayObject(0, width));
//            moving.add(manager.getPlayObject(width, width));
//              moving.add((GameObject) FactoryMaker.getFactory().createShape());

            GameDataManager.setRandomSeconds();
            GameDataManager.setCurrentTime();
//            System.out.println("hena "+currentTime + "random " + randomSeconds);

        }
    }

}
