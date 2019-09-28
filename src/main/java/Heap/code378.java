//378. 有序矩阵中第K小的元素
//给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
//请注意，它是排序后的第k小元素，而不是第k个元素。
//
//示例:
//
//matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//返回 13。
//说明:
//你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class code378 {

    //二分法
    public int kthSmallest1(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;

        //最小数
        int left = matrix[0][0];

        //最大数
        int right = matrix[row-1][col-1];

        while (left < right){
            int mid = (left + right)/2;

            //小于mid 的个数
            int count = findCount(matrix, mid, row, col);

            if (count < k){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return right;
    }

    //按照列搜索
    public int findCount(int[][] matrix, int mid, int row, int col){
        int i = row - 1;
        int j = 0;
        int count = 0;

        while (j < col && i >= 0){
            if (matrix[i][j] <= mid){
                count = count + i+ 1;
                j++;
            }else{
                i--;
            }
        }

        return count;
    }


    //最大堆
    public int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0 ; i< matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (priorityQueue.size() >= k){
                    if (priorityQueue.peek() > matrix[i][j]){
                        priorityQueue.add(matrix[i][j]);
                        priorityQueue.poll();
                    }
                }else{
                    priorityQueue.add(matrix[i][j]);
                }
            }
        }

        return priorityQueue.peek();
    }
}
