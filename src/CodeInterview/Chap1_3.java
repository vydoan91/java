package CodeInterview;

public class Chap1_3 {
    static char[] replaceSpace(char[] str, int trueLength) {
        int numSpace = 0;
        for(int i = 0; i < trueLength; i++) {
            if(str[i] == ' ') {
                numSpace++;
            }
        }

        int index = trueLength + numSpace * 2;

        if(trueLength < str.length) {
            str[trueLength] = '\0';
        }

        for(int i = trueLength - 1; i >= 0; i--) {
            if(str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String test = "Mr John Smith                                 ";
        char[] content = test.toCharArray();
        char[] result = replaceSpace(content, 13);
        System.out.println(result);
    }
}
