package example_4;

public class Main
{
    public static void main(String[] args) {
        getDurationString(7800);
        getDurationString(65, 55 );
        System.out.println(
                getDurationString(7800)
        );
        System.out.println(
                getDurationString(78, 55)
        );
    }
    public static String getDurationString (int seconds){
        int minutes = seconds/60;
        return getDurationString(minutes,seconds);
    };
    public static String  getDurationString( int minutes, int seconds){
        int hours = minutes/60;
        int remainingMinutes = minutes % 60;
        int remainingSeconds = seconds % 60;
        return hours + "h " + remainingMinutes + "m " + remainingSeconds + "s";
    }
}

