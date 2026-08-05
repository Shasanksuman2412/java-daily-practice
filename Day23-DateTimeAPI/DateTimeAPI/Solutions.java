import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Solutions {

    // ---- Exercise 3: Is it a weekend? ----
    static boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }

    public static void main(String[] args) {

        // ---- Exercise 1: Age calculator ----
        LocalDate birthDate = LocalDate.of(2000, 3, 20);
        Period agePeriod = Period.between(birthDate, LocalDate.now());
        System.out.println("You are " + agePeriod.getYears() + " years old");
        System.out.println("---");

        // ---- Exercise 2: Days until a future event ----
        LocalDate eventDate = LocalDate.of(2026, 12, 25);
        long daysUntil = ChronoUnit.DAYS.between(LocalDate.now(), eventDate);
        System.out.println("Days until Christmas 2026: " + daysUntil);
        System.out.println("---");

        // ---- Exercise 3: Is it a weekend? ----
        System.out.println("Is today a weekend? " + isWeekend(LocalDate.now()));
        LocalDate knownSaturday = LocalDate.of(2026, 8, 8); // confirmed Saturday
        System.out.println("Is " + knownSaturday + " a weekend? " + isWeekend(knownSaturday));
        System.out.println("---");

        // ---- Exercise 4: Format a date multiple ways ----
        LocalDate date = LocalDate.of(2026, 8, 5);
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("EEEE");

        System.out.println("Format 1: " + date.format(fmt1));
        System.out.println("Format 2: " + date.format(fmt2));
        System.out.println("Format 3: " + date.format(fmt3));
        System.out.println("---");

        // ---- Exercise 5: Countdown with days, months, AND years ----
        LocalDate start = LocalDate.of(2020, 1, 1);
        LocalDate end = LocalDate.of(2026, 8, 5);
        Period fullPeriod = Period.between(start, end);
        System.out.println(fullPeriod.getYears() + " years, " +
                fullPeriod.getMonths() + " months, " +
                fullPeriod.getDays() + " days");
    }
}
