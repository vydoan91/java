package CodeInterview;

public class Chap1_5 {
    static boolean isOneEdit(String str1, String str2) {
        int lengthDiff = str1.length() - str2.length();

        if(lengthDiff >= 2) {
            return false;
        }

        if(str1.equals(str2)) {
            return true;
        }

        String longStr, shortStr;
        if(lengthDiff == 1 || lengthDiff == -1) {
            if(lengthDiff == 1) {
                longStr = str1;
                shortStr = str2;
            } else {
                longStr = str2;
                shortStr = str1;
            }

            // Case 1 and 2:
            // remove last character
            String newStr = longStr.substring(0, longStr.length() - 1);
            if(newStr.equals(shortStr)) {
                return true;
            }

            // for loop to check each char

            for(int i = 0; i < longStr.length() - 1; i++) {
                if(longStr.charAt(i) != shortStr.charAt(i)) {
                    newStr = longStr.substring(0,i) + longStr.substring(i+1,longStr.length());
                    if(newStr.equals(shortStr)) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
        }


        // Case 3:

        if(lengthDiff == 0) {
            int numberOfDiff = 0;
            for(int i = 0; i < str1.length() - 1; i++) {
                if(str1.charAt(i) != str2.charAt(i)) {
                    numberOfDiff++;
                    if(numberOfDiff > 1) {
                        break;
                    }
                }
            }
            if(numberOfDiff == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.print(isOneEdit("aple", "apple"));
    }
}
