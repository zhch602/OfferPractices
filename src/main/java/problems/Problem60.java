package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem60 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int nextLevel = 0;
        int toBePrinted = 1;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null)
            return lists;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevel++;
            }
            queue.poll();
            toBePrinted--;
            if (toBePrinted == 0) {
                lists.add(list);
                list = new ArrayList<Integer>();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
        return lists;
    }

}
