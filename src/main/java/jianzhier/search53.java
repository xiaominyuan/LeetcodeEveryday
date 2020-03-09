//面试题53 - I. 在排序数组中查找数字 I
//统计一个数字在排序数组中出现的次数。
//
// 
//
//示例 1:
//
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2
//示例 2:
//
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package jianzhier;

public class search53 {
    public int search(int[] nums, int target) {
        int result = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left >= 0 && right <= nums.length-1 && left <= right){
            int mid = (left + right)/2;
            if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else{
                result = 1;
                int left2 = mid - 1;
                int right2 = mid + 1;
                while (left2 >= left){
                    if (nums[left2] == target){
                        left2--;
                        result++;
                    }else{
                        break;
                    }
                }

                while (right2 <= right){
                    if (nums[right2] == target){
                        right2++;
                        result++;
                    }else{
                        break;
                    }
                }

                break;
            }
        }

        return result;
    }
}
