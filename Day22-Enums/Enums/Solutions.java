public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1: Traffic light enum ----
        System.out.println("Traffic light actions:");
        for (TrafficLight light : TrafficLight.values()) {
            System.out.println(light + " -> " + light.action());
        }
        System.out.println("---");

        // ---- Exercise 2: Season with field and method ----
        System.out.println("Seasons and warmth:");
        for (Season s : Season.values()) {
            System.out.println(s + ": " + s.getAvgTemperature() + "C, warm? " + s.isWarm());
        }
        System.out.println("---");

        // ---- Exercise 3: Enum implementing an interface, per-constant behavior ----
        System.out.println("Season descriptions:");
        for (Season s : Season.values()) {
            System.out.println(s + ": " + s.describe());
        }
        System.out.println("---");

        // ---- Exercise 4: next() cycling through TrafficLight ----
        TrafficLight current = TrafficLight.RED;
        System.out.println("Cycling through traffic light states:");
        for (int i = 0; i < 5; i++) { // go around the cycle more than once
            System.out.println(current);
            current = current.next();
        }
        System.out.println("---");

        // ---- Exercise 5: OrderStatus state machine ----
        System.out.println("PLACED -> SHIPPED valid? " + OrderStatus.PLACED.canTransitionTo(OrderStatus.SHIPPED));
        System.out.println("PLACED -> DELIVERED valid? " + OrderStatus.PLACED.canTransitionTo(OrderStatus.DELIVERED));
        System.out.println("SHIPPED -> DELIVERED valid? " + OrderStatus.SHIPPED.canTransitionTo(OrderStatus.DELIVERED));
        System.out.println("DELIVERED -> PLACED valid? " + OrderStatus.DELIVERED.canTransitionTo(OrderStatus.PLACED));
        System.out.println("CANCELLED -> SHIPPED valid? " + OrderStatus.CANCELLED.canTransitionTo(OrderStatus.SHIPPED));
    }
}
