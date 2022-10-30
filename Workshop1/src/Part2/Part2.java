package Part2;
/**
 *
 * @author nghia
 */
import java.util.Scanner;

/**
 *
 * @author nghia
 */
public class Part2 {

    public static void main(String[] args) {
        // TODO code application logic here
        float num1, num2;
        String op;
        Scanner in = new Scanner(System.in);
        System.out.println("Input the number 1: ");
        num1 = in.nextFloat();
        System.out.println("Input the number 2: ");
        num2 = in.nextFloat();
        System.out.println("Input the operator: ");
        in = new Scanner(System.in);
        op = in.nextLine();
        if (op.equals("+")) {
            System.out.println("The result of " + num1 + op + num2 + "=" + (num1 + num2));
        } else if (op.equals("-")) {
            System.out.println("The result of " + num1 + op + num2 + "=" + (num1 - num2));
        } else if (op.equals("*")) {
            System.out.println("The result of " + num1 + op + num2 + "=" + (num1 * num2));
        } else if (op.equals("/")) {
            System.out.println("The result of " + num1 + op + num2 + "=" + (num1 / num2));
        }

    }

}
