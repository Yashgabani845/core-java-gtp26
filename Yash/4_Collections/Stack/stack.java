import java.util.*;

public class StackQueueExample {

    public static void main(String[] args) {

        // ------------------------ STACK ------------------------
        Stack<Integer> stack = new Stack<>();


        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack after pushes: " + stack);

        System.out.println("Top element (peek): " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after pop: " + stack);


        // ------------------------ QUEUE ------------------------
        Queue<Integer> queue = new LinkedList<>();


        queue.add(100);
        queue.add(200);
        queue.add(300);

        System.out.println("Queue after adds: " + queue);

        System.out.println("Front element (peek): " + queue.peek());

        System.out.println("Removed element: " + queue.remove());
        System.out.println("Queue after remove: " + queue);
    }
}
