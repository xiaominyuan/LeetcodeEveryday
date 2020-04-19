//面试题38. 字符串的排列
//输入一个字符串，打印出该字符串中字符的所有排列。
//
// 
//
//你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
//
// 
//
//示例:
//
//输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package backTracking;

import java.util.HashSet;
import java.util.Set;

public class permutation38 {

    Set<String> set = new HashSet<>();
    public String[] permutation(String s) {
        int len = s.length();
        if (len == 0){
            return new String[0];
        }

        boolean[] flag = new boolean[len];

        dfs(s, "", flag);
        return set.toArray(new String[set.size()]);
    }

    public void dfs(String s, String tmp, boolean[] flag){
        if (tmp.length() == s.length()){
            set.add(tmp);
        }else{
            for (int i = 0; i< s.length(); i++){
                char c = s.charAt(i);
                if (flag[i] == true){
                    continue;
                }

                flag[i] = true;
                dfs(s, tmp+c, flag);
                flag[i] = false;
            }
        }
    }
}
