//611. 有效三角形的个数
//给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
//
//示例 1:
//
//输入: [2,2,3,4]
//输出: 3
//解释:
//有效的组合是:
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
//注意:
//
//数组长度不超过1000。
//数组里整数的范围为 [0, 1000]。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/valid-triangle-number
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package sort;

import java.util.Arrays;

//思路： 先对数组排序，再用滑动窗口
public class code611 {
    public int triangleNumber(int[] nums) {
//        Arrays.sort(nums);

        sort(nums,0,nums.length-1);
        int result = 0;

        for (int i = nums.length-1; i>= 2; i--){
            int left = 0;
            int right = i - 1;
            while (left < right){
                if (nums[left] + nums[right] > nums[i]){
                    result = result + right - left;
                    right--;
                }else{
                    left++;
                }
            }
        }

        return result;
    }

    //归并排序复习
    public void sort(int[] nums, int low, int high){
        if (low >= high){
            return;
        }
        int mid = (low + high)/2;
        sort(nums, low, mid);
        sort(nums, mid+1, high);
        mergeSort(nums, low, mid, high);
    }

    public void mergeSort(int[] nums, int low, int mid, int high){
        //辅助数组
        int[] tmp = new int[high-low +1];
        int i = low;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= high){
            if (nums[i] <= nums[j]){
                tmp[k++] = nums[i++];
            }else{
                tmp[k++] = nums[j++];
            }
        }

        while (i <= mid){
            tmp[k++] = nums[i++];
        }

        while (j <= high){
            tmp[k++] = nums[j++];
        }

        for (int x = 0; x < nums.length-1; x++){
            nums[low + x] = tmp[x];
        }
    }
}
