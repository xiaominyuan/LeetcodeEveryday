//216. 组合总和 III
//        找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
//
//        说明：
//
//        所有数字都是正整数。
//        解集不能包含重复的组合。 
//        示例 1:
//
//        输入: k = 3, n = 7
//        输出: [[1,2,4]]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/combination-sum-iii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


//套用回溯魔板
package backTracking;

import java.util.ArrayList;
import java.util.List;

public class code216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        backTracking(n, k, 1, tmp, result);
        return result;
    }

    public void backTracking(int n, int k, int start, ArrayList<Integer> tmp, List<List<Integer>> result){
        if (n == 0 && k == 0){
            result.add(new ArrayList(tmp));
        }

        for (int i = start; i< 10; i++){
            tmp.add(i);
            backTracking(n-i,k-1,i+1, tmp, result);
            tmp.remove(tmp.size()-1);
        }
    }
}
