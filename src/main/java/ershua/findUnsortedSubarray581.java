//581. 最短无序连续子数组
//给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//
//你找到的子数组应是最短的，请输出它的长度。
//
//示例 1:
//
//输入: [2, 6, 4, 8, 10, 9, 15]
//输出: 5
//解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package ershua;

import java.util.ArrayList;
import java.util.List;

public class findUnsortedSubarray581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] nums2 = nums.clone();
        int[] sortNums = sort(nums2, 0, nums2.length-1);
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i< nums.length; i++){
            if (nums[i] != sortNums[i]){
                index.add(i);
            }
        }

        if (index.size() == 0){
            return 0;
        }

        return index.get(index.size()-1) - index.get(0) + 1;
    }

    public int[] sort(int[] nums, int low, int high){
        int mid = (low+high)/2;
        if (low < high){
            sort(nums, low, mid);
            sort(nums, mid+1, high);
            merge(nums, low, mid, high);
        }
        return nums;
    }

    public void merge(int[] nums, int low, int mid, int high){
        int[] tmp = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k =0;

        while (i <= mid && j <= high){
            if (nums[i] < nums[j]){
                tmp[k++] = nums[i];
            }else{
                tmp[k++] = nums[j];
            }
        }

        while (i <= mid){
            tmp[k++] = nums[i++];
        }

        while (j <= high){
            tmp[k++] = nums[j++];
        }

        for (int x = 0; x < tmp.length; x++){
            nums[x+low] = tmp[k];
        }

    }
}
