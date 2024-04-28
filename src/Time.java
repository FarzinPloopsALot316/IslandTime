public class Time {
    private String month;
    private int day;
    private String time;
    private String weekday;
    private String weather;

    public Time (String month, int day, String time, String weekday, String weather) {
        this.day = day;
        this.month = month;
        this.time = time;
        this.weekday = weekday;
        this.weather = weather;
    }

    public int getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getTime() {
        return time;
    }

    public String getWeekday() {
        return weekday;
    }

    public String getWeather() {
        return weather;
    }
}
