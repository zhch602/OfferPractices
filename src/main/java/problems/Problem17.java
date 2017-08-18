package problems;

public class Problem17 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if (root2 != null && root1 != null) {
            if(root1.val == root2.val){
                result = doesTree1HaveTree2(root1,root2);
            }
            if (!result) {
                result = HasSubtree(root1.left,root2);
            }
            if (!result) {
                result = HasSubtree(root1.right,root2);
            }
        }
        return result;
    }

    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        return node2 == null || node1 != null && node1.val == node2.val && doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
    }

}
