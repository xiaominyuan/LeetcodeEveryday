//784. 字母大小写全排列
//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
//
//示例:
//输入: S = "a1b2"
//输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入: S = "3z4"
//输出: ["3z4", "3Z4"]
//
//输入: S = "12345"
//输出: ["12345"]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/letter-case-permutation
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package backTracking;

import java.util.ArrayList;
import java.util.List;

public class letterCasePermutation784 {
    List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        dfs("", S, 0);
        return res;
    }

    public void dfs(String tmp, String s, int index){
        if (index == s.length()){
            res.add(tmp);
        }else{
            char ch = s.charAt(index);
            if (!Character.isLetter(ch)){
                dfs(tmp+ch, s, index+1);
            }else{
                ch = Character.toLowerCase(ch);
                dfs(tmp+ch, s, index+1);
                ch = Character.toUpperCase(ch);
                dfs(tmp+ch, s, index+1);
            }
        }
    }
}
