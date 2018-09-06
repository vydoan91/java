package Chap8;//(Sum the major diagonal in a matrix) Write a method that sums all the numbers
//        in the major diagonal in an n * n matrix of double values using the following
//        header:
//public static double sumMajorDiagonal(double[][] m)
//        Write a test program that reads a 4-by-4 matrix and displays the sum of all its
//        elements on the major diagonal. Here is a sample run:
//Enter a 4-by-4 matrix row by row:
//        1 2 3 4.0
//        5 6.5 7 8
//        9 10 11 12
//        13 14 15 16
//        Sum of the elements in the major diagonal is 34.5
import java.util.Scanner;
public class Chap8$2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] matrix = new double[4][4];
        System.out.println("Enter a 4x4 matrix:");
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = input.nextDouble();
            }
        }
        System.out.println("Sum of elements in major diagonal: " + sumMajorDiagonal(matrix));
    }
    public static double sumMajorDiagonal(double[][]m) {
        double sum = 0;
        for(int i = 0; i < m.length; i++) {
            sum += m[i][i];
        }
        return sum;
    }
}
