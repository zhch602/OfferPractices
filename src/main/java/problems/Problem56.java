package problems;

public class Problem56 {

    public ListNode deleteDuplication(ListNode pHead) {
        ListNode result;
        ListNode temp = pHead;
        ListNode index = new ListNode(1);
        index.next = pHead;
        result = index;
        while (temp != null) {
            if (temp.next != null && temp.next.val == temp.val) {
                while (temp.next != null && temp.next.val == temp.val) {
                    temp = temp.next;
                }
                temp = temp.next;
                index.next = temp;
            } else {
                index = index.next;
                temp = temp.next;
            }
        }
        return result.next;
    }

}
