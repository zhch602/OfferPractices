package problems;

public class Problem2 {

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy.");
        System.out.println(replaceSpace(str));
    }

    public static String replaceSpace(StringBuffer str) {

        return str.toString().replaceAll(" ", "%20");
    }

}
