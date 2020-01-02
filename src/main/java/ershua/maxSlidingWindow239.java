//239. 滑动窗口最大值
//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//返回滑动窗口中的最大值。
//
// 
//
//示例:
//
//输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7]
//解释:
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/sliding-window-maximum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package ershua;

import java.util.LinkedList;
import java.util.Map;

public class maxSlidingWindow239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0){
            return new int[0];
        }

        int len = nums.length;
        int[] res = new int[len-k+1];
        for (int i =0; i<len-k+1; i++){
            int max = Integer.MIN_VALUE;
            for (int j = i; j <i+k; j++){
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }

        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == n || nums.length == 0){
            return new int[0];
        }
        int len = nums.length;
        int[] res = new int[len-k+1];
        LinkedList<Integer> list = new LinkedList<>();

        int index = 0;
        for (int i = 0; i<len; i++){
            while (!list.isEmpty() && nums[list.peekLast()] < nums[i]){
                list.pollLast();
            }

            list.add(i);

            if (i - list.peek() >= k){
                //首尾两个索引距离超过k，那么第一个索引就没有用了
                list.poll();
            }
            if (i >= k-1){
                res[index++] = nums[list.peek()];
            }
        }

        return res;
    }
}
