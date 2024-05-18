public class Player {
    private String name;
    private String birthMonth;
    private int birthDate;

    public Player(String name, String birthMonth, int birthDate) {
        this.name = name;
        this.birthMonth = birthMonth;
        this.birthDate = birthDate;
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
