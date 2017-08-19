package problems;

public class Problem31 {

    public static void main(String[] args) {
        Problem31 problem31 = new Problem31();
        System.out.println(problem31.NumberOf1Between1AndN_Solution(21345));
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int times = 0, current, addOne = 0, powerOfTen = 0, n2 = n;
        while (n > 0) {
            current = n % 10;
            n /= 10;
            if (current > 1) {
                addOne = 1;
            } else if (current == 1) {
                times += (n2 % Math.pow(10, powerOfTen)) + 1;
            }
            times += (n + addOne) * Math.pow(10, powerOfTen);
            powerOfTen++;
            addOne = 0;
        }
        return times;
    }

}
