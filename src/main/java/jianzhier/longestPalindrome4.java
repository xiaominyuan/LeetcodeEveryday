//5. 最长回文子串
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
//示例 1：
//
//输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//示例 2：
//
//输入: "cbbd"
//输出: "bb"
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-palindromic-substring
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package jianzhier;

public class longestPalindrome4 {
    public String longestPalindrome(String s) {
        if (s.length() == 0){
            return "";
        }

        int len = s.length();
        //dp[i][j] 代表i - j 之间是否为回文串
        boolean[][] dp = new boolean[len][len];
        String res = s.substring(0, 1);
        for (int i = 0; i< len; i++){
            dp[i][i] = true;
        }

        for (int i = 0; i< len-1; i++){
            if (s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
            }
            res = s.substring(i, i+2);
        }

        for (int k = 3; k <= len; k++){
            for (int start = 0; start+k <= len; start++){
                int end = start+k-1;
                if (s.charAt(start) == s.charAt(end) && dp[start+1][end-1]){
                    dp[start][end] = true;
                }

                if (dp[start][end] && end-start+1 > res.length()){
                    res = s.substring(start, end+1);
                }
            }
        }

        return res;
    }
}
