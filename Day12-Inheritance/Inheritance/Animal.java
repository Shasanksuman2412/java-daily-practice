public class Animal {

    protected String name; // protected: accessible in this class AND subclasses

    Animal(String name) {
        this.name = name;
    }

    void eat() {
        System.out.println(name + " is eating.");
    }

    void sleep() {
        System.out.println(name + " is sleeping.");
    }

    void makeSound() {
        System.out.println(name + " makes some generic animal sound.");
    }
}
