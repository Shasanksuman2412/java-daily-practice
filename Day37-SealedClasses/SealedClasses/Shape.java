public sealed abstract class Shape permits Circle, Square, Triangle {
    abstract double area();
}
