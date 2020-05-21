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

package ershua;

public class longestPalindrome5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return "";
        }

        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i< s.length(); i++){
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            int maxLen = Math.max(len1, len2);
            if (maxLen > max){
                max = maxLen;
                start = i - (maxLen - 1)/2;
                end = i+(maxLen/2);
            }
        }

        return s.substring(start, end+1);

    }

    public int expand(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right-left-1;
    }
}
