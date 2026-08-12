public record ComparablePoint(int x, int y) implements Comparable<ComparablePoint> {

    @Override
    public int compareTo(ComparablePoint other) {
        return Integer.compare(this.x, other.x); // natural order by x coordinate
    }
}
