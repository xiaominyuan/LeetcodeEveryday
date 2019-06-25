//392. 判断子序列
//        给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
//        示例 1:
//        s = "abc", t = "ahbgdc"
//
//        返回 true.
//
//        示例 2:
//        s = "axc", t = "ahbgdc"
//
//        返回 false.
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/is-subsequence
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package greedy;

public class code392 {
    public boolean isSubsequence(String s, String t) {
        char[] small = s.toCharArray();
        char[] big = t.toCharArray();

        if (small.length == 0){
            return true;
        }

        int sIndex = 0;

        for (int i = 0; i<big.length; i++){
            if (big[i] == small[sIndex]){
                if (sIndex == small.length-1){
                    return true;
                }
                sIndex++;
            }
        }

        return false;
    }
}
