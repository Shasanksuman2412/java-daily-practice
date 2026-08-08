public class Ebook extends Book {
    double fileSizeMB;

    Ebook(String title, String author, int year, double fileSizeMB) {
        super(title, author, year);
        this.fileSizeMB = fileSizeMB;
    }
}
