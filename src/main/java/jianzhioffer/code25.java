//数组中出现次数超过一半的数字
//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
// 超过数组长度的一半，因此输出2。如果不存在则输出0。

package jianzhioffer;

import java.util.HashMap;
import java.util.Map;

public class code25 {
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i< array.length; i++){
            if (!map.containsKey(array[i])){
                map.put(array[i], 1);
            }else{
                int val = map.get(array[i]);
                map.put(array[i], val +1);
            }
        }

        for (Integer key : map.keySet()){
            int val = map.get(key);
            if (val > array.length/2){
                return key;
            }
        }

        return 0;
    }


}
