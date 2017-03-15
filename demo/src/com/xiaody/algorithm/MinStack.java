package com.xiaody.algorithm;

import java.util.Stack;

/**
 * Created by Xiaody on 2017/3/1.
 */
public class MinStack {
    private int min;
    private Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0);
            min = x;
        } else {
            stack.push(x - min);
            if (x < min) min = x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        int pop = stack.pop();
        if (pop < 0) min = min - pop;
    }

    public int top() {
        int top = stack.peek();
        if (top > 0) {
            return top + min;
        } else {
            return min;
        }
    }

    public int getMin() {
        return min;
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.push(5);
        System.out.println(minStack.getMin());
        minStack.push(2);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.push(1);
        System.out.println(minStack.getMin());
    }
}
