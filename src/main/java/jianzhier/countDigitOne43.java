//面试题43. 1～n整数中1出现的次数
//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
//
//例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
//
// 
//
//示例 1：
//
//输入：n = 12
//输出：5
//示例 2：
//
//输入：n = 13
//输出：6
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package jianzhier;

public class countDigitOne43 {
    public int countDigitOne(int n) {
        return dfs(n);
    }

    public int dfs(int n){
        if (n <= 0){
            return 0;
        }

        String str = String.valueOf(n);
        int high = str.charAt(0) - '0';
        int pow = (int) Math.pow(10, str.length()-1);
        int left = n - high*pow;

        if (high == 1){
            //dfs(pow) 0-999之间包含1的
            //left + 1 最高位为1
            //dfs(left) 低位包含1
            return dfs(pow-1) + left + 1+ dfs(left);
        }else{
            return pow + high*dfs(pow-1) + dfs(left);
        }
    }
}
