//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MayorVillager MrMiller = new MayorVillager("Hah haa", 44, "May", 17);
        Town hoesInMyHood = new Town("the fire hood", 5);
        Time time = new Time("May", 17, 2024, "morning", "Tuesday", "rainy");
        MrMiller.announcement(time, hoesInMyHood);
    }
}