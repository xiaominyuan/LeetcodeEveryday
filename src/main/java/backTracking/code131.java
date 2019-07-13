//131. 分割回文串
//        给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//
//        返回 s 所有可能的分割方案。
//
//        示例:
//
//        输入: "aab"
//        输出:
//        [
//        ["aa","b"],
//        ["a","a","b"]
//        ]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/palindrome-partitioning
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package backTracking;

import java.util.ArrayList;
import java.util.List;

public class code131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        ArrayList<String> tmp = new ArrayList<>();
        if (s == "" || s.length() == 0){
            return result;
        }
        backTracking(s,0,tmp,result);
        return result;
    }

    public void backTracking(String s, int start, ArrayList<String> tmp, List<List<String>> result){

        if (start == s.length()){
            result.add(new ArrayList(tmp));
        }

        for (int i = start; i<s.length(); i++){
            if (this.checkHui(s.substring(start,i+1))){
                tmp.add(s.substring(start,i+1));
            }
            backTracking(s,i+1, tmp,result);
            tmp.remove(tmp.size()-1);
        }

    }

    //判断是否回文串

    public boolean checkHui(String s){
        if (s == "" || s.length() == 0){
            return false;
        }

        for (int i = 0; i<=s.length()/2; i++){
            if (s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
