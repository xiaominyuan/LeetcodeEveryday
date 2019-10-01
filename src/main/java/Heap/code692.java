//692. 前K个高频单词
//给一非空的单词列表，返回前 k 个出现次数最多的单词。
//
//返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
//
//示例 1：
//
//输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
//示例 2：
//
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/top-k-frequent-words
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package Heap;

import java.util.*;

public class code692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : words){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        //小顶堆
        PriorityQueue<String> minHeap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int count1 = map.get(o1);
                int count2 = map.get(o2);
                if (count1 == count2){
                    return o2.compareTo(o1);
                }else{
                    return count1 - count2;
                }
            }
        });

        for (String str : map.keySet()){
            minHeap.add(str);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()){
            result.add(minHeap.poll());
        }
        Collections.reverse(result);
        return result;
    }
}
