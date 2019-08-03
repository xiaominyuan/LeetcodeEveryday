//300. 最长上升子序列
//        给定一个无序的整数数组，找到其中最长上升子序列的长度。
//
//        示例:
//
//        输入: [10,9,2,5,3,7,101,18]
//        输出: 4
//        解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。




//如果是连续的子序列： dp[i] = nums[i]>nums[i-1] ? dp[i-1]+1 : dp[i]
//但是这题的子序列可以是不连续的，所以对于一个数nums[i],
//这个数必须大于它前面的子序列的数，才能应用状态方程
//dp[i] = max{1+dp[j] for j <i if nums[j]<nums[i]}
//dp[i]：表示以第 i 个数字为结尾的“最长上升子序列”的长度。

package DP;

import java.util.Arrays;

public class code300 {
    public int lengthOfLIS(int[] nums) {

        //这个是连续的，题目没说是连续的

//         int len = nums.length;

//         if (len == 0){
//             return 0;
//         }

//         int[] dp = new int[len];
//         dp[0] = 0;

//         for (int i = 1; i<len; i++){
//             if (nums[i]>nums[i-1]){
//                 dp[i] = dp[i-1]+1;
//             }else{
//                 dp[i] = 0;
//             }
//         }

//         int result = 0;
//         for (int i = 0; i<len; i++){
//             if (dp[i] >= result){
//                 result = dp[i];
//             }
//         }

//         return result+1;


        int len = nums.length;
        if (len == 0){
            return 0;
        }

        int[] dp = new int[len];
        Arrays.fill(dp,1);

        for (int i = 1; i<len; i++){
            for (int j =0; j<i; j++){
                if (nums[j]<nums[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }

        int result = 0;
        for (int i = 0; i<len; i++){
            if (dp[i] >= result){
                result = dp[i];
            }
        }

        return result;
    }
}
