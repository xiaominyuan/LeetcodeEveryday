//128. 最长连续序列
//给定一个未排序的整数数组，找出最长连续序列的长度。
//
//要求算法的时间复杂度为 O(n)。
//
//示例:
//
//输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//链接：https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/tao-lu-jie-jue-zui-chang-zi-xu-lie-deng-yi-lei-wen/
//来源：力扣（LeetCode）

package ershua;

public class longestConsecutive128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1){
            return nums.length;
        }

        sort(nums, 0, nums.length-1);
        int max = 1;
        int cur = 1;
        for (int i = 1; i<nums.length; i++){
            if (nums[i] != nums[i-1]){
                if (nums[i] == nums[i-1] + 1){
                    cur++;
                }else{
                    max = Math.max(max, cur);
                    cur = 1;
                }
            }
        }

        return Math.max(max, cur);

    }

    public int[] sort(int[] nums, int low, int high){
        int mid = (low + high)/2;

        if (low < high){
            sort(nums, low, mid);
            sort(nums, mid+1, high);
            merge(nums, low, mid, high);
        }

        return nums;
    }

    public void merge(int[] nums, int low, int mid, int high){
        int[] tmp = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;

        while (i <= mid && j <= high){
            if (nums[i] < nums[j]){
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

        for (int x = 0; x<tmp.length; x++){
            nums[x+low] = tmp[x];
        }
    }
}
