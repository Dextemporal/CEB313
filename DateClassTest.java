public class DateClassTest{
    public static void main(String[] args) {
        DateClass date1 = new DateClass(6, 14, 1992);
        System.out.println("Date1 (MM/DD/YYYY): " + date1.toString());
        System.out.println("Date1 (Month DD, YYYY): " + date1.toStringLong());
        System.out.println("Date1 (DDD YYYY): " + date1.toStringDayOfYear());

        DateClass date2 = new DateClass("June", 14, 1992);
        System.out.println("\nDate2 (MM/DD/YYYY): " + date2.toString());
        System.out.println("Date2 (Month DD, YYYY): " + date2.toStringLong());
        System.out.println("Date2 (DDD YYYY): " + date2.toStringDayOfYear());

        DateClass date3 = new DateClass(165, 1992);
        System.out.println("\nDate3 (MM/DD/YYYY): " + date3.toString());
        System.out.println("Date3 (Month DD, YYYY): " + date3.toStringLong());
        System.out.println("Date3 (DDD YYYY): " + date3.toStringDayOfYear());
    }
}


