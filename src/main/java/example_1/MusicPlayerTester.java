package example_1;

public class MusicPlayerTester {
    public static void main(String[] args) {
        MusicPlayer iPod = new MusicPlayer();
        iPod.name = "iPod nano 2017";
        iPod.addSong();
        iPod.addSong();
        iPod.printAllSongs();

    }
}
