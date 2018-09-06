package Math225;

public class ex1 {

    /**
     * Calculate e^-x directly
     * @param x Exponent
     * @param n Number of terms
     * @return Estimate value of e^-x
     */

    static  double exp1(int x, int n) {
        double result = 0;
        for(int i = 0; i <= n; i++) {
            result += Math.pow(-x,i) / factorial(i);
        }
        return result;
    }

    /**
     * Calculates 1/(e^x)
     * @param x Exponent
     * @param n Number of terms
     * @return Estimate value of 1/e^x
     */
    static double exp2(int x, int n) {
        double denominator = 0;
        for(int i = 0; i <= n; i++) {
            denominator += Math.pow(x,i) / factorial(i);
        }
        return 1 / denominator;
    }

    /**
     * Calculate factorials
     * @param n A number
     * @return Value of n!
     */
    static int factorial(int n) {
        if(n == 0) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int exponent = 5;
        int numberOfTerms = 6;
        System.out.println("Number of terms = " + numberOfTerms + ": e^-" + exponent + " = ");
        System.out.println("Expression 1: " + exp1(exponent,numberOfTerms));
        System.out.println("Expression 2: " + exp2(exponent,numberOfTerms));
    }
}
