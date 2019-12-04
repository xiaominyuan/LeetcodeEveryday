//18. 四数之和
//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
//
//注意：
//
//答案中不可以包含重复的四元组。
//
//示例：
//
//给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/4sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//https://leetcode-cn.com/problems/4sum/solution/kshu-zhi-he-de-tong-yong-mo-ban-by-mrxiong/


package Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//K个数之和，模板
public class code18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //先排序
        Arrays.sort(nums);

        int[] stack = new int[4];

        int stackIndex = -1;
        int begin = 0;

        List<List<Integer>> result = kSumRecurive(nums, stack, stackIndex, begin, 4, target);

        return result;



    }

    public List<List<Integer>> kSumRecurive(int[] nums, int[] stack, int stackIndex, int begin, int k, int target){
        List<List<Integer>> result = new ArrayList<>();

        if (k == 2){
            List<Integer> tmp;
            int left = begin;
            int right = nums.length-1;

            while (left < right){
                if (nums[left] + nums[right] > target){
                    right--;
                }else if (nums[left] + nums[right] < target){
                    left++;
                }else {
                    tmp = new ArrayList<>();
                    stack[++stackIndex] = nums[left];
                    stack[++stackIndex] = nums[right];

                    for (int i = 0; i<= stackIndex; i++){
                        tmp.add(nums[i]);
                    }

                    result.add(tmp);

                    stack[stackIndex--] = 0x3f3f3f3f;
                    stack[stackIndex--] = 0x3f3f3f3f;

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left-1]){
                        left++;
                    }

                    while (left <right && right<nums.length-1 && nums[right] == nums[right+1]){
                        right--;
                    }
                }
            }
        }else {
            int targetTmp;

            for (int i = begin; i<nums.length-k+1; i++){
                if (i<begin && nums[i] == nums[i-1]){
                    continue;
                }

                targetTmp = target-nums[i];

                stack[++stackIndex] = nums[i];

                List<List<Integer>> res = kSumRecurive(nums, stack,stackIndex,i+1,k-1,targetTmp);

                stack[stackIndex--] = 0x3f3f3f3f;

                result.addAll(res);
            }
        }

        return result;
    }
}
