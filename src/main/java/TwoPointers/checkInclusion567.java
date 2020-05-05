//567. 字符串的排列
//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
//
//换句话说，第一个字符串的排列之一是第二个字符串的子串。
//
//示例1:
//
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
//示例2:
//
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/permutation-in-string
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class checkInclusion567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int valid = 0;

        for (char c : s1.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s2.length()){
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(right)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).intValue() == window.get(c).intValue()){
                    valid++;
                }
            }

            while (right - left == s1.length()){
                if (valid == need.size()){
                    return true;
                }
                char d = s2.charAt(left);
                left++;

                if (need.containsKey(d)){
                    if (need.get(d).intValue() == window.get(d).intValue()){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }

        return false;
    }
}
