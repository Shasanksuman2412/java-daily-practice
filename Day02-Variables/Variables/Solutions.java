public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1: Declare and print ----
        String name = "Shasank";
        int age = 21;
        double height = 1.75;
        boolean likesJava = true;
        System.out.println(name + " is " + age + " years old, " + height
                + "m tall, and likes Java: " + likesJava);
        System.out.println("---");

        // ---- Exercise 2: Simple Interest Calculator ----
        double principal = 10000;
        double rate = 7.5;
        int time = 3;
        double simpleInterest = (principal * rate * time) / 100;
        System.out.println("Simple Interest: " + simpleInterest);
        System.out.println("---");

        // ---- Exercise 3: Celsius to Fahrenheit ----
        double celsius = 37.0;
        // 9.0/5 forces floating point division instead of integer division
        double fahrenheit = (celsius * 9.0 / 5) + 32;
        System.out.println(celsius + "C is " + fahrenheit + "F");
        System.out.println("---");

        // ---- Exercise 4: Swap without a third variable ----
        int a = 5;
        int b = 10;
        System.out.println("Before swap -> a: " + a + ", b: " + b);
        a = a + b;   // a now holds sum of both
        b = a - b;   // b becomes original a
        a = a - b;   // a becomes original b
        System.out.println("After swap  -> a: " + a + ", b: " + b);
        System.out.println("---");

        // ---- Exercise 5: Narrowing cast prediction ----
        double d1 = 9.99;
        double d2 = -9.99;
        char c = 65;         // 65 is the ASCII/Unicode value for 'A'
        int i = 'Z';         // 'Z' has Unicode value 90

        System.out.println((int) d1); // 9  (decimal truncated, not rounded)
        System.out.println((int) d2); // -9 (truncates toward zero, not -10)
        System.out.println(c);        // A
        System.out.println(i);        // 90
    }
}
