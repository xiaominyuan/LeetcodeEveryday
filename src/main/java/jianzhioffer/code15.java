//包含min函数的栈
//定义栈的数据结构，
// 请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
package jianzhioffer;

import java.util.Stack;

public class code15 {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node){
        data.push(node);
        if (min.isEmpty()){
            min.push(node);
        }

        if (node <= min.peek()){
            min.push(node);
        }
    }

    public void pop(){
        if (data.peek() == min.peek()){
            min.pop();
        }
        data.pop();
    }

    public int top(){
        return data.peek();
    }

    public int min(){
        return min.peek();
    }
}
