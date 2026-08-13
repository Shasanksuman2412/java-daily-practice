public sealed abstract class Employee permits Manager, Contractor {
    abstract String role();
}

final class Manager extends Employee {
    @Override
    String role() {
        return "Manager";
    }
}

// non-sealed: this branch is deliberately reopened
public non-sealed class Contractor extends Employee {
    @Override
    String role() {
        return "Contractor";
    }
}
