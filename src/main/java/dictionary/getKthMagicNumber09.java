//面试题 17.09. 第 k 个数
//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
//
//示例 1:
//
//输入: k = 5
//
//输出: 9
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/get-kth-magic-number-lcci
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package dictionary;

public class getKthMagicNumber09 {
    public int getKthMagicNumber(int k) {
        int p3 = 0;
        int p5 = 0;
        int p7 = 0;
        int[] dp = new int[k];
        dp[0] = 1;
        for (int i = 1; i< k; i++){
            dp[i] = Math.min(dp[p3]*3, Math.min(dp[p5]*5, dp[p7]*7));
            if (dp[i] == dp[p3]*3){
                p3++;
            }
            if (dp[i] == dp[p5]*5){
                p5++;
            }
            if (dp[i] == dp[p7]*7){
                p7++;
            }
        }

        return dp[k-1];
    }
}
