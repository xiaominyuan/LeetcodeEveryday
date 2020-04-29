//47. 全排列 II
//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
//示例:
//
//输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/permutations-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package backTracking;

import java.util.ArrayList;
import java.util.List;

public class permuteUnique47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        boolean[] flag = new boolean[len];

        quickSort(nums, 0, nums.length-1);

        dfs(res, new ArrayList<>(), nums, flag);

        return res;
    }


    public void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] flag){
        if (tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }else {
            for (int i = 0; i< nums.length; i++){
                if (flag[i] == true){
                    continue;
                }

                //关键点  同一个递归内不能有相同数字， 不同递归内可以有
                if (i > 0 && nums[i-1] == nums[i] && flag[i-1] == true){
                    continue;
                }

                flag[i] = true;
                tmp.add(nums[i]);
                dfs(res, tmp, nums, flag);
                tmp.remove(tmp.size()-1);
                flag[i] = false;
            }
        }
    }

    public void quickSort(int[] nums, int low, int high){
        if (low > high){
            return;
        }

        int left = low;
        int right = high;
        int mid = nums[low];

        while(left <= right){
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
            }else{
                break;
            }
        }

        nums[low] = nums[right];
        nums[right] = mid;

        quickSort(nums, low, right-1);
        quickSort(nums, right+1, high);
    }
}
