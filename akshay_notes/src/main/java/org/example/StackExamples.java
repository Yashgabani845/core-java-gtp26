package org.example;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * StackExamples - demonstrates stack usage in Java.
 * Shows:
 *  - legacy Stack
 *  - ArrayDeque used as stack (recommended)
 *  - LinkedList used as stack
 *  - ConcurrentLinkedDeque (thread-safe)
 *  - LinkedBlockingDeque as blocking stack (producer/consumer)
 *
 * Also includes:
 *  - Expression evaluation (infix -> postfix -> evaluate)
 *  - Simple undo example
 */
public class StackExamples {

    public static void main(String[] args) {
        legacyStackDemo();
        arrayDequeStackDemo();
        linkedListStackDemo();
        concurrentStackDemo();
        blockingStackDemo();
        infixExpressionEvalDemo();
        undoExampleDemo();
    }

    // -----------------------------
    // 1) Legacy java.util.Stack demo
    // -----------------------------
    static void legacyStackDemo() {
        System.out.println("\n--- Legacy Stack demo ---");
        Stack<String> stack = new Stack<>();

        stack.push("one");
        stack.push("two");
        stack.push("three");

        System.out.println("Stack (top is right): " + stack); // [one, two, three]
        System.out.println("peek(): " + stack.peek()); // three
        System.out.println("pop(): " + stack.pop());   // removes three
        System.out.println("after pop: " + stack);

        // search(Object) returns 1-based position from top (top element = 1)
        System.out.println("search(\"one\"): " + stack.search("one")); // 2 (because two is above one)
        System.out.println("empty()? " + stack.empty());
    }

    // ---------------------------------
    // 2) ArrayDeque used as stack (recommended)
    // ---------------------------------
    static void arrayDequeStackDemo() {
        System.out.println("\n--- ArrayDeque as Stack (recommended) ---");
        Deque<Integer> stack = new ArrayDeque<>();

        // push/pop/peek are available on Deque
        stack.push(10); // addFirst
        stack.push(20);
        stack.push(30);

        System.out.println("Stack top element (peek): " + stack.peek()); // 30
        System.out.println("pop(): " + stack.pop()); // 30
        System.out.println("after pop: " + stack);

        // iterate from top to bottom using iterator() which returns elements from head (top)
        System.out.println("iterate (top->bottom):");
        for (Integer x : stack) System.out.println(x);


        // important: ArrayDeque does NOT allow null elements
        try {
            stack.push(null); // throws NullPointerException
        } catch (NullPointerException npe) {
            System.out.println("ArrayDeque does not allow null: " + npe);
        }
    }

    // ---------------------------
    // 3) LinkedList used as stack
    // ---------------------------
    static void linkedListStackDemo() {
        System.out.println("\n--- LinkedList as Stack ---");
        Deque<String> stack = new LinkedList<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println("pop(): " + stack.pop()); // C
        System.out.println("contains(\"A\")? " + stack.contains("A")); // true

        // LinkedList allows null elements
        stack.push(null);
        System.out.println("After adding null: " + stack);
        stack.remove(null); // remove first occurrence of null
        System.out.println("After removing null: " + stack);
    }

    // -----------------------------------------
    // 4) ConcurrentLinkedDeque (non-blocking thread-safe)
    // -----------------------------------------
    static void concurrentStackDemo() {
        System.out.println("\n--- ConcurrentLinkedDeque as concurrent stack ---");
        ConcurrentLinkedDeque<Integer> stack = new ConcurrentLinkedDeque<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("pop(): " + stack.pop()); // 3
        System.out.println("peek(): " + stack.peek()); // 2

        // good for concurrent producers/consumers that need stack behavior
    }

    // -------------------------------------------------------
    // 5) LinkedBlockingDeque - blocking stack (producer/consumer)
    // -------------------------------------------------------
    static void blockingStackDemo() {
        System.out.println("\n--- LinkedBlockingDeque as blocking stack example (demo threads not started) ---");
        LinkedBlockingDeque<String> stack = new LinkedBlockingDeque<>();

        // blocking operations:
        try {
            // putFirst blocks if deque is full (bounded constructor), here unbounded so won't block
            stack.putFirst("job1");
            System.out.println("putFirst succeeded, size: " + stack.size());

            // takeFirst blocks until element available (useful in consumer thread)
            String item = stack.takeFirst(); // will take "job1"
            System.out.println("takeFirst returned: " + item);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Note: LinkedBlockingDeque is useful when you need blocking behavior across threads.
    }

    // -------------------------------------------------------
    // 6) Expression evaluation example using ArrayDeque stack
    //    (convert infix to postfix (shunting-yard simplified) then evaluate)
    // -------------------------------------------------------
    static void infixExpressionEvalDemo() {
        System.out.println("\n--- Infix Expression Eval Demo ---");
        String expr = "3 + 4 * 2 - ( 1 - 5 )";
        System.out.println("expr: " + expr);

        List<String> tokens = Arrays.asList(expr.split("\\s+"));
        List<String> postfix = infixToPostfix(tokens);
        System.out.println("postfix: " + postfix);

        int result = evaluatePostfix(postfix);
        System.out.println("evaluation result: " + result);
    }

    // helper: precedence
    static int precedence(String op) {
        return switch (op) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> -1;
        };
    }

    // convert tokens (space-separated) infix -> postfix (shunting-yard simplified)
    static List<String> infixToPostfix(List<String> tokens) {
        List<String> output = new ArrayList<>();
        Deque<String> ops = new ArrayDeque<>(); // operator stack

        for (String t : tokens) {
            if (t.isBlank()) continue;
            if (t.matches("\\d+")) {
                output.add(t);
            } else if ("(".equals(t)) {
                ops.push(t);
            } else if (")".equals(t)) {
                while (!ops.isEmpty() && !"(".equals(ops.peek())) {
                    output.add(ops.pop());
                }
                if (!ops.isEmpty() && "(".equals(ops.peek())) ops.pop(); // pop "("
            } else { // operator
                while (!ops.isEmpty() && !"(".equals(ops.peek()) &&
                        precedence(ops.peek()) >= precedence(t)) {
                    output.add(ops.pop());
                }
                ops.push(t);
            }
        }
        while (!ops.isEmpty()) output.add(ops.pop());
        return output;
    }

    // evaluate postfix list of tokens
    static int evaluatePostfix(List<String> postfix) {
        Deque<Integer> st = new ArrayDeque<>();
        for (String tok : postfix) {
            if (tok.matches("\\d+")) {
                st.push(Integer.parseInt(tok));
            } else {
                int b = st.pop();
                int a = st.pop();
                int res = switch (tok) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> a / b;
                    default -> 0;
                };
                st.push(res);
            }
        }
        return st.pop();
    }

    // -------------------------------------------------------
    // 7) Simple undo example using Deque stack
    // -------------------------------------------------------
    static void undoExampleDemo() {
        System.out.println("\n--- Undo example demo ---");
        Deque<String> undoStack = new ArrayDeque<>();
        String state = "";

        // do operations and push reverse operation (simple strings)
        state = applyOperation(state, "type:Hello", undoStack);
        state = applyOperation(state, "type: World", undoStack);
        System.out.println("current state: " + state);

        // undo last operation
        if (!undoStack.isEmpty()) {
            String undoAction = undoStack.pop();
            System.out.println("undoAction: " + undoAction);
            // in real app you'd parse undoAction and apply reverse
            // here we just demonstrate popping the stack
        }
    }

    static String applyOperation(String state, String op, Deque<String> undoStack) {
        // naive example: append text
        if (op.startsWith("type:")) {
            String toAdd = op.substring("type:".length());
            // push reverse operation onto undo stack (delete last n chars)
            undoStack.push("delete:" + toAdd.length());
            return state + toAdd;
        }
        return state;
    }
}
