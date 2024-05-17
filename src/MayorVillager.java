import java.util.ArrayList;

public class MayorVillager extends Villager {
    private int friendship;
    private ArrayList<String> intro;

    public MayorVillager (String catchphrase, int age, String birthMonth, int birthDate) {
        super(catchphrase, age, birthMonth, birthDate);
        this.friendship = 50;

        //intro list;
        intro = new ArrayList<>();
        intro.add("Hello hello? Is this the newcomer speaking?");
        intro.add("Ah yes! Welcome! It is a pleasure to have you here.");
        intro.add("Thank you for purchasing the Tropical Vacation package.");
        intro.add("I am Micheal, your guide to a happy, peaceful, and tranquil start in a new community.");
        intro.add("...");
        intro.add("You don't... talk much do you?");
        intro.add("That's okay... you can trust me you know.");
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
