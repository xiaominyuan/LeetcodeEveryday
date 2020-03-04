package jianzhier;

public class smallestK17 {
    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        for (int i = 0; i< k; i++){
            res[i] = arr[i];
        }

        return res;
    }

    public void quickSort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }

        int low = left;
        int high = right;
        int flag = nums[low];

        while (low <= high){
            while (left < right && nums[low] <= flag){
                low++;
            }

            while (nums[high] > flag){
                high--;
            }

            if (low < high){
                int tmp = nums[left];
                nums[low] = nums[high];
                nums[high] = tmp;
            }else{
                break;
            }
        }

        nums[low] = nums[right];
        nums[right] = flag;

        quickSort(nums, left, high-1);
        quickSort(nums, high+1, right);
    }
}
