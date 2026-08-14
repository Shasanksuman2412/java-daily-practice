public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1: Convert concatenated String to a text block ----
        String poemOld = "Roses are red,\n" +
                          "Violets are blue,\n" +
                          "Java is fun,\n" +
                          "And so are you.";

        String poemNew = """
                Roses are red,
                Violets are blue,
                Java is fun,
                And so are you.""";

        System.out.println(poemNew);
        System.out.println("Both versions equal? " + poemOld.equals(poemNew));
        System.out.println("---");

        // ---- Exercise 2: SQL query as a text block ----
        String query = """
                SELECT name, age, marks
                FROM students
                WHERE marks > 75
                ORDER BY marks DESC
                """;
        System.out.println("SQL query:");
        System.out.println(query);
        System.out.println("---");

        // ---- Exercise 3: Formatted receipt template ----
        String receiptTemplate = """
                Receipt
                -------
                Item: %s
                Quantity: %d
                Price: $%.2f
                """;

        String receipt1 = receiptTemplate.formatted("Laptop", 1, 55000.00);
        String receipt2 = receiptTemplate.formatted("Mouse", 2, 499.50);

        System.out.println(receipt1);
        System.out.println(receipt2);
        System.out.println("---");

        // ---- Exercise 4: Embedded JSON with nested quotes ----
        String nestedJson = """
                {
                  "name": "Shasank",
                  "age": 21,
                  "address": {
                    "city": "Mumbai",
                    "country": "India"
                  }
                }
                """;
        System.out.println("Nested JSON, no escaping needed:");
        System.out.println(nestedJson);
        System.out.println("---");

        // ---- Exercise 5: Trailing newline behavior comparison ----
        String noTrailing = """
                Sample text""";

        String oneTrailing = """
                Sample text
                """;

        String twoTrailing = """
                Sample text

                """;

        System.out.println("noTrailing length: " + noTrailing.length());
        System.out.println("oneTrailing length: " + oneTrailing.length());
        System.out.println("twoTrailing length: " + twoTrailing.length());
        // each extra newline before the closing """ adds exactly one more
        // '\n' character to the resulting String's length
    }
}
