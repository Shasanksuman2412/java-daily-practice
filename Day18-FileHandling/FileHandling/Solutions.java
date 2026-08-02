import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1: Write a list of names to a file ----
        List<String> names = List.of("Shasank", "Priya", "Amit", "Neha", "Raj");
        try (FileWriter writer = new FileWriter("names.txt")) {
            for (String name : names) {
                writer.write(name + "\n");
            }
            System.out.println("Names written to names.txt");
        } catch (IOException e) {
            System.out.println("Error writing names: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Exercise 2: Read the file back and count lines ----
        int lineCount = 0;
        try {
            File file = new File("names.txt");
            Scanner reader = new Scanner(file);
            System.out.println("Reading names.txt:");
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
                lineCount++;
            }
            reader.close();
            System.out.println("Total names: " + lineCount);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Exercise 3: Append a new name without overwriting ----
        try (FileWriter writer = new FileWriter("names.txt", true)) { // append mode
            writer.write("Kavya\n");
            System.out.println("Appended 'Kavya' to names.txt");
        } catch (IOException e) {
            System.out.println("Error appending: " + e.getMessage());
        }

        try {
            File file = new File("names.txt");
            Scanner reader = new Scanner(file);
            System.out.println("names.txt after append:");
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Exercise 4: Word count from a file ----
        try (FileWriter writer = new FileWriter("paragraph.txt")) {
            writer.write("Java is a powerful language. It is used widely in industry. Learning it daily builds real skill.");
        } catch (IOException e) {
            System.out.println("Error writing paragraph: " + e.getMessage());
        }

        int wordCount = 0;
        try {
            File file = new File("paragraph.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] words = line.split(" ");
                wordCount += words.length;
            }
            reader.close();
            System.out.println("Total words in paragraph.txt: " + wordCount);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Exercise 5: Copy contents from one file to another ----
        List<String> linesToCopy = new ArrayList<>();
        try (Scanner reader = new Scanner(new File("names.txt"))) {
            while (reader.hasNextLine()) {
                linesToCopy.add(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        try (FileWriter writer = new FileWriter("names_copy.txt")) {
            for (String line : linesToCopy) {
                writer.write(line + "\n");
            }
            System.out.println("Copied names.txt into names_copy.txt");
        } catch (IOException e) {
            System.out.println("Error writing copy: " + e.getMessage());
        }

        System.out.println("Contents of names_copy.txt:");
        try (Scanner reader = new Scanner(new File("names_copy.txt"))) {
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
