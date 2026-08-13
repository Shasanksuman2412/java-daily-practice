public class Solutions {

    // ---- Exercise 2: exhaustive switch over sealed Vehicle, no default ----
    static String describeVehicle(Vehicle v) {
        return switch (v) {
            case Car c -> "Car with " + c.wheelCount() + " wheels";
            case Motorcycle m -> "Motorcycle with " + m.wheelCount() + " wheels";
            case Truck t -> "Truck with " + t.wheelCount() + " wheels";
            // no default needed - Vehicle is sealed with exactly these 3 permitted types
        };
    }

    // ---- Exercise 5: recursive evaluator over the sealed Expr hierarchy ----
    static double evaluate(Expr e) {
        return switch (e) {
            case Number n -> n.value();
            case Add a -> evaluate(a.left()) + evaluate(a.right());       // recurse into both sides
            case Multiply m -> evaluate(m.left()) * evaluate(m.right()); // recurse into both sides
            // no default needed - Expr is sealed with exactly these 3 permitted types
        };
    }

    public static void main(String[] args) {

        // ---- Exercise 1 ----
        Vehicle[] vehicles = { new Car(), new Motorcycle(), new Truck() };
        for (Vehicle v : vehicles) {
            System.out.println(v.getClass().getSimpleName() + " wheel count: " + v.wheelCount());
        }
        System.out.println("---");

        // ---- Exercise 2 ----
        for (Vehicle v : vehicles) {
            System.out.println(describeVehicle(v));
        }
        System.out.println("---");

        // ---- Exercise 3 is a conceptual/manual exercise - see notes in Practice.md ----
        System.out.println("Exercise 3: try removing 'sealed' from Vehicle.java yourself");
        System.out.println("and see describeVehicle() fail to compile without a default case.");
        System.out.println("---");

        // ---- Exercise 4 ----
        Employee manager = new Manager();
        Employee contractor = new Contractor();
        Employee remoteContractor = new RemoteContractor(); // proves non-sealed reopening works

        System.out.println(manager.role());
        System.out.println(contractor.role());
        System.out.println(remoteContractor.role());
        System.out.println("---");

        // ---- Exercise 5: evaluate 3 + (4 * 5) = 23 ----
        Expr expression = new Add(new Number(3), new Multiply(new Number(4), new Number(5)));
        System.out.println("Expression evaluates to: " + evaluate(expression));
    }
}
