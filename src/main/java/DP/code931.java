//931. 下降路径最小和
//给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
//
//        下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
//
//         
//
//        示例：
//
//        输入：[[1,2,3],[4,5,6],[7,8,9]]
//        输出：12
//        解释：
//        可能的下降路径有：
//        [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
//        [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
//        [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
//        和最小的下降路径是 [1,4,7]，所以答案是 12。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package DP;

public class code931 {
    public int minFallingPathSum(int[][] A) {
        int len = A.length;
        int[][] dp = new int[len][len];

        for (int i =0; i<len; i++){
            dp[0][i] = A[0][i];
        }

        for (int i = 1; i< len; i++){
            //第一列
            dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + A[i][0];

            //中间的列
            for (int j = 1; j< len-1; j++){
                dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i-1][j+1]) + A[i][j];
            }

            //最后一列
            dp[i][len-1] = Math.min(dp[i-1][len-1], dp[i-1][len-2]) + A[i][len-1];

        }

        int mins = Integer.MAX_VALUE;

        for (int i =0; i<len; i++){
            if (dp[len-1][i] < mins){
                mins = dp[len-1][i];
            }
        }

        return mins;
    }
}
