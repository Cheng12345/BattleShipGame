import java.util.Scanner;

public class ScannerUtil {
    // Static variable that holds the Scanner instance
    public static final Scanner SCANNER = new Scanner(System.in);

    // Static method to close the Scanner
    public static void closeScanner() {
        SCANNER.close();
    }
}