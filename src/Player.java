import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Player {
    private String name;
    private String birthMonth;
    private int birthDate;
    private final double MOVE_AMT = 0.4;
    private double xCoord;
    private double yCoord;
    private boolean facingRight;
    private boolean facingLeft;
    private boolean standing;

    private BufferedImage playerStand;
    private BufferedImage playerLeft;
    private BufferedImage playerRight;
    private BufferedImage currentImage;


    public Player(String name, String birthMonth, int birthDate) {
        this.name = name;
        this.birthMonth = birthMonth;
        this.birthDate = birthDate;
        xCoord = 300;
        yCoord = 300;
        try {
            playerStand = ImageIO.read(new File("src/PlayerStand.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            playerLeft = ImageIO.read(new File("src/PlayerLeft.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            playerRight = ImageIO.read(new File("src/PlayerRight.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            currentImage = ImageIO.read(new File("src/PlayerStand.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        standing = true;
        currentImage = playerStand;
    }

    public void setX (int x) {
        xCoord = x;
    }

    public void setY (int y) {
        yCoord = y;
    }

    public int getHeight() {
        return currentImage.getHeight();
    }

    public int getWidth() {
        return currentImage.getWidth();
    }

    public void moveLeft() {
        if (xCoord - MOVE_AMT >= 0) {
            xCoord -= MOVE_AMT;
            currentImage = playerLeft;
        }
    }

    public void moveRight() {
        if (xCoord + MOVE_AMT <= 725) {
            xCoord += MOVE_AMT;
            currentImage = playerRight;
        }
    }

    public void moveUp() {
        if (yCoord - MOVE_AMT >= 0) {
            yCoord -= MOVE_AMT;
        }
    }

    public void moveDown () {
        if (yCoord + MOVE_AMT <= 389) {
            yCoord += MOVE_AMT;
        }
    }

    public double getXCoord () {
        return xCoord;
    }

    public double getYCoord () {
        return yCoord;
    }

    public BufferedImage getCurrentImage () {
        return currentImage;
    }

    public Rectangle playerRect() {
        int imageHeight = currentImage.getHeight();
        int imageWidth = currentImage.getWidth();
        Rectangle rect = new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
        return rect;
    }

    public void setCurrentImage(BufferedImage currentImage) {
        this.currentImage = currentImage;
    }

    //personal information

    public String getName () {
        return name;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public String getBirthMonth() {
        return birthMonth;
    }
}
