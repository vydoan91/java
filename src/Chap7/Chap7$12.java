package Chap7;

//(Reverse an array) The reverse method in Section 7.7 reverses an array by
//        copying it to a new array. Rewrite the method that reverses the array passed in
//        the argument and returns this array. Write a test program that prompts the user to
//        enter ten numbers, invokes the method to reverse the numbers, and displays the
//        numbers.
public class Chap7$12 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] newArray = reverse(array);
        for(int item : newArray) {
            System.out.print(item + " ");
        }
    }
    public static int[] reverse(int[] original) {
        for(int i = 0, j = original.length - 1; i < original.length / 2; i++, j--) {
            int temp = original[i];
            original[i] = original[j];
            original[j] = temp;
        }
        return original;
    }
}

