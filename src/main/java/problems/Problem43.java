package problems;

public class Problem43 {

    public static void main(String[] args) {
        Problem43 problem43 = new Problem43();
        System.out.println(problem43.LeftRotateString("abcdefg", 2));
    }

    public String LeftRotateString(String str, int n) {
        if (n > str.length())
            return "";
        String left = str.substring(0, n);
        String right = str.substring(n);
        return reverse(reverse(left) + reverse(right));
    }

    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

}
