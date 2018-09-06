package CodeInterview;

public class Chap1_6 {
    static String compressStr(String str) {
        char tempChar = str.charAt(0);
        int counter = 0;
        StringBuilder newStr = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == tempChar) {
                counter++;
            } else {
                newStr.append(tempChar);
                newStr.append(counter);
                tempChar = str.charAt(i);
                counter = 1;
            }
        }

        newStr.append(tempChar);
        newStr.append(counter);

        if(newStr.toString().length() >= str.length()) {
            return str;
        }
        return newStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressStr("Aabbbbcca"));
    }
}
