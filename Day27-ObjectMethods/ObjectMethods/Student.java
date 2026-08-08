import java.util.Objects;

public class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // same object reference - quick exit
        if (obj == null || getClass() != obj.getClass()) return false; // different type entirely
        Student other = (Student) obj;
        return this.age == other.age && this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age); // combines fields into one hash value
    }
}
