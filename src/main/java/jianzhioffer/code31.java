//数字在排序数组中出现的次数
//统计一个数字在排序数组中出现的次数。

package jianzhioffer;

//有序数组直接二分
public class code31 {
    public int GetNumberOfK(int [] array , int k) {
        int left = getFirstIndex(array, k);
        int right = getLastIndex(array, k);
        return right - left + 1;
    }

    public int getFirstIndex(int[] nums, int k){
        int left = 0;
        int right = nums.length-1;
        int mid = (left + right)/2;
        while (left <= right){
            if (nums[left] < mid){
                left = mid +1;
            }else{
                right = mid - 1;
            }
            mid = (left + right)/2;
        }

        return left;
    }

    public int getLastIndex(int[] nums, int k){
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right)/2;
        while (left <= right){
            if (nums[left] <= mid){
                left = mid +1;
            }else{
                right = mid - 1;
            }
            mid = (left + right)/2;

        }

        return right;
    }
}
