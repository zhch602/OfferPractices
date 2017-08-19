package problems;

public class Problem33 {

    public int GetUglyNumber_Solution(int index) {
        if (index == 0)
            return 0;
        int[] ugly = new int[index];
        ugly[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < index; i++) {
            ugly[i] = min(ugly[t2] * 2, ugly[t3] * 3, ugly[t5] * 5);
            if (ugly[i] == ugly[t2] * 2)
                t2++;
            if (ugly[i] == ugly[t3] * 3)
                t3++;
            if (ugly[i] == ugly[t5] * 5)
                t5++;
        }
        return ugly[index - 1];
    }

    private int min(int a, int b, int c) {
        int temp = (a < b) ? a : b;
        return (temp < c) ? temp : c;
    }

}
