//1239. 串联字符串的最大长度
//给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
//
//请返回所有可行解 s 中最长长度。
//
//
//
//示例 1：
//
//输入：arr = ["un","iq","ue"]
//输出：4
//解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
//示例 2：
//
//输入：arr = ["cha","r","act","ers"]
//输出：6
//解释：可能的解答有 "chaers" 和 "acters"。
//示例 3：
//
//输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
//输出：26

package backTracking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class maxLength1239 {

    Map<Character, Boolean> res = new HashMap<>();

    public int maxLength(List<String> arr) {
        dfs(arr, 0, new HashMap<>());
        return res.size();
    }

    public Map<Character, Boolean> dfs(List<String> arr, int index, Map<Character, Boolean> parent){
        if (index >= arr.size()){
            return parent;
        }else{
            for (int i = index; i< arr.size(); i++){
                Map<Character, Boolean> curMap = new HashMap<>();
                String curStr = arr.get(i);
                for (Character ch : curStr.toCharArray()){
                    curMap.put(ch, true);
                }

                //判断arr中的单个 str 中是否有重复字符
                if (curMap.size() == curStr.length()){
                    Map<Character, Boolean> sumMap = new HashMap<>(parent);
                    sumMap.putAll(curMap);


                    //判断arr 中前后两个的 str 中是否有重复字符
                    if (sumMap.size() == (parent.size() + curMap.size())){
                        Map<Character, Boolean> resMap = dfs(arr, i+1, sumMap);
                        if (resMap.size() > res.size()){
                            res = resMap;
                        }else {
                            res = res;
                        }
                    }

                }
            }


            //通过前两个if 重复判断， 如果都不通过，直接使用之前积累的字符map
            return parent;
        }
    }


}
