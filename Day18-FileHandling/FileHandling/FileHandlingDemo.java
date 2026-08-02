import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandlingDemo {
    public static void main(String[] args) {

        // ---- Writing to a file (overwrites if it already exists) ----
        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write("Hello, file!\n");
            writer.write("Second line.\n");
            writer.close(); // important - always close, or data may not save
            System.out.println("Written to output.txt successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Reading from a file ----
        try {
            File file = new File("output.txt");
            Scanner reader = new Scanner(file);
            System.out.println("Reading output.txt:");
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Appending to an existing file ----
        try {
            FileWriter writer = new FileWriter("output.txt", true); // true = append mode
            writer.write("This gets added at the end, not overwritten.\n");
            writer.close();
            System.out.println("Appended a line to output.txt.");
        } catch (IOException e) {
            System.out.println("Error appending: " + e.getMessage());
        }
        System.out.println("---");

        // ---- try-with-resources: auto-closing, cleaner and safer ----
        try (FileWriter writer = new FileWriter("autoclosed.txt")) {
            writer.write("Auto-closed, no manual .close() needed!");
            System.out.println("Written to autoclosed.txt using try-with-resources.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Checking if a file exists ----
        File checkFile = new File("output.txt");
        if (checkFile.exists()) {
            System.out.println("output.txt exists, size: " + checkFile.length() + " bytes");
        } else {
            System.out.println("output.txt does not exist.");
        }

        File missingFile = new File("doesNotExist.txt");
        System.out.println("doesNotExist.txt exists? " + missingFile.exists());
    }
}
