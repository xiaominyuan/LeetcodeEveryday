//139. 单词拆分

package ershua;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for (int i = 1; i<=s.length(); i++){
            for (int j = 0; j < i; j++){
                if (dp[j] == true && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
