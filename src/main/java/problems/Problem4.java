package problems;

public class Problem4 {


    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        return initTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode initTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        int rootData = preOrder[preStart];
        TreeNode head = new TreeNode(rootData);
        //找到根节点所在的位置
        int rootIndex = findIndexInArray(inOrder, rootData, inStart, inEnd);
        int offSet = rootIndex - inStart - 1;
        //构建左子树
        TreeNode left = initTree(preOrder, preStart + 1, preStart + 1 + offSet, inOrder, inStart, inStart + offSet);
        //构建右子树
        TreeNode right = initTree(preOrder, preStart + offSet + 2, preEnd, inOrder, rootIndex + 1, inEnd);
        head.left = left;
        head.right = right;
        return head;
    }

    public int findIndexInArray(int[] a, int x, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            if (a[i] == x)
                return i;
        }
        return -1;
    }

}
