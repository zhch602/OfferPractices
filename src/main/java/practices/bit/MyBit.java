package practices.bit;

public class MyBit {

    public static void main(String[] args) {
    }

    public static int powerN(int m, int n) {
        return m << n;
    }

    public static boolean isPower(int n) {
        if (n < 1)
            return false;
        int m = n & (n - 1);
        return m == 0;
    }

    public static int countOne(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

}
