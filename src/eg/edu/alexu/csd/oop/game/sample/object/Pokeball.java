/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game.sample.object;

import Observer.Observer;
import eg.edu.alexu.csd.oop.game.sample.object.Shape;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Katary
 */
public class Pokeball extends Shape implements Observer{
    
    private BufferedImage[] spriteImages;

    
    public Pokeball(boolean horizontalOnly, Color color) {
        super(30, 30,true, horizontalOnly, color);
        String path = null;
        spriteImages = getSpriteImages();
        
        if (color.getRGB() == color.RED.getRGB()){
            System.out.println("red ");
            path="/redpoke.png";
    }
        else if(color.getRGB() == color.YELLOW.getRGB()){
            System.out.println("yellow ");
        path="/yellowpoke.png";
    }
        else if(color.getRGB() == color.BLUE.getRGB()){
            System.out.println("blue ");
            path="/bluepoke.png";
    }
         else if (color.getRGB() == color.BLACK.getRGB()){
             System.out.println("black ");
             path="/blackpoke.png";
    }
         try {
            spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
         
    
    
}

    @Override
    public void update() {
       this.setOnScreen(false);
       //this.setVisible(false);
    }
}