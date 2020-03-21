//365. 水壶问题
//有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
//
//如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
//
//你允许：
//
//装满任意一个水壶
//清空任意一个水壶
//从一个水壶向另外一个水壶倒水，直到装满或者倒空
//示例 1: (From the famous "Die Hard" example)
//
//输入: x = 3, y = 5, z = 4
//输出: True
//示例 2:
//
//输入: x = 2, y = 6, z = 5
//输出: False
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/water-and-jug-problem
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package ershua;

import java.util.*;

//思路：把所有结果都存在队列里面，然后用一个set去判断是否有重复， bfs
public class canMeasureWater365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z){
            return false;
        }

        if (x + y == z || x == z || y == z){
            return true;
        }

        Set<List<Integer>> set = new HashSet<>();
        LinkedList<List<Integer>> res = new LinkedList<>();

        //一开始是两个空杯子
        List<Integer> first = Arrays.asList(0, 0);
        set.add(first);
        res.add(first);

        while (!res.isEmpty()){
            List<Integer> tmp = res.poll();

            int xTmp = tmp.get(0);
            int yTmp = tmp.get(1);

            if (xTmp == z || yTmp == z || xTmp + yTmp == z){
                return true;
            }

            //x加满水
            List<Integer> tmp1 = Arrays.asList(x, yTmp);
            if (!set.contains(tmp1)){
                set.add(tmp1);
                res.add(tmp1);
            }

            //y加满水
            List<Integer> tmp2 = Arrays.asList(xTmp, y);
            if (!set.contains(tmp2)){
                set.add(tmp2);
                res.add(tmp2);
            }

            //x清空
            List<Integer> tmp3 = Arrays.asList(0, yTmp);
            if (!set.contains(tmp3)){
                set.add(tmp3);
                res.add(tmp3);
            }

            //y清空
            List<Integer> tmp4 = Arrays.asList(xTmp, 0);
            if (!set.contains(tmp4)){
                set.add(tmp4);
                res.add(tmp4);
            }

            //x往y里面倒
            int xNow;
            int yNow;

            if (xTmp + yTmp <= y){
                xNow = 0;
            }else{
                xNow = xTmp + yTmp - y;
            }
            if (xTmp + yTmp >= y){
                yNow = y;
            }else{
                yNow = xTmp + yTmp;
            }
            List<Integer> tmp5 = Arrays.asList(xNow, yNow);
            if (!set.contains(tmp5)){
                set.add(tmp5);
                res.add(tmp5);
            }

            //y往 x 里面到
            if (xTmp + yTmp >= x){
                xNow = x;
            }else{
                xNow = xTmp + yTmp;
            }
            if (xTmp + yTmp <= x){
                yNow = 0;
            }else{
                yNow = xTmp + yTmp -x;
            }
            List<Integer> tmp6 = Arrays.asList(xNow, yNow);
            if (!set.contains(tmp6)){
                set.add(tmp6);
                res.add(tmp6);
            }
        }

        return false;
    }
}
