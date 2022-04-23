import java.util.InputMismatchException;
import java.util.Scanner;

public class FirstTaskFibonacci {
    public static void fibonacciUI(){
        while (true) {
            try {
                int length;
                System.out.println("Enter length of Fibonacci numbers sequence:");
                Scanner scanner = new Scanner(System.in);
                length = scanner.nextInt();
                if (length <= 0) {
                    System.out.println("Error! The length must be more than 0.");
                    continue;
                }
                fibonacciSolver(length);
                break;
            }catch (InputMismatchException e){
                System.out.println("Error! Length must me an Integer!");
                continue;
            }
        }
    }
    private static void fibonacciSolver(int length){
        int previousNumber = 1;
        int nextNumber = 1;
        int currentNumber;
        System.out.print(previousNumber + " " + nextNumber + " ");
        for (int i = 3; i <= length; i++){
            currentNumber = previousNumber + nextNumber;
            System.out.print(currentNumber + " ");
            previousNumber = nextNumber;
            nextNumber = currentNumber;
        }
        System.out.println(" ");
    }

}
