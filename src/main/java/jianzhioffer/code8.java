//变态挑台阶
//一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

package jianzhioffer;


//下一级台阶的方法 = 这一节台阶的方法 * 2
public class code8 {
    public int JumpFloorII(int target) {
        int res = 2;
        if (target == 1 || target == 2){
            return target;
        }

        if (target <= 0){
            return -1;
        }

        for (int i = 3; i<= target; i++){
            res = res * 2;
        }

        return res;
    }
}
