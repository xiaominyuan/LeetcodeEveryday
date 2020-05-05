//76. 最小覆盖子串
//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
//
//示例：
//
//输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC"
//
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/minimum-window-substring
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class minWindow76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;

        while (right < s.length()){
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if (need.get(c).intValue() == window.get(c).intValue()){
                    valid++;
                }
            }

            while (need.size() == valid){
                if (right- left < len){
                    start = left;
                    len = right-left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (need.get(d).intValue() == window.get(d).intValue()){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+ len);
    }
}
