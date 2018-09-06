package Chap7;//(Revise Listing 5.15, PrimeNumber.java) Listing 5.15 determines whether a number
//        n is prime by checking whether 2, 3, 4, 5, 6, . . . , n/2 is a divisor. If a divisor
//        is found, n is not prime. A more efficient approach is to check whether any of the
//        prime numbers less than or equal to sqrt(n) can divide n evenly. If not, n is prime.
//        Rewrite Listing 5.15 to display the first 50 prime numbers using this approach.
//        You need to use an array to store the prime numbers and later use them to check
//        whether they are possible divisors for n.

public class Chap7$6 {
    public static void main(String[] args) {
        int numberOfPrime = 0;
        int n = 2;
        int[] prime = new int[50];
        int index = 0;

        System.out.println("The first 50 prime numbers are:");

        while(numberOfPrime < prime.length) {
            double sqrt = Math.sqrt(n);
            boolean isPrime = true;

            for(int i = 0; prime[i] <= sqrt; i++) {
                if(prime[i] == 0) {
                    break;
                }
                if(n % prime[i] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                numberOfPrime++;
                prime[index] = n;
                index++;
            }
            n++;
        }
        for(int item : prime) {
            System.out.print(item + " ");
        }
    }
}
