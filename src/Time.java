public class Time {
    private String month;
    private int day;
    private String time;
    private String weekday;
    private String weather;

    public Time () {
        day = (int) (Math.random() * 31) + 1;
        int monthChance = (int) (Math.random() * 12) + 1;
        if (monthChance == 1) {
            month = "January";
        } else if (monthChance == 2) {
            month = "February";
        } else if (monthChance == 3) {
            month = "March";
        } else if (monthChance == 4) {
            month = "April";
        } else if (monthChance == 5) {
            month = "May";
        } else if (monthChance == 6) {
            month = "June";
        } else if (monthChance == 7) {
            month = "July";
        } else if (monthChance == 8) {
            month = "August";
        } else if (monthChance == 9) {
            month = "September";
        } else if (monthChance == 10) {
            month = "October";
        } else if (monthChance == 11) {
            month = "November";
        } else if (monthChance == 12) {
            month = "December";
        }

        time = "Morning";

        int dayChance = (int) (Math.random() * 7) + 1;

        if (dayChance == 1) {
            weekday = "Monday";
        } else if (dayChance == 2) {
            weekday = "Tuesday";
        } else if (dayChance == 3) {
            weekday = "Wednesday";
        } else if (dayChance == 4) {
            weekday = "Thursday";
        } else if (dayChance == 5) {
            weekday = "Friday";
        } else if (dayChance == 6) {
            weekday = "Saturday";
        } else if (dayChance == 7) {
            weekday = "Sunday";
        }

        if (month.equals("December") || month.equals("January")) {
            int weatherChance = (int) (Math.random() * 3) + 1;
            if (weatherChance == 1) {
                weather = "Sunny";
            }
            if (weatherChance == 2) {
                weather = "Rainy";
            }
            if (weatherChance == 3) {
                weather = "Snowy";
            }
        } else {
            int weatherChance = (int) (Math.random() * 2) + 1;
            if (weatherChance == 1) {
                weather = "Sunny";
            }
            if (weatherChance == 2) {
                weather = "Rainy";
            }
        }
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
