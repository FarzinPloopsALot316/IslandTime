public class Villager {
    private String name;
    private String catchphrase;
    private int age;

    public Villager (String name, String catchphrase, int age) {
        this.name = name;
        this.catchphrase = catchphrase;
        this.age = age;
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
