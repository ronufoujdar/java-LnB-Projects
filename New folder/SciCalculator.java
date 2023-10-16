
import java.util.Scanner;
public class SciCalculator {
    public static void main(String[] args) {

        char operation;
        Double result;

        Scanner input = new Scanner(System.in);

        System.out.println("Choose an operation:\n1. Sin()\n2. Cos()\n3. Tan()");
        operation = input.next().charAt(0);

        double number = 0;
        if (operation >= '1' && operation <= '3') {
            System.out.println("Enter degrees");
            number = input.nextDouble();
            number = Math.toRadians(number);
        }


        switch (operation) {
            case '1': {
                result = Math.sin(number);
                System.out.println("Sin of given degrees is " + result);
                break;
            }
            case '2': {
                result = Math.cos(number);
                System.out.println("Cos of given degrees is " + result);
                break;
            }
            case '3': {
                result = Math.tan(number);
                System.out.println("Tan of given degrees is " + result);
                break;
            }
            default: {
                System.out.println("Invalid operation!");
            }
        }
    }
}