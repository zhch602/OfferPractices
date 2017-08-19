package problems;

public class Problem26 {

    TreeNode lastLeft = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            lastLeft = pRootOfTree;
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);
        if (left != null) {
            lastLeft.right = pRootOfTree;
            pRootOfTree.left = lastLeft;
        }
        lastLeft = pRootOfTree;
        TreeNode right = Convert(pRootOfTree.right);
        if (right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        if (left == null)
            return pRootOfTree;
        else return left;
    }

}
