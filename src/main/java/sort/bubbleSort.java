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

class tt{
    public static void main(String[] args) {
        int[] a = new int[]{1,7,3,6,4};
        bubbleSort b = new bubbleSort();
        b.sort(a);
        for (int e : a){
            System.out.println(e);
        }

    }
}

