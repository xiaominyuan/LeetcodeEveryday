//451. 根据字符出现频率排序
//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
//
//示例 1:
//
//输入:
//"tree"
//
//输出:
//"eert"
//
//解释:
//'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
//示例 2:
//
//输入:
//"cccaaa"
//
//输出:
//"cccaaa"
//
//解释:
//'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package HashTable;

import java.util.*;

public class code451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if (!map.containsKey(c)){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c) +1);
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>();

        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : list){
            for (int i = 0; i < entry.getValue(); i++){
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
}
