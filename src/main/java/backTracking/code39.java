//39. 组合总和
//        给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//        candidates 中的数字可以无限制重复被选取。
//
//        说明：
//
//        所有数字（包括 target）都是正整数。
//        解集不能包含重复的组合。 
//        示例 1:
//
//        输入: candidates = [2,3,6,7], target = 7,
//        所求解集为:
//        [
//        [7],
//        [2,2,3]
//        ]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/combination-sum
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



//典型回溯问题，套用魔板
package backTracking;

import java.util.ArrayList;
import java.util.List;

public class code39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        quickSort(candidates, 0, candidates.length-1);

        // Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        backTracking(candidates, target, 0, new ArrayList<Integer>(), result);

        return result;

    }

    public void backTracking(int[] candidates, int target, int start, ArrayList<Integer> tmp, List<List<Integer>> result){
        if (target < 0){
            return;
        }

        if (target == 0){
            result.add(new ArrayList(tmp));
            return;
        }

        for (int i = start; i< candidates.length; i++){
            if (target<candidates[i]){
                break;
            }

            tmp.add(candidates[i]);

            //由于可以重复使用数组中的数字，所以递归函数中中的start为i，而不是i+1
            backTracking(candidates, target - candidates[i], i, tmp, result);

            tmp.remove(tmp.size()-1);
        }
    }

    public void quickSort(int[] nums, int low, int high){
        int left = low+1;
        int right = high;
        int tmp = nums[low];

        while (left <= right){
            while (left< right && nums[left]<= tmp){
                left++;
            }
            while (nums[right]>tmp){
                right--;
            }

            if (left < right){
                int tmpSub = nums[left];
                nums[left] = nums[right];
                nums[right] = tmpSub;
            }else {
                break;
            }
        }

        nums[low] = nums[right];
        nums[right] = tmp;

        quickSort(nums, low, right-1);
        quickSort(nums, right+1, high);
    }
}
