//287. 寻找重复数
//给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
//
//示例 1:
//
//输入: [1,3,4,2,2]
//输出: 2
//示例 2:
//
//输入: [3,1,3,4,2]
//输出: 3
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/find-the-duplicate-number
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package Arrays;


//思路：先排序，再遍历寻找
public class code287 {
    public int findDuplicate(int[] nums) {
        quickSort(nums,0,nums.length-1);

        for (int i = 0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                return nums[i];
            }
        }

        return 0;
    }

    public void quickSort(int[] nums, int low, int high){
       if (low > high){
           return;
       }

       int mid = nums[low];
       int left = low;
       int right = high;

       while (left <= right){
           while (left<right && nums[left]<=mid){
               left++;
           }
           while (nums[right]>mid){
               right--;
           }

           if(left <right){
               int tmp = nums[left];
               nums[left] = nums[right];
               nums[right] = tmp;
           }
       }

       nums[mid] = nums[right];
       nums[right] = mid;

       quickSort(nums, low, right-1);
       quickSort(nums, right+1,high);
    }
}
