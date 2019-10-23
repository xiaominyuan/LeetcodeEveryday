//189. 旋转数组
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
//示例 1:
//
//输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//示例 2:
//
//输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/rotate-array
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package Arrays;

public class code189 {

    //暴力法
    public void rotate(int[] nums, int k) {
        int tmp;
        int pre;
        for (int i = 0; i < k; i++) {
            pre = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++){
                tmp = nums[j];
                nums[j] = pre;
                pre = tmp;
            }
        }
    }

    //反转
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end){
        while (start <= end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
