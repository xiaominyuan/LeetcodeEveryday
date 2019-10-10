//976. 三角形的最大周长
//给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
//
//如果不能形成任何面积不为零的三角形，返回 0。
//
// 
//
//示例 1：
//
//输入：[2,1,2]
//输出：5
//示例 2：
//
//输入：[1,2,1]
//输出：0
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/largest-perimeter-triangle
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


//先对数组排序，从小到大，a+b > c  先用最大的a 和 b ，就是倒数第二个和第三个
package sort;

public class code976 {
    public int largestPerimeter(int[] A) {
        sort(A, 0 , A.length-1);
        for (int i = A.length -3; i>= 0; i--){
            if (A[i] + A[i+1] > A[i+2]){
                return A[i] + A[i+1] + A[i+2];
            }
        }
        return 0;
    }

    //归并排序
    public void sort(int[] nums, int low, int high){
        if (low >= high){
            return;
        }
        int mid = (low + high)/2;
        sort(nums, low, mid);
        sort(nums, mid+1, high);
        mergeSort(nums, low, mid, high);
    }

    public void mergeSort(int[] nums, int low, int mid, int high){
        int[] tmp = new int[high-low+1];
        int i = low;
        int j = mid +1;
        int k = 0;

        while (i <= mid && j <= high){
            if (nums[i] <= nums[j]){
                tmp[k++] = nums[i++];
            }else{
                tmp[k++] = nums[j++];
            }

        }

        while (i <= mid){
            tmp[k++] = nums[i++];
        }

        while (j <= high){
            tmp[k++] = nums[j++];
        }

        for (int x = 0; x< tmp.length; x++){
            nums[low + x] = tmp[x];
        }
    }
}
