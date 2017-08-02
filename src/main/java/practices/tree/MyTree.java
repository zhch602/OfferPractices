package practices.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MyTree {

    public static void main(String[] args) {
        MyTree tree = new MyTree();
        int[] data = {2, 8, 7, 4, 9, 3, 1, 6, 7, 5};
//        tree.buildTree(data);
//        System.out.println("中：");
//        tree.inOrder();
//        System.out.println("先：");
//        tree.preOrder();
//        System.out.println("后：");
//        tree.postOrder();
//        tree.layerTranverse();
        int[] preOrder = {1, 2, 4, 5, 3, 6};
        int[] inOrder = {4, 2, 5, 1, 6, 3};
        tree.initTree(preOrder, inOrder);
//        tree.postOrder();
        tree.findMaxDistance(tree.root);
        System.out.println(tree.maxLen);
    }

    private Node root;
    private int maxLen = -1;

    //将data插入到排序二叉树中
    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    //将数值输入构建二叉树
    public void buildTree(int[] data) {
        for (int each : data) {
            insert(each);
        }
    }

    //中序遍历方法递归实现
    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            System.out.println(localRoot.data);
            inOrder(localRoot.right);
        }
    }

    public void inOrder() {
        this.inOrder(root);
    }

    //先序遍历方法递归实现
    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.println(localRoot.data);
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    public void preOrder() {
        this.preOrder(root);
    }

    //后序遍历方法递归实现
    public void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.println(localRoot.data);
        }
    }

    public void postOrder() {
        this.postOrder(root);
    }

    //层序遍历二叉树
    public void layerTranverse() {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.data);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }

    //已知先序遍历和中序遍历，求后序遍历

    public void initTree(int[] preOrder, int[] inOrder) {
        root = initTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public Node initTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        int rootData = preOrder[preStart];
        Node head = new Node(rootData);
        //找到根节点所在的位置
        int rootIndex = findIndexInArray(inOrder, rootData, inStart, inEnd);
        int offSet = rootIndex - inStart - 1;
        //构建左子树
        Node left = initTree(preOrder, preStart + 1, preStart + 1 + offSet, inOrder, inStart, inStart + offSet);
        //构建右子树
        Node right = initTree(preOrder, preStart + offSet + 2, preEnd, inOrder, rootIndex + 1, inEnd);
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

    //求二叉树中结点的最大距离
    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public void findMaxDistance(Node root) {
        if (root == null)
            return;
        if (root.left == null)
            root.leftMaxDistance = 0;
        else {
            findMaxDistance(root.left);
            root.leftMaxDistance = max(root.left.leftMaxDistance, root.left.rightMaxDistance) + 1;
        }
        if (root.right == null)
            root.rightMaxDistance = 0;
        else {
            findMaxDistance(root.right);
            root.rightMaxDistance = max(root.right.leftMaxDistance, root.right.rightMaxDistance) + 1;
        }
        if (root.leftMaxDistance + root.rightMaxDistance > maxLen)
            maxLen = root.leftMaxDistance + root.rightMaxDistance;
    }

}

class Node {
    public int data;
    public Node left;
    public Node right;
    public int leftMaxDistance;
    public int rightMaxDistance;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}


