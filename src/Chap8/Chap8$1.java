package Chap8;//(Sum elements column by column) Write a method that returns the sum of all the
//        elements in a specified column in a matrix using the following header:
//public static double sumColumn(double[][] m, int columnIndex)
//Write a test program that reads a 3-by-4 matrix and displays the sum of each
//        column. Here is a sample run:
//Enter a 3-by-4 matrix row by row:
//        1.5 2 3 4
//        5.5 6 7 8
//        9.5 1 3 1
//        Sum of the elements at column 0 is 16.5
//        Sum of the elements at column 1 is 9.0
//        Sum of the elements at column 2 is 13.0
//        Sum of the elements at column 3 is 13.0
import java.util.Scanner;
public class Chap8$1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] matrix = new double[3][4];
        System.out.println("Enter a 3-by-4 matrix row by row: ");
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = input.nextDouble();
            }
        }
        System.out.println(matrix[2][3]);
        for(int i = 0; i < 4; i++) {
            System.out.println("Sum of elements at column " + i + " is " + sumColumn(matrix, i));
        }
    }
    public static double sumColumn(double[][] m, int columnIndex) {
        double sum = 0;
        for(int row = 0; row < m.length; row++) {
            sum += m[row][columnIndex];
        }
        return sum;
    }
}
