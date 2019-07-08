package backTracking;

import java.util.ArrayList;
import java.util.List;

public class code40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        quickSort(candidates, 0, candidates.length-1);

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

        for (int i = start; i<candidates.length; i++){

            //回溯的时候将重复的的删去，例如【2,2,8】,target = 10;
            // 首先找到了【2，8】,再回溯的时候必然第二次找到【2,8】，
            //这个时候需要将此次循环跳过，不把第二次的[2,8]添加
            if(i > start && candidates[i] == candidates[i-1])
                continue;

            if (target<candidates[i]){
                break;
            }

            tmp.add(candidates[i]);

            backTracking(candidates, target-candidates[i], i+1, tmp, result);

            tmp.remove(tmp.size()-1);
        }


    }

    public void quickSort(int[] nums, int low, int high){
        if (low > high){
            return;
        }

        int left = low+1;
        int right = high;

        int tmp = nums[low];

        while (left <= right){
            while (left < right && nums[left]<=tmp){
                left++;
            }
            while (nums[right]>tmp){
                right--;
            }

            if (left < right){
                int tmpSub = nums[left];
                nums[left] = nums[right];
                nums[right] = tmpSub;
            }else{
                break;
            }

        }

        nums[low] = nums[right];
        nums[right] = tmp;

        quickSort(nums, low, right-1);
        quickSort(nums, right+1, high);
    }
}
