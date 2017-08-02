package practices.stack;

import java.util.Arrays;

public class ArrayStack<E> {

    public static void main(String[] args) {
        ArrayStack<Integer> s = new ArrayStack<Integer>();
        s.push(1);
        s.push(2);
        System.out.println(s.size);
        System.out.println(s.pop());
    }

    private Object[] stack;
    private int size;

    public ArrayStack() {
        stack = new Object[10];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E peek() {
        if (isEmpty())
            return null;
        else
            return (E) stack[size - 1];

    }

    public E pop() {
        E e = peek();
        stack[size - 1] = null;
        size--;
        return e;
    }

    public E push(E item) {
        ensureCapacity(size + 1);
        stack[size++] = item;
        return item;
    }

    public void ensureCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            int newLen = 10;
            stack = Arrays.copyOf(stack, newLen);
        }
    }

}
