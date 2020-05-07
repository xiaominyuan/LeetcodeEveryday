//567. 字符串的排列

package ershua;

import java.util.HashMap;
import java.util.Map;

public class checkInclusion567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s2.length()){
            char c = s2.charAt(right);
            right++;

            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).intValue() == need.get(c).intValue()){
                    valid++;
                }
            }

            while (right - left == s1.length()){
                if (need.size() == valid){
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
