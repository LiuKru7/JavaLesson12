package example_1;

public class MusicPlayerTester {
    public static void main(String[] args) {
        MusicPlayer iPod = new MusicPlayer(
                "iPod 10",4.245, new String[]{"Marlin manson", "Beyonce", "Eminem", "Ventukai", "TeleBimBam"},true
        );
        MusicPlayer samsung = new MusicPlayer();

        samsung.name = "samsung gt3500";
        iPod.connectHeadset();
        iPod.connectHeadset();
        iPod.addSong();
        System.out.println(iPod.getAllSongs());
        iPod.playSong();
        iPod.playSong();
        iPod.playSong();
        iPod.printAllSongs();
        iPod.switchSongs();
        iPod.printAllSongs();
        samsung.transferSong(iPod.songs);
        samsung.printAllSongs();
        iPod.clearAllSongs();
        iPod.printAllSongs();
        iPod.showSongsHistory();
    }
}
