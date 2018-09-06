package CodeInterview;

public class Chap1_4 {
    static boolean isPalindromePermutation(String str) {
        int[] letters = new int[128];

        int counter = 0;

        for(int i = 0; i < str.length(); i++) {
            int c = (int)str.charAt(i);
            letters[c]++;
        }

        for(int i = 0; i < letters.length; i++) {
            if((letters[i] % 2) != 0 && i != (int)' ') {
                    counter++;
            }
        }
        return (counter == 0 || counter == 1);
    }

    public static void main(String[] args) {
        String test = "tot".toLowerCase();
        System.out.print(isPalindromePermutation(test));
    }
}
