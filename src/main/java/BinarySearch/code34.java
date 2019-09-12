//34. 在排序数组中查找元素的第一个和最后一个位置
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//你的算法时间复杂度必须是 O(log n) 级别。
//
//如果数组中不存在目标值，返回 [-1, -1]。
//
//示例 1:
//
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4]
//示例 2:
//
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package BinarySearch;

public class code34 {
    //暴力法
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int len = nums.length;

        for (int i = 0; i< len; i++){
            if (nums[i] == target){
                result[0] = i;
                break;
            }
        }

        if (result[0] == -1){
            return result;
        }

        for (int i = len - 1; i>=0; i--){
            if (nums[i] == target){
                result[1] = i;
                break;
            }
        }

        return result;
    }




    //二分
    public int[] searchRange2(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int len = nums.length;

        result[0] = binarySearch(nums, 0, len-1, target);
        result[1] = binarySearch(nums, 0, len-1, target);

        while (result[0] > 0 && nums[result[0] -1] == target){
            result[0]--;
        }

        while (result[1] <len-1 && nums[result[1] + 1] == target){
            result[1]++;
        }

        return result;
    }


    public int binarySearch(int[] nums, int left, int right, int target){
        while (left <= right){
            int mid = left + (right - left)/2;

            if (nums[mid] == target){
                return target;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return -1;
    }
}
