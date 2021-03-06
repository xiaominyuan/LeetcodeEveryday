//1143. 最长公共子序列
//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
//
//一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
//
//若这两个字符串没有公共子序列，则返回 0。
//
// 
//
//示例 1:
//
//输入：text1 = "abcde", text2 = "ace"
//输出：3
//解释：最长公共子序列是 "ace"，它的长度为 3。
//示例 2:
//
//输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
//示例 3:
//
//输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-common-subsequence
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package ershua;

public class longestCommonSubsequence1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0){
            return 0;
        }

        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for (int i = 0; i <= text1.length(); i++){
            for (int j = 0; j <= text2.length(); j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if (text1.charAt(i-1) == text2.charAt(i-1)){
                    dp[i][j] = dp[i][j] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
