//713. 乘积小于K的子数组
//给定一个正整数数组 nums。
//
//找出该数组内乘积小于 k 的连续的子数组的个数。
//
//示例 1:
//
//输入: nums = [10,5,2,6], k = 100
//输出: 8
//解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
//说明:
//
//0 < nums.length <= 50000
//0 < nums[i] < 1000
//0 <= k < 10^6
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/subarray-product-less-than-k
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package Arrays;

public class code713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1){
            return 0;
        }


        //双指针
        int left = 0;
        int right = 0;

        //乘积
        int tmp = 1;

        int result = 0;

        for (int i = right; i<nums.length; i++){
            tmp = tmp * nums[i];

            //如果当前乘积大于k， 左指针后移
            while (tmp >= k){
                tmp = tmp / nums[left];
                left = left + 1;
            }

            result += i - left +1;
        }

        return result;
    }
}
