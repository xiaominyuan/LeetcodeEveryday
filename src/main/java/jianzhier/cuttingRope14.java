//面试题14- I. 剪绳子
//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
//
//示例 1：
//
//输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package jianzhier;

public class cuttingRope14 {
    public int cuttingRope(int n) {
        if (n < 2){
            return 0;
        }

        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i<=n; i++){
            for (int j = 1; j< i; j++){
                //dp[i-j]*j  代表i-j 这段绳子还会继续分割
                //(i-j)*j   代表i-j不会分割了
                dp[i] = Math.max(dp[i], Math.max(dp[i-j]*j, (i-j)*j));
            }
        }

        return dp[n];
    }
}
