package Chap7;// (Count occurrence of numbers) Write a program that reads the integers between 1
// and 100 and counts the occurrences of each. Assume the input ends with 0. Here
// is a sample run of the program:
// Note that if a number occurs more than one time, the plural word “times” is used
//in the output.
import java.util.Scanner;

public class Chap7$3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the integers between 1 and 100: ");
        int[] counts = new int[100];
        while(input.hasNextInt()) {
            int current = input.nextInt();
            if (current == 0) {
                break;
            }
            counts[current - 1]++;
        }
        for(int i = 0; i < 100; i++) {
            if (counts[i] == 0) {
                continue;
            }
            else if(counts[i] == 1) {
                System.out.println((i + 1) + " occurs 1 time.");
            } else {
                System.out.println((i + 1) + " occurs " + counts[i] + " times.");
            }
        }

    }
}
