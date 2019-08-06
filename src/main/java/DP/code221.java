//221. 最大正方形
//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
//
//示例:
//
//输入:
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/maximal-square
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。




//dp[i][j] 代表（i,j）为右下角元素的最大正方形的边长
//dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
//代表左边、上面以及左上的坐标所代表的三个最大正方形的最大边长

package DP;

public class code221 {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = 0;
        if (row != 0){
            col = matrix[0].length;
        }

        int[][] dp = new int[row+1][col+1];
        int result = 0;

        for (int i = 1; i<=row; i++){
            for (int j = 1; j<=col; j++){
                if (matrix[i][j] == '1'){
                    dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result*result;
    }
}
