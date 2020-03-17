//面试题40. 最小的k个数

package jianzhier;

public class getLeastNumbers40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0){
            return new int[0];
        }

        if (k == arr.length){
            return arr;
        }

        int[] res = new int[k];

        for (int i = 0; i< k; i++){
            res[i] = arr[i];
        }
        build(res);

        for (int i = k; i< arr.length; i++){
            if (arr[i] < res[0]){
                res[0] = arr[i];
                heap(res, 0);
            }
        }

        return res;
    }

    public void build(int[] nums){
        int last = nums.length-1;
        int start = (last-1)/2;
        while (start >= 0){
            heap(nums, start);
            start--;
        }
    }

    public void heap(int[] nums, int i){
        if (i >= nums.length){
            return;
        }

        int left = 2*i+1;
        int right = 2*i+2;
        int max = i;
        if (left < nums.length && nums[i] < nums[left]){
            max = left;
        }

        if (right < nums.length && nums[i] < nums[right]){
            max = right;
        }

        if (max != i){
            swap(nums, i, max);
            heap(nums, max);
        }

    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
