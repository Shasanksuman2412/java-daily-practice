import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateTimeAPIDemo {
    public static void main(String[] args) {

        // ---- LocalDate: just a date, no time ----
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(2003, 5, 15); // year, month, day
        System.out.println("Today: " + today);
        System.out.println("Birthday: " + birthday);
        System.out.println("---");

        // ---- LocalTime and LocalDateTime ----
        LocalTime now = LocalTime.now();
        LocalDateTime meeting = LocalDateTime.of(2026, 8, 10, 14, 30);
        System.out.println("Current time: " + now);
        System.out.println("Meeting scheduled: " + meeting);
        System.out.println("---");

        // ---- Date arithmetic: immutable, returns a NEW object ----
        LocalDate nextWeek = today.plusDays(7);
        LocalDate lastMonth = today.minusMonths(1);
        LocalDate nextYear = today.plusYears(1);
        System.out.println("Today unchanged: " + today); // proves immutability
        System.out.println("Next week: " + nextWeek);
        System.out.println("Last month: " + lastMonth);
        System.out.println("Next year: " + nextYear);
        System.out.println("---");

        // ---- Comparing dates ----
        LocalDate date1 = LocalDate.of(2026, 1, 1);
        LocalDate date2 = LocalDate.of(2026, 6, 15);
        System.out.println("date1 before date2? " + date1.isBefore(date2));
        System.out.println("date1 after date2? " + date1.isAfter(date2));
        System.out.println("date1 equals date2? " + date1.isEqual(date2));
        System.out.println("---");

        // ---- Calculating the difference between dates ----
        Period period = Period.between(date1, date2);
        System.out.println("Difference: " + period.getMonths() + " months, " + period.getDays() + " days");
        System.out.println("---");

        // ---- Formatting dates ----
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formatted = today.format(formatter);
        System.out.println("Today formatted: " + formatted);
        System.out.println("---");

        // ---- Getting parts of a date ----
        System.out.println("Year: " + today.getYear());
        System.out.println("Month: " + today.getMonth());
        System.out.println("Day of week: " + today.getDayOfWeek());
        System.out.println("Day of month: " + today.getDayOfMonth());
    }
}
