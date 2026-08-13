public sealed interface Vehicle permits Car, Motorcycle, Truck {
    int wheelCount();
}

record Car() implements Vehicle {
    public int wheelCount() {
        return 4;
    }
}

record Motorcycle() implements Vehicle {
    public int wheelCount() {
        return 2;
    }
}

record Truck() implements Vehicle {
    public int wheelCount() {
        return 6;
    }
}
