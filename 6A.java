import java.util.LinkedList;

public class MusicPlaylist {
    private LinkedList<String> playlist;

    public MusicPlaylist() {
        playlist = new LinkedList<>();
    }

    public void addSong(String song) {
        playlist.add(song);
        System.out.println("Added song: " + song);
    }

    public void removeSong(String song) {
        if (playlist.remove(song)) {
            System.out.println("Removed song: " + song);
        } else {
            System.out.println("Song not found: " + song);
        }
    }

    public void moveSong(int fromIndex, int toIndex) {
        if (fromIndex >= 0 && fromIndex < playlist.size() && toIndex >= 0 && toIndex <= playlist.size()) {
            String song = playlist.remove(fromIndex);
            playlist.add(toIndex, song);
            System.out.println("Moved song to position " + toIndex + ": " + song);
        } else {
            System.out.println("Invalid indices");
        }
    }

    public void displayPlaylist() {
        System.out.println("Playlist:");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println(i + ": " + playlist.get(i));
        }
    }

    public static void main(String[] args) {
        MusicPlaylist playlist = new MusicPlaylist();
        playlist.addSong("Song A");
        playlist.addSong("Song B");
        playlist.addSong("Song C");
        playlist.displayPlaylist();
        playlist.moveSong(2, 1);
        playlist.displayPlaylist();
        playlist.removeSong("Song B");
        playlist.displayPlaylist();
    }
}
