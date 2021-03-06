//46. 全排列
//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
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

package backTracking;

import java.util.ArrayList;
import java.util.List;

public class permute46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        boolean[] flag = new boolean[len];

        List<Integer> tmp = new ArrayList<>();

        dfs(res, tmp, nums, flag);

        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] flag){
        if (tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
        }else{
            for (int i = 0; i< nums.length; i++){
                if (flag[i] == true){
                    continue;
                }

                int a = nums[i];
                tmp.add(a);
                flag[i] = true;
                dfs(res, tmp, nums, flag);
                tmp.remove(tmp.size()-1);
                flag[i] = false;
            }
        }
    }
}
