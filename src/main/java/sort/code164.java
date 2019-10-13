package sort;

import java.util.Arrays;

public class code164 {
    public int maximumGap(int[] nums) {

        if (nums.length < 2 || nums == null){
            return 0;
        }

        Arrays.sort(nums);
        int res = 0;
        for (int i = 0 ; i <nums.length-1; i++){
            res = Math.max(nums[i+1] - nums[i], res);
        }

        return res;
    }

    //归并排序
    public void sort(int[] nums, int low, int high){
        if (low >= high){
            return;
        }

        int mid = (low + high)/2;
        sort(nums, low, mid);
        sort(nums, mid+1, high);
        mergeSort(nums, low, mid, high);
    }
    public void mergeSort(int[] nums, int low, int mid, int high){
        int[] tmp = new int[high - low + 1];
        int i = low;
        int j = mid+1;
        int k = 0;

        while (i <= mid && j <= high){
            if (nums[i] <= nums[j]){
                tmp[k++] = nums[i++];
            }else{
                tmp[k++] = nums[j++];
            }
        }

        while (i <= mid){
            tmp[k++] = nums[i++];
        }
        while (j <= high){
            tmp[k++] = nums[j++];
        }

        for (int x = 0; x<tmp.length; x++){
            nums[low + x] = tmp[x];
        }
    }


    //冒泡排序
    public void bubbleSort(int[] nums){


        for (int i = 0; i< nums.length - 1; i++){
            boolean flag = false;
            for (int j = 0; j< nums.length-i-1; j++){
                if (nums[j] > nums[j+1]){
                    int change = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = change;
                    flag = true;
                }
            }
            if (flag == false){
                break;
            }
        }
    }

    //快速排序

}
