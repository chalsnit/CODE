package Part2;

import java.util.Scanner;

/**
 *
 * @author nghia
 */
public class Part2_2 {

    public String inputString() throws Exception {
        String pattern = "^SE[0-9]{3}$";
        String str = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the string: ");
        str = sc.nextLine();
        if (!str.matches(pattern)) {
            throw new Exception();
        }
        return str;
    }

    public static void main(String[] args) {
        Part2_2 obj = new Part2_2();
        boolean cont = false;
        do {
            try {
                String str = obj.inputString();
                System.out.println("The string is " + str);
                cont = false;
            } catch (Exception e) {
                System.out.println("The string is invalid");
                cont = true;
            }
        } while (cont);
    }
}
