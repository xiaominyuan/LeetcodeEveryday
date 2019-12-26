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
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/top-k-frequent-elements
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package ershua;

import java.util.*;

public class topKFrequent347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();

        Map<Integer,Integer> map = new HashMap();

        for (int num : nums){
            if (map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : nums){
            queue.add(num);
        }

        while (k > 0){
            list.add(queue.poll());
            k--;
        }

        return list;
    }
}
