package Chap7;//(Find the smallest element) Write a method that finds the smallest element in an
//        array of double values using the following header:
//public static double min(double[] array)
//        Write a test program that prompts the user to enter ten numbers, invokes this
//        method to return the minimum value, and displays the minimum value. Here is a
//        sample run of the program:
//        Enter ten numbers: 1.9 2.5 3.7 2 1.5 6 3 4 5 2
//        The minimum number is: 1.5
import java.util.Scanner;
public class Chap7$9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ten numbers: ");
        final int NUMBER_OF_DOUBLES = 10;
        double[] array = new double[NUMBER_OF_DOUBLES];
        for(int i = 0; i < NUMBER_OF_DOUBLES; i++) {
            array[i] = input.nextDouble();
        }
        System.out.println("The minimum number is: " + min(array));
    }
    public static double min(double[] array) {
        double min = array[0];
        for(int i = 0; i < array.length; i++) {
            if(array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
