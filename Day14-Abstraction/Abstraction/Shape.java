public abstract class Shape {

    // Abstract method: no body - every subclass MUST implement this
    abstract double area();

    // Regular method: CAN have a body, shared by all subclasses
    void display() {
        System.out.println("This shape has an area of: " + area());
    }
}
