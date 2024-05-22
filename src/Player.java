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
    private final double MOVE_AMT = 0.2;
    private double xCoord;
    private double yCoord;
    private boolean facingRight;
    private boolean facingLeft;
    private boolean standing;

    private BufferedImage playerStand;
    private BufferedImage playerLeft;
    private BufferedImage playerRight;
    private BufferedImage currentImage;
    private BufferedImage playerHouse;


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
        standing = true;
        currentImage = playerStand;
    }

    //moving and images


    public void setPlayerHouse (String string) {
        try {
            playerHouse = ImageIO.read(new File(string));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public BufferedImage getPlayerHouse () {
        return playerHouse;
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
        }
    }

    public void moveRight() {
        if (xCoord + MOVE_AMT <= 900) {
            xCoord += MOVE_AMT;
        }
    }

    public void moveUp() {
        if (yCoord - MOVE_AMT >= 0) {
            yCoord -= MOVE_AMT;
        }
    }

    public void moveDown () {
        if (yCoord + MOVE_AMT <= 600) {
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
