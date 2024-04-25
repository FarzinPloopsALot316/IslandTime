public class Town {
    private String name;
    private int villagerNumbers;

    public Town (String name, int villagerNumbers) {
        this.name = name;
        this.villagerNumbers = villagerNumbers;
    }

    public String getName() {
        return name;
    }

    public int getVillagerNumbers() {
        return villagerNumbers;
    }

}