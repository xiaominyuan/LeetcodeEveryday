//215. 数组中的第K个最大元素
//        在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//        示例 1:
//
//        输入: [3,2,1,5,6,4] 和 k = 2
//        输出: 5
//        示例 2:
//
//        输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//        输出: 4
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package DivideAndConquer;

//先用快速排序，找到中间值，左边的都是比中间值大的，右边都是比中间值小的
//那么如果中间值得索引等于K-1，那么就是找到了，直接返回这个值nums[mid]
//如果mid>K-1，那么说明这个要找的值在mid左边,就直接在左边的数组找，right=mid-1;
//如果mid<K-1, 那么说明这个要找的值在mid右边，直接在右边的小数组找，left=mid+1
public class code215 {
    public int findKthLargest(int[] nums, int k){
        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        while (left<=right){

            mid = quickSort(nums,left,right);

            if (mid == k-1){
                return nums[mid];
            }else if(mid>k-1){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return -1;
    }

    public int quickSort(int[] nums, int low, int high){
        int left = low+1;
        int right = high;
        int tmp = nums[low];

        while (left <= right){
            while (left < right && nums[left]>=tmp){
                left++;
            }
            while (nums[right]<tmp){
                right--;
            }
            if (left < right){
                int tmp2 = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp2;
            }else{
                break;
            }

            left++;
            right--;
        }

        nums[low] = nums[right];
        nums[right] = tmp;

        return right;
    }
}
