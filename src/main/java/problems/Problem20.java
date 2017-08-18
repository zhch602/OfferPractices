package problems;

import java.util.Stack;

public class Problem20 {

    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();

    public void push(int node) {
        data.push(node);
        if (min.isEmpty())
            min.push(node);
        else if (node <= min.peek())
            min.push(node);
    }

    public void pop() {
        if (min.peek().equals(data.pop()))
            min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }

}
