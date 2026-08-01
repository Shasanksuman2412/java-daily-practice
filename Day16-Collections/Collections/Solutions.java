import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1: Remove duplicates using a Set ----
        List<Integer> numbers = new ArrayList<>(List.of(1, 3, 2, 3, 4, 1, 5, 2));
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        System.out.println("Original: " + numbers);
        System.out.println("Unique (via Set): " + uniqueNumbers);
        System.out.println("---");

        // ---- Exercise 2: Word frequency counter ----
        String text = "the cat sat on the mat the cat ran";
        String[] words = text.split(" ");
        Map<String, Integer> frequency = new HashMap<>();
        for (String w : words) {
            frequency.put(w, frequency.getOrDefault(w, 0) + 1);
        }
        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("---");

        // ---- Exercise 3: Common elements between two Lists ----
        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> list2 = new ArrayList<>(List.of(3, 4, 5, 6, 7));
        List<Integer> common = new ArrayList<>(list1);
        common.retainAll(list2); // keeps only elements also present in list2
        System.out.println("Common elements: " + common);
        System.out.println("---");

        // ---- Exercise 4: Sort a Map by its values ----
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 85);
        scores.put("Bob", 92);
        scores.put("Charlie", 78);

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(scores.entrySet());
        entryList.sort((a, b) -> b.getValue() - a.getValue()); // descending by value

        System.out.println("Scores sorted highest to lowest:");
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("---");

        // ---- Exercise 5: Student records with a List of Maps ----
        List<Map<String, Object>> students = new ArrayList<>();

        Map<String, Object> student1 = new HashMap<>();
        student1.put("name", "Shasank");
        student1.put("marks", 85);
        students.add(student1);

        Map<String, Object> student2 = new HashMap<>();
        student2.put("name", "Priya");
        student2.put("marks", 92);
        students.add(student2);

        Map<String, Object> student3 = new HashMap<>();
        student3.put("name", "Amit");
        student3.put("marks", 78);
        students.add(student3);

        System.out.println("All students:");
        Map<String, Object> topStudent = students.get(0);
        for (Map<String, Object> student : students) {
            System.out.println(student.get("name") + ": " + student.get("marks"));
            int currentMarks = (int) student.get("marks");
            int topMarks = (int) topStudent.get("marks");
            if (currentMarks > topMarks) {
                topStudent = student;
            }
        }
        System.out.println("Top student: " + topStudent.get("name") +
                " with " + topStudent.get("marks") + " marks");
    }
}
