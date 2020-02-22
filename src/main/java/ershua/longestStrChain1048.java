package ershua;

import java.util.Arrays;
import java.util.Comparator;

public class longestStrChain1048 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);

        int result = 0;

        for (int i = 1; i< words.length; i++){
            for (int j = 0; j< i; j++){
                if (isContain(words[i], words[j])){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
//                    result = Math.max(dp[i], result);
                }
                result = Math.max(dp[i], result);
            }
        }

        return result;
    }

    public boolean isContain(String a, String b){
        if (a.length() != b.length()+1){
            return false;
        }

        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()){
            if (a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }

        if (j == b.length()){
            return true;
        }

        return false;
    }
}
