public class BadBook {
    String title;
    String author;

    BadBook(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BadBook other = (BadBook) obj;
        return title.equals(other.title) && author.equals(other.author);
    }

    // hashCode() is DELIBERATELY NOT overridden here - uses Object's default,
    // which is based on memory address, not title/author.
    // This BREAKS the equals/hashCode contract on purpose, to demonstrate the bug.
}
