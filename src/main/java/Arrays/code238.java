//238. 除自身以外数组的乘积
//给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
//
//示例:
//
//输入: [1,2,3,4]
//输出: [24,12,8,6]
//说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/product-of-array-except-self
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package Arrays;

import java.util.Arrays;


//某个值除了自身的乘积=左边所有的数字乘积 * 右边所有的数字乘积
public class code238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = 1;

        int[] result = new int[len];
        Arrays.fill(result,1);

        for (int i = 0; i<len; i++){
            result[i] = result[i]*left;
            left = left*nums[i];

            result[len-i-1] = result[len-i-1]*right;
            right = right*nums[len-i-1];
        }

        return result;
    }
}
