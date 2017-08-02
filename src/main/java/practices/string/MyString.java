package practices.string;

import java.util.HashSet;
import java.util.Set;

public class MyString {

    public static void main(String[] args) {
        String s1 = "abc123";
        String s2 = "321acb";
        String s3 = "aabbcc";
//        System.out.println(compare(s1, s2));
        String s4 = "abc";
//        combineRecursive(s4,new StringBuffer(""));
        combine(s4);
    }

    /**
     * 反转字符数组
     *
     * @param cArr  数组
     * @param begin 起始
     * @param end   结束
     */
    public static void swap(char[] cArr, int begin, int end) {
        while (begin < end) {
            char temp = cArr[end];
            cArr[end] = cArr[begin];
            cArr[begin] = temp;
            begin++;
            end--;
        }
    }

    /**
     * 实现字符串的反转
     *
     * @param s String
     * @return swapWords
     */
    public static String swapWords(String s) {
        char[] cArr = s.toCharArray();
        int len = cArr.length;
        swap(cArr, 0, len - 1);
        int begin = 0;
        for (int i = 0; i < len; i++) {
            if (cArr[i] == ' ') {
                swap(cArr, begin, i - 1);
                begin = i + 1;
            }
        }
        swap(cArr, begin, len - 1);
        return new String(cArr);
    }

    /**
     * 判断两个字符串是否由相同的字符组成
     *
     * @param s1 s1
     * @param s2 s2
     * @return bool
     */
    public static boolean compare(String s1, String s2) {
        byte[] b1 = s1.getBytes();
        byte[] b2 = s2.getBytes();
        int[] bCount = new int[256];
        for (byte b : b1) {
            bCount[b - '0']++;
        }
        for (byte b : b2) {
            bCount[b - '0']--;
        }
        for (int i : bCount) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 删除字符串中重复的字符
     *
     * @param s String
     * @return sb
     */
    public static String removeDuplicate(String s) {
        StringBuilder sb = new StringBuilder();
        char[] b = s.toCharArray();
        int[] bCount = new int[256];
        for (char each : b) {
            if (bCount[each - '0'] == 0) {
                bCount[each - '0']++;
                sb.append(each);
            }
        }
        return sb.toString();
    }

    /**
     * 统计一行字符中有多少个单词
     *
     * @param s String
     * @return count
     */
    public static int wordCount(String s) {
//        String[] words = s.split(" ");
//        return words.length;
        int word = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                word = 0;
            else if (word == 0) {
                word = 1;
                count++;
            }
        }
        return count;
    }

    public static void combineRecursive(String s, StringBuffer sb) {
        if (s.length() == 0) {
            System.out.println(sb);
            return;
        }
        sb.append(s.charAt(0));
        combineRecursive(s.substring(1), sb);
        sb.deleteCharAt(sb.length() - 1);
        combineRecursive(s.substring(1), sb);
    }

    public static void combine(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[] used = new boolean[len];
        char[] cache = new char[len];
        int result = len;
        while (true) {
            int index = 0;
            while (used[index]) {
                used[index] = false;
                result++;
                if (++index == len)
                    return;
            }
            used[index] = true;
            cache[--result] = chars[index];
            System.out.println(new String(cache).substring(result));
        }
    }

}
