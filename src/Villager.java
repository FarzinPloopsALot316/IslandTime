import java.awt.*;
import java.awt.image.BufferedImage;

public class Villager {
    private String name;
    private String catchphrase;
    private int age;
    private int x;
    private int y;
    private BufferedImage house;

    public Villager (String name, String catchphrase, int age) {
        this.name = name;
        this.catchphrase = catchphrase;
        this.age = age;
    }

    public int getX() {
        return x;
    }

    public void setX (int coord) {
        x = coord;
    }

    public int getY() {
        return y;
    }

    public void setY (int coord) {
        y = coord;
    }

    public BufferedImage getHouse () {
        return house;
    }

    public void setHouse (BufferedImage newHouse) {
        house = newHouse;
    }

    public String getName() {
        return name;
    }

    public Rectangle VillagerRect() {
        int imageHeight = 211;
        int imageWidth = 175;
        Rectangle rect = new Rectangle((int) x, (int) y, imageWidth, imageHeight);
        return rect;
    }

    public String getCatchphrase () {
        return catchphrase;
    }

    public int getAge() {
        return age;
    }
}
