//78.子集
//        给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//        说明：解集不能包含重复的子集。
//
//        示例:
//
//        输入: nums = [1,2,3]
//        输出:
//        [
//        [3],
//          [1],
//          [2],
//          [1,2,3],
//          [1,3],
//          [2,3],
//          [1,2],
//          []
//        ]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/subsets
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
package backTracking;

import java.util.ArrayList;
import java.util.List;

public class code78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getResult(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void getResult(int[] nums, int start, ArrayList<Integer> tmp, List<List<Integer>> result){
        result.add(new ArrayList<>(tmp));

        for (int i = start; i<nums.length; i++){
            tmp.add(nums[i]);
            getResult(nums, i+1, tmp, result);
            //每次回溯都删除一个，然后继续循环寻找新的组合
            tmp.remove(tmp.size()-1);
        }
    }
}
