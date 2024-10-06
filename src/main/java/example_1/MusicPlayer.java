package example_1;

import java.util.Arrays;
import java.util.Scanner;

public class MusicPlayer {

    public String name;
    private double version;
    private String[] songs = new String[5];
    private boolean isHeadSetConnected;
    private final Scanner myScanner = new Scanner(System.in);

    public MusicPlayer() {
    }

    public MusicPlayer(String name, double version, boolean isHeadSetConnected) {
        this.name = name;
        this.version = version;
        this.isHeadSetConnected = isHeadSetConnected;
    }

    public MusicPlayer(String name, String[] songs) {
        this.name = name;
        this.songs = songs;
    }

    public void addSong() {

        System.out.printf("Please enter your song name: %n");
        String name = myScanner.nextLine();
        System.out.printf("Please enter your song place : [0 - %d] %n", this.songs.length);
        int songPlace = myScanner.nextInt();
        myScanner.nextLine();

        final boolean isSongRangeValid = songPlace >= 1 && songPlace <= songs.length;

        if (!isSongRangeValid) {
            System.out.printf("Song place is invalid. Please select place from 1 to %d. %n", this.songs.length);
            return;
        }

        this.songs[songPlace - 1] = name;
        System.out.printf("Song %s was added to %d place.%n", name, songPlace);

    }

    public void printAllSongs() {
        int counter = 0;
        while (counter < this.songs.length ) {

            System.out.printf("%d. %s. %n", counter+1, this.songs[counter]);
            counter ++;
        }
    }

    public String getAllSongs() {

        return Arrays.toString(this.songs);
    }


}
