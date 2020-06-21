package JZ.topic1;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class T_20_StackMin {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (stackMin.isEmpty()) {
            stackMin.push(node);
        } else {
            stackMin.push(stackMin.peek() > node ? node : stackMin.peek());
        }
    }

    public void pop() {
        stack.pop();
        stackMin.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}
