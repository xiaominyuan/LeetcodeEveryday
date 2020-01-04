//301. 删除无效的括号
//删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
//
//说明: 输入可能包含了除 ( 和 ) 以外的字符。
//
//示例 1:
//
//输入: "()())()"
//输出: ["()()()", "(())()"]
//示例 2:
//
//输入: "(a)())()"
//输出: ["(a)()()", "(a())()"]
//示例 3:
//
//输入: ")("
//输出: [""]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/remove-invalid-parentheses
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package ershua;

import java.util.ArrayList;
import java.util.List;

public class removeInvalidParentheses301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null){
            return res;
        }
        if (s.equals("")){
            res.add("");
            return res;
        }
        int left = 0;
        int right = 0;

        for (int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if (c == '('){
                left ++;
            }else if (c == ')'){
                if (left > 0){
                    left--;
                }else{
                    right++;
                }
            }
        }
        dfs(s, 0, left, right, "", res);
        return res;
    }

    public void dfs(String s, int index, int left, int right, String tmp, List<String> list){
        if (left < 0 || right < 0){
            return;
        }

        if (index == s.length()){
            if (left != 0 || right != 0){
                return;
            }

            if (isValid(tmp) && !s.contains(tmp)){
                list.add(tmp);
            }
            return;
        }
        char c = s.charAt(index);

        if ( c == '('){
            dfs(s, index+1, left-1, right, tmp, list);
            dfs(s, index+1, left, right, tmp + c, list);
        }else if (c == ')'){
            dfs(s, index+1, left, right-1, tmp, list);
            dfs(s, index+1, left, right, tmp+c, list);
        }else{
            dfs(s, index+1, left, right, tmp+c, list);
        }
    }

    public boolean isValid(String s){
        if (s == null){
            return false;
        }

        if (s.equals("")){
            return true;
        }

        if (s.charAt(0) == ')'){
            return false;
        }

        int left = 0;
        int right = 0;
        for (int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if (c == '('){
                left++;
            }else if (c == ')'){
                if (left > 0){
                    left--;
                }else{
                    right++;
                }
            }

            if (right > 0){
                return false;
            }
        }

        if (left > 0){
            return false;
        }

        return true;
    }

}
