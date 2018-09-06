package Chap8;

//(Sort students on grades) Rewrite Listing 8.2, GradeExam.java, to display the
//        students in increasing order of the number of correct answers
public class Chap8$3 {
    public static void main(String[] args) {
        char[][] answers = {{'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
                {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
                {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
                {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};
        // Key to the questions
        char[] keys = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};
        int[] numberOfCorrectAnswer = new int[answers.length];
        for (int i = 0; i < answers.length; i++) {
            int count = 0;
            for (int j = 0; j < answers[i].length; j++) {
                if (answers[i][j] == keys[j]) {
                    count++;
                }
            }
            numberOfCorrectAnswer[i] = count;
        }
        int[] currentArray = numberOfCorrectAnswer;
        for(int i = 0; i < numberOfCorrectAnswer.length; i++) {
            int minIndex = getMinIndex(currentArray);
            System.out.println("Student " + minIndex + "'s correct count is " + numberOfCorrectAnswer[minIndex]);
            currentArray = removedIndexArray(currentArray,minIndex);
        }
    }
    private static int getMinIndex(int[] array) {
        int min = array[0];
        int minIndex = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    private static int[] removedIndexArray(int[] original, int index) {
        int[] newArray = new int[original.length - 1];
        for(int i = 0; i < original.length; i++) {
            if(i >= index) {
                newArray[i] = original[i+1];
            } else {
                newArray[i] = original[i];
            }
        }
        return newArray;
    }
}
