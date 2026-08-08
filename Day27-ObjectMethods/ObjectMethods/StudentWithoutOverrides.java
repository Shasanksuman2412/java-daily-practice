public class StudentWithoutOverrides {
    String name;
    int age;

    StudentWithoutOverrides(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // No toString(), equals(), or hashCode() overridden - uses Object's defaults
}
