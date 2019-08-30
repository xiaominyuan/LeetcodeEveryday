//31. 下一个排列
//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
//如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
//必须原地修改，只允许使用额外常数空间。
//
//以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/next-permutation
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package Arrays;

//若数组全是降序，那么不存在下一个更大的排列

//思路： 先从低位往高位遍历，找到第一个下降的数字，然后再从低位往高位遍历
//找到第一个比下降的数字大的数字，然后交换这两个数，这时候还不是最小的排列，
//需要把第一次遍历找到上升的子数组反转，变成下降的子数组，这时候就是最小的排列

public class code31 {
    public void nextPermutation(int[] nums) {
        int index = nums.length-2;

        while (index>=0 && nums[index+1] <= nums[index]){
            index--;
        }

        if (index>=0){
            int j = nums.length-1;
            while (nums[j]<= nums[index]){
                j--;
            }
            swap(nums, index, j);
        }

        reverse(nums, index+1, nums.length-1);
    }

    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public void reverse(int[] nums, int start, int end){
        while (start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
