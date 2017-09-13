package problems;

public class Problem62 {

    int k;

    TreeNode KthNode(TreeNode pRoot, int k) {
        this.k=k;
        if (pRoot == null || k <= 0)
            return null;
        return KthNodeCore(pRoot);
    }

    private TreeNode KthNodeCore(TreeNode pRoot) {
        TreeNode temp = null;
        if (pRoot != null) {
            if ((temp = KthNodeCore(pRoot.left)) != null)
                return temp;
            if (--k == 0)
                return pRoot;
            if ((temp = KthNodeCore(pRoot.right)) != null)
                return temp;
        }
        return null;
    }

}
