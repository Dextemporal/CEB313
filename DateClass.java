import java.time.LocalDate;

public class DateClass {
    private int month;
    private int day;
    private int year;

    // Constructor with three integer values (MM, DD, YYYY)
    public DateClass(int month, int day, int year) {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    // Constructor with a String and two integer values (Month, DD, YYYY)
    public DateClass(String month, int day, int year) {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    // Constructor with two integer values (DDD, YYYY)
    public DateClass(int dayOfYear, int year) {
        LocalDate localDate = LocalDate.ofYearDay(year, dayOfYear);
        setMonth(localDate.getMonthValue());
        setDay(localDate.getDayOfMonth());
        setYear(localDate.getYear());
    }

    // Setter method for month
    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month. Month must be between 1 and 12.");
        }
        this.month = month;
    }

    // Setter method for month (String)
    public void setMonth(String month) {
        switch (month.toLowerCase()) {
            case "january":
                this.month = 1;
                break;
            case "february":
                this.month = 2;
                break;
            case "march":
                this.month = 3;
                break;
            case "april":
                this.month = 4;
                break;
            case "may":
                this.month = 5;
                break;
            case "june":
                this.month = 6;
                break;
            case "july":
                this.month = 7;
                break;
            case "august":
                this.month = 8;
                break;
            case "september":
                this.month = 9;
                break;
            case "october":
                this.month = 10;
                break;
            case "november":
                this.month = 11;
                break;
            case "december":
                this.month = 12;
                break;
            default:
                throw new IllegalArgumentException("Invalid month. Month must be a valid month name.");
        }
    }

    // Setter method for day
    public void setDay(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Invalid day. Day must be between 1 and 31.");
        }
        this.day = day;
    }

    // Setter method for year
    public void setYear(int year) {
        this.year = year;
    }

    // Method to output the date in the format MM/DD/YYYY
    public String toString() {
        return String.format("%02d/%02d/%04d", month, day, year);
    }

    // Method to output the date in the format Month DD, YYYY
    public String toStringLong() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return String.format("%s %02d, %04d", months[month - 1], day, year);
    }

    // Method to output the date in the format DDD YYYY
    public String toStringDayOfYear() {
        LocalDate localDate = LocalDate.of(year, month, day);
        return String.format("%03d %04d", localDate.getDayOfYear(), year);
    }
}

