//424. 替换后的最长重复字符
//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
//
//注意:
//字符串长度 和 k 不会超过 104。
//
//示例 1:
//
//输入:
//s = "ABAB", k = 2
//
//输出:
//4
//
//解释:
//用两个'A'替换为两个'B',反之亦然。
//示例 2:
//
//输入:
//s = "AABABBA", k = 1
//
//输出:
//4
//
//解释:
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package TwoPointers;

//思路：需要替换的字符数目 = 窗口的字符数目 - 窗口内出现次数最多的字符的次数

public class code424 {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0){
            return 0;
        }

        int[] count = new int[26];

        int left = 0;
        int maxCount = 0;
        int res = 0;

        for (int i = 0; i<s.length(); i++){
            count[s.charAt(i) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(i) - 'A']);

            //i - left + 1 是窗口的字符数目， maxCount 是窗口内出现次数最多的字符的次数
            while (i - left + 1 - maxCount > k){
                //多于k 的时候，把指针左移，也要把左指针对应的出现次数减1
                count[s.charAt(left) - 'A']--;
                left++;
            }

            res = Math.max(res, i - left + 1);
        }

        return res;
    }
}
