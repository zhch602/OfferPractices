package problems;

public class problem15 {

    public ListNode ReverseList(ListNode head) {
        ListNode curNode = head;
        ListNode preNode = null;
        ListNode nextNode = null;
        ListNode reversedNode = null;
        while (curNode != null) {
            nextNode = curNode.next;
            if (nextNode == null)
                reversedNode = curNode;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return reversedNode;
    }

}
