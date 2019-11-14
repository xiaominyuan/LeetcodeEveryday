//斐波那契数列
//大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
//n<=39

package jianzhioffer;

public class code6 {
    public int Fibonacci(int n) {
        int preNum = 1;
        int preLastNum = 0;
        if (n == 0){
            return preLastNum;
        }

        if (n == 1){
            return preNum;
        }

        int result = 0;

        for (int i = 2; i<= n; i++){
            result = preLastNum + preNum;
            preLastNum = preNum;
            preNum = result;
        }

        return result;
    }
}
