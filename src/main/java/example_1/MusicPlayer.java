package example_1;

import java.util.Arrays;
import java.util.Scanner;

public class MusicPlayer {

    public String name;
    private double version;
    public String[] songs = new String[5];
    private boolean isHeadSetConnected;
    private final Scanner myScanner = new Scanner(System.in);
    private int nowPlaying;
    private String[] songHistory = new String[5];

    public MusicPlayer(String name, double version, String[] songs, boolean isHeadSetConnected) {
        this.name = name;
        this.version = version;
        this.songs = songs;
        this.isHeadSetConnected = isHeadSetConnected;
    }

    public MusicPlayer() {
    }

    public void addSong() {

        System.out.printf("Please enter your song name: %n");
        String name = myScanner.nextLine();
        System.out.printf("Please enter your song place : [0 - %d] %n", this.songs.length);
        int songPlace = myScanner.nextInt();
        myScanner.nextLine();

        if (checkOrSongRangeValid(songPlace)) {
            return;
        }

        this.songs[songPlace - 1] = name;
        System.out.printf("Song %s was added to %d place.%n", name, songPlace);

    }

    public void printAllSongs() {
        int counter = 0;
        while (counter < this.songs.length) {
            System.out.printf("%d. %s. %n", counter + 1, this.songs[counter]);
            counter++;
        }
    }

    public String getAllSongs() {
        return Arrays.toString(this.songs);
    }

    public void deleteSong() {
        System.out.println("That song you want delete? ");
        int songPlace = myScanner.nextInt();

        if (checkOrSongRangeValid(songPlace)) {
            return;
        }
        if (checkOrThisPlaceHaveSong(songPlace)) {
            return;
        }

        System.out.printf("Song %s was delete to %d place.%n", this.songs[songPlace - 1], songPlace);
        this.songs[songPlace - 1] = null;

    }

    public void playSong() {
        if (!isHeadSetConnected) {
            System.out.println("Connect Headset");
            return;
        }
        System.out.println("\nPlease enter your song number ");
        int songPlace = myScanner.nextInt();

        if (checkOrSongRangeValid(songPlace)) {
            return;
        }
        if (checkOrThisPlaceHaveSong(songPlace)) {
            return;
        }
        nowPlaying = songPlace;
        System.out.printf("Now playing song: %s ", songs[songPlace - 1]);

        int i = 0;
        while (i < songs.length) {
            if (songHistory[i] == null) {
                songHistory[i] = songs[songPlace - 1];
                return;
            }
            i++;
        }
    }

    public void connectHeadset() {
        if (isHeadSetConnected) {
            isHeadSetConnected = false;
            System.out.println("Headset is not connected!");
        } else {
            isHeadSetConnected = true;
            System.out.println("Headset is connected! ");
        }
    }

    public void clearAllSongs() {
        Arrays.fill(songs, null);
        System.out.println("All songs are deleted");
    }

    public void switchSongs() {
        System.out.println("Tell first song number: ");
        int firstNumber = myScanner.nextInt();
        if (checkOrSongRangeValid(firstNumber)) {
            return;
        }

        System.out.println("Tell second song number: ");
        int secondNumber = myScanner.nextInt();
        if (checkOrSongRangeValid(secondNumber)) {
            return;
        }

        String firstSong = songs[firstNumber - 1];
        String secondSong = songs[secondNumber - 1];
        songs[firstNumber - 1] = secondSong;
        songs[secondNumber - 1] = firstSong;
        System.out.println("Songs switch positions");

    }

    public void showSongsHistory() {
        System.out.println("\n" + Arrays.toString(songHistory));
    }

    public void transferSong(String[] songsFromOtherPlayer) {
        System.out.println("Enter the number of the song you want to transfer: ");
        int songNumberYouWantTransfer = myScanner.nextInt();

        final boolean isSongRangeValid =  songNumberYouWantTransfer >= 1 && songNumberYouWantTransfer <= songs.length;
        if (!isSongRangeValid) {
            System.out.printf("Song place is invalid. Please select place from 1 to %d. %n", songsFromOtherPlayer.length);
            return;
        }

        System.out.println("Enter the position in your playlist where you want to place the transferred song: ");
        int songPlace = myScanner.nextInt();

        if (checkOrSongRangeValid(songPlace)) {
            return;
        }

        System.out.printf("Transferring song: %s to position %d.%n", songsFromOtherPlayer[songNumberYouWantTransfer - 1], songPlace);
        songs[songPlace-1] = songsFromOtherPlayer[songNumberYouWantTransfer - 1];
    }

    private boolean checkOrSongRangeValid(int songPlace) {
        final boolean isSongRangeValid = songPlace >= 1 && songPlace <= songs.length;
        if (!isSongRangeValid) {
            System.out.printf("Song place is invalid. Please select place from 1 to %d. %n", this.songs.length);
            return true;
        }
        return false;
    }

    private boolean checkOrThisPlaceHaveSong(int songPlace) {
        if (songs[songPlace - 1] == null) {
            System.out.println("This place don`t have song");
            return true;
        }
        return false;
    }
}






