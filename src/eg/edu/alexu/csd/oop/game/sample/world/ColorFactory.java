/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game.sample.world;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.Color;
import java.util.HashMap;

/**
 *
 * @author alizain
 */
public class ColorFactory {

    private static ColorFactory instance;
    private static final HashMap<Integer, Color> randomColors = new HashMap<>();

    private ColorFactory() {
        randomColors.put(0, Color.BLUE);
        randomColors.put(1, Color.BLACK);
        randomColors.put(2, Color.RED);
        randomColors.put(3, Color.YELLOW);
        randomColors.put(4, Color.PINK);
    }

    public static ColorFactory getInstance() {

        if (instance == null) {
            instance = new ColorFactory();
        }
        return instance;

    }

    public Color getColor(int randomNumber) {
        return randomColors.get(randomNumber);
    }

}
