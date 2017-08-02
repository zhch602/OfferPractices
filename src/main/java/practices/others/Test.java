package practices.others;

public class Test {

    public static void main(String[] args) {

        String s1 = "(1,(2,3),(4,(5,6),7)";
        String s2 = "(1,(2,3),(4,(5,6),7))";

//        System.out.println(changeStr(s1));
//        System.out.println(changeStr(s2));

        System.out.println(max(3,5));
        System.out.println(min(3,5));

    }

    //消除嵌套的括号
    public static String changeStr(String s) {
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        int bracketNum = 0;
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == '(')
                bracketNum++;
            else if (chars[i] == ')')
                if (bracketNum > 0)
                    bracketNum--;
                else {
                    System.out.println("Error!");
                    return null;
                }
            else if (chars[i] == ',')
                result.append(chars[i]);
            else if (chars[i] >= '0' && chars[i] <= '9')
                result.append(chars[i]);
            else {
                System.out.println("Error!");
                return null;
            }
            i++;
        }
        if (bracketNum > 0) {
            System.out.println("Error!");
            return null;
        }
        return result.toString();
    }

    //不使用比较运算符求出两个数的较大值和较小值
    public static int max(int a, int b) {
        return (int) ((long) a + (long) b + Math.abs((long) a - (long) b)) / 2;
    }

    public static int min(int a, int b) {
        return (int) ((long) a + (long) b - Math.abs((long) a - (long) b)) / 2;
    }

}
