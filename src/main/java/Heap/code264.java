//264. 丑数 II
//编写一个程序，找出第 n 个丑数。
//
//丑数就是只包含质因数 2, 3, 5 的正整数。
//
//示例:
//
//输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/ugly-number-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package Heap;

import java.util.PriorityQueue;

public class code264 {
    public int nthUglyNumber(int n) {

        //最小堆
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        //防止int 类型溢出到堆顶
        long[] result = new long[n];

        int[] elements = new int[]{2,3,5};

        //1与任何正整数（包括1本身）都是互质
        result[0] = 1;

        for (int i = 0; i< n; i++){
            for (int j = 0; j< elements.length; j++){
                long tmp = (long)(result[i] * elements[j]);
                if (!minHeap.contains(tmp)){
                    minHeap.add(tmp);
                }
            }

            if (i +1 < n){
                result[i+1] = minHeap.poll();
            }
        }

        return (int)(result[n-1]);
    }
}
