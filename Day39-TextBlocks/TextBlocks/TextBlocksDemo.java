public class TextBlocksDemo {
    public static void main(String[] args) {

        // ---- The old, messy way ----
        String oldHtml = "<html>\n" +
                          "  <body>\n" +
                          "    <p>Hello</p>\n" +
                          "  </body>\n" +
                          "</html>";
        System.out.println("Old way:");
        System.out.println(oldHtml);
        System.out.println("---");

        // ---- Text block: clean and readable ----
        String newHtml = """
                <html>
                  <body>
                    <p>Hello</p>
                  </body>
                </html>
                """;
        System.out.println("Text block way:");
        System.out.println(newHtml);
        System.out.println("---");

        // ---- Java strips common leading whitespace automatically ----
        String indented = """
                Hello
                World
                """;
        System.out.println("Indented source, but clean output:");
        System.out.println(indented);
        System.out.println("---");

        // ---- Embedded quotes: no escaping needed ----
        String json = """
                {
                  "name": "Shasank",
                  "age": 21
                }
                """;
        System.out.println("Embedded JSON quotes, no escaping:");
        System.out.println(json);
        System.out.println("---");

        // ---- Trailing newline control ----
        String noTrailingNewline = """
                No trailing newline here""";
        String withTrailingNewline = """
                This one has a trailing newline
                """;
        System.out.println("[" + noTrailingNewline + "]"); // no blank line before ]
        System.out.println("[" + withTrailingNewline + "]"); // notice the blank line before ]
        System.out.println("---");

        // ---- Combining with .formatted() for variable substitution ----
        String name = "Shasank";
        int age = 21;
        String message = """
                Hello, %s!
                You are %d years old.
                """.formatted(name, age);
        System.out.println("Formatted text block:");
        System.out.println(message);
        System.out.println("---");

        // ---- Line continuation with backslash: suppresses the newline ----
        String continued = """
                This is a very long line that we wrap \
                in the source code but it stays on ONE line \
                in the actual String value.
                """;
        System.out.println("With line continuation:");
        System.out.println(continued);
    }
}
