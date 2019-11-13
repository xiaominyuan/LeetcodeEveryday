//用两个栈实现队列
//用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

package jianzhioffer;

import java.util.Stack;

public class code4 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        while (!stack2.isEmpty()){
            stack1.push(stack1.pop());
        }
        stack1.push(node);
    }

    public int pop(){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        return stack1.pop();
    }
}
