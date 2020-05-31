//面试题 17.15. 最长单词
//定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。
//
//示例：
//
//输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
//输出： "dogwalker"
//解释： "dogwalker"可由"dog"和"walker"组成。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-word-lcci
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package dictionary;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class longestWord15 {
    int minLen = 100;
    Set<String> set = new HashSet<>();
    public String longestWord(String[] words) {
        for (String word : words){
            minLen = Math.min(minLen, minLen);
            set.add(word);
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return o2.length()-o1.length();
            }
        });

        for (String word : words){
            if (word.length() < minLen*2){
                break;
            }

            if (judge(word, 0, 0)){
                return word;
            }
        }

        return "";
    }

    public boolean judge(String s, int l, int k){
        if (k != 0 && set.contains(s.substring(l))){
            return true;
        }

        for (int i = l + minLen; i + minLen <= s.length(); i++){
            if (set.contains(s.substring(l, i)) && judge(s, i, k+1)){
                return true;
            }
        }

        return false;
    }
}
