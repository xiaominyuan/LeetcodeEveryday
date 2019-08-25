//209. 长度最小的子数组
//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
//
//示例: 
//
//输入: s = 7, nums = [2,3,1,2,4,3]
//输出: 2
//解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package Arrays;

public class code209 {
    public int minSubArrayLen(int s, int[] nums) {
        //暴力法，超出时间限制

        if (nums == null || nums.length == 0){
            return 0;
        }

        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i<nums.length; i++){
            int sum = 0;
            for (int j = i; j<nums.length; j++){
                sum = sum + nums[j];
                if (sum >= s && j-i+1 < minLen){
                    minLen = j-i+1;
                }
            }
        }

        return minLen;
    }


    //滑动窗口,双指针
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        for (int right = 0; right<nums.length; right++){
            sum = sum + nums[right];
            while (sum >= s){
                minLen = Math.min(minLen, right-left+1);
                sum = sum - nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
