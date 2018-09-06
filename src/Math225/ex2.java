package Math225;

// bisection algorithm
class ex2 {
    static double f(double a) {
        return Math.pow(a,2) - 18;
    }

    static double bisection(double start, double end, double error) {
        double a = start;
        double b = end;
        double mid = 0;
        while(Math.abs(f(mid)) > error) {
            mid = (a + b) / 2;
            if(f(mid) * f(a) > 0) {
                a = mid;
            } else if(f(mid) * f(b) > 0) {
                b = mid;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(bisection(4,5,0.01));
    }
}
