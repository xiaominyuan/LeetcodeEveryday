//560. 和为K的子数组
//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
//
//示例 1 :
//
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package ershua;

import java.util.HashMap;
import java.util.Map;

public class subarraySum560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;
        for (int i =0; i<nums.length; i++){
            sum = sum+nums[i];
            if (map.containsKey(sum -k)){
                //如果累积总和（由 sum[i]sum[i] 表示加到 i^{th}i
                //th
                //  的和）最多两个指数是相同的，那么这些元素之间的元素总和为零。进一步扩展相同的想法，如果累计总和，在索引 ii 和 jj 处相差 kk，即 sum[i] - sum[j] = ksum[i]−sum[j]=k，则位于索引 ii 和 jj 之间的元素之和是 kk。

                count = count + 1 + (map.get(sum-k) -1);
            }

            if (map.containsKey(sum)){
                map.put(sum, map.get(sum) +1);
            }else {
                map.put(sum, 1);
            }
        }

        return count;
    }
}
