package sort;

public class quickSort {
    public void quickSorts(int[] nums, int low, int high){
        if (low > high){
            return;
        }

        int left = low;
        int right = high;
        int mid = nums[low];

        while (left <= right){
            while (left < right && nums[left]<=mid){
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

        quickSorts(nums, low, right-1);
        quickSorts(nums, right+1, high);
    }
}
