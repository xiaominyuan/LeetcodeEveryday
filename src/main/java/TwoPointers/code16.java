//16. 最接近的三数之和
//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
//
//例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/3sum-closest
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package TwoPointers;

public class code16 {
    public int threeSumClosest(int[] nums, int target) {

        int len = nums.length;
        quickSort(nums, 0, len-1);

        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i<len; i++){
            int start = i+1;
            int end = len - 1;
            while (start < end){
                int tmp = nums[i] + nums[start] + nums[end];
                int absTmp = Math.abs(tmp - target);
                int absRes = Math.abs(result - target);

                if (absRes > absTmp){
                    result = tmp;
                }

                if (tmp  == target){
                    return tmp;
                }else if (tmp < target){
                    start++;
                }else {
                    end--;
                }
            }
        }

        return result;

    }

    public void quickSort(int[] nums, int low, int high){
        if (low > high){
            return;
        }

        int left = low;
        int right = high;

        int mid = nums[low];

        while (left < right){
            while (left <= right && nums[left] <= mid){
                left++;
            }

            while (nums[right] > mid){
                right--;
            }

            if (left < right){
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
            }else {
                break;
            }
        }

        nums[low] = nums[right];
        nums[right] = mid;

        quickSort(nums, low, right -1);
        quickSort(nums, right + 1, high);
    }
}
