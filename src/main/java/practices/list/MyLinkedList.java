package practices.list;

import java.util.Hashtable;

public class MyLinkedList {

    public static void main(String[] args) {
        Node head = null;
        head = addNode(head, 1);
        head = addNode(head, 2);
        head = addNode(head, 3);
        head = addNode(head, 4);
        head = addNode(head, 5);
        Node node = reverseIteratively(head);
        printList(node);
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.println(head.getData());
            head = head.next;
        }
    }

    public static void backPrintList(Node head) {
        if (head != null) {
            backPrintList(head.next);
            System.out.println(head.getData());
        }
    }

    public static Node addNode(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static Node deleteNode(Node head, int index) {
        if (index < 1 || index > length(head)) {
            return head;
        } else if (index == 1) {
            return head.next;
        } else {
            int i = 1;
            Node preNode = head;
            Node curNode = head.next;
            while (curNode != null) {
                if (i == index) {
                    preNode.next = curNode.next;
                    return head;
                } else {
                    preNode = curNode;
                    curNode = curNode.next;
                    i++;
                }
            }
            return head;
        }
    }

    public static int length(Node head) {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }

    public static Node orderList(Node head) {
        Node nextNode = null;
        int temp = 0;
        Node curNode = head;
        while (curNode.next != null) {
            nextNode = curNode.next;
            while (nextNode != null) {
                if (curNode.getData() > nextNode.getData()) {
                    temp = curNode.getData();
                    curNode.setData(nextNode.getData());
                    nextNode.setData(temp);
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }

    public static Node deleteDuplecate(Node head) {
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        Node curNode = head;
        Node preNode = null;
        while (curNode != null) {
            if (table.containsKey(curNode.getData())) {
                preNode.next = curNode.next;
            } else {
                table.put(curNode.getData(), 1);
                preNode = curNode;
            }
            curNode = curNode.next;
        }
        return head;
    }

    public static Node deleteDuplecateWithoutMap(Node head) {
        Node p = head;
        while (p != null) {
            Node q = p;
            while (q.next != null) {
                if (p.getData() == q.next.getData()) {
                    q.next = q.next.next;
                } else {
                    q = q.next;
                }
            }
            p = p.next;
        }
        return head;
    }

    public static Node findBackwardsElem(Node head, int k) {
        Node p = head;
        Node q = head;
        for (int i = 0; i < k - 1; i++) {
            q = q.next;
        }
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

    public static Node reverseIteratively(Node head) {
        Node reverseHead = head;
        Node curNode = head;
        Node preNode = null;
        while (curNode != null) {
            Node nextNode = curNode.next;
            if (curNode.next != null)
                reverseHead = nextNode;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return reverseHead;
    }

    public static Node searchMid(Node head) {
        Node p = head;
        Node q = head;
        while (q != null && q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        return p;
    }

    public static boolean deleteNode(Node n) {
        if (n == null || n.next == null) {
            return false;
        } else {
            n.setData(n.next.getData());
            n.next = n.next.next;
            return true;
        }
    }

}

class Node {
    Node next = null;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    private int data;

    public Node(int data) {
        this.data = data;
    }
}