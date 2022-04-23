import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("Choose task to show: \n" +
                        "'1' - Fibonacci numbers,\n" +
                        "'2' - Json reader;");
                Scanner scanner = new Scanner(System.in);
                int userMode = scanner.nextInt();
                switch (userMode) {
                    case 1:
                        FirstTaskFibonacci.fibonacciUI();
                        break;
                    case 2:
                        SecondTaskJsonReader.manageReader();
                        break;
                    default:
                        System.out.println("The answer must be '1' or '2'!");
                        break;
                }
            } catch (NoSuchElementException exception) {
                System.err.println("Unknown combination was entered. Leaving the program!'");
                System.exit(1);
            }
        }
    }
}
