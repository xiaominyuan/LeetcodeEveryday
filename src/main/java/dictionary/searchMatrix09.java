//面试题 10.09. 排序矩阵查找
//给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
//
//示例:
//
//现有矩阵 matrix 如下：
//
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
//给定 target = 5，返回 true。
//
//给定 target = 20，返回 false。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/sorted-matrix-search-lcci
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package dictionary;

public class searchMatrix09 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        if (matrix[0][0] > target || matrix[row-1][col-1] < target){
            return false;
        }
        for (int i = 0; i < row; i++){
            if (matrix[i][col-1] >= target){
                if (binarySearch(matrix[i], target) == true){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while (left <= right){
            int mid = (left + right)/2;
            if (arr[mid] == target){
                return true;
            }else if (arr[mid] > target){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }

        return false;
    }
}
