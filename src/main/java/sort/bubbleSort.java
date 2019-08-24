package sort;

public class bubbleSort {
    public void sort(int[] nums){
        for (int i = 0; i<nums.length-1; i++){
            boolean flag = false;
            for (int j = 0; j<nums.length-1-i; j++){
                if (nums[j+1]<nums[j]){
                    int tmp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = tmp;
                    flag = true;
                }
            }

            if (!flag){
                break;
            }
        }
    }
}
