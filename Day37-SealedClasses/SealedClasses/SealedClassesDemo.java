public class SealedClassesDemo {

    // ---- Exhaustive pattern matching: NO default needed! ----
    // The compiler KNOWS Circle, Square, and Triangle are the ONLY possible
    // subclasses of Shape, since Shape is sealed with an explicit permits list.
    static String describeShape(Shape s) {
        return switch (s) {
            case Circle c -> "Circle with radius " + c.getRadius() + ", area " + c.area();
            case Square sq -> "Square with side " + sq.getSide() + ", area " + sq.area();
            case Triangle t -> "Triangle with base " + t.getBase() + ", area " + t.area();
            // no default case - the compiler VERIFIES this switch is exhaustive
        };
    }

    // ---- Exhaustive pattern matching on the sealed PaymentMethod interface ----
    static String processPayment(PaymentMethod method) {
        return switch (method) {
            case CreditCard cc -> "Charging card ending in " +
                    cc.cardNumber().substring(cc.cardNumber().length() - 4) + " via " + cc.provider();
            case Cash cash -> "Received cash: $" + cash.amount();
            case Crypto crypto -> "Processing " + crypto.coinType() + " to wallet " + crypto.walletAddress();
        };
    }

    public static void main(String[] args) {

        // ---- Creating instances of the sealed hierarchy ----
        Shape circle = new Circle(5);
        Shape square = new Square(4);
        Shape triangle = new Triangle(6, 3);

        System.out.println(describeShape(circle));
        System.out.println(describeShape(square));
        System.out.println(describeShape(triangle));
        System.out.println("---");

        // ---- non-sealed reopening: Triangle can be extended further ----
        Triangle rightTriangle = new RightTriangle(10, 5);
        System.out.println("RightTriangle area (inherited from Triangle): " + rightTriangle.area());
        System.out.println("Is valid right triangle: " +
                ((RightTriangle) rightTriangle).isValidRightTriangle());
        System.out.println("---");

        // ---- Sealed interface + records: exhaustive payment processing ----
        PaymentMethod[] payments = {
            new CreditCard("1234567890123456", "Visa"),
            new Cash(250.0),
            new Crypto("0xABC123...", "Bitcoin")
        };

        System.out.println("Processing payments:");
        for (PaymentMethod payment : payments) {
            System.out.println(processPayment(payment));
        }
    }
}
