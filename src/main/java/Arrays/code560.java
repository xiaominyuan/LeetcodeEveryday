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



//注意是连续子数组
package Arrays;

import java.util.HashMap;
import java.util.Map;

public class code560 {
    //暴力方法
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i<nums.length; i++){
            int sum = 0;
            for (int j = i; j <nums.length; j++){
                sum = sum+nums[j];
                if (k == sum){
                    result++;
                }
            }
        }

        return result;
    }

    //Map存储sum的出现的次数
    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int result = 0;

        for (int i = 0; i<nums.length; i++){
            sum = sum + nums[i];
            if (map.containsKey(sum-k)){
                result = result + map.get(sum-k);
            }

            if (map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);
            }else {
                map.put(sum,1);
            }
        }

        return result;
    }

}
