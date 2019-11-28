//数组中只出现一次的数字
//一个整型数组里除了两个数字之外，其他的数字都出现了两次。
// 请写程序找出这两个只出现一次的数字。

package jianzhioffer;

import java.util.HashMap;
import java.util.Map;

public class code33 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i< array.length; i++){
            if (map.containsKey(array[i])){
                int value = map.get(array[i]);
                map.put(array[i], value + 1);
            }else{
                map.put(array[i], 1);
            }
        }

        for (Integer key : map.keySet()){
            if (map.get(key) == 1){
                if (num1[0] == 0){
                    num1[0] = key;
                }else{
                    num2[0] = key;
                }
            }
        }
    }
}
