import java.util.Iterator;
import java.util.NoSuchElementException;

public class Playlist implements Iterable<String> {
    private String[] songs;

    Playlist(String[] songs) {
        this.songs = songs;
    }

    // ---- Required by Iterable: forward iteration, used by for-each ----
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < songs.length;
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more songs in the playlist");
                }
                return songs[index++]; // return current, THEN increment
            }
        };
    }

    // ---- Custom iteration order: reverse ----
    public Iterator<String> reverseIterator() {
        return new Iterator<String>() {
            private int index = songs.length - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more songs in reverse iteration");
                }
                return songs[index--];
            }
        };
    }

    // ---- Custom iteration: only songs matching a keyword ----
    public Iterator<String> songsContaining(String keyword) {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                while (index < songs.length && !songs[index].toLowerCase().contains(keyword.toLowerCase())) {
                    index++; // skip non-matching songs
                }
                return index < songs.length;
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more matching songs");
                }
                return songs[index++];
            }
        };
    }
}
