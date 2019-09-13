package DP;

public class code416 {
    public boolean canPartition(int[] nums) {
        int size = nums.length;
        int sum = 0;

        for (int num : nums){
            sum = sum + num;
        }

        // 如果和为奇数，不可能分成两份
        if (sum %2 == 1){
            return false;
        }

        int target = sum/2;

        boolean[][] dp = new boolean[size][target+1];

        //初始化第一列 由于和为0， 但是数组中都是正整数，所以false
        for (int i = 0; i <size; i++){
            dp[i][0] = false;
        }

        //初始化第一行，只有数组第一个数进行判断
        for (int i = 1; i<target +1 ; i++){
            if (nums[0] == i){
                dp[0][i] = true;
            }
        }

        for (int i = 1; i <size; i++){
            for (int j = 1; j<target+1; j++){
                //第i 个数不放进去
                dp[i][j] = dp[i-1][j];
                if (nums[i] <= j){
                    dp[i][j] = dp[i][j] || dp[i-1][j - nums[i]];
                }
            }
        }

        return dp[size-1][target];
    }
}
