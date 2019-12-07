//75. 颜色分类
//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
//此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//注意:
//不能使用代码库中的排序函数来解决这道题。
//
//示例:
//
//输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/sort-colors
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package Arrays;

//三指针法： 一个指针为0的边界，一个指针为2的边界， 一个指针遍历数组
//如果当前值为0，这个指针与0指针交换，两个指针同时往左移动
//如果当前值为2， 这个指针与2指针交换，2指针往右移动， 当前指针不动，因为不确定交换后是1还是0， 需要再次判断
//如果当前值为1， 这个指针直接右移就好了

public class code75 {
    public void sortColors(int[] nums) {

        int cur = 0;
        int p0 = 0;
        int p2 = nums.length - 1;

        while (cur <= p2){
            if (nums[cur] == 0){
                int tmp = nums[cur];
                nums[cur] = nums[p0];
                nums[p0] = tmp;
                cur++;
                p0++;
            }else if (nums[cur] == 2){
                int tmp = nums[cur];
                nums[cur] = nums[p2];
                nums[p2] = tmp;

                p2--;
            }else{
                cur++;
            }
        }

    }
}
