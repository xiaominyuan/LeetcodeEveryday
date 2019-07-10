//77. 组合
//        给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
//        示例:
//
//        输入: n = 4, k = 2
//        输出:
//        [
//        [2,4],
//        [3,4],
//        [2,3],
//        [1,2],
//        [1,3],
//        [1,4],
//        ]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/combinations
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package backTracking;

import java.util.ArrayList;
import java.util.List;


//直接套用魔板
public class code77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        backTracking(n, k, 1, new ArrayList<Integer>(), result);

        return result;

    }

    public void backTracking(int n, int k, int start, ArrayList<Integer> tmp, List<List<Integer>> result){
        if (tmp.size() == k){
            result.add(tmp);
        }

        for (int i=start; i<n+1; i++){
            tmp.add(i);
            backTracking(n, k, i+1, tmp, result);
            tmp.remove(tmp.size()-1);
        }
    }
}
