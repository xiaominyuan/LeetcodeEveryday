package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.SortedMap;

public class code719 {


    //方法一 ： 最大堆
    public int smallestDistancePair1(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 -o1;
            }
        });

        for (int i = 0; i<nums.length - 1; i++){
            for (int j = i+1; j<nums.length; j++){
                int dist = Math.abs(nums[j] - nums[i]);

                if (maxHeap.size() >= k){
                    if (maxHeap.peek() > dist){
                        maxHeap.add(dist);
                        maxHeap.poll();
                    }
                }else {
                    maxHeap.add(dist);
                }
            }
        }

        return maxHeap.peek();
    }



    //二分法
    public int smallestDistancePair2(int[] nums, int k) {
        Arrays.sort(nums);

        int minDist = 0;
        int maxDist = nums[nums.length-1] -nums[0];

        while (minDist < maxDist){
            int mid = (minDist+ maxDist)/2;

            int count = 0;
            int left = 0;

            for (int right = 0; right < nums.length; right++){
                while (nums[right] - nums[left] > mid){
                    left++;
                }

                count = count + right - left;
            }

            if (count >= k){
                maxDist = mid;
            }else{
                minDist = mid + 1;
            }
        }

        return minDist;
    }
}
