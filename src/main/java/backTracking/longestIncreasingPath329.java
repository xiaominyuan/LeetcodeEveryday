//329. 矩阵中的最长递增路径
//给定一个整数矩阵，找出最长递增路径的长度。
//
//对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
//
//示例 1:
//
//输入: nums =
//[
//  [9,9,4],
//  [6,6,8],
//  [2,1,1]
//]
//输出: 4
//解释: 最长递增路径为 [1, 2, 6, 9]。
//示例 2:
//
//输入: nums =
//[
//  [3,4,5],
//  [3,2,6],
//  [2,2,1]
//]
//输出: 4
//解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package backTracking;

public class longestIncreasingPath329 {
    //上下左右四个方向
    private int[][] dirs = {{1,0}, {-1,0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0){
            return 0;
        }

        int max = 0;

        //标记是否访问过， 以及当前格子所代表的路径长度
        int[][] flag = new int[matrix.length][matrix[0].length];
        for (int i = 0 ; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){

                //防止重复遍历
                if (flag[i][j] == 0){
                    max = Math.max(max, dfs(matrix, i, j, flag));
                }
                max = Math.max(max, flag[i][j]);
            }
        }

        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int[][] flag){
        if (flag[i][i] != 0){
            return flag[i][j];
        }

        for (int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]){
                flag[i][j] = Math.max(flag[i][j], dfs(matrix, x, y, flag));
            }
        }

        flag[i][j] = flag[i][j] + 1;
        return flag[i][j];
    }


}
