package Chap7;

import java.util.Scanner;
public class Chap7$2 {
    public static void main(String[] args) {
        int numberOfInt = 10;
        int[] reversedList = new int[numberOfInt];

        Scanner input = new Scanner(System.in);
        System.out.print("Enter 10 integers: ");
        for(int i = numberOfInt - 1; i >= 0; i--) {
            reversedList[i] = input.nextInt();
        }

        for(int integer : reversedList) {
            System.out.print(integer + " ");
        }
    }
}
