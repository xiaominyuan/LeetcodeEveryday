//面试题40. 最小的k个数
//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
// 
//
//示例 1：
//
//输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
//示例 2：
//
//输入：arr = [0,1,2,1], k = 1
//输出：[0]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package ershua;

public class getLeastNumbers40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0){
            return new int[k];
        }

        int len = arr.length;
        if (k == len){
            return arr;
        }
        int[] res = new int[k];

        for (int i = 0; i< k; i++){
            res[i] = arr[i];
        }
        build(res);
        for (int i = k; i< len; i++){
            if (arr[i] < res[0]){
                res[0] = arr[i];
                heap(res, 0);
            }
        }

        return res;
    }

    public void build(int[] nums){
        int start = (nums.length - 1)/2;
        while (start >= 0){
            heap(nums, start);
            start--;
        }
    }

    public void heap(int[] nums, int i){
        if (i >= nums.length){
            return;
        }

        int left = 2*i + 1;
        int right = 2*i + 2;
        int max = i;

        if (left < nums.length && nums[left] > nums[max]){
            max = left;
        }

        if (right < nums.length && nums[right] > nums[max]){
            max = right;
        }

        if (max != i){
            swap(nums, max, i);
            heap(nums, max);
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
