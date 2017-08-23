package problems;

public class Problem46 {

    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0)
            return -1;
        if (n < 1 || m < 1)
            return 1;
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

}
