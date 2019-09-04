//567. 字符串的排列
//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
//
//换句话说，第一个字符串的排列之一是第二个字符串的子串。
//
//示例1:
//
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
//示例2:
//
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/permutation-in-string
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package TwoPointers;


//思路： 用数组储存出现的频率， 然后用s1 的长度的窗口去遍历s2 判断
public class code567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }

        int[] a1 = new int[26];
        int[] a2 = new int[26];

        for (int i = 0; i< s1.length(); i++){
            a1[s1.charAt(i) - 'a']++;
            a2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i< s2.length() - s1.length(); i++){
            if (judge(a1, a2)){
                return true;
            }

            a2[s2.charAt(i+s1.length()) - 'a']++;
            a2[s2.charAt(i) - 'a']--;
        }

        return judge(a1, a2);
    }

    public boolean judge(int[] a1, int[] a2){
        for (int i = 0; i<a1.length; i++){
            if (a1[i] != a2[i]){
                return false;
            }
        }

        return true;
    }
}
