package 基础算法题总结.队列和栈;

import java.util.Stack;

/**
 * 栈实现队列的思路：构建两个栈：Push栈和Pop栈；将Push栈中的数据倒入Pop栈中然后返回给用户，就实现了队列。需要注意两个条件：①Pop栈为空时才能其中倒入数据。②向Pop栈倒入数据时必须要倒完。
 *
 * ①如果两栈都为空，报异常；②如果出队栈有元素就出队；③如果出队栈为空，就把入队栈的元素都弹过来再出队。
 */
public class 栈实现队列 {
    public class TwoStacks_Queue {
        Stack<Integer> stackPush = new Stack<>();
        Stack<Integer> stackPop = new Stack<>();

        public void push(int p) {
            stackPush.push(p);
        }

        public int poll() { //队列命名为 poll
            if (stackPush.isEmpty() && stackPop.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek() {
            if (stackPush.isEmpty() && stackPop.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }
}
