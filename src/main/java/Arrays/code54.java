//54. 螺旋矩阵
//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
//
//示例 1:
//
//输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
//示例 2:
//
//输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/spiral-matrix
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package Arrays;

import java.util.ArrayList;
import java.util.List;

//将矩阵看成一圈圈数字， 然后遍历
public class code54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0){
            return res;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        //目前的层数
        int tmp = 0;

        //矩阵有多少层
        int layer = (Math.min(row, col) + 1)/2;
        while (tmp < layer){
            //从左到右
            for (int j = tmp; j <col-tmp; j++){
                res.add(matrix[tmp][j]);
            }

            //从上到下
            for (int j = tmp+1; j< row-tmp;j++){
                res.add(matrix[j][col-1-tmp]);
            }

            //从右到左
            for (int j = col-1-(tmp+1); j>=tmp && (row-2*tmp != 1); j--){
                res.add(matrix[row-1-tmp][j]);
            }

            //从下到上
            for (int j = row-1-(tmp+1); j>=tmp+1 && (col-2*tmp != 1); j--){
                res.add(matrix[j][tmp]);
            }

            tmp++;
        }

        return res;
    }
}
