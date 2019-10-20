package LinkedList;

import java.util.ArrayDeque;

public class code239 {
    //暴力法
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (k == 0 || len == 0){
            return new int[0];
        }

        int[] res = new int[len - k + 1];
        for (int i = 0; i < len - k + 1; i++){
            int max = Integer.MIN_VALUE;
            for (int j = i; j<i+k; j++){
                max = Math.max(max, nums[j]);
            }
        }

        return res;
    }


    //双向队列， 存储索引， 对应的值递减顺序
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    int[] nums;

    public void cleanQueue(int i, int k){

        //维持队列的长度等于K
        if (!queue.isEmpty() && i - queue.getFirst() == k){
            queue.removeFirst();
        }

        //把较小的值去掉
        while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]){
            queue.removeLast();
        }
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int len = nums.length;
        if (k == 0 || len == 0){
            return new int[0];
        }

        if (k == 1){
            return nums;
        }

        this.nums = nums;
        int maxIndex = 0;

        for (int i = 0; i < k; i++){
            cleanQueue(i, k);
            queue.addLast(i);
            if (nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }

        int[] res = new int[len - k + 1];
        res[0] = nums[maxIndex];

        for (int j = k; j < len; j++){
            cleanQueue(j , k);
            queue.addLast(j);
            res[j - k + 1] = nums[queue.getFirst()];
        }

        return res;
    }
}
