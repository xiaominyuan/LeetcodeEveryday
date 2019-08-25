//945. 使数组唯一的最小增量
//给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
//
//返回使 A 中的每个值都是唯一的最少操作次数。
//
//示例 1:
//
//输入：[1,2,2]
//输出：1
//解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
//示例 2:
//
//输入：[3,2,1,2,1,7]
//输出：6
//解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
//可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package Arrays;


public class code945 {
    public int minIncrementForUnique(int[] A) {
        if (A.length == 0 || A.length == 1){
            return 0;
        }

        quickSort(A, 0, A.length-1);

        int maxNum = A[0];
        int count = 0;

        for (int i = 0; i<A.length; i++){
            if (A[i] <= maxNum){
                count = count + maxNum - A[i];
            }else {
                maxNum = A[i];
            }

            maxNum++;
        }

        return count;
    }

    public void quickSort(int[] nums, int low, int high){


        if (low > high){
            return;
        }

        int tmp = nums[low];
        int left = low;
        int right = high;

        while (left <= right){
            while (left < right && nums[left]<=tmp){
                left++;
            }
            while (nums[right]>tmp){
                right--;
            }
            if (left < right){
                int exchange = nums[left];
                nums[left] = nums[right];
                nums[right] = exchange;
            }
        }

        nums[low] = nums[right];
        nums[right] = tmp;

        quickSort(nums, low, right-1);
        quickSort(nums, right+1,high);

    }
}
