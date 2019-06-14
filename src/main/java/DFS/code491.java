package DFS;//491. 递增子序列
//给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
//
//        示例:
//
//        输入: [4, 6, 7, 7]
//        输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/increasing-subsequences
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class code491 {
    public List<List<Integer>> findSubSequences(int[] nums){
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        helper(nums, 0, new ArrayList<Integer>(), set);
        return new ArrayList<List<Integer>>(set);
    }
    public void helper(int[] nums, int cur, List<Integer> list, Set<List<Integer>> set){
        if (list.size() >= 2){
            List<Integer> newList = new ArrayList<Integer>(list);
            set.add(newList);
        }
        if (cur == nums.length){
            return;
        }
        for (int i = cur; i < nums.length; i++){
            if (list.size() == 0 || nums[i]>list.get(list.size()-1)){
                list.add(nums[i]);
                helper(nums,i+1,list,set);
                list.remove(list.size() - 1);
            }
        }
    }
}
