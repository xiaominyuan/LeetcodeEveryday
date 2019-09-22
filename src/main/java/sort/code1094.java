//1094. 拼车
//假设你是一位顺风车司机，车上最初有 capacity 个空座位可以用来载客。由于道路的限制，车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向，你可以将其想象为一个向量）。
//
//这儿有一份行程计划表 trips[][]，其中 trips[i] = [num_passengers, start_location, end_location] 包含了你的第 i 次行程信息：
//
//必须接送的乘客数量；
//乘客的上车地点；
//以及乘客的下车地点。
//这些给出的地点位置是从你的 初始 出发位置向前行驶到这些地点所需的距离（它们一定在你的行驶方向上）。
//
//请你根据给出的行程计划表和车子的座位数，来判断你的车是否可以顺利完成接送所用乘客的任务（当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false）。
//
// 
//
//示例 1：
//
//输入：trips = [[2,1,5],[3,3,7]], capacity = 4
//输出：false
//示例 2：
//
//输入：trips = [[2,1,5],[3,3,7]], capacity = 5
//输出：true
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/car-pooling
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package sort;

//思路: 将每站路程的乘客全部加上去，然后判断每站的乘客是否大于容量

public class code1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int len = trips.length;

        int[] a = new int[1001];

        for (int i = 0; i< len; i++){
            for (int j = trips[i][1]; j<trips[i][2]; j++){
                a[j] = a[j] + trips[i][0];
            }
        }

        for (int i = 0; i<1001; i++){
            if (a[i] > capacity){
                return false;
            }
        }

        return true;
    }
}
