package dictionary;

import java.util.HashSet;
import java.util.Set;

public class canPermutePalindrome0104 {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        if (s == null){
            return false;
        }
        for (char c : s.toCharArray()){
            if (set.contains(c)){
                set.remove(c);
            }else{
                set.add(c);
            }
        }

        if (set.size()>1){
            return false;
        }else{
            return true;
        }
    }

    public boolean res;
    public boolean canPermutePalindrome2(String s) {
        if (s == null){
            return false;
        }
        boolean[] flag = new boolean[s.length()];
        dfs(s, "", flag);
        return res;
    }

    public void dfs(String s, String path, boolean[] flag){
        if (path.length() == s.length() && judge(path)){
            res = true;
        }

        for (int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if (flag[i] == true){
                continue;
            }
            flag[i] = true;
            dfs(s, path+c, flag);
            flag[i] = false;
        }
    }

    public boolean judge(String s){
        int left = 0;
        int right = s.length()-1;
        while (left <= right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
