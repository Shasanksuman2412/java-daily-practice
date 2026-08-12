public record Movie(String title, String director, int year, double rating) implements Comparable<Movie> {

    // ---- Exercise 2: compact constructor validation ----
    public Movie {
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Rating must be between 0 and 10, got: " + rating);
        }
    }

    // ---- Exercise 3: additional method ----
    boolean isHighlyRated() {
        return rating >= 8.0;
    }

    // ---- Exercise 4: Comparable, sorting by rating descending ----
    @Override
    public int compareTo(Movie other) {
        return Double.compare(other.rating, this.rating); // reversed for descending order
    }
}
