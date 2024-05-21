import java.util.ArrayList;

public class MayorVillager extends Villager {
    private int friendship;
    private ArrayList<String> intro;
    private ArrayList<String> day1;

    public MayorVillager(String catchphrase, int age, String birthMonth, int birthDate) {
        super(catchphrase, age, birthMonth, birthDate);
        this.friendship = 50;

        //intro list;
        intro = new ArrayList<>();
        day1 = new ArrayList<>();
        intro.add("Hello hello? Is this the newcomer speaking?");
        intro.add("Ah yes! Welcome! It is a pleasure to have you here.");
        intro.add("Thank you for purchasing the Tropical Vacation package.");
        intro.add("I am Micheal, your guide to a happy, peaceful, and tranquil start in a new community.");
        intro.add("...");
        intro.add("You don't... talk much do you?");
        intro.add("That's okay... you can trust me you know.");
        intro.add("Hm. How about you tell me your name? I'll have to start off somewhere, hah haa!"); //7
        intro.add("What a lovely name!");
        intro.add("I need to ask you a few more things... if you don't mind.");
        intro.add("I have to make your experience as a player more... lively, must I not? Hah haa!");
        intro.add("For the town we're going to decide on... it'll need a name, won't it now?");
        intro.add("Why don't you do the honors and come up with a lovely name for our little vacation town? Hah haa!"); //12
        intro.add("Lovely! Our town's name is now ");
        intro.add("I could never pick a better name! Hah haa!");
        intro.add("Oh! I almost forgot.");
        intro.add("How can I forget to ask about my client's beloved birthday!");
        intro.add("Why don't you tell me your birth month and year?");
        intro.add("I'll need it for documentation. Hah haa! Or whatnot."); //18

        intro.add("Oh wonderful! You're amazing, you know that? Hah haa.");//19
        intro.add("Enter your birth month. (e.g: May)"); //20
        intro.add("Enter your date. (Numbers only! e.g: 17)"); //21

        intro.add("W-what?... why not?"); //22
        intro.add("I... okay. That's fine."); //23
        intro.add("Well, now that all that's done, let's move on shall we?"); //24
        intro.add("Don't want to delay you on you vacation!");

        day1.add("Ah! There you are!");
        day1.add("I just couldn't wait for you to arrive! I was so excited! Hah haa!");
        day1.add("Why don't we get to business, hm? Gotta show you around the island!");
        day1.add("This is the grassy spot I've cleared for me, you, and all the friends we're gonna have!"); //3
        day1.add("I'll be placing my quarters along the top left. Your house will be nearby mine, hah haa."); //4
        day1.add("My house will probably look like this! I picked the design myself!"); //5
        day1.add("Which design would you like for your very own vacation home?"); //6
        day1.add("Sounds great! I can have both our houses done by tonight, hah haa!");
        day1.add("That's just a cliff."); //8
        day1.add("While we're here, lets go set up a campfire before the sun sets.");
        day1.add("Help me find some wood while I get some tents ready.");
    }

    public int getMichealIntroLength() {
        return intro.size();
    }

    public void decreaseFriendship(int num) {
        friendship -= num;
        if (friendship < 0) {
            friendship = 0;
        }
    }

    public void increaseFriendship(int num) {
        friendship += num;
        if (friendship > 100) {
            friendship = 100;
        }
    }

    public String getDialogue(int idx) {
        return intro.get(idx);
    }

    public String getDay1Dialogue(int idx) {
        return day1.get(idx);
    }
}