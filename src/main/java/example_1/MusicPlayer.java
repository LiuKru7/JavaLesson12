package example_1;

import java.util.Arrays;
import java.util.Scanner;

public class MusicPlayer {

    public String name;
    private double version;
    public String[] songs = new String[5];
    private boolean isHeadSetConnected;
    private final Scanner myScanner = new Scanner(System.in);
    private int nowPlaying ;
    private String [] songHistory = new String[5];


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

        final boolean isSongRangeValid = songPlace >= 1 && songPlace  <= songs.length;

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
    public void deleteSong() {
        System.out.println("That song you want delete? ");
        int songPlace = myScanner.nextInt();
        final boolean isSongRangeValid = songPlace >= 1 && songPlace  <= songs.length;
        if (!isSongRangeValid) {
            System.out.printf("Song place is invalid. Please select place from 1 to %d. %n", this.songs.length);
            return;
        }

        if (songs[songPlace-1]==null) {
            System.out.println("This place don`t have song");
            return;
        }

        System.out.printf("Song %s was delete to %d place.%n", this.songs[songPlace-1], songPlace);
        this.songs[songPlace-1] = null;

    }
    public void playSong() {

        if (!isHeadSetConnected) {
            System.out.println("Connect Headset");
            return;
        }
        System.out.println("\nPlease enter your song number ");
        int songPlace = myScanner.nextInt();
        final boolean isSongRangeValid = songPlace >= 1 && songPlace  <= songs.length;
        if (!isSongRangeValid) {
            System.out.printf("Song place is invalid. Please select place from 1 to %d. %n", this.songs.length);
            return;
        }
        if (songs[songPlace-1]==null) {
            System.out.println("This place don`t have song");
            return;
        }
        nowPlaying = songPlace;
        System.out.printf("Now playing song: %s ", songs[songPlace-1]);



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
//        songs[0] = null;
//        songs[1] = null;
//        songs[2] = null;
//        songs[3] = null;
//        songs[4] = null;

        for (int index = 0; index < songs.length; index++) {
            songs[index]=null;
        }
        System.out.println("All songs are deleted");
    }
    public void switchSongs() {
        System.out.println("Tell me first song number: ");
        int firstNumber = myScanner.nextInt();

        final boolean isSongRangeValid = firstNumber >= 1 && firstNumber  <= songs.length;
        if (!isSongRangeValid) {
            System.out.printf("Song number is invalid. Please select place from 1 to %d. %n", this.songs.length);
            return;
        }


        System.out.println("Tell me second song number: ");
        int secondNumber = myScanner.nextInt();

        final boolean isSongRangeValid2 = secondNumber >= 1 && secondNumber  <= songs.length;
        if (!isSongRangeValid2) {
            System.out.printf("Song number is invalid. Please select place from 1 to %d. %n", this.songs.length);
            return;
        }

        String firstSong = songs[firstNumber-1];
        String secondSong = songs[secondNumber-1];
        songs[firstNumber-1] = secondSong;
        songs[secondNumber-1] = firstSong;
        System.out.println("Songs switch positions");

    }
    public void showSongsHistory() {
        System.out.println("\n" + Arrays.toString(songHistory));
    }

    public void transferSong() {


    }
}






