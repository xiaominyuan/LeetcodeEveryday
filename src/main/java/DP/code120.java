package DP;


import java.awt.*;
import java.util.List;

//动态规划：dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1])+triangle(i)(j)
// i 为第几行， j第几个数
public class code120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len == 0){
            return 0;
        }

        int[][] dp = new int[len][len];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i<len; i++){
            for (int j = 0; j <= i; j++){
                //每一行的首位比较特殊，单独处理
                if (j == 0){
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                }else if (j == i){
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
                }
            }
        }

        int minNum = Integer.MAX_VALUE;
        for (int num : dp[len-1]){
            if (num <= minNum){
                minNum = num;
            }
        }

        return minNum;
    }
}
