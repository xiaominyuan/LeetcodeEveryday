//494. 目标和
//        给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
//
//        返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
//
//        示例 1:
//
//        输入: nums: [1, 1, 1, 1, 1], S: 3
//        输出: 5
//        解释:
//
//        -1+1+1+1+1 = 3
//        +1-1+1+1+1 = 3
//        +1+1-1+1+1 = 3
//        +1+1+1-1+1 = 3
//        +1+1+1+1-1 = 3
//
//        一共有5种方法让最终目标和为3。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/target-sum
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


//sum(p)-sum(n) = target
//sum(p)-sum(n) + sum(nums) = target + sum(nums)
//sum(p)+sum(p) = target + sum(nums)
//sum(p) = (target + sum(nums))/2

//java /表示除法所得的最小整数    %表示余数

package DP;

public class code494 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums){
            sum = sum + num;
        }

        if (sum < S || (S + sum)%2 == 1){
            return 0;
        }

        int w = (S + sum)/2;
        int[] dp = new int[w+1];
        dp[0] = 1;

        for (int num : nums){
            for (int j = w; j<=num; j--){
                dp[j] = dp[j] + dp[j-num];
            }
        }

        return dp[w];
    }
}
