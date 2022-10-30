package Part3;

import java.util.Scanner;

/**
 *
 * @author nghia
 */
public class Part3 {

    public static String capitalize(String str) {
        char[] charArray = str.toCharArray();
        boolean space = true;
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLetter(charArray[i])) {
                if (space) {
                    charArray[i] = Character.toUpperCase(charArray[i]);
                    space = false;
                }
            } else {
                space = true;
            }
        }

        str = String.valueOf(charArray);
        return str;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        String[] list = new String[10];
        int num;
        System.out.println("Input the number of students");
        num = in.nextInt();
        System.out.println("Input name of student:");
        for (int i = 0; i <= num; i++) {
            list[i] = in.nextLine();
        }
        for (int i = 0; i <= num; i++) {
            list[i] = list[i].toLowerCase();
        }
        System.out.print("Result is:");
        for (int i = 0; i <= num; i++) {
            System.out.println(capitalize(list[i]));
        }
    }

}
