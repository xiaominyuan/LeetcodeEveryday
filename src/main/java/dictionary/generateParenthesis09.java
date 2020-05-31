//面试题 08.09. 括号
//括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
//
//说明：解集不能包含重复的子集。
//
//例如，给出 n = 3，生成结果为：
//
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/bracket-lcci
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package dictionary;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis09 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", 0, 0, n);
        return res;
    }

    public void dfs(List<String> res, String tmp, int left, int right, int n){
        if (tmp.length() == 2*n){
            res.add(tmp);
            return;
        }


        //剪枝， 左边的括号数量小于右边 比如“（（）））”
        if (left < right){
            return;
        }

        if (left < n){
            dfs(res, tmp +'(', left+1, right, n);
        }

        if (right < n){
            dfs(res, tmp+')', left, right+1, n);
        }
    }
}
