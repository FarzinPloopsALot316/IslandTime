import java.awt.image.BufferedImage;

public class Villager {
    private String name;
    private String catchphrase;
    private int age;
    private BufferedImage house;

    public Villager (String name, String catchphrase, int age) {
        this.name = name;
        this.catchphrase = catchphrase;
        this.age = age;
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

    public String getCatchphrase () {
        return catchphrase;
    }

    public int getAge() {
        return age;
    }
}
