package practices.stack;

public class ListStack<E> {

    private Node<E> top = null;

    public boolean isEmpty() {
        return top == null;
    }

    public E peek() {
        if (isEmpty())
            return null;
        return top.getData();
    }

    public E pop() {
        if (this.isEmpty())
            return null;
        E data = top.getData();
        top = top.next;
        return data;
    }

    public void push(E data) {
        Node<E> newNode = new Node<E>(data);
        newNode.next = top;
        top = newNode;
    }

}

class Node<E> {
    Node<E> next = null;

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    private E data;

    public Node(E data) {
        this.data = data;
    }
}
