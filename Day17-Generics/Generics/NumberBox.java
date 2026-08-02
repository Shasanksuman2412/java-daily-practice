public class NumberBox<T extends Number> {
    private T value;

    NumberBox(T value) {
        this.value = value;
    }

    double doubled() {
        return value.doubleValue() * 2; // guaranteed to work since T IS a Number
    }
}
