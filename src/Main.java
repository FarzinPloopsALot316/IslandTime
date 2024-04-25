public class Main {
    public static void main(String[] args) {
        MayorVillager MrMiller = new MayorVillager("Hah haa", 44, "May", 17);
        Town hoesInMyHood = new Town("hoes in my hood");
        Time time = new Time("May", 17, 2024, "morning", "Tuesday", "rainy");
        MrMiller.announcement(time, hoesInMyHood);
    }
}