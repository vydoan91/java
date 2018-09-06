package CodeInterview;


//    Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
//    Hints: #44, # 117, # 132

public class Chap1_1 {
    public static boolean isUnique(String string) {
        int[] list = new int[26];
        String str = string.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            Character currentChar = str.charAt(i);
            int index = currentChar - 'a';
            list[index]++;
        }
        for (int item : list) {
            if (item > 1) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String testString = "tuna";
        System.out.println("The string hass all unique characters? " + isUnique(testString));
        }
}
