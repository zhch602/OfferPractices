package problems;

public class Problem14 {

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0)
            return null;
        ListNode ahead = head;
        ListNode behind = head;
        for (int i = 0; i < k - 1; i++) {
            if (behind.next != null)
                behind = behind.next;
            else
                return null;

        }
        while (behind.next != null) {
            behind = behind.next;
            ahead = ahead.next;
        }
        return ahead;
    }

}
