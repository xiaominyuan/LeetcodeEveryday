//914. 卡牌分组
//给定一副牌，每张牌上都写着一个整数。
//
//此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
//
//每组都有 X 张牌。
//组内所有的牌上都写着相同的整数。
//仅当你可选的 X >= 2 时返回 true。
//
// 
//
//示例 1：
//
//输入：[1,2,3,4,4,3,2,1]
//输出：true
//解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
//示例 2：
//
//输入：[1,1,1,2,2,2,3,3]
//输出：false
//解释：没有满足要求的分组。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package Arrays;

import java.util.HashMap;
import java.util.Map;

public class code914 {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : deck){
            Integer tmp = count.get(num);
            if (tmp == null){
                count.put(num, 1);
            }else{
                count.put(num, tmp+1);
            }
        }

        int len = deck.length;
        for (int i = 2; i<= len+1; i++){
            if (len % i == 0){
                int tmpCount = 0;
                for (int k : count.keySet()){
                    if (count.get(k) % i == 0){
                        tmpCount++;
                    }
                }

                if (tmpCount == count.size()){
                    return true;
                }
            }
        }

        return false;
    }
}
