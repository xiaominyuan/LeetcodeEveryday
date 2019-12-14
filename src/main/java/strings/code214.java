//214. 最短回文串
//给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
//
//示例 1:
//
//输入: "aacecaaa"
//输出: "aaacecaaa"
//示例 2:
//
//输入: "abcd"
//输出: "dcbabcd"
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/shortest-palindrome
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package strings;

public class code214 {
    public String shortestPalindrome(String s) {
        String revs = new StringBuilder(s).reverse().toString();
        String res = s;

        for (int i = 0; i< s.length(); i++){
            String tmp = revs.substring(i);
            if (s.startsWith(tmp)){
                res = revs.substring(0,i) + s;
                break;
            }
        }

        return res;
    }
}
