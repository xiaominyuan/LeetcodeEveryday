//15. 三数之和
//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
//
//例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/3sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//思路： 先排序，从小到大，再遍历，先固定当前遍历值，
//再用两个指针，从两端开始遍历，若这三个数小于0，就把left 指针后移
//若这三个数大于0，就把right指针前移
public class code15 {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3){
            return result;
        }

        quickSort(nums, 0, nums.length-1);

        for (int i = 0; i<nums.length; i++){
            if (nums[i] > 0){
                break;
            }

            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i+1;
            int right = nums.length-1;

            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }

                    while (left < right && nums[right] == nums[right--]){
                        right--;
                    }

                    left++;
                    right--;
                }else if (sum < 0){
                    left++;
                }else {
                    right--;
                }
            }

//            return result;
        }

        return result;
    }

    public void quickSort(int[] nums, int low, int high){
        if (low > high){
            return;
        }

        int mid = nums[low];
        int left = low;
        int right = high;

        while (left < right){
            while (left <= right && nums[left] <= mid){
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
