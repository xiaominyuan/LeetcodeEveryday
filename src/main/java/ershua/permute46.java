//46. 全排列
//给定一个没有重复数字的序列，返回其所有可能的全排列。
//
//示例:
//
//输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/permutations
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package ershua;

//https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-xiang-jie-by-labuladong-2/

import java.util.LinkedList;
import java.util.List;

public class permute46 {
    public List<List<Integer>> list = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, track);
        return list;
    }

    public void backTrack(int[] nums, LinkedList<Integer> track){
        if (track.size() == nums.length){
            list.add(new LinkedList<>(track));
            return;
        }

        for (int i =0; i<nums.length; i++){
            if (track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backTrack(nums, track);
            track.removeLast();
        }
    }
}
