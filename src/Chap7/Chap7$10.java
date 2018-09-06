package Chap7;//(Find the index of the smallest element) Write a method that returns the index of
//        the smallest element in an array of integers. If the number of such elements is
//        greater than 1, return the smallest index. Use the following header:
//public static int indexOfSmallestElement(double[] array)
//        Write a test program that prompts the user to enter ten numbers, invokes this
//        method to return the index of the smallest element, and displays the index.
import java.util.Scanner;
public class Chap7$10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] array = new double[5];
        System.out.print("Enter 10 double values: ");
        for(int i = 0; i < 5 ; i++) {
            array[i] = input.nextDouble();
        }
        System.out.println("Index of smallest number: " + indexOfSmallestElement(array));
    }
    public static int indexOfSmallestElement(double[] array) {
        double smallestInteger = array[0];
        int indexOfSmallestInt = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] < smallestInteger) {
                smallestInteger = array[i];
            }
        }
        for(int i = 0; i<array.length; i++) {
            if(array[i] == smallestInteger) {
                indexOfSmallestInt = i;
                break;
            }
        }
        return indexOfSmallestInt;
    }
}
