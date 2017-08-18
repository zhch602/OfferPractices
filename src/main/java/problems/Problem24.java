package problems;

import java.util.ArrayList;

public class Problem24 {

    ArrayList<ArrayList<Integer>> allList = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root==null)
            return allList;
        list.add(root.val);
        target-=root.val;
        if (target==0&&root.left==null&&root.right==null)
            allList.add(new ArrayList<Integer>(list));
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return allList;
    }

}
