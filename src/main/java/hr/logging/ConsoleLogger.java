package hr.logging;

public class ConsoleLogger {
    public static  void logInfo(String message) {
        System.out.println( "info:" + message );
    }

    static public  void logError(String message, Exception e) {
        System.out.println( "Error: " + message + " ;" + e );
    }
}
