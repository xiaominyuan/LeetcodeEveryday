//442. 数组中重复的数据
//给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
//
//找到所有出现两次的元素。
//
//你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
//
//示例：
//
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[2,3]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



package Arrays;

import sun.misc.LRUCache;

import java.util.ArrayList;
import java.util.List;

public class code442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<nums.length-1; i++){
            if (nums[i] == nums[i+1]){
                list.add(nums[i]);
            }
        }

        return list;
    }

    public void quickSort(int[] nums, int low, int high){
        if (low > high){
            return;
        }

        int left = low;
        int right = high;
        int mid = nums[low];

        while (left <= right){
            while (left < right && nums[left] <= mid){
                left++;
            }

            while (nums[right] > mid){
                right--;
            }

            if (left < right){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }else {
                break;
            }
        }

        nums[low] = nums[right];
        nums[right] = mid;

        quickSort(nums, low, right-1);
        quickSort(nums, right+1, high);
    }
}
