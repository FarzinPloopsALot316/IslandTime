import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Game {
    private Town myTown;
    private MayorVillager MrMiller;
    private Player player;
    private Time myTime;

    public Game () {
        this.MrMiller = new MayorVillager("Hah haaa", 44, "May", 17);
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
        Scanner scan = new Scanner(System.in);
        String userString = "";
        int userInt = 0;
        ConsoleUtility.clearScreen();
        waitASecond();
        System.out.println(ConsoleUtility.PURPLE + "Hello hello! Is this the client speaking?...");
        wait2seconds();
        System.out.println(ConsoleUtility.CYAN + "Oh yes! You were the one that ordered an island getaway.");
        wait2seconds();
        System.out.println("""
                Greetings! I am Mr Miller, your guide to your new tropical life!
                Before we begin, I must clarify some information about you and the preferences of your island.
                """);
        System.out.println();
        wait2seconds();
        System.out.println("Why don't we get to know you a bit better, hm?");
        wait(4);
        System.out.println("You seem to be hesitant. Don't worry, you can trust me. I'm real.");
        waitASecond();
        System.out.println(ConsoleUtility.CYAN + "To begin, what is your name? Your real name is most preferred!");
        String playerName = scan.nextLine();
        System.out.println();
        System.out.println("Cool! Nice to meet you, " + playerName + ".");
        waitASecond();
        System.out.println("How about your birthday? How lovely it would be to celebrate my client on their special day, " + MrMiller.getCatchphrase() + "!");
        waitASecond();
        System.out.println("Please enter your birth month.");
        String playerMonth = scan.nextLine();
        System.out.println();
        System.out.println("(NUMBER ONLY!!) Enter only the number of your birthday.");
        int playerDate = scan.nextInt();
        waitASecond();
        System.out.println();
        System.out.println("Excellent! Now, for your island...");
        wait2seconds();
        System.out.println("What name would you like for your island?");
        System.out.println("Please note this information cannot be changed later, so name wisely.");
        scan.nextLine();
        String townName = scan.nextLine();
        myTown = new Town(townName);
        System.out.println();
        System.out.println("Okay, " + playerName + "! You will be the new owner of your island, " + townName + ".");
        wait(3);
        ConsoleUtility.clearScreen();
        System.out.println("Now, for some final confirmations!");
        waitASecond();
        System.out.println("How about you tell me your time and location?");
        System.out.println("It'll help me make your gameplay more precise.");
        wait2seconds();
        System.out.println("""
                
                1. I'm sorry, I can't do that.
                2. Sure, that's alright.
                """);
        userInt = scan.nextInt();
        scan.nextLine();
        if (userInt == 1) {
            MrMiller.decreaseFriendship(5);
            String location = "unknown";
            player = new Player(playerName, playerMonth, playerDate, location);
            waitASecond();
            ConsoleUtility.clearScreen();
            System.out.println(ConsoleUtility.RED + "What?..." + ConsoleUtility.CYAN);
            wait2seconds();
            System.out.println("Okay, so no? That's fine. Totes okay. I understand.");
            wait2seconds();
            System.out.println("But I still need to know your current time and weather.");
            waitASecond();
            System.out.println("Can you... at least give me that information?");
            System.out.println("""
                
                1. Yes.
                2. Okay.
                """);
            scan.nextLine();
            System.out.println();
        } else {
            MrMiller.increaseFriendship(5);
            waitASecond();
            System.out.println();
            System.out.println(ConsoleUtility.BLUE + "How kind of you." + ConsoleUtility.CYAN);
           wait(3);
            System.out.println("Okay! Tell me where you are right now. Perhaps a specific address or place. Maybe even your coordinates.");
            wait2seconds();
            System.out.println("Well, you know what? Place is fine. Tell me your current address and place.");
            String location = scan.nextLine();
            player = new Player(playerName, playerMonth, playerDate, location);
        }
        System.out.println("Cool! Enter the current weekday.");
        String currentDay = scan.nextLine();
        System.out.println("Current month?");
        String currentMonth = scan.nextLine();
        System.out.println("Current year?");
    }
}
