//152. 乘积最大子序列
//给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
//
//示例 1:
//
//输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
//示例 2:
//
//输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/maximum-product-subarray
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package DP;

public class maxProduct152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0){
            return -1;
        }

        int[][] dp = new int[nums.length][2];

        int max = nums[0];

        dp[0][0] = nums[0]; //最大
        dp[0][1] = nums[0]; //最小

        for (int i = 1; i< nums.length; i++){
            if (nums[i] >= 0){
                dp[i][0] = Math.max(dp[i-1][0]*nums[i], nums[i]);
                dp[i][1] = Math.min(dp[i-1][1]*nums[i], nums[i]);
            }else{
                dp[i][0] = Math.max(dp[i-1][1]*nums[i], nums[i]);
                dp[i][1] = Math.min(dp[i-1][0]*nums[i], nums[i]);
            }

            if (max < dp[i][0]){
                max = dp[i][0];
            }
        }

        return max;
    }
}
