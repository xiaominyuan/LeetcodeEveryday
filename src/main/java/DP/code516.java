//516. 最长回文子序列
//给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
//
//示例 1:
//输入:
//
//"bbbab"
//输出:
//
//4
//一个可能的最长回文子序列为 "bbbb"。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package DP;

public class code516 {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }

        char[] arr = s.toCharArray();
        int size = arr.length;
        int[][] dp = new int[size][size];

        for (int i = 0; i<size; i++){
            dp[i][i] = 1;
        }

        for (int i = 0; i <size-1; i++){
            if (arr[i] == arr[i+1]){
                dp[i][i+1] = 2;
            }else{
                dp[i][i+1] = 1;
            }
        }

        for (int len = 3; len < size; len++){
            for (int i = 1; i < size-len; i++){
                int j = len+i-1;
                dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);

                if (arr[i] == arr[j]){
                    dp[i][j] = Math.max(dp[i][j], dp[i+1][j-1]+2);
                }
            }
        }

        return dp[0][size-1];
    }
}
