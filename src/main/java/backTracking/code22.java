//22. 括号生成
//        给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//
//        例如，给出 n = 3，生成结果为：
//
//        [
//        "((()))",
//        "(()())",
//        "(())()",
//        "()(())",
//        "()()()"
//        ]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/generate-parentheses
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package backTracking;

import java.util.ArrayList;
import java.util.List;

public class code22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backTracking(n, "", result, 0, 0);
        return result;

    }

    public void backTracking(int n, String tmp, List<String> result, int open, int close){
        if (tmp.length() == n*2){
            result.add(tmp);
            return;
        };

        if (open < n){
            backTracking(n, tmp+"(", result,open+1,close);
        }

        if (close<open){
            backTracking(n, tmp+")", result, open, close+1);
        }
    }
}
