//76. 最小覆盖子串

package ershua;

import java.util.HashMap;
import java.util.Map;

public class minWindow76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int valid = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()){
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).intValue() == need.get(c).intValue()){
                    valid++;
                }
            }

            while (need.size() == valid){
                if (right - left < len){
                    start = left;
                    len = right - left;
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

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }
}
