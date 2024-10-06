package example_1;

public class MusicPlayerTester {
    public static void main(String[] args) {
        MusicPlayer iPod = new MusicPlayer();
        iPod.name = "iPod nano 2017";

        MusicPlayer samsung = new MusicPlayer();
        samsung.name = "samsung gt3500";


        iPod.connectHeadset();
        iPod.addSong();
        iPod.addSong();
        iPod.playSong();
        iPod.playSong();
        iPod.showSongsHistory();




    }

}
