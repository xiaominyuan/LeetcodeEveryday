//49. 字母异位词分组
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
//示例:
//
//输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/group-anagrams
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package strings;

import java.util.*;

//遍历数组。对每个元素进行排序，然后存在 map 中

public class code49 {
//    public List<List<String>> groupAnagrams(String[] strs) {
//        if (strs.length == 0){
//            return new ArrayList<>();
//        }
//
//        Map<String, List> result = new HashMap<>();
//
//        for (String s : strs){
//            char[] c = s.toCharArray();
//            Arrays.sort(c);
//            String key = String.valueOf(c);
//            if (!result.containsKey(key)){
//                result.put(key, new ArrayList());
//            }
//            result.get(key).add(s);
//        }
//
//        return new ArrayList<>(result.values());
//    }
}
