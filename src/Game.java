public class Game {
    private Town myTown;
    private MayorVillager MrMiller;
    private Player player;
    private Time myTime;

    public Game () {
        this.MrMiller = new MayorVillager("Hah haaa", 44, "May", 17);
        this.myTown = new Town("tbd");
    }

    public void wait(int seconds) {
        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public void wait2seconds() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public void waitASecond() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public void intro () {
        System.out.println("Hello hello! Is this the player speaking?...");
    }
}
