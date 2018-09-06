package Chap7;//(Statistics: compute deviation) Programming Exercise 5.45 computes the standard
//        deviation of numbers. This exercise uses a different but equivalent formula to
//        compute the standard deviation of n numbers.
//        To compute the standard deviation with this formula, you have to store the individual
//        numbers using an array, so that they can be used after the mean is obtained.
//        Your program should contain the following methods:
///** Compute the deviation of double values */
//public static double deviation(double[] x)
///** Compute the mean of an array of double values */
//public static double mean(double[] x)
//        Write a test program that prompts the user to enter ten numbers and displays the
//        mean and standard deviation, as shown in the following sample run:
import java.util.Scanner;
public class Chap7$11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] array = new double[10];
        System.out.println("Enter 10 numbers: ");
        for(int i = 0; i < 10; i++) {
            array[i] = input.nextDouble();
        }
        System.out.println("The mean is: " + mean(array));
        System.out.println("The s.d is: " + deviation(array));
    }
    public static double deviation(double[] x) {
        double mean = mean(x);
        double sum = 0;
        for(int i = 0; i < x.length; i++) {
            sum += (x[i] - mean) * (x[i] - mean);
        }
        return Math.sqrt(sum / (x.length - 1));
    }
    public static double mean(double[] x) {
        double sum = 0;
        for(double item : x) {
            sum += item;
        }
        return sum / x.length;
    }
}
