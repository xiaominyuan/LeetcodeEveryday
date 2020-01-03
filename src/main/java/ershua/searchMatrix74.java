//74. 搜索二维矩阵
//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//每行中的整数从左到右按升序排列。
//每行的第一个整数大于前一行的最后一个整数。
//示例 1:
//
//输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/search-a-2d-matrix
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package ershua;

public class searchMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }

        if (matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        int i = 0;
        int row = matrix.length;
        int col = matrix[0].length;

        while (i <col){
            if (matrix[i][col-1] >= target){
                return binarySearch(matrix[i], target);
            }else{
                i++;
            }
        }

        return false;
    }

    public boolean binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = (left+ right)/2;

            if (nums[mid] > target){
                right = mid-1;
            }else if (nums[mid] < target){
                left = mid+1;
            }else{
                return true;
            }
        }

        return false;
    }
}
