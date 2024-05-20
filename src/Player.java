import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Player {
    private String playerHouse;
    private String name;
    private String birthMonth;
    private int birthDate;
    private final double MOVE_AMT = 0.2;
    private double xCoord;
    private double yCoord;

    public Player(String name, String birthMonth, int birthDate) {
        this.name = name;
        this.birthMonth = birthMonth;
        this.birthDate = birthDate;
        xCoord = 300;
        yCoord = 300;
        playerHouse = "src/MayorHome.png";
    }

    public void moveRight() {
        if (xCoord + MOVE_AMT <= 900) {
            xCoord += MOVE_AMT;
        }
    }

    public void setPlayerHouse (String string) {
        playerHouse = string;
    }

    public void moveLeft() {
        if (xCoord - MOVE_AMT >= 0) {
            xCoord -= MOVE_AMT;
        }
    }

    public void moveUp() {
        if (yCoord + MOVE_AMT <= 600) {
            yCoord += MOVE_AMT;
        }
    }

    public void moveDown () {
        if (yCoord - MOVE_AMT >= 0) {
            yCoord -= MOVE_AMT;
        }
    }

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
