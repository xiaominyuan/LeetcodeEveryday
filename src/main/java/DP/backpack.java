package DP;

public class backpack {

    //capcity 背包容量 个数  weight 物品的重量  value 物品的价值

    //方法一：递归
    public int method1(int capacity, int[] weight, int[] values){
        int n = weight.length;

        return bestValue(capacity, n-1,weight, values);
    }

    public int bestValue(int capacity, int index, int[] weight, int[] values){
        if (index <= 0 || capacity <= 0){
            return 0;
        }

        int res = bestValue(capacity, index-1, weight, values);

        if (capacity >= weight[index]){
            res = Math.max(res, values[index] + bestValue(capacity-weight[index], index-1, weight, values));
        }

        return res;
    }


    //动态规划
    public int method2(int capacity, int[] weight, int[] values){
        int len = weight.length;
        if (len == 0){
            return 0;
        }

        //dp 表示i 个物品放进去容量为c背包的效益，
        int[][] dp = new int[len][capacity+1];

        //初始化第一列，容量为0
        for (int i = 0; i<len; i++){
            dp[i][0] = 0;
        }

        //初始化第一行，只放一个物品
        for (int i = 1; i<= capacity; i++){
            if (capacity >= weight[i]){
                dp[0][i] = values[0];
            }else {
                dp[0][i] = 0;
            }
        }

        for (int i = 1; i <len; i++){
            for (int j = 1; j<=capacity; j++){
                //第i 个物品不放时， 和只有i - 1 个物品在背包是一样的
                dp[i][j] = dp[i-1][j];

                //比较放和不放
                if (j >= weight[i]){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - weight[i]]);
                }
            }
        }

        return dp[len-1][capacity];
    }


}
