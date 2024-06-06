import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Lever {
    private int widthAndHeight;
    private int x;
    private int y;
    private BufferedImage currentImage;
    private BufferedImage leverUp;
    private BufferedImage leverDown;

    public Lever (int x, int y) {
        this.widthAndHeight = 100;
        this.x = x;
        this.y =y;
        try {
            leverUp = ImageIO.read(new File("src/leverUp.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            leverDown = ImageIO.read(new File("src/leverDown.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        currentImage = leverUp;
    }

    public BufferedImage getImage () {
        return currentImage;
    }

    public void switchDown () {
        currentImage = leverDown;
    }

    public int getWidthAndHeight() {
        return widthAndHeight;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Rectangle leverRect() {
        Rectangle rect = new Rectangle(x, y, widthAndHeight, widthAndHeight);
        return rect;
    }
}
