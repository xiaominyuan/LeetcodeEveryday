package ershua;
//136. 只出现一次的数字



import java.util.HashMap;
import java.util.Map;

public class singleNumber136 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }
        int res = 0;
        for (int key : map.keySet()){
            if (map.get(key) == 1){
                res = key;
            }
        }

        return res;
    }
}
