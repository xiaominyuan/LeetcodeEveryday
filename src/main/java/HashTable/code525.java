//525. 连续数组
//给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
//
// 
//
//示例 1:
//
//输入: [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
//示例 2:
//
//输入: [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/contiguous-array
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package HashTable;

import java.util.HashMap;
import java.util.Map;

public class code525 {
    public int findMaxLength(int[] nums) {
        int count = 0;
        int maxLen = 0;
        Map<Integer,Integer> map = new HashMap<>();

        map.put(0, -1);

        for (int i = 0; i <nums.length; i++){
            if (nums[i] == -1){
                count +=-1;
            }else{
                count += 1;
            }

            if (map.containsKey(count)){
                //如果两个数字的累计值一样， 说明两个数字之间的01数量一样
                maxLen = Math.max(maxLen, i - map.get(count));
            }else{
                map.put(count, i);
            }
        }

        return maxLen;
    }
}
