//954. 二倍数对数组
//给定一个长度为偶数的整数数组 A，只有对 A 进行重组后可以满足 “对于每个 0 <= i < len(A) / 2，都有 A[2 * i + 1] = 2 * A[2 * i]” 时，返回 true；否则，返回 false。
//
// 
//
//示例 1：
//
//输入：[3,1,3,6]
//输出：false
//示例 2：
//
//输入：[2,1,2,6]
//输出：false
//示例 3：
//
//输入：[4,-2,2,-4]
//输出：true
//解释：我们可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/array-of-doubled-pairs
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package ershua;

import java.util.Map;
import java.util.TreeMap;

public class canReorderDoubled954 {

    public boolean canReorderDoubled(int[] A) {
        if (A.length == 0){
            return true;
        }
        Map<Integer, Integer> map = new TreeMap<>();

        for (int a : A){
            map.put(a, map.getOrDefault(a,0)+1);
        }

        for (int key : map.keySet()){
            if (map.get(key) == 0){
                continue;
            }
            int m = map.get(key);
            if (key < 0){
                key = key/2;
            }else {
                key = key*2;
            }
            int n = map.get(key);
            if (n < m){
                return false;
            }
            map.put(key, n-m);
        }

        return true;
    }
}
