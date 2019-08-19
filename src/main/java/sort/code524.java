//524. 通过删除字母匹配到字典里最长单词
//给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
//
//示例 1:
//
//输入:
//s = "abpcplea", d = ["ale","apple","monkey","plea"]
//
//输出:
//"apple"
//示例 2:
//
//输入:
//s = "abpcplea", d = ["a","b","c"]
//
//输出:
//"a"
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class code524 {
    public String findLongestWord(String s, List<String> d) {

        //首先对字典list进行排序，从大到小，相同长度下，字典序最小在最前面
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() != o2.length() ? o2.length() - o1.length():o1.compareTo(o2);
            }
        });

        for (String str : d){
            if (checkStr(s, str)){
                return str;
            }
        }

        return "";
    }

    public boolean checkStr(String s, String str){
        int j = 0;

        for (int i = 0; i<s.length() && j < str.length(); i++){
            if (s.charAt(i) == str.charAt(j)){
                j++;
            }
        }

        if (j == str.length()){
            return true;
        }else {
            return false;
        }
    }
}
