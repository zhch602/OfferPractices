package problems;

public class Problem12 {

    public static void main(String[] args) {
        System.out.println(Power(2, -3));
    }

    public static double Power(double base, int exponent) {

        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        if (exponent < 0) {
            base = 1 / base;
            exponent = 0 - exponent;
        }
        double result = Power(base, exponent >> 1);
        result *= result;
        if (exponent % 2 == 1)
            result *= base;

        return result;

    }

}
