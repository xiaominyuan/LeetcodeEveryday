//最小的K个数
//输入n个整数，找出其中最小的K个数。
// 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

package jianzhioffer;

import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class code26 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        quickSort(input, 0, input.length-1);
        ArrayList<Integer> res = new ArrayList<>();

        if (k <= input.length){
            for (int i = 0; i< k; i++){
                res.add(input[i]);
            }
            return res;
        }else{
            ArrayList<Integer> res2 = new ArrayList<>(input.length);
            return res2;

        }
    }

    public void quickSort(int[] nums, int low, int high){
        if (low > high){
            return;
        }

        int left = low;
        int right = high;
        int mid = nums[low];

        while (left <= right){
            while(left < right && nums[left] <= mid){
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
