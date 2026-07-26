public class ConditionalsDemo {
    public static void main(String[] args) {

        // ---- if / else if / else ----
        int marks = 72;
        if (marks >= 90) {
            System.out.println("Grade A");
        } else if (marks >= 75) {
            System.out.println("Grade B");
        } else if (marks >= 60) {
            System.out.println("Grade C");
        } else {
            System.out.println("Fail");
        }
        System.out.println("---");

        // ---- Nested conditionals ----
        int age = 20;
        boolean hasID = true;
        if (age >= 18) {
            if (hasID) {
                System.out.println("Entry allowed");
            } else {
                System.out.println("Need ID");
            }
        } else {
            System.out.println("Too young");
        }
        System.out.println("---");

        // ---- Ternary operator ----
        String result = (marks >= 40) ? "Pass" : "Fail";
        System.out.println("Result: " + result);
        System.out.println("---");

        // ---- switch statement ----
        int day = 3;
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
            default:
                System.out.println("Weekend or invalid day");
        }
        System.out.println("---");

        // ---- switch WITHOUT break (demonstrating fall-through) ----
        int number = 2;
        System.out.println("Fall-through demo for number = " + number + ":");
        switch (number) {
            case 1:
                System.out.println("one");
            case 2:
                System.out.println("two");
            case 3:
                System.out.println("three");
                break;
            case 4:
                System.out.println("four");
        }
        // Notice: prints "two" AND "three" because case 2 has no break,
        // so execution falls through into case 3 until it hits a break.
    }
}
