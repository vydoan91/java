package Chap7;

import java.util.Scanner;
public class Chap7$1 {
    public static void main(String[] args) {
        int[] scores;
        int numberOfStudents;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        numberOfStudents = input.nextInt();
        scores = new int[numberOfStudents];

        System.out.print("Enter 4 scores: ");
        for(int i = 0; i < numberOfStudents; i++) {
            scores[i] = input.nextInt();
        }

        int bestScore = scores[0];
        for(int i = 0; i < numberOfStudents; i++) {
            if(bestScore < scores[i]) {
                bestScore = scores[i];
            }
        }

        for(int i = 0; i < numberOfStudents; i++) {
            if(scores[i] >= bestScore - 10) {
                System.out.println("Student " + i + " score is " + scores[i] + " and grade is A");
            } else if(scores[i] >= bestScore - 20) {
                System.out.println("Student " + i + " score is " + scores[i] + " and grade is B");
            } else if(scores[i] >= bestScore - 30) {
                System.out.println("Student " + i + " score is " + scores[i] + " and grade is C");
            } else if(scores[i] >= bestScore - 40) {
                System.out.println("Student " + i + " score is " + scores[i] + " and grade is D");
            } else {
                System.out.println("Student " + i + " score is " + scores[i] + " and grade is F");
            }
        }
    }
}
