/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game.sample.object;

import Observer.Observer;
import eg.edu.alexu.csd.oop.game.sample.object.Shape;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Katary
 */
public class Plate extends Shape implements Observer{
    
//    private BufferedImage[] spriteImages;
//    
//    public Plate(int x, int y, boolean horizontalOnly, Color color){
//       super(x ,y ,35,5 ,true ,horizontalOnly ,color);
//       spriteImages = getSpriteImages();
//       Graphics2D g2 = spriteImages[0].createGraphics();
//        g2.setColor(color);
//        g2.setBackground(color);
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//	g2.setStroke(new BasicStroke(20));
////        int xPoly[] = {0, width, (int)0.8*width ,(int)0.2*width};
////        int yPoly[] = {0, 0, height ,height};
//	g2.drawLine(0, 0, getWidth(), 0);
////       g2.drawPolygon(xPoly, yPoly, 4);
////        g2.drawOval(0, 0, width, height);
//	g2.dispose();
//    }
      private BufferedImage[] spriteImages;

    
    public Plate(boolean horizontalOnly, Color color) {
        super(40, 8,true, horizontalOnly, color);
        String path = null;
        spriteImages = getSpriteImages();
        
        if (color.getRGB() == color.RED.getRGB()){
            System.out.println("red ");
            path="/redPlate.png";
    }
        else if(color.getRGB() == color.YELLOW.getRGB()){
            System.out.println("yellow ");
        path="/yellowPlate.png";
    }
        else if(color.getRGB() == color.BLUE.getRGB()){
            System.out.println("blue ");
            path="/bluePlate.png";
    }
         else if (color.getRGB() == color.BLACK.getRGB()){
             System.out.println("black ");
             path="/blackPlate.png";
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
      // this.setVisible(false);
    }
}
