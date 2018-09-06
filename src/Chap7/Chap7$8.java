package Chap7;//(Average an array) Write two overloaded methods that return the average of an
//        array with the following headers:
//public static int average(int[] array)
//public static double average(double[] array)
//        Write a test program that prompts the user to enter ten double values, invokes this
//        method, and displays the average value.
import java.util.Scanner;
public class Chap7$8 {
    public static void main(String[] args) {
        final int NUMBER_OF_DOUBLE = 10;
        double[] array = new double[NUMBER_OF_DOUBLE];
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ten double values: ");
        for(int i = 0; i < NUMBER_OF_DOUBLE; i++) {
            array[i] = input.nextDouble();
        }
        double average = average(array);
        System.out.println("avg of the 10 double values is " + average);
    }

    public static int average(int[] array) {
        int sum = 0;
        for(int item : array) {
            sum += item;
        }
        int avg = sum / array.length;
        return avg;
    }
    public static double average(double[] array) {
        double sum = 0.0;
        for(double item: array) {
            sum += item;
        }
        double avg = sum / array.length;
        return avg;
    }
}
