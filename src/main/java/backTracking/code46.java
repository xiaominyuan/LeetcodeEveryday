//46. 全排列
//        给定一个没有重复数字的序列，返回其所有可能的全排列。
//
//        示例:
//
//        输入: [1,2,3]
//        输出:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/permutations
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package backTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class code46 {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> tmp = new ArrayList<Integer>();

        List<List<Integer>> result = new LinkedList<>();

        for (int a : nums){
            tmp.add(a);
        }

        backTracking(n, 0, tmp, result);

        return result;
    }

    public void backTracking(int n, int start, ArrayList<Integer> tmp, List<List<Integer>> result){
        if (n == start){
            //Java 中的对象是引用传递，直接 output.add(nums)只是把nums的引用拷贝了一份，
            // 更改nums的时候就会影响到output中的每一份nums的引用。用拷贝构造函数就能进行值传递，把整个nums拷贝了一份，后面再修改就不会受影响。
            //List为可变对象
            result.add(new ArrayList(tmp));
        }

        for (int i = start; i<n; i++){
            Collections.swap(tmp,i,start);

            backTracking(n, start+1, tmp, result);

            //回溯完了之后把排列归位
            Collections.swap(tmp,i,start);
        }
    }
}
