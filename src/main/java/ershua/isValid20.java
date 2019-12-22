//20. 有效的括号
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//注意空字符串可被认为是有效字符串。
//
//示例 1:
//
//输入: "()"
//输出: true
//示例 2:
//
//输入: "()[]{}"
//输出: true
//示例 3:
//
//输入: "(]"
//输出: false
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/valid-parentheses
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package ershua;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class isValid20 {
    public boolean isValid(String s) {
        int len = s.length();
        if (len == 0){
            return true;
        }

        if (len%2 == 1){
            return false;
        }

        Map<Character, Character> map = new HashMap<>();

        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<len; i++){
            char tmp = s.charAt(i);
            if (map.containsKey(tmp)){
                stack.push(tmp);
            }else{
                if (stack.empty()){
                    return false;
                }

                char a = stack.pop();
                if (map.get(a) != tmp){
                    return false;
                }
            }
        }

        if(stack.empty()){
            return true;
        }else{
            return false;
        }
    }
}
