package Part1;

/**
 *
 * @author nghia
 */
import java.util.Scanner;

public class Part1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int rows, cols, matrix[][], sum = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        rows = in.nextInt();
        System.out.println("Enter number of cols: ");
        cols = in.nextInt();
        matrix = new int[rows + 1][cols + 1];
        System.out.println("Enter the matrix: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("matrix [" + i + "][" + j + "] ");
                matrix[i][j] = in.nextInt();
            }
        }
        System.out.println("Matrix inputted:");
        for (int i = rows-1; i >= 0; i--) {
            for (int j = cols-1; j >=0; j--) {
                System.out.format("%3d ", matrix[i][j]);
                sum += matrix[i][j];
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <cols; j++) {
                System.out.format("%3d ", matrix[i][j]);
                sum += matrix[i][j];
            }
            System.out.println();
        }
        System.out.println("Sum = " + sum);
        System.out.println("Average:" +(float)sum/(rows*cols));
    }

    public Part1() {
    }

}
