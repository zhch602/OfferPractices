package problems;

import java.util.Stack;

public class Problem21 {

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};
        System.out.println(IsPopOrder(push, pop));
    }

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        int nextPush = 0;
        int nextPop = 0;
        stack.push(pushA[nextPush++]);
        while (nextPop < popA.length) {
            if (stack.peek() == popA[nextPop]) {
                nextPop++;
                stack.pop();
            } else if (nextPush < pushA.length) {
                stack.push(pushA[nextPush++]);
            } else
                return false;
        }
        return stack.isEmpty();
    }

}
