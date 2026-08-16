import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomIteratorDemo {
    public static void main(String[] args) {

        Playlist playlist = new Playlist(new String[]{"Song A", "Song B", "Blue Moon", "Sad Melody"});

        // ---- for-each works because Playlist implements Iterable ----
        System.out.println("for-each iteration (uses .iterator() automatically):");
        for (String song : playlist) {
            System.out.println("- " + song);
        }
        System.out.println("---");

        // ---- What for-each actually does behind the scenes ----
        System.out.println("Manual iterator (what for-each compiles down to):");
        Iterator<String> it = playlist.iterator();
        while (it.hasNext()) {
            String song = it.next();
            System.out.println("- " + song);
        }
        System.out.println("---");

        // ---- NoSuchElementException: calling next() too many times ----
        System.out.println("Calling next() one too many times:");
        Iterator<String> exhausted = playlist.iterator();
        try {
            while (true) {
                exhausted.next(); // eventually throws once exhausted
            }
        } catch (NoSuchElementException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Custom iteration order: reverse ----
        System.out.println("Reverse iteration:");
        Iterator<String> reverse = playlist.reverseIterator();
        while (reverse.hasNext()) {
            System.out.println("- " + reverse.next());
        }
        System.out.println("---");

        // ---- Custom iteration: filtered by keyword ----
        System.out.println("Songs containing 'song' (case-insensitive):");
        Iterator<String> filtered = playlist.songsContaining("song");
        while (filtered.hasNext()) {
            System.out.println("- " + filtered.next());
        }
    }
}
