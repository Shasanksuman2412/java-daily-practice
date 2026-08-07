public class Product implements Comparable<Product> {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price); // ascending by price
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}
