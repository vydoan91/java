package Chap7;//(Count single digits) Write a program that generates 100 random integers between
//        0 and 9 and displays the count for each number. (Hint: Use an array of ten integers,
//        say counts, to store the counts for the number of 0s, 1s, . . . , 9s.)

public class Chap7$7 {
    public static void main(String[] args) {
        final int NUMBER_OF_INTEGERS = 100;
        int[] counts = new int[10];
        System.out.println("100 random single-digit numbers: ");
        for(int i = 0; i < NUMBER_OF_INTEGERS; i++) {
            int random = (int)(Math.random() * 10);
            System.out.print(random + " ");
            counts[random]++;
        }
        System.out.println("\nCounts for numbers:");
        for(int i = 0; i < counts.length; i++) {
            System.out.println("Numbers: " + i + ", count: " + counts[i]);
        }
    }
}

