public class Town {
    private String name;
    private int villagerNumbers;

    public Town (String name) {
        this.name = name;
        this.villagerNumbers = 5;
    }

    public String getName() {
        return name;
    }

    public int getVillagerNumbers() {
        return villagerNumbers;
    }

}