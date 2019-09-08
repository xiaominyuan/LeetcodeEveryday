//347. 前 K 个高频元素
//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
//示例 1:
//
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//示例 2:
//
//输入: nums = [1], k = 1
//输出: [1]
//说明：
//
//你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
//你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/top-k-frequent-elements
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package Arrays;

import java.util.*;

public class code347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums){
            if (map.containsKey(num)){
                int v = map.get(num);
                map.put(num, v+1);
            }else {
                map.put(num, 1);
            }
        }

        //小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (int key : map.keySet()){
            queue.add(key);
            if (queue.size() > k){
                queue.poll();
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()){
            result.add(queue.poll());
        }

        return result;
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int num : nums){
            if (map.containsKey(num)){
                int v = map.get(num);
                map.put(num, v+1);
            }else{
                map.put(num, 1);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){

            @Override
            public int compare(Integer a, Integer b){
                return map.get(b) - map.get(a);
            }

        });


        List<Integer> list = new ArrayList<>();

        for (int key : map.keySet()){
            queue.add(key);
        }

        while (k > 0){
            list.add(queue.poll());
            k--;
        }
        return list;
    }
}
