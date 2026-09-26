
public class Playlist {
    private final String[] songs;
    private int count;

    public Playlist(int capacity) {
        this.songs = new String[capacity];
        this.count = 0;
    }

    public void addSong(String songTitle) {
        if (this.count < this.songs.length && songTitle != null) {
            this.songs[this.count] = songTitle;
            this.count++;
        }
    }

    public String[] getSongs() {
        String[] copy = new String[this.count];
        for (int i = 0; i < this.count; i++) {
            copy[i] = this.songs[i];
        }
        return copy;
    }

    public int getSongCount() {
        return this.count;
    }
}