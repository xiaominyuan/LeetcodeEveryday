//22. 括号生成
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
//示例：
//
//输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/generate-parentheses
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package jianzhier;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int left = 0; //左括号个数
        int right = 0; //右括号个数
        dfs(res, "", left, right, n);
        return res;
    }

    public void dfs(List<String> res, String path, int left, int right, int n){
        if (left < right || left > n || right >n){
            return;
        }

        if (left == right && left == n){
            res.add(path);
            return;
        }

        dfs(res, path + '(', left +1, right, n);
        dfs(res, path+')', left, right+1, n);
    }
}
