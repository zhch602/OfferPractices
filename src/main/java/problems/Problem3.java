package problems;

import java.util.ArrayList;
import java.util.Stack;


public class Problem3 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        Stack<Integer> stack = new Stack<Integer>();
        ListNode pNode = listNode;
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (pNode != null) {
            stack.push(pNode.val);
            pNode = pNode.next;
        }

        while (!stack.empty()) {
            list.add(stack.pop());
        }

        return list;
    }

}
