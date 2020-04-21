//1248. 统计「优美子数组」
//给你一个整数数组 nums 和一个整数 k。
//
//如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
//
//请返回这个数组中「优美子数组」的数目。
//
// 
//
//示例 1：
//
//输入：nums = [1,1,2,1,1], k = 3
//输出：2
//解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
//示例 2：
//
//输入：nums = [2,4,6], k = 1
//输出：0
//解释：数列中不包含任何奇数，所以不存在优美子数组。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package ershua;

public class numberOfSubarrays1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int oddCount = 0;
        int res = 0;
        int len = nums.length;

        while (right < len){
            if (nums[right++] %2 == 1){
                oddCount++;
            }

            if (oddCount == k){
                int rightTmp = right;

                //统计右指针的连续偶数个数
                while (right < len && (nums[right]%2 == 0)){
                    right++;
                }

                int rightEvenCount = right - rightTmp;

                int leftTmp = left;
                //统计左指针左边连续偶数的个数
                while (nums[left]%2 == 0){
                    left++;
                }
                int leftEvenCount = left - leftTmp;

                //因为偶数是没有用的，所以结果等于左边偶数个数与右边偶数个数的组合
                res = res + (leftEvenCount+1)*(rightEvenCount+1);

                //把左边的第一个奇数右移一位，寻找新的子数组
                left++;
                //因为左边第一个奇数右移了，那么子数组内的奇数个数减一个
                oddCount--;
            }
        }

        return res;
    }
}
