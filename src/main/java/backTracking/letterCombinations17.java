//17. 电话号码的字母组合
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//示例:
//
//输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package backTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.UIManager.put;

public class letterCombinations17 {

    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {

        Map<String, String> phone = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};

        if (digits.length() == 0){
            return res;
        }

        dfs(res, "", digits, phone);

        return res;
    }

    public void dfs(List<String> res, String tmp, String digits, Map<String, String> map){
        if (digits.length() == 0){
            res.add(tmp);
        }else{
            String letterKey = digits.substring(0, 1);
            String letterValue = map.get(letterKey);

            for (int i = 0; i< letterKey.length(); i++){
                dfs(res, tmp+letterValue.charAt(i), digits.substring(1), map);
            }
        }
    }
}
