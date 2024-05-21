import java.util.ArrayList;

public class MayorVillager extends Villager {
    private int friendship;
    private ArrayList<String> intro;
    private ArrayList<String> day1;

    public MayorVillager (String catchphrase, int age, String birthMonth, int birthDate) {
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

    }

    public int getMichealIntroLength() {
        return intro.size();
    }

    public void decreaseFriendship (int num) {
        friendship -= num;
        if (friendship < 0) {
            friendship = 0;
        }
    }

    public void increaseFriendship (int num) {
        friendship += num;
        if (friendship > 100) {
            friendship = 100;
        }
    }

    public String getDialogue(int idx) {
        return intro.get(idx);
    }

    public String getDay1Dialogue (int idx) {
        return day1.get(idx);
    }

    public void announcement(Time currentTime, Town village) {
        int greeting = (int) (Math.random() * 10) + 1;
        if (greeting == 1) {
            System.out.println("Good " + currentTime.getTime() + ", fellow villagers of " + village.getName() + ".");
        }
        if (greeting == 2) {
            System.out.println("Hello everybody!");
        }
        if (greeting == 3) {
            System.out.println("Heyyyyyyyyy!");
        }
        if (greeting == 4) {
            System.out.println("Good " + currentTime.getTime() + "!");
        }
        if (greeting == 5) {
            System.out.println("Hey everyone!");
        }
        if (greeting == 6) {
            System.out.println("Happy " + currentTime.getWeekday() + ", everybody!");
        }
        if (greeting == 7) {
            System.out.println("Good " + currentTime.getTime() + ", " + village.getName());
        }
        if (greeting == 8) {
            System.out.println("Ḩ̵̤̤̭̟̫̣͎̦͈͕̩̹͎͉̝̄̔͜͝ȩ̷̨͕̝͖̫̰̼̘̮͚͙̙̩̉̍́̾̈́ľ̵̨͉̬̰̩͍̜̞̇̈́̆̇̌̐͒ľ̵̡̧̯͚̬̦͎̼̟̬̘̖͔̰̹̈́̓̏̓̈́̑̑̀̊́̇̾͘͜͝͠ͅǫ̸̥̣̼͈̭̻͍͌̀̃̀́̓͑̆̾̉̆͂̀,̴̧̧̛͈̣̭̜͕̙̝͓̩̠̘̊́̈́̀̈́̆́̆̏̓̕͝͠ ̶͍͓̖͎͇̞̭͇̺̬̿͒̊̈̃̀̇̐̅̃̏̕͜͜͝ͅv̵̨̢̳͍̮̭̮͎̰̘̥̘͊̀͐̔̽̾̌̌̄̄͑̽̀͠i̷̛̩̰̭̖͒̎̊̃͊̍́̃̔̚̕͝l̵̪̹͇͓̖̹̬̰̫̰͖̽l̶̢̦̺͕͕̼̠̹̱̹̦̘̲͊͐̎͌͆̒a̶̝͔̗̟̪̥̤̳̹̹̥͔͚͕͔͆͋̀̕͘͘g̶͕̬̲͈̟̞̳̻̲̝̏́e̷̢͖̰̘̰̝̫̥̱͇̰̤̽̓̐͊͆͂̏̌̔͛̕̚̚r̸̭̝͇͉͑͂́s̸̢̛͙̀̅̿̅́̆̋̂̀̎̎͒̚̕͘!̸̼͎̭̩̗͕̼͎͓͇̥̰͈̪̪͎̅̅͠ͅ");
        }
        if (greeting == 9) {
            System.out.println("?̵̲͋̉̌̓́̅̚?̸̳͒̑̿̈͌̒͂͠?̶̨̳̘͇̣͎̘̝͙͚͓̳̬̦̹̉̂̈́?̵̛͚̏̔̒̈́̊̽͊́̅͐͝?̶͈̥̻̦̫͕͈̖͔̑̅̌͆̓͑͐̕?̷̛̛̮̲͒͊̾̑̓̄̽́̆̇̌̈́͝?̴̨̛̘͍̻̼̤̼̪̌͊́̏̀͒̏́̀̊̇̿͊͜͠ͅ?̵̢̨̰̣̺͍͉̺̦̆̊̅͊̒͑̈́̓͊̽͘̚͘͝?̴̢̭̖͚͈̹̪͛͆̉̅̏́́͂̚̕͝͠͝?̴̡̧̼̻͍̮̝͇̟̙͊̃̉̅͌͒̿̈͘?̴͚̱̬̈́̈́̾̓̎̎̇̄͘̕͝?̴̨̘͙̜̖̭̼̱̠̖̱̳̯̀̌͋̀̓͛̍̉̄̑̚?̷̡̨̣̮̹̫̜͓͔̬͍̥̜̀ͅ?̵͙̮͍̥̩̺̹̦͖͓̦̩̫̙̣̏̑̏?̸̩͚͉̙͕̺͉̣̺̥̜͛̿͊̆̂̚̕͝?̴̡̼̠̗̞̻̍̾̆̽͆̇̃̊̿̓͗͘͝?̶̟̹͇̼̮͖̤̦̗̤̗͕̩͌͌͑͛̅̈̒͘ͅ?̷̯̾̄̓?̸̛̛̛̛̬̼͓͉́̔̀̎̋̃͠͝͠?̸̛̛̠͑̏͋̅̓͗̈́̚͝͝͝?̵̛̛̲͕̱̱͓̳͙̖́͗̋̇̅͑͋̆̔̋̚̚͘̕͠?̸̨͖͔̯̮͛̒̿̊̋̽̎͗͋́̚͘͠?̶̨̝̖̬̱̻͚̳͍̤̖̈́̊͌̍͝?̸̡̙̗̙̬͍͍̱̠̯̙̞̅͗͆̾͌̓̀̉̈́̚?̸̧̡̨͚̫̯̼̱̗̜̙̼͉̤̥̝̞̌̒̀͆̂̀̄́͐̚?̸̼̗̭̲̻̙̖͚̅͐̎̔́̓̚͝ͅ?̶̡̛̛͓͓̪̭̘͓̀̏͗̌̉̋̿̂̐́̈̇̕͝?̷̨̣̲̗̰̟̝̦̦͔̭̲͕̏̒̄̎͐̉̈́͂́͜ͅ?̷̛̹͖̙̭̮̦̘͉͎̫͚̠̹̳̗̰̰̔͊͋̏͛͒̈́͝?̷̨̦̯̠͕̙̖͔̰̠͎̘͉͎̗͈̏͊͆̊̽̚͝?̴̡̬̞̬̺̉̽͛̊̍̄̊̋͌̇́̋̓̚͝?̸̫̦͍͉̯̖͐̓́̋͛?̵̧̛͉̠̯̹̞̙͎̭̱̭̺̈́̏̓͂̇̽́̊̌͛̚̚͜͜?̷͕̯̝͔̦̠̪͇͍̩̹̖̫̦͂̓̃̅͒̏̓̿́͑̕͝͝?̶̛̛̘̲͔̱͕͚̲̽̑̓̋̈͐͐͒̄̿̋̊́̍͘?̶̨͙̪̰̝̲̻̞͆̏̾͊͛̈̇̇̍͜͝͝ͅ?̸̢̢̡̨̛̛̪͖͇͚̼̳͈͚̟̪͍͗̃́͒̑͒̎͆͑̌͘͠͝͝ͅ?̶͔̟̩̘͊͆̄̀͐̄͌̇̌̾́̋̅͂̕̚?̵̢̰̠̭͇̯̞̝̫̮̝̦̩̦͓͇͋̀͗͐̀̅̈̒̃͌̑͜?̵̡͍͓͉̠̞̪͍̯̯̱̣͒?̶̩͕̈́̔̔͂͆͠ͅ?̷̡̰͖͚̰͕̰̹̹̻̲̮͔̻͌̃͛̓̌̆̾̿͆̓̅͠?̴̻̇?̵̢̦̳͓͔̈̏̍́͑̀͐̍̂̒̈́͐̋̕̕͠͝ͅ?̴̨̧̛͓̣̥̠̘̞̬̹̩͚̈́̎̌͒̅͒̆́̒̏̅̚̚͝?̶̡̨̧̛̪̜̹̘̇̇̿̋͛̉͂̒̏̏̽̽̊͠?̵͗͛̂̐̂̎͊̑̀̕?̶̢͙͎̜̮͂̒͋͋̈̽͆͊́͑̋͊̉́͑̚͠?̵̢̩͈̯̘̭̺͎̰̥̒̽̊̄͆̇̃ͅ?̸͍̠̐̑͊͌͒̒̋͆͘͠?̸̜̜̣̲̥̩̿̊͂̽͒́́̎?̴̱͆̌̀͘?̸̠͑?̸͍̬̙͙̘̲͓͛̈́̃̀̃̆͊̇̇͗̈́̑͝?̶̧͕̮͕͍̜͓͚̤͍̲̔̓͐̅̔̋̑́͂̚͜͠?̷̨̩͉̹͎̥̻͇̠͈̝̤͙̬̪̉̀͋͛͜?̴̥̠̮͓̫̟̳̼͔̘̳̮͍͎̩̓͗̈̏͌͜ͅ?̶̨̢͉̳͕̖̻̹͚̰̦͇̃̂̃̃̓?̴̖̙́̑?̷̛̜͖͎̍̍̉͜?̵̻̹̞͈̓́̀̂̕ͅ?̸̡̪̩͖̲̝̦̤̩̗̹̠̼̞͊̿̇?̶͇̳̱̞͔̤̔?̴̡̛͉͓͖̱̮̝̯͓̱͎̲͕̀͐̆̒̋͌͋̆́͜ͅ?̷̢̘̌̾̀͋̕͠?̸̧̧͔̣̠̟̩̖̯͉͍̗̆̎͂̕͜");
        }
        if (greeting == 10) {
            System.out.println("I hate you all, and I couldn't give less of a shit about your lives, but here I am.");
        }
        System.out.println("Today is " + currentTime.getMonth() + " " + currentTime.getDay() + "!");
        if (currentTime.getWeather().equals("rainy")) {
            System.out.println("It sure is a rainy " + currentTime.getWeekday() + "!");
            System.out.println("Be sure to bring an umbrella outside! We don't want our friends to catch a cold now, do we? " + getCatchphrase() + "!");
        }
        if (currentTime.getWeather().equals("sunny")) {
            System.out.println("What lovely skies we have on this beautiful sunny " + currentTime.getWeekday() + "!");
            System.out.println("Head outside, smell the grass, and frolick in the flowers! Get some fresh air, " + getCatchphrase().toLowerCase() + "!");
        }
        if (currentTime.getWeather().equals("snowy")) {
            System.out.println("Wow! It's a lovely snowy " + currentTime.getWeekday() + ", and boy oh boy do I feel the spirit of winter!");
            System.out.println("The world is covered in a blanket of tranquility, the skies are freckled with a white sprinkle... it's so admirable.");
            System.out.println("A perfect day to play in the snow and make snow angels and throw snowballs, " + getCatchphrase().toLowerCase() + "!");
        }
    }

}
