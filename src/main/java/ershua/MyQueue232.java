
//232. 用栈实现队列
package ershua;

import java.util.Stack;

public class MyQueue232 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue232(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x){
        stack1.push(x);
    }

    public int pop(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public int peek(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    public boolean empty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }


}
