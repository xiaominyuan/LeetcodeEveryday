package HashTable;

import java.util.Arrays;
import java.util.Stack;

public class code739 {
    //方法一 ： 暴力遍历
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        Arrays.fill(res, 0);
        for (int i = 0; i< len - 1; i++){
            int nowTmp = T[i];
            for (int j = i+1; j<len; j++){
                if (T[j] > nowTmp){
                    res[i] = j - i;
                    break;
                }
            }
        }

        return res;
    }

    //方法二 ： 栈
    public int[] dailyTemperatures2(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = T.length - 1; i>= 0; i--){
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]){
                stack.pop();
            }
            if (stack.isEmpty()){
                res[i] = 0;
            }else{
                res[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return res;
    }
}
