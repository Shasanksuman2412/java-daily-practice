public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1: Leap Year Checker ----
        int year = 2024;
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            System.out.println(year + " is a Leap year");
        } else {
            System.out.println(year + " is Not a leap year");
        }
        System.out.println("---");

        // ---- Exercise 2: Largest of Three Numbers ----
        int a = 45, b = 89, c = 67;
        int largest;
        if (a >= b && a >= c) {
            largest = a;
        } else if (b >= a && b >= c) {
            largest = b;
        } else {
            largest = c;
        }
        System.out.println("Largest: " + largest);
        System.out.println("---");

        // ---- Exercise 3: Simple Grading System ----
        int marks = 68;
        char grade;
        if (marks >= 90) {
            grade = 'A';
        } else if (marks >= 75) {
            grade = 'B';
        } else if (marks >= 60) {
            grade = 'C';
        } else if (marks >= 40) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("Grade: " + grade);
        System.out.println("---");

        // ---- Exercise 4: Day Name using switch ----
        int day = 6;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
            case 7:
                // no break between 6 and 7 on purpose:
                // both Saturday and Sunday fall through to the same message
                System.out.println("Weekend!");
                break;
            default:
                System.out.println("Invalid day");
        }
        System.out.println("---");

        // ---- Exercise 5: Predict the output (dangling else) ----
        int x = 10;
        // Even though it's indented to LOOK like the else belongs to
        // "if (x > 5)", Java actually attaches an else to the NEAREST
        // unmatched if - which is "if (x > 20)".
        // So: x > 5 is true -> enter outer if
        //     x > 20 is false -> its else runs -> prints "B"
        if (x > 5)
            if (x > 20)
                System.out.println("A");
            else
                System.out.println("B"); // this runs
        else
            System.out.println("C");
        // Output: B
        // Lesson: always use { } braces to make the intended pairing explicit,
        // regardless of indentation.
    }
}
