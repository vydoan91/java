package Chap7;// (Analyze scores) Write a program that reads an unspecified number of scores and
// determines how many scores are above or equal to the average and how many
// scores are below the average. Enter a negative number to signify the end of the
// input. Assume that the maximum number of scores is 100.
import java.util.Scanner;

public class Chap7$4 {
    public static void main(String[] args) {
        int sum = 0;
        int avg = 0;
        int scoresBelowAvg = 0;
        int scoresAboveAvg = 0;
        int counter = 0;
        int[] scores = new int[100];

        Scanner input = new Scanner(System.in);
        System.out.println("Enter scores: ");
        while(input.hasNextInt()) {
            int currentScore = input.nextInt();
            if(currentScore < 0) {
                break;
            }
            scores[counter] = currentScore;
            sum += currentScore;
            counter++;
        }
        avg = sum/(counter + 1);
        for(int i = 0; i < scores.length; i++) {
            if(scores[i] == 0) {
                continue;
            }
            if(scores[i] >= avg) {
                scoresAboveAvg++;
            } else {
                scoresBelowAvg++;
            }
        }
        System.out.println("Number of scores above average: " + scoresAboveAvg);
        System.out.println("Number of scores below average: " + scoresBelowAvg);
    }
}
