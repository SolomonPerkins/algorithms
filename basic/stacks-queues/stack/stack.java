package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class stack {
    // initialize a stack
    public static Stack<Integer> initStack() {
        final Stack<Integer> s = new Stack();
        int[] vals = { 10, 4, 2, 35 };
        for (int i = 0; i < vals.length; i++) {
            s.push(vals[i]); // push item on to the stack.
        }
        return s;
    }

    // Given a stack use it to implemetn a queue
    static Queue<Integer> toQueue(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<Integer>(); // Queue is an interface, adding LinnkedList as an implementation.

        while (!s.empty()) {
            q.add(s.pop());
        }

        return q;
    }

    public static void main(String[] args) {
        Stack<Integer> s = initStack();
        while (!s.empty()) {
            System.out.printf("Stack value: %d\n", s.pop());
        }

        Queue q = toQueue(initStack());
        System.out.println("Queue values: ");
        while (q.peek() != null) {
            System.out.printf("-> %d", q.poll());
        }

    }

}
