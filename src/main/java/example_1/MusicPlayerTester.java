package example_1;

public class MusicPlayerTester {
    public static void main(String[] args) {
        MusicPlayer iPod = new MusicPlayer(
                "iPod 10",4.245, new String[]{"Marlin manson", "Beyonce", "Eminem", "Ventukai", "TeleBimBam"},true
        );

        MusicPlayer samsung = new MusicPlayer();
        samsung.name = "samsung gt3500";

        iPod.printAllSongs();
        samsung.printAllSongs();
        samsung.transferSong(iPod.songs);
        iPod.printAllSongs();
        samsung.printAllSongs();
    }
}
