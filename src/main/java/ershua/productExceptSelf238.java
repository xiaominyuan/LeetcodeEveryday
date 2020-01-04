//238. 除自身以外数组的乘积
//给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
//
//示例:
//
//输入: [1,2,3,4]
//输出: [24,12,8,6]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/product-of-array-except-self
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package ershua;

import java.util.Arrays;

public class productExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, 1);

        int left = 1;//储存当前数左边的乘机
        int right = 1;//存储当前数右边的乘机

        for (int i = 0; i< nums.length; i++){
            //交叉相乘， 乘积 = 当前数左边的乘积 * 当前数右边的乘积
            res[i] = res[i]* left;
            left = left*nums[i];

            res[len-i-1] = res[len-i-1]*right;
            right = right*nums[len-i-1];
        }

        return res;
    }
}
