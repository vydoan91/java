package CS311.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class hw1 {
    //Write a Java, C/C++ program that implements a simple scanner for a source file given as a command-line argument.
    // The format of the tokens is described below.
    // You may assume that the input is syntactically correct.
    // Optionally, your program can build a symbol table (a hash table is a good choice),
    // which contains an entry for each token that was found in the input. When all the input has been read,
    // your program should produce a summary report that includes
    // 1. a list of all the tokens that appeared in the input,
    // 2. the number of times each token appears in the input and the class of each token.
    // Your program should also list how many times tokens of each catagory appeared in the input.
    //
    //Sample token format:
    //
    //	keyword -> if | then | else | begin | end
    //	identifier -> character | character identifier
    //	integer -> digit | digit integer
    //	real -> integer.integer
    //	special -> ( | ) | [ | ] | + | - | = | , | ;
    //	digit -> 0|1|2|3|4|5|6|7|8|9
    //	character -> a|b|c ... |z|A|B|C ... |Z
    //
    //More details:
    //
    //Case is not used to distinguish tokens.
    //The delimiters can be space, tab, newline, and special characters.
    //Choice at least 5 token classes or use the sample ones above.

    static class Token {
        String token, lexeme;
        Token(String token, String lexeme) {
            this.token = token;
            this.lexeme = lexeme;
        }
    }

    static public class LexicalAnalyzer {

        ArrayList<Token> list = new ArrayList<>();
        int caseNumber = 0;
        char c;

        LexicalAnalyzer(String filePath) {
            try {
                File file = new File(filePath);
                Scanner scanner = new Scanner(file);
                while(scanner.hasNext()) {
                    String current = scanner.next();
                    if(isNumeric(current)) {
                        caseNumber = 1;
                    } else if(isKeyWord(current)) {
                        caseNumber = 2;
                    } else if(isChar(current)) {
                        c = current.charAt(0);
                        caseNumber = 3;
                        if(c >= 'a' && c <= 'z') {
                            caseNumber = 4;
                        }
                    }
                    switch (caseNumber) {
                        case 1:
                            list.add(new Token("Numbers",current));
                            break;
                        case 2:
                            list.add(new Token("Keywords",current));
                            break;
                        case 3:
                            switch (c) {
                                case '=':
                                    list.add(new Token("Equal Sign",current));
                                    break;
                                case '*':
                                    list.add(new Token("Mult op",current));
                                    break;
                                case '<':
                                    list.add(new Token("Less than", current));
                                    break;
                                case ':':
                                    list.add(new Token("Semicolon", current));
                                    break;
                            }
                            break;
                        case 4:
                            list.add(new Token("Indentifier", current));
                            break;
                    }

                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean isNumeric(String str) {
            try{
                double d = Double.parseDouble(str);
            } catch (NumberFormatException | NullPointerException e){
                return false;
            }
            return true;
        }

        boolean isKeyWord(String str) {
            return str.equals("int") || str.equals("if");
        }
        boolean isChar(String str) {
            return str.length() == 1;
        }
    }

    public static void main(String[] args) {
        String file = "/Users/vydoan/Desktop/Self-Study/Java/src/CS311/hw1/input.txt";
        int numKW, numNum, ID, EO, LTO, MO;
        numKW = numNum = ID = EO = LTO = MO = 0;

        LexicalAnalyzer la = new LexicalAnalyzer(file);
        ArrayList<Token> list = la.list;

        for (Token aList : list) {
            String t = aList.token;
            switch (t) {
                case "Keywords":
                    numKW++;
                    break;
                case "Numbers":
                    numNum++;
                    break;
                case "Indentifier":
                    ID++;
                    break;
                case "Equal Sign":
                    EO++;
                    break;
                case "Less than":
                    LTO++;
                    break;
                case "Mult op":
                    MO++;
                    break;
            }
            System.out.println(t + " " + aList.lexeme);
        }
        System.out.println("-----------------------------");
        System.out.println("Number of keywords: " + numKW);
        System.out.println("Number of numbers: " + numNum);
        System.out.println("Number of Identifiers: " + ID);
        System.out.println("Number of Equal Sign: " + EO);
        System.out.println("Number of Less than operator: " + LTO);
        System.out.println("Number of Multiply operator: " + MO);
    }
}
