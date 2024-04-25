public class Time {
    private String month;
    private int day;
    private int year;
    private String time;
    private String weekday;
    private String weather;

    public Time (String month, int day, int year, String time, String weekday, String weather) {
        this.day = day;
        this.month = month;
        this.year = year;
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

    public int getYear() {
        return year;
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
