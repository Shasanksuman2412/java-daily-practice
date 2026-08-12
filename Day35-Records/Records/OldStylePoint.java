import java.util.Objects;

// ---- The "old way" - what a record replaces, for comparison ----
public class OldStylePoint {
    private final int x;
    private final int y;

    public OldStylePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        OldStylePoint other = (OldStylePoint) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "OldStylePoint{x=" + x + ", y=" + y + "}";
    }
}
