//73. 矩阵置零
//给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
//
//示例 1:
//
//输入:
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出:
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
//示例 2:
//
//输入:
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出:
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/set-matrix-zeroes
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package Arrays;

public class code73 {

    public void setZeroes(int[][] matrix) {

        //标识第一行和第一列是否存在0值
        boolean rowFlag = false;
        boolean colFlag = false;

        int row = matrix.length;
        int col = matrix[0].length;

        //遍历第一列以及第一行寻找0值
        for (int i = 0; i<row; i++){
            if (matrix[i][0] == 0){
                colFlag = true;
                break;
            }
        }

        for (int i = 0; i<col; i++){
            if (matrix[0][i] == 0){
                rowFlag = true;
                break;
            }
        }

        //用第一行第一列作为0值标记
        for (int i = 1; i<row; i++){
            for (int j = 1; j<col; j++){
                if (matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        if (colFlag){
            for (int i = 0; i<row; i++){
                matrix[i][0] = 0;
            }
        }

        if (rowFlag){
            for (int i = 0; i<col; i++){
                matrix[0][i] = 0;
            }
        }
    }


}
