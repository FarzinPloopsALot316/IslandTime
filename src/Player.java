public class Player {
    private String name;
    private String birthMonth;
    private int birthDate;
    private String location;
    private boolean locationSetting;

    public Player(String name, String birthMonth, int birthDate, String location) {
        this.name = name;
        this.birthMonth = birthMonth;
        this.birthDate = birthDate;
        this.location = location;
        this.locationSetting = false;
    }

    public void setOn () {
        locationSetting = true;
        System.out.println(ConsoleUtility.RED + "YOUR LOCATION HAS BEEN TURNED ON." + ConsoleUtility.CYAN);
    }

    public void setOff () {
        locationSetting = false;
        System.out.println("Your location has been turned OFF.");
    }
}
