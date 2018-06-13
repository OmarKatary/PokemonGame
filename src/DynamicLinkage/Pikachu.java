/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicLinkage;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author ahmed
 */
public class Pikachu extends LoadableCharacters {

    private BufferedImage[] spriteImages = new BufferedImage[1];
    private int x;
    private int y;
    private int width;
    private int height;

    public void setPath(String path) throws IOException {
        spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));

    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;

    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {

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
    public boolean isVisible() {
        return true;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }

    @Override
    public void start() {
        try {
            this.setPath("/pikachu.png");
        } catch (IOException ex) {
            Logger.getLogger(Pikachu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.x = 150;
        this.y = this.world.getHeight() - spriteImages[0].getHeight();
    }

}
