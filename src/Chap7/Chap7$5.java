package Chap7;//(Print distinct numbers) Write a program that reads in ten numbers and displays
//        the number of distinct numbers and the distinct numbers separated by exactly one
//        space (i.e., if a number appears multiple times, it is displayed only once). (Hint:
//        Read a number and store it to an array if it is new. If the number is already in the
//        array, ignore it.) After the input, the array contains the distinct numbers. Here is
//        the sample run of the program:
//Enter ten numbers: 1 2 3 2 1 6 3 4 5 2
//        The number of distinct number is 6
//        The distinct numbers are: 1 2 3 6 4 5

import java.util.Scanner;
public class Chap7$5 {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        int current = 0;
        int numberOfDistinct = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter ten numbers: ");

        outerLoop:
       for(int counter = 0; counter < 10; counter++) {
            current = input.nextInt();
            for(int i = 0; i < counter; i++) {
                if(numbers[i] == current) { ;
                    continue outerLoop;
                }
            }
            numbers[numberOfDistinct] = current;
            numberOfDistinct++;
        }
        System.out.println("The number of distinct number " + numberOfDistinct);
        System.out.print("The distinct numbers are ");
        for(int item : numbers) {
            if(item == 0) {
                continue;
            }
            System.out.print(item + " ");
        }
    }
}
