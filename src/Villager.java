public class Villager {
    private String catchphrase;
    private int age;
    private String birthMonth;
    private int birthDate;

    public Villager (String catchphrase, int age, String birthMonth, int birthDate) {
        this.catchphrase = catchphrase;
        this.age = age;
        this.birthMonth = birthMonth;
        this.birthDate = birthDate;
    }

    public String getCatchphrase () {
        return catchphrase;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        return age;
    }

    public String getBirthMonth () {
        return birthMonth;
    }
}
