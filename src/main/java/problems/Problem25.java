package problems;

public class Problem25 {

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);
        RandomListNode node6 = new RandomListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node1.random = node4;
        node2.random = node6;
        node3.random = node5;
        node4.random = node1;
        node5.random = node2;
        node6.random = node3;
        Problem25 problem25 = new Problem25();
        RandomListNode clone = problem25.Clone(node1);
//        problem25.cloneNodes(node1);
//        problem25.connectRandomNodes(node1);
//        RandomListNode clone = problem25.reconnectNodes(node1);
        RandomListNode pNode = clone;
        while (pNode!=null){
            System.out.println(pNode.label);
            System.out.println(pNode.random.label+"\n");
            pNode = pNode.next;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        cloneNodes(pHead);
        connectRandomNodes(pHead);
        return reconnectNodes(pHead);
    }

    public void cloneNodes(RandomListNode pHead){
        RandomListNode curNode = pHead;
        while (curNode!=null){
            RandomListNode cloned = new RandomListNode(curNode.label);
            cloned.next = curNode.next;
            curNode.next = cloned;
            curNode = cloned.next;
        }
    }

    public void connectRandomNodes(RandomListNode pHead){
        RandomListNode curNode = pHead;
        while (curNode!=null){
            RandomListNode cloned = curNode.next;
            if (curNode.random!=null)
                cloned.random = curNode.random.next;
            curNode = cloned.next;
        }
    }

    public RandomListNode reconnectNodes(RandomListNode pHead){
        RandomListNode clonedHead = pHead.next;
        RandomListNode pNode = pHead;
        RandomListNode cloned = clonedHead;
        while (cloned.next!=null){
            pNode.next = cloned.next;
            cloned.next = pNode.next.next;
            pNode = pNode.next;
            cloned = cloned.next;
        }
        return clonedHead;
    }

}
