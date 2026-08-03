import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentManager {
    private List<Student> students = new ArrayList<>();
    private static final String FILE_NAME = "students.txt";

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Added: " + s);
    }

    public boolean deleteStudent(int rollNumber) {
        return students.removeIf(s -> s.getRollNumber() == rollNumber);
    }

    public Optional<Student> findByRollNumber(int rollNumber) {
        return students.stream()
                .filter(s -> s.getRollNumber() == rollNumber)
                .findFirst();
    }

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public double classAverage() {
        return students.stream()
                .mapToDouble(Student::getMarks)
                .average()
                .orElse(0);
    }

    public Optional<Student> topScorer() {
        return students.stream()
                .max((a, b) -> Double.compare(a.getMarks(), b.getMarks()));
    }

    public void saveToFile() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            for (Student s : students) {
                writer.write(s.toFileFormat() + "\n");
            }
            System.out.println("Saved " + students.size() + " students to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No saved file found (" + FILE_NAME + ") - starting fresh.");
            return;
        }
        students.clear();
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.isBlank()) continue;
                try {
                    students.add(Student.fromFileFormat(line));
                } catch (InvalidMarksException e) {
                    System.out.println("Skipping invalid record: " + e.getMessage());
                }
            }
            System.out.println("Loaded " + students.size() + " students from " + FILE_NAME);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
